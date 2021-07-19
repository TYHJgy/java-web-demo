package com.example.spring.exercise.controller;


import static java.lang.System.*;

import com.example.spring.exercise.dao.entity.Task;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "其他示例接口")
@RestController
@RequestMapping("Other")
public class OtherController {
  @ApiOperation(value = "测试swagger1", notes = "详细描述详...")
  @GetMapping("/testAnnotation")
  public void testAnnotation(){
    System.out.println("testAnnotation");
  }
}
