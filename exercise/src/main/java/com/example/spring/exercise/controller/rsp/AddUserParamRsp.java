package com.example.spring.exercise.controller.rsp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel( value = "AddUserParamRsp", description = "新增用户参数3")
public class AddUserParamRsp{

  @ApiModelProperty(name = "id",value = "ID",example = "1")
  private String id;

  @ApiModelProperty(name = "name",value = "姓名",example = "1", position = 1)
  private String name;

  @ApiModelProperty(name = "age",value = "年龄",example = "1", position = 2)
  private int age;

}