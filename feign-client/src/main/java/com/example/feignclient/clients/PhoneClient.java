package com.example.feignclient.clients;

import com.example.api.PhoneApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "PhoneClient", url = "${user-project-url}")
public interface PhoneClient extends PhoneApi {
}
