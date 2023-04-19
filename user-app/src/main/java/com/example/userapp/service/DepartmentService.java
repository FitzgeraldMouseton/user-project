package com.example.userapp.service;

import com.example.userapp.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @GrpcClient("grpc-dev")
    private DepartmentServiceGrpc.DepartmentServiceBlockingStub grpcClient;

    public DepartmentResponseGrpc getDepartment(String id) {
        DepartmentRequestGrpc request = DepartmentRequestGrpc.newBuilder().setId(id).build();
        return grpcClient.getDepartment(request);
    }
}
