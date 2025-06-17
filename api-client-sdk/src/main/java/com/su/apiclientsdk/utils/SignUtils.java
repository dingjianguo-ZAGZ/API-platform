package com.su.apiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public class SignUtils {
    public static String getSign(String body,String secretKey){
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        // 5393554e94bf0eb6436f240a4fd71282
        String str = body +"."+secretKey;
        String sign = md5.digestHex(str);
        return sign;
    }
}
