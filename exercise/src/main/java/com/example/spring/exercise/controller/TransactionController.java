package com.example.spring.exercise.controller;


import com.example.spring.exercise.controller.rsp.BaseRsp;
import com.example.spring.exercise.service.TestTransactionService;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试spring事务（transaction）
 *
 * @author gy
 * @since 2021-7-9 10:32:50
 */
@Api(tags = "spring事务示例接口")
@RestController
public class TransactionController {

  @Resource
  private TestTransactionService testTransactionService;

  @RequestMapping
  public BaseRsp<Void> testTrans(){
    testTransactionService.testTrans();
    return BaseRsp.success();

  }

}
