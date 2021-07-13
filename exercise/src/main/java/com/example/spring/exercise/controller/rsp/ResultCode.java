package com.example.spring.exercise.controller.rsp;

/**
 * 状态码. <br>
 * 正常码（3） AAABBBCCC AAA: 999 - 业务 BBB: 具体业务 - 具体到一类业务(伙伴/) CCC: 失败码
 *
 * @author liuliuguo@richinfo.cn
 * @since 2021/5/8-10:36
 */
public interface ResultCode {
  /**
   * 状态码.
   *
   * @return 状态码
   */
  String getCode();

  /**
   * 状态信息.
   *
   * @return 状态信息
   */
  String getMsg();
}
