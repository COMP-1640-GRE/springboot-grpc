package com.example.grpctest1;

import com.example.grpctest1.model.entity.Template;
import com.example.grpctest1.repository.TemplateRepository;
import com.example.grpctest1.service.TemplateServiceImp;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class GrpcTest1Application {
    @Autowired
    private static TemplateServiceImp templateServiceImp;
    public static void main(String[] args) {
        SpringApplication.run(GrpcTest1Application.class, args);

//        try {
//            /* *
//             * Do not forget to install maven. The grpc stub classes are generated when you run the protoc compiler
//             * and it finds a service declaration in your proto file.
//             * Do not forget the client must use the same port in order to connect to this server.
//             * */
//            Server server = ServerBuilder.forPort(8999).addService(templateServiceImp).build();
//
//            server.start();
//            server.awaitTermination();
//        } catch (IOException | InterruptedException e) {
//            System.out.println("Error: " + e);
//        }
    }
    @Bean
    public GrpcServerConfigurer keepAliveServerConfigurer() {
        return serverBuilder -> {
            if (serverBuilder instanceof NettyServerBuilder) {
                ((NettyServerBuilder) serverBuilder)
                        .keepAliveTime(30, TimeUnit.SECONDS)
                        .keepAliveTimeout(5, TimeUnit.SECONDS)
                        .permitKeepAliveWithoutCalls(true);
            }
        };
    }
}
