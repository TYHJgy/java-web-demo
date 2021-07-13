package com.example.spring.exercise.controller;

import com.example.spring.exercise.controller.rsp.BaseRsp;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试httpsession.
 *
 * @author gaoyang
 * @since 2021-6-24
 */
@Api(tags = "httpsession示例接口")
@RestController
@RequestMapping("/TestHttpSession")
public class HttpSessionController {
  private Logger logger = LoggerFactory.getLogger(HttpSessionController.class);

  @GetMapping("/test1")
  public BaseRsp<Void> test1(HttpSession httpSession){
    logger.info("test1:{}",httpSession.getId());
    return BaseRsp.success();
  }

  @GetMapping("/test2")
  public BaseRsp<Void>  test2(HttpSession httpSession){
    logger.info("test2:{}",httpSession.getId());
    return BaseRsp.success();
  }
}
