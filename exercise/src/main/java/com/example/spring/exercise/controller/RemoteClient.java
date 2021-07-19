package com.example.spring.exercise.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "test-service",url = "http://localhost:8003/")
public interface RemoteClient {

  @GetMapping("/feign/test2")
  String test();
}
