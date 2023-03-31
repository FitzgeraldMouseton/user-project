package com.example.feignclient.clients;

import com.example.api.EmailApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "emailClient", url = "${user-project-url}")
public interface EmailClient extends EmailApi {
}
