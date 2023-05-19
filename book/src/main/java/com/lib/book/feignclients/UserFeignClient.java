package com.lib.book.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lib.book.entities.Users;

@Component
@FeignClient(name = "user",  path = "/api/users")

public interface UserFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<Users>findById(@PathVariable Long id);

}
 