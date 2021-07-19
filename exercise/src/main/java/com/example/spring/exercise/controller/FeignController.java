package com.example.spring.exercise.controller;

import com.example.common.dto.BaseRsp;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign")
@Api(tags = "feign测试接口")
public class FeignController {
  private Logger logger = LoggerFactory.getLogger(FeignController.class);
  @Resource
  private RemoteClient remoteClient;

  /**
   * 通过feign调用test2接口.
   * @return BaseRsp
   */
  @GetMapping("/test1")
  public BaseRsp<Void> test1() {
    // 调用feign接口
    String result = remoteClient.test();
    logger.info("调用成功：{}", result);
    return BaseRsp.success();
  }

  /**
   * 通过feign被调用的test2接口.
   * @return BaseRsp
   */
  @GetMapping("/test2")
  public BaseRsp<Void> test2() {
    logger.info("this is test2");
    return BaseRsp.success();
  }
}
