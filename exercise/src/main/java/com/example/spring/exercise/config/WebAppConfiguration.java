package com.example.spring.exercise.config;

import com.example.spring.exercise.filter.MyFilter;
import com.example.spring.exercise.interceptor.MyInterceptor;
import javax.servlet.Filter;
import lombok.Data;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Data
public class WebAppConfiguration implements WebMvcConfigurer {

  @Bean
  public MyInterceptor getMyInterceptor() {
    return new MyInterceptor();
  }

  /**
   * 添加拦截器.
   *
   * @param registry .
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 添加登录处理拦截器，拦截所有请求，登录请求除外
    InterceptorRegistration interceptorRegistration = registry.addInterceptor(getMyInterceptor());
    // 配置拦截策略
//    interceptorRegistration.addPathPatterns("/**");
    interceptorRegistration.addPathPatterns("/interceptor");
    // 值越小，拦截器越靠前。
    interceptorRegistration.order(-90000);
  }



}
