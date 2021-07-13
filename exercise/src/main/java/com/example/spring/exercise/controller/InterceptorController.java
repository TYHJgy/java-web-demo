package com.example.spring.exercise.controller;


import com.example.spring.exercise.controller.rsp.BaseRsp;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拦截器示例.
 */
@Api(tags = "拦截器示例接口")
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {
  private Logger logger = LoggerFactory.getLogger(InterceptorController.class);

  @GetMapping("")
  public BaseRsp<Void> testInterceptor(){
    logger.info("this is testInterceptor");
    return BaseRsp.success();
  }

}
