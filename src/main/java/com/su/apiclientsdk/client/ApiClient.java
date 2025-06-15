package com.su.apiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.su.apiclientsdk.model.User;



import java.util.HashMap;
import java.util.Map;

public class ApiClient {
    private String accessKey;
    private String secretKey;
    private final String GATEWAY_HOST = "http://localhost:8090";

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name){
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.get(GATEWAY_HOST+"/api/name/", paramMap);
        return result;
    }
    public String getNameByPost(String name) {

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.get(GATEWAY_HOST+"/api/name/", paramMap);
        return result;
    }

    public Map<String,String> getRequestHeader(String body){
        Map<String,String> header = new HashMap<>();
        header.put("accessKey",accessKey);
        //header.put("secretKey",secretKey);//不能在请求头中传递
        header.put("nonce",RandomUtil.randomNumbers(4));
        header.put("body",body);
        header.put("timestamp",String.valueOf(System.currentTimeMillis() / 1000));
        header.put("sign",getSign(body,secretKey));
        return header;
    }
    public String getSign(String body,String secretKey){
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        // 5393554e94bf0eb6436f240a4fd71282
        String str = body +"."+secretKey;
        String sign = md5.digestHex(str);
        return sign;
    }
    public String getUserName(User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse response = HttpRequest.post(GATEWAY_HOST+"/api/name/user")
                .addHeaders(getRequestHeader(json))
                .body(json)
                .execute();
        return response.body();
    }
}
