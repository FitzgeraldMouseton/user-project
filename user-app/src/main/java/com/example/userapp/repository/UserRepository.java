package com.example.userapp.repository;

import com.example.userapp.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @NotNull
    Optional<User> findById(@NotNull Long id);

    @NotNull
    List<User> findAll();
}
