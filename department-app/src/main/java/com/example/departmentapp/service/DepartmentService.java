package com.example.departmentapp.service;

import com.example.departmentapp.DepartmentRequestGrpc;
import com.example.departmentapp.DepartmentResponseGrpc;
import com.example.departmentapp.DepartmentServiceGrpc;
import com.example.departmentapp.mappers.DepartmentMapper;
import com.example.departmentapp.model.Department;
import com.example.departmentapp.repository.DepartmentRepository;
import com.example.model.DepartmentResponse;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@GrpcService
@Service
@RequiredArgsConstructor
public class DepartmentService extends DepartmentServiceGrpc.DepartmentServiceImplBase {

    private final DepartmentRepository departmentRepository;

    @Override
    public void getDepartment(DepartmentRequestGrpc request,
                              StreamObserver<DepartmentResponseGrpc> responseObserver) {
        Optional<Department> departmentOptional = departmentRepository.findById(request.getId());
        if (departmentOptional.isPresent()) {
            DepartmentResponseGrpc defaultInstance = DepartmentMapper.INSTANCE.toResponseGrpc(departmentOptional.get());
            responseObserver.onNext(defaultInstance);
            responseObserver.onCompleted();
        }
    }

    public List<DepartmentResponse> getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments
                .stream()
                .map(DepartmentMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
