package com.example.spring.exercise.controller;


import com.example.common.dto.BaseRsp;
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

  @GetMapping("enable")
  public BaseRsp<Void> testInterceptor_enable(){
    logger.info("this is testInterceptor_enable");
    return BaseRsp.success();
  }
  @GetMapping("disable")
  public BaseRsp<Void> testInterceptor_disable(){
    logger.info("this is testInterceptor_disable");
    return BaseRsp.success();
  }

}
