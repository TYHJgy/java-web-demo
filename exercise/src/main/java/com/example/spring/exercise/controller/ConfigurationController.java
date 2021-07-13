package com.example.spring.exercise.controller;

import io.swagger.annotations.Api;
import java.util.List;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 关于配置文件，优先级顺序如下：
// 1.file:./config/
// 2.file:./config/*/
// 3.file:./
// 4.classpath:/config/
// 5.classpath:/
// 备注：
// 1.file表示工程目录
// 2.同一级目录下properties文件优先级高于yml文件
//
// lazy(延时)初始化：
// 当lazy初始化被启用时，bean将在需要时创建，而不是在应用程序启动时创建。
// 因此，启用延迟初始化可以减少应用程序启动所需的时间。
// 在web应用程序中，启用延迟初始化将导致许多与web相关的bean直到收到HTTP请求后才初始化。
// lazy初始化的一个缺点是，它会延迟应用程序问题的发现。如果延迟初始化一个配置错误的bean，那么在启动期间将不再出现失败，只有在初始化bean时问题才会变得明显。
// 还必须注意确保JVM有足够的内存来容纳应用程序的所有bean，而不仅仅是在启动期间初始化的bean。由于这些原因，默认情况下不启用延迟初始化，建议在启用延迟init之前对JVM堆大小进行微调。
// 可以使用SpringApplicationBuilder上的lazyinitialize方法或SpringApplication上的setlazyinitialize方法通过编程启用延迟初始化。
// 或者，也可以使用spring.main来启用它。延迟初始化属性，如下面的示例所示

/**
 * 配置信息测试类.
 *
 * @author gy
 * @since 2021-5-26 14:53:16 *
 */

@Api(tags = "获取配置信息示例接口")
@RestController
@RequestMapping("/config")
@ConfigurationProperties(prefix = "my.config") // 前缀为"my.config"的配置.
@Data
public class ConfigurationController {
  private Logger logger = LoggerFactory.getLogger(ConfigurationController.class);

  /** 配置文件中无"my.config.name"，结果为null. */
  private String name;

  /** 配置文件中"name=gy" */
  @Value("${name}")
  private String name2;

  /** 配置文件中 my.config.name3=gy3. */
  private String name3;

  /** 直接注入"gy4". */
  @Value("gy4")
  private String name4;

  /** 配置文件中 my.config.random=${random.int}. */
  private String random;

  /** 配置文件中 my.config.name3.year. 默认值：8 */
  @Value("${my.config.name3.year:8}")
  private String year;

  /** 配置文件中 my.config.servers */
  private List<String> servers;


  @GetMapping("")
  public String getConfigPara() {
    return getName() + " "
        + getName2() + " "
        + getName3() + " "
        + getName4() + " "
        + getYear();
  }

  @GetMapping("/random")
  public String getConfigParaRandom() {
    return getRandom();
  }

  @GetMapping("/properties")
  public List<String> getPropertiesVal() {
    return getServers();
  }

}
