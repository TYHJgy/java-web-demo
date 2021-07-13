package com.example.demo.web.controller;

import com.example.common.dto.BaseRsp;
import javax.sql.rowset.BaseRowSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign被调用接口.
 *
 * @author gy
 * @since 2021-7-13 09:34:03
 */
@RestController
@RequestMapping("/feign-service")
public class FeignServiceController {

  @GetMapping("")
  public BaseRsp<Void> testFeignService(){
    return BaseRsp.success();
  }
}
