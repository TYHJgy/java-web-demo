package com.example.spring.exercise.controller;


import com.example.spring.exercise.controller.rsp.BaseRsp;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 过滤器示例.
 */
@Api(tags = "过滤器示例接口")
@RestController
@RequestMapping("/filter")
public class FilterController {
  private Logger logger = LoggerFactory.getLogger(FilterController.class);

  @GetMapping("")
  public BaseRsp<Void> testFilter(){
    logger.info("this is testFilter");
    return BaseRsp.success();
  }

}
