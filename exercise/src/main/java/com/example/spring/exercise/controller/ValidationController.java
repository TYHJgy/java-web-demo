package com.example.spring.exercise.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 校验器使用示例.
 */
@Api(tags = "校验器使用示例接口")
@RestController
@RequestMapping("validtion")
public class ValidationController {

  @GetMapping("")
  public String test(){
    return "test";
  }

}
