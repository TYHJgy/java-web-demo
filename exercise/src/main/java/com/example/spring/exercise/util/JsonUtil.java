package com.example.spring.exercise.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * json工具类.
 *
 * @author liaoqingaoyang@richinfo.cnu
 * @author liuliuguo@richinfo.cn
 * @since 2021-04
 */
@Slf4j
public class JsonUtil {

  /** json工具类. */
  private JsonUtil() {}

  /** Object mapper. */
  private static final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();

  static {
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
  }

  /**
   * get object mapper.
   *
   * @return object mapper
   */
  public static ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  /**
   * convert obj to jsonb string.
   *
   * @param obj obj
   * @return json string.
   * @throws JsonProcessingException 解析失败.
   */
  public static String obj2String(Object obj) throws JsonProcessingException {
    return getObjectMapper().writeValueAsString(obj);
  }

  /**
   * convert obj to jsonb string.
   *
   * @param obj obj
   * @return json string -> 解析失败 null,传入null: empty string.
   */
  public static String obj2StringDefaultNull(Object obj) {
    if (obj == null) {
      return "";
    }
    try {
      return obj2String(obj);
    } catch (JsonProcessingException e) {
      log.error("序列化对象为字符串失败", e);
      return null;
    }
  }

  /**
   * parse object from json string.
   *
   * @param jsonStr json string
   * @param cls type
   * @param <T> generic type.
   * @return object instance.
   * @throws JsonProcessingException 解析失败.
   */
  public static <T> T jsonStrToObj(String jsonStr, Class<T> cls) throws JsonProcessingException {
    return getObjectMapper().readValue(jsonStr, cls);
  }

  /**
   * parse object from json string.
   *
   * @param jsonStr json string
   * @param cls type
   * @param <T> generic type.
   * @return object instance.
   */
  public static <T> T jsonStrToObjDefaultNull(String jsonStr, Class<T> cls) {
    try {
      return getObjectMapper().readValue(jsonStr, cls);
    } catch (JsonProcessingException e) {
      log.error("parse json as object failed", e);
      return null;
    }
  }

  /**
   * parse object from json string.
   *
   * @param jsonStr json string
   * @param reference reference
   * @param <T> generic type.
   * @return object instance.
   * @throws JsonProcessingException 解析失败.
   */
  public static <T> T jsonStrToList(String jsonStr, TypeReference<T> reference)
      throws JsonProcessingException {
    return getObjectMapper().readValue(jsonStr, reference);
  }

  /**
   * parse object from json string.
   *
   * @param jsonStr json string
   * @param reference type reference
   * @param <T> generic type.
   * @return object instance.
   */
  public static <T> T jsonStrToListDefaultNull(String jsonStr, TypeReference<T> reference) {
    try {
      return getObjectMapper().readValue(jsonStr, reference);
    } catch (JsonProcessingException e) {
      log.error("parse json as object failed", e);
      return null;
    }
  }

  /**
   * parse object from json string.
   *
   * @param jsonStr json string
   * @param <T> generic type.
   * @return object instance.
   */
  public static <T> T jsonStrToGenericObjectDefaultNull(String jsonStr) {
    try {
      return getObjectMapper().readValue(jsonStr, new TypeReference<T>() {});
    } catch (JsonProcessingException e) {
      log.error("parse json as object failed", e);
      return null;
    }
  }
}
