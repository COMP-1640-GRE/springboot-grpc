package com.example.grpctest1;

import com.example.grpctest1.model.entity.Template;
import com.example.grpctest1.repository.TemplateRepository;
import com.example.grpctest1.service.TemplateServiceImp;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
public class GrpcTest1Application {
    @Autowired
    private static TemplateServiceImp templateServiceImp;
    public static void main(String[] args) {
        SpringApplication.run(GrpcTest1Application.class, args);
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
