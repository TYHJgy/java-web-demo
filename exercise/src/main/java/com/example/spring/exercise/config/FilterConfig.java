package com.example.spring.exercise.config;

import com.example.spring.exercise.filter.MyFilter;
import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

  @Bean
  public MyFilter getMyFilter(){
    return new MyFilter();
  }

  /**
   * 添加过滤器.
   *
   * @return
   */
  @Bean
  public FilterRegistrationBean<Filter> registerBufferedServletFilter() {
    FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
    registration.setFilter(getMyFilter());
//    registration.addUrlPatterns("/*");
    registration.addUrlPatterns("/filter");
    registration.setName("MyFilter");
    registration.setOrder(-900); //值越小，Filter越靠前。
    return registration;
  }
}
