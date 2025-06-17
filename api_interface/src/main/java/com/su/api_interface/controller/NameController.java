package com.su.api_interface.controller;

import com.su.apiclientsdk.model.User;
import com.su.apiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


/**
 * API  接口
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/get")
    public String getNameByGet(HttpServletRequest request,String name){
        System.out.println(request.getHeader("su"));
        return "GET：你的名字是"+name;
    }
    @PostMapping("/post")
    public String getNameByPost(@RequestParam("name") String name){
        return "Post：你的名字是"+name;
    }
    @PostMapping("/user")
    public String getUserName(@RequestBody User user, HttpServletRequest request){
      String accessKey = request.getHeader("accessKey");
      String nonce = request.getHeader("nonce");
      String timestamp = request.getHeader("timestamp");
      String sign = request.getHeader("sign");
      String body = request.getHeader("body");
      // todo 实际情况应该是去数据库中查是否已分配给用户
      if (!accessKey.equals("su")) {
          throw new RuntimeException("无权限");
      }
      if (Long.parseLong(nonce) > 10000) {
          throw new RuntimeException("无权限");
      }
    // todo 时间和当前时间不能超过 5 分钟
      /*if (timestamp) {

      }*/
    // todo 实际情况中是从数据库中查出 secretKey
      String serverSign = SignUtils.getSign(body, "suhongrun");
      if (!sign.equals(serverSign)) {
          throw new RuntimeException("无权限");
      }
      String result = "用户名是" + user.getUsername();
      return result;
    }
}


