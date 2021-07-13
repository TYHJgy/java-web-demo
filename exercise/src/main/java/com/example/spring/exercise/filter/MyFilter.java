package com.example.spring.exercise.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 过滤器.
 */
public class MyFilter implements Filter {
  private Logger logger = LoggerFactory.getLogger(MyFilter.class);

  @Override
  public void init(FilterConfig filterConfig) {
    logger.info("this is Myfilter init()");
  }

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    logger.info("我是过滤器的执行方法doFilter，客户端向Servlet发送的请求被我拦截到了");
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    // 获取资源请求路径
    String requestURI = request.getRequestURI();
    logger.info("获取请求路径：{}", requestURI);
    if (requestURI.contains("/filter")) {
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      logger.info("过滤");
    }
    logger.info("我是过滤器的执行方法doFilter，Servlet向客户端发送的响应被我拦截到了");
  }

  @Override
  public void destroy() {
    logger.info("this is Myfilter destroy()");
  }
}
