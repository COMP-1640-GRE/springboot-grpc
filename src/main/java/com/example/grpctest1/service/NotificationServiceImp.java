package com.example.grpctest1.service;

import com.example.grpctest1.*;
import com.example.grpctest1.model.Email;
import com.example.grpctest1.model.entity.Notification;
import com.example.grpctest1.model.entity.Template;
import com.example.grpctest1.model.entity.User;
import com.example.grpctest1.repository.NotificationRepository;
import com.example.grpctest1.repository.TemplateRepository;
import com.example.grpctest1.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@GrpcService
@Slf4j
public class NotificationServiceImp extends NotificationServiceGrpc.NotificationServiceImplBase{
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private TemplateRepository templateRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender emailSender;

    public static final String STANDARD_CHARSETS_UTF8 = "UTF-8";
//    public static final String NO_REPLY_ADDRESS = "hungcuong28597@gmail.com";
    public static final String SEND_MAIL_ERROR = "Send mail error:::";
    @Value( "${spring.mail.username}" )
    private String emailFrom;
    private final LocalDateTime localDateTime = LocalDateTime.now();

    private void sendEmail(Long studentUserid, String templateCode, Long staffUserid, String option) {
        if (studentUserid == 0) {
            throw new IllegalArgumentException("Student is null");
        }
        User student = userRepository.findById(studentUserid).orElseThrow();
        User staff = userRepository.findById(staffUserid).orElseThrow();
        Template template = templateRepository.findByTemplateCode(templateCode);
        String content = template.getTemplateContent().replace("[Student Name]", student.getFirstName() + " " + student.getLastName())
                .replace("[Name]", staff.getFirstName() + " " + student.getLastName())
                .replace("[Role]", staff.getRole().name())
                .replace("[choose appropriate option]", option);
        Email email = new Email();
        email.setTo(new String[]{student.getEmail()});
        email.setSubject(template.getTemplateName());
        email.setHtmlBody(content);

        try {
            log.error("------Sendmail info::: \n to " + Arrays.toString(email.getTo()) + ", subject:::" + email.getSubject());
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, STANDARD_CHARSETS_UTF8);
            helper.setFrom(emailFrom);
            helper.setTo(email.getTo());
            if (email.getCc() != null && email.getCc().length > 0) {
                helper.setCc(email.getCc());
            }
            if (email.getBcc() != null && email.getBcc().length > 0) {
                helper.setBcc(email.getBcc());
            }
            helper.setSubject(email.getSubject());
            helper.setText(email.getHtmlBody(), true);
            emailSender.send(message);
        } catch (Exception e) {
            log.error(SEND_MAIL_ERROR + e.getMessage());
        }
    }

    @Override
    public void sendNotification(NotificationRequest request, StreamObserver<NotificationResponse> responseObserver) {
        if (request.getWithEmail()){
            sendEmail(request.getStudentUserid(), request.getTemplateCode().replace("noti","email"), request.getStaffUserid(), request.getOption());
        }
        Template template = templateRepository.findByTemplateCode(request.getTemplateCode());
        String content = template.getTemplateContent().replace("[choose appropriate option]", request.getOption());
        Notification notification = new Notification();
        notification.setContent(content);
        notification.setSeen(false);
        notification.setCreatedAt(localDateTime);
        notification.setUser(userRepository.findById(request.getStudentUserid()).orElseThrow());
        notification.setWithEmail(request.getWithEmail());
        notificationRepository.save(notification);
        NotificationResponse notificationResponse = NotificationResponse.newBuilder()
                .setContent(content)
                .setStudentUserid(notification.getUser().getId())
                .build();
        responseObserver.onNext(notificationResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getListNotifications(ListNotificationRequest request, StreamObserver<NotificationResponse> responseObserver) {
        List<Notification> notifications = notificationRepository.getNotifications(request.getStudentUserid(), request.getSeen(), PageRequest.of(0, 10)).getContent();
        notifications.forEach(notification -> {
            NotificationResponse notificationResponse = NotificationResponse.newBuilder()
                    .setContent(notification.getContent())
                    .setStudentUserid(notification.getUser().getId())
                    .build();
            responseObserver.onNext(notificationResponse);
        });
        responseObserver.onCompleted();
    }
}
