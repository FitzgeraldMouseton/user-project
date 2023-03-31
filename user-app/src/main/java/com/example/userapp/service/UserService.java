package com.example.userapp.service;

import com.example.grpc.UserServiceGrpc;
import com.example.grpc.UserServiceOuterClass;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUser(UserServiceOuterClass.GrpcUserRequest request,
                        StreamObserver<UserServiceOuterClass.GrpcUserResponse> responseObserver) {
        UserServiceOuterClass.GrpcUserResponse resp1 = UserServiceOuterClass.GrpcUserResponse.newBuilder()
                .setId(1)
                .setFirstName("Fitz")
                .setLastName("Mouse")
                .setAge(30)
                .build();

        UserServiceOuterClass.GrpcUserResponse resp2 = UserServiceOuterClass.GrpcUserResponse.newBuilder()
                .setId(2)
                .setFirstName("Skillet")
                .setLastName("Squirrel")
                .setAge(30)
                .build();
        List<UserServiceOuterClass.GrpcUserResponse> users = List.of(resp1, resp2);
        UserServiceOuterClass.GrpcUserResponse response =
                users.stream()
                        .filter(u -> u.getId() == request.getId())
                        .findFirst()
                        .orElse(null);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @KafkaListener(topics = "example")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
