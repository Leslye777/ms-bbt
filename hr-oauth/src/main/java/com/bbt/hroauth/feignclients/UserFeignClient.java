package com.bbt.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbt.hroauth.entities.Users;

@Component
@FeignClient(name = "user", path = "/api/users")
public interface UserFeignClient {
	
    @GetMapping("/search")
    ResponseEntity<Users> findByEmail(@RequestParam String email);

}
