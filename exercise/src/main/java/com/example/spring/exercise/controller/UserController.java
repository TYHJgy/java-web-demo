package com.example.spring.exercise.controller;

import com.example.spring.exercise.controller.rsp.BaseRsp;
import com.example.spring.exercise.dao.entity.User;
import com.example.spring.exercise.service.UserService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** 用户管理接口. */
@Api(tags = "用户管理接口")
@RestController
@RequestMapping(path = "/user")
public class UserController {
  @Resource private UserService userService;

  /**
   * 获取user.
   *
   * @param userId userId
   * @return User
   */
  @GetMapping(path = "")
  public BaseRsp<User> getUserByUserId(
      @RequestParam(value = "userId", defaultValue = "1") String userId) {
    return BaseRsp.success(userService.getUserByUserId(userId));
  }

  /**
   * 获取user.
   *
   * @param userId userId
   * @return User
   */
  @GetMapping("/{userId}")
  public BaseRsp<User> getUserByUserId3(@PathVariable String userId) {
    return BaseRsp.success(userService.getUserByUserId(userId));
  }

  /**
   * 获取所有user.
   *
   * @return List<User>
   */
  @GetMapping(path = "all")
  public BaseRsp<List<User>> getAllUser() {
    return BaseRsp.success(userService.getAllUser());
  }

  /**
   * 获取user.
   *
   * @param userId userId
   * @return User
   */
  @RequestMapping("/{userId}")
  public BaseRsp<User> getUserByUserId2(@PathVariable String userId) {
    return BaseRsp.success(userService.getUserByUserId(userId));
  }

  /**
   * 添加user.
   *
   * @param user user
   * @return BaseRsp
   */
  @PostMapping("")
  public BaseRsp<Void> addUser(@RequestBody User user) {
    userService.insertUserTotTab(user);
    return BaseRsp.success();
  }

  /**
   * 修改user.
   *
   * @param user user
   * @return BaseRsp
   */
  @PutMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public BaseRsp<Void> updateUserbyId(@RequestBody User user) {
    userService.updateUserbyId(user);
    return BaseRsp.success();
  }

  /**
   * 删除user.
   *
   * @param userId userId
   * @return BaseRsp
   */
  @DeleteMapping("/{userId}")
  public BaseRsp<Void> deleteUserByUid(@PathVariable String userId) {
    userService.deleteUserByUid(userId);
    return BaseRsp.success();
  }
}
