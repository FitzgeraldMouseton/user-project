package com.example.feignclient.clients;

import com.example.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "userClient", url = "${user-project-url}")
public interface UserClient extends UserApi {
}
