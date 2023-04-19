package com.example.departmentapp.feignclient;

import com.example.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "userClient", url = "${user-app-url}")
public interface UserClient extends UserApi {
}
