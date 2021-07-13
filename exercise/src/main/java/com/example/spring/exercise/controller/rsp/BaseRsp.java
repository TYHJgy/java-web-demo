package com.example.spring.exercise.controller.rsp;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 基本响应对象.
 *
 * <p>注意：该类只能在web层中使用。
 *
 * @author chenjie@richinfo.cn
 */
@Data
public class BaseRsp<T> {
  private String code;
  private String msg;
  private T data;

  /** 默认成功. */
  public BaseRsp() {
    this(BaseResultCode.SUCCESS, null);
  }

  /**
   * 默认成功.
   *
   * @param data 业务数据
   */
  public BaseRsp(T data) {
    this(BaseResultCode.SUCCESS, data);
  }

  public BaseRsp(ResultCode baseResultCode, T data) {
    this(baseResultCode.getCode(), baseResultCode.getMsg(), data);
  }

  /**
   * 基本响应对象.
   *
   * @param code 返回码
   * @param msg 返回信息
   * @param data 业务数据
   */
  public BaseRsp(String code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  /**
   * 成功.
   *
   * @return 响应
   */
  public static <T> BaseRsp<T> success() {
    return new BaseRsp<>(BaseResultCode.SUCCESS, null);
  }

  /**
   * 成功，包含数据.
   *
   * @param data 成功时的数据
   * @return 响应
   */
  public static <T> BaseRsp<T> success(T data) {
    return new BaseRsp<>(BaseResultCode.SUCCESS, data);
  }

  /**
   * 失败，包含数据.
   *
   * @param baseResultCode 失败对应的错误码
   * @return 响应
   */
  public static <T> BaseRsp<T> fail(ResultCode baseResultCode) {
    return new BaseRsp<>(baseResultCode, null);
  }

  /**
   * 失败，包含数据.
   *
   * @param baseResultCode 失败对应的错误码
   * @param msg 返回消息
   * @return 响应
   */
  public static <T> BaseRsp<T> fail(ResultCode baseResultCode, String msg) {
    BaseRsp<T> baseRsp = new BaseRsp<>(baseResultCode, null);
    if (msg != null) {
      baseRsp.setMsg(msg);
    }
    return baseRsp;
  }

  /**
   * 将service层方法返回的结果转换成web层的响应数据.
   *
   * @param bizResult 业务结果
   * @return 响应数据
   */
  public static <T> BaseRsp<T> fromBizResult(BaseBizResult<T> bizResult) {
    if (bizResult == null) {
      return null;
    }
    if (bizResult.isSuccess()) {
      return new BaseRsp<>(
          BaseResultCode.SUCCESS.getCode(), bizResult.getMsg(), bizResult.getData());
    } else {
      return new BaseRsp<>(
          bizResult.getCode() == null ? BaseResultCode.BIZ_FAIL.getCode() : bizResult.getCode(),
          bizResult.getMsg(),
          bizResult.getData());
    }
  }
}
