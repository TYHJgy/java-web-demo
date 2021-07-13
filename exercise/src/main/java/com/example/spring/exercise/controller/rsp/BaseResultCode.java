package com.example.spring.exercise.controller.rsp;

/**
 * 返回信息.
 *
 * @author chenjie@richinfo.cn
 */
public interface BaseResultCode extends ResultCode {
  /** 200：成功. */
  ResultCode SUCCESS = new BaseResultCodeImpl("200", "成功");
  /** 208 Already Reported. */
  ResultCode ALREADY_REPORTED = new BaseResultCodeImpl("208", "信息已存在");
  /** 400：参数错误（客户端请求的数据校验失败）. */
  ResultCode CLIENT_DATA_ERROR = new BaseResultCodeImpl("400", "参数错误");
  /** 401：会话过期（服务端）. */
  ResultCode SESSION_EXPIRED = new BaseResultCodeImpl("401", "会话过期");
  /** 403：无访问权限. */
  ResultCode FORBIDDEN = new BaseResultCodeImpl("403", "无访问权限");
  /** 404：内容不存在. */
  ResultCode NOT_FOUND = new BaseResultCodeImpl("404", "内容不存在");
  /** 500：程序出错. */
  ResultCode PROGRAM_ERROR = new BaseResultCodeImpl("500", "程序出错");
  /** 500：服务端异常（所有中间件访问的错误，例如数据库访问不了）. */
  ResultCode SERVER_ERROR = new BaseResultCodeImpl("500", "服务端异常");
  /** 500：数据异常（所有数据问题，例如：未设置唯一性约束，查出来两条记录。）. */
  ResultCode DATA_ERROR = new BaseResultCodeImpl("500", "数据异常");
  /** 501：功能建设中. */
  ResultCode NOT_IMPLEMENT = new BaseResultCodeImpl("501", "功能建设中");
  /** 999：业务失败（例如：数据找不到，数据已经存在等。程序中可以单独设置返回信息。）. */
  ResultCode BIZ_FAIL = new BaseResultCodeImpl("999", "业务失败");

  /** 内部实现类. */
  class BaseResultCodeImpl implements BaseResultCode {
    /** 返回码. */
    private String code;
    /** 返回信息. */
    private String msg;

    BaseResultCodeImpl(String code, String msg) {
      this.code = code;
      this.msg = msg;
    }

    @Override
    public String getCode() {
      return code;
    }

    @Override
    public String getMsg() {
      return msg;
    }
  }
}
