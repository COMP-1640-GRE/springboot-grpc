package com.example.grpctest1.service;

import com.example.grpctest1.TemplateRequest;
import com.example.grpctest1.TemplateResponse;
import com.example.grpctest1.TemplateServiceGrpc;
import com.example.grpctest1.model.entity.Notification;
import com.example.grpctest1.model.entity.Template;
import com.example.grpctest1.model.entity.User;
import com.example.grpctest1.repository.NotificationRepository;
import com.example.grpctest1.repository.TemplateRepository;
import com.example.grpctest1.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@GrpcService
public class TemplateServiceImp extends TemplateServiceGrpc.TemplateServiceImplBase {
    @Autowired
    TemplateRepository templateRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    NotificationRepository notificationRepository;
    private final LocalDateTime localDateTime = LocalDateTime.now();

    @Override
    public void getEmailTemplate(TemplateRequest request, StreamObserver<TemplateResponse> responseObserver) {
        Template template = templateRepository.findByTemplateCode(request.getTemplateCode());
        User student = userRepository.findById(request.getStudentUserid()).orElseThrow();
        String studentName = student.getFirstName() + " " + student.getLastName();
        User staff = userRepository.findById(request.getStaffUserid()).orElseThrow();
        TemplateResponse templateResponse = TemplateResponse.newBuilder()
                .setContent(template.getTemplateContent().replace("[Student Name]", studentName)
                        .replace("[Name]", staff.getFirstName() + " " + student.getLastName())
                        .replace("[Role]", staff.getRole().name()))
                .setNotificationTo(student.getEmail())
                .build();
        responseObserver.onNext(templateResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getNotificationTemplate(TemplateRequest request, StreamObserver<TemplateResponse> responseObserver) {
        Template template = templateRepository.findByTemplateCode(request.getTemplateCode());
        String content = template.getTemplateContent().replace("[choose appropriate option]", request.getOption());
        TemplateResponse templateResponse = TemplateResponse.newBuilder()
                .setContent(content)
                .build();
        responseObserver.onNext(templateResponse);
        responseObserver.onCompleted();
    }
}
