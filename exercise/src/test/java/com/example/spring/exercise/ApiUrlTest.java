package com.example.spring.exercise;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ApiUrlTest {

  private static final String TIME_STAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

  private static final String APP_ID = "AppId";

  private static final String TIME_STAMP = "Timestamp";
  private static final String SIGNATURE = "Signature";
  private static final String SIGNATURE_METHOD = "SignatureMethod";
  private static final String SIGNATURE_VERSION = "SignatureVersion";
  private static final String SIGNATURE_NONCE = "SignatureNonce";
  private static final String SIGNATURE_VERSION_VALUE = "V1.0";
  private static final String SIGNATURE_METHOD_VALUE = "HmacSHA1";
  private static final String URL_ENCODER_FORMAT = "%s=%s";
  private static final String ENCODING = "utf-8";
  private static final String STRING_SEPARATOR = "\n";
  private static final String PARAMETER_SEPARATOR = "&";
  private static final String SIGNING_STRING = "BC_SIGNATURE&";

  private static String percentEncode(String value) throws UnsupportedEncodingException {
    if(value != null){
      String encode = URLEncoder.encode(value, ENCODING);
      encode.replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
      return encode;
    }else{
      return null;
    }
  }

  private static String encode(String data)
      throws UnsupportedEncodingException, NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hash = digest.digest(data.getBytes(ENCODING));
    return new String(encodeHex(hash));
  }

  private static char[] encodeHex(final byte[] data) {
    char[] toDigits = {
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    final int l = data.length;
    final char[] out = new char[l << 1];
    // two characters form the hex value.
    for (int i = 0, j = 0; i < l; i++) {
      out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
      out[j++] = toDigits[0x0F & data[i]];
    }
    return out;
  }

  private static String sign(String secretKey, String data) {
    try {
      Mac mac = Mac.getInstance(SIGNATURE_METHOD_VALUE);
      byte[] secretKeyByte = secretKey.getBytes(ENCODING);
      SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyByte, SIGNATURE_METHOD_VALUE);
      mac.init(secretKeySpec);
      return new String(encodeHex(mac.doFinal(data.getBytes(ENCODING))));
    } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
      return null;
    }
  }


  private String doSignature(String servletPath, String method, String appId, String appSecret) {
    try {

      Map<String, Object> query = new HashMap<>();
      query.put(APP_ID, appId);
      query.put(TIME_STAMP, new SimpleDateFormat(TIME_STAMP_FORMAT).format(new Date()));
      query.put(SIGNATURE_NONCE, UUID.randomUUID().toString());
      query.put(SIGNATURE_VERSION, SIGNATURE_VERSION_VALUE);
      query.put(SIGNATURE_METHOD, SIGNATURE_METHOD_VALUE);

      servletPath = java.net.URLDecoder.decode(servletPath, ENCODING);

      ArrayList<String> parameterList = new ArrayList<>(query.keySet());

      Collections.sort(parameterList);

      List<String> list = new ArrayList<>(query.size());
      for (String name : parameterList) {
        if (!SIGNATURE.equalsIgnoreCase(name)) {
          String value;
          if (query.get(name) instanceof Boolean) {
            value = Boolean.getBoolean(name) ? "true" : "false";
          } else {
            value = query.get(name).toString();
          }
          list.add(String.format(URL_ENCODER_FORMAT, percentEncode(name), percentEncode(value)));
        }
      }

      String canonicalizedQueryString = String.join(PARAMETER_SEPARATOR, list);

      String encryptedCanonicalizedQueryStr = encode(canonicalizedQueryString);
      String sb = method.toUpperCase()
          + STRING_SEPARATOR
          + percentEncode(servletPath)
          + STRING_SEPARATOR
          + encryptedCanonicalizedQueryStr;

      String signature = sign(SIGNING_STRING + appSecret, sb);
      if (Objects.isNull(signature) || signature.length() == 0) {
        return null;
      }
      return servletPath
          + "?"
          + canonicalizedQueryString
          + PARAMETER_SEPARATOR
          + String.format(URL_ENCODER_FORMAT, SIGNATURE, percentEncode(signature));
    } catch (Exception e) {
      return null;
    }
  }

  private static void test_sign(){
    System.out.println(
        sign(
            "BC_SIGNATURE&9bcc2082c663482a8eeb9301a6c2a251",
            "POST\n"
                + "%2Flingxiyun%2Fapi%2Fiat%2Fv1\n"
                + "a27bd50d680ebe9a7eacff8f4e9b5d9f68023cdb0c279cea9210e8464687de69"));
  }
  private static void test_percentEncode() throws UnsupportedEncodingException {
    System.out.println(percentEncode("abc"));
  }
  private static void test_encode() throws UnsupportedEncodingException, NoSuchAlgorithmException {
    System.out.println(encode("SignatureVersion=V1.0&AppId=m8zii2wg&SignatureNonce=a149bc3c-5f28-43f8-8b4c-c392b1843a04&SignatureMethod=HmacSHA1&Timestamp=2021-07-21T15%3A46%3A06Z"));
  }

  public static void main(String[] args)
      throws UnsupportedEncodingException, NoSuchAlgorithmException {
    ApiUrlTest tt = new ApiUrlTest();
    String appId = "m8zii2wg";
    String appSecret = "9bcc2082c663482a8eeb9301a6c2a251";
    String ip_port = "http://221.178.45.8:8080";
    // http方式接入
    String url = "/lingxiyun/api/iat/v1";
    String method = "post";
    String urlpath;
    urlpath = tt.doSignature(url, method, appId, appSecret);
    System.out.println(ip_port + urlpath);

    url = "/lingxiyun/api/tts/v1";
    urlpath = tt.doSignature(url, method, appId, appSecret);
    System.out.println(ip_port + urlpath);
    // websocket方式接入
    /*      String url = "/lingxiyun/api/ist/v2";
    String method = "get";
    String urlpath = tt.doSignature(url, method, appId, appSecret);
    System.out.println("ws://221.178.45.8:8080" + urlpath);*/
    // url编码
    test_percentEncode();

    // sha256编码
    test_encode();

    //hmac_sha1编码
    test_sign();

  }


}
