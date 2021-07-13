package com.example.spring.exercise.controller;

import com.example.spring.exercise.controller.rsp.BaseRsp;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * log示例.
 */
@Api(tags = "log示例接口")
@RestController
@RequestMapping("logger")
public class LoggerController {
  private Logger logger = LoggerFactory.getLogger(LoggerController.class);

  @GetMapping("")
  public BaseRsp<Void> testLogger(){
    logger.info("this is testLogger");
    logger.info("sssd" + "sss");
    logger.info("sssd" + 12);
    int a = 10;
    int a2 = 20;
    logger.info("sssd{}" , a);
    logger.info("sssd{}+{}" , a,a2);

    return BaseRsp.success();
  }
}
