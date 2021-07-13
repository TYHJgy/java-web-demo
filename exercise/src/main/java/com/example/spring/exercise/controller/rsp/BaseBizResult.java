package com.example.spring.exercise.controller.rsp;

/**
 * 基本业务返回结果.
 *
 * <p>用途：service层方法返回时使用，注意：仅在有多个复合属性需要封装时使用，简单返回时不需要。
 *
 * @author chenjie@richinfo.cn
 */
public class BaseBizResult<T> {
  private boolean success = true;
  private String code = BaseResultCode.SUCCESS.getCode();
  private String msg = BaseResultCode.SUCCESS.getMsg();
  private T data;

  /**
   * 基本业务返回结果.
   *
   * @param data 业务数据
   */
  public BaseBizResult(T data) {
    this.data = data;
  }

  /**
   * 基本业务返回结果.
   *
   * @param data 业务数据
   */
  public BaseBizResult(boolean success, ResultCode resultCode, T data) {
    this(success, resultCode.getCode(), resultCode.getMsg(), data);
  }

  /**
   * 基本业务返回结果.
   *
   * @param data 业务数据
   */
  public BaseBizResult(ResultCode resultCode, T data) {
    this(resultCode == BaseResultCode.SUCCESS, resultCode.getCode(), resultCode.getMsg(), data);
  }

  /**
   * 基本业务返回结果.
   *
   * @param success 业务是否成功
   * @param code 返回码
   * @param msg 返回信息
   * @param data 业务数据
   */
  public BaseBizResult(boolean success, String code, String msg, T data) {
    this.success = success;
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public boolean isSuccess() {
    return success;
  }

  public String getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  public T getData() {
    return data;
  }

  /**
   * 格式化信息.
   *
   * @param args 参数
   * @param <T> 类型
   * @return .
   */
  @SuppressWarnings("unchecked")
  public <T> BaseBizResult<T> pushMsgArgs(Object... args) {
    this.msg = String.format(this.msg, args);
    return (BaseBizResult<T>) this;
  }

  /**
   * 业务成功.
   *
   * @param <T> 类型
   * @return .
   */
  public static <T> BaseBizResult<T> success() {
    return success(null);
  }

  /**
   * 业务成功.
   *
   * @param data 业务数据
   * @param <T> 类型
   * @return .
   */
  public static <T> BaseBizResult<T> success(T data) {
    return new BaseBizResult<>(data);
  }

  /**
   * 业务失败.
   *
   * @param resultCode 返回码
   * @param msg 返回信息
   * @param <T> 类型
   * @return .
   */
  public static <T> BaseBizResult<T> fail(ResultCode resultCode, String msg) {
    return fail(resultCode.getCode(), msg == null ? resultCode.getMsg() : msg);
  }

  /**
   * 业务失败.
   *
   * @param resultCode 返回码
   * @param <T> 类型
   * @return .
   */
  public static <T> BaseBizResult<T> fail(ResultCode resultCode) {
    return fail(resultCode, null);
  }

  /**
   * 业务失败.
   *
   * @param code 返回码
   * @param msg 返回信息
   * @param data 业务数据
   * @param <T> 类型
   * @return .
   */
  public static <T> BaseBizResult<T> fail(String code, String msg, T data) {
    return new BaseBizResult<>(false, code, msg, data);
  }

  /**
   * 业务失败.
   *
   * @param code 返回码
   * @param msg 返回信息
   * @param <T> 类型
   * @return .
   */
  public static <T> BaseBizResult<T> fail(String code, String msg) {
    return fail(code, msg, null);
  }
}
