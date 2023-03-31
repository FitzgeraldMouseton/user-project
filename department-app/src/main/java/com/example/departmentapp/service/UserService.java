package com.example.departmentapp.service;

import com.example.grpc.UserServiceGrpc;
import com.example.grpc.UserServiceOuterClass;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @GrpcClient("grpc-dev")
    private UserServiceGrpc.UserServiceBlockingStub grpcClient;

    public UserServiceOuterClass.GrpcUserResponse findUserById(String id) {
        UserServiceOuterClass.GrpcUserRequest request =
                UserServiceOuterClass.GrpcUserRequest.newBuilder().setId(Integer.parseInt(id)).build();
        return grpcClient.getUser(request);
    }
}
