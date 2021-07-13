package com.example.spring.exercise.controller;

import com.example.spring.exercise.controller.rsp.AddUserParamRsp;
import com.example.spring.exercise.controller.rsp.BaseRsp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * swagger demo（url:http://localhost:8003/swagger-ui.html）.
 *
 * @author gy
 * @since 2021-7-9 11:18:25
 */
@Api(tags = {"swagger测试接口"})
@RestController
public class SwaggerController {

  private Logger logger = LoggerFactory.getLogger(SwaggerController.class);
  /**
   * POST请求demo.
   *
   * @param addUserParamRsp
   * @return
   */
  @ApiOperation(value = "测试swagger1", notes = "详细描述详...")
  @ApiResponses({
      @ApiResponse(code = 200, message = "OK")
  })
  @PostMapping("/testSwagger")
  public AddUserParamRsp testSwagger(
      @ApiParam(name = "addUserParamRsp", value = "新增用户参数", required = true)
      @RequestBody AddUserParamRsp addUserParamRsp) {
    logger.info("this is testSwagger(POST)");
    return addUserParamRsp;
  }

  /**
   * GET请求demo.
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "测试swagger2", notes = "详细描述详...")
  @ApiResponses({@ApiResponse(code = 200, message = "OK", response = String.class)})
  @ApiImplicitParams({
    @ApiImplicitParam(
        name = "id",
        value = "用户ID",
        dataType = "string",
        paramType = "query",
        required = true,
        defaultValue = "1",
        example = "11")
  })
  @GetMapping("/testSwagger")
  public String testSwagger(@RequestParam String id) {
    logger.info("this is testSwagger(GET)");
    return id;
  }
}
