package com.example.spring.exercise.controller;


import static java.lang.System.*;

import com.example.spring.exercise.dao.entity.Task;
import io.swagger.annotations.Api;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "其他示例接口")
@RestController
@RequestMapping("Other")
public class OtherController {


  public void testBuilder() {
    Task task = new Task.TaskBuilder(99, "紧急任务")
        .type(1)
        .status(0)
        .finishDate(new Date())
        .build();

    out.println(task.toString());
  }

}
