package com.example.spring.exercise.controller;

import com.example.spring.exercise.service.AopByAnnotationService;
import com.example.spring.exercise.service.AopByMethodService;
import com.example.spring.exercise.controller.rsp.BaseRsp;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * aop示例.
 */
@Api(tags = "aop示例接口")
@RestController
@RequestMapping("/testAop")
public class AopController {
  private Logger logger = LoggerFactory.getLogger(AopController.class);

  @Resource
  private AopByAnnotationService aopByAnnotationService;
  @Resource
  private AopByMethodService aopByMethodService;

  @GetMapping("")
  public BaseRsp<Void> testAop() {

    logger.info("开始基于注解的拦截.");
    aopByAnnotationService.add();
    logger.info("结束基于注解的拦截.");

    logger.info("开始基于方法规则的拦截.");
    aopByMethodService.add();
    logger.info("结束基于方法规则的拦截.");

    return BaseRsp.success();
  }
}
