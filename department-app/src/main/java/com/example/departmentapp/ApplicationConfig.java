package com.example.departmentapp;

import com.example.grpc.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.client.inject.GrpcClientBean;
import net.devh.boot.grpc.client.inject.StubTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@GrpcClientBean(
//        clazz = UserServiceGrpc.UserServiceBlockingStub.class,
//        beanName = "grpcUserService",
//        client = @GrpcClient("grpcUserService")
//)
public class ApplicationConfig {

}
