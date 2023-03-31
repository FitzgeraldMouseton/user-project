package com.example.feignclient.clients;

import com.example.api.AccountApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "accountClient", url = "${user-project-url}")
public interface AccountClient extends AccountApi {
}
