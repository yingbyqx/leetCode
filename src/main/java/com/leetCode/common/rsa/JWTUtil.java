package com.leetCode.common.rsa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

@Slf4j
public class JWTUtil {

//    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrjwnRjUOsAPaC1hHMlH2wWzi3MW1L419BenBgZ11r0g5YTlEP3x7t0vPo/xdR12mWKGo/cWGzySjJrcLTOdVE1sryJNzVZOcXR6mfdE8JWr8uggPUN/FPTUBnuo3mfrNX6+RQnVYVObsZZPUzBmP2QMKzBHEBjKLjNXX19leGVQIDAQAB";
//    private static final String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKuPCdGNQ6wA9oLWEcyUfbBbOLcxbUvjX0F6cGBnXWvSDlhOUQ/fHu3S8+j/F1HXaZYoaj9xYbPJKMmtwtM51UTWyvIk3NVk5xdHqZ90Twlavy6CA9Q38U9NQGe6jeZ+s1fr5FCdVhU5uxlk9TMGY/ZAwrMEcQGMouM1dfX2V4ZVAgMBAAECgYBLSe28KeuN26pTRtDu4Ce8snvUYXuetz0BhlM064fjHn8vH8eRWJDBPDfQg8pfH1L2E+x0xTRkax5cS8ZZXmMKJ4RTWvQLGmGlWjt07USKiSqUt9WjdtL0IY/pk+k2m6pAdILc7ujZMnSa717FxoCDN0bCQGiP6SmXvui3kD5FgQJBAN/1eZjzsJn3mrqUX/jlqdBWYxW3iNQkwEHu6r/6SS/pr1VEkXupoRibDFscErjwmTynlWtyXy8u3zh0rFVPd+ECQQDEGmaipinjoQJguzap5+21iIuZfmwEPmSwXjuslqLc7+DMyI2wVwM1lxj5j+EIPkWQXgBiHPT33wO+VplUE0z1AkEA1j5YMq98k+3AARkLrmjVyE27v/yxUnBN00UhIMHn3YPpjOJpYillyMoaSdZTOsQ/czzFveHNmK94LuO+MGYzQQJAIQBkZ1jZUdJlyQuYfm1mhpdNDu7ElM4/OaMSHdBX5iCET1Is7hEmnB0qec0pzK5WHJ6FJ/3Bh/lC8wQ1131MBQJBAK6e51Ry9wGEPOhcSE+Ek1fFtPDxW2hKTdFc8b2MSzPeaQMmTloaY0aH/CNkcyxKs1deBVGinPxrXXcbGeN9Les=";

    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDTjhghDAxGB4jhinh0UI82bvM8oJuq79/7ZQ97fWoNe43TUuUqWaDL0slIvYIkg4fkUmUCVayY7U+KZUwTYDZgvyBbXQc75H7pyDkSJUSMX3BPIYGGIwRQNjiEFiSeyEZLyNASuy/XUepJ2bENGY5UF21BRmxRlWCGml77XVZQTwIDAQAB";
    private static final String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANOOGCEMDEYHiOGKeHRQjzZu8zygm6rv3/tlD3t9ag17jdNS5SpZoMvSyUi9giSDh+RSZQJVrJjtT4plTBNgNmC/IFtdBzvkfunIORIlRIxfcE8hgYYjBFA2OIQWJJ7IRkvI0BK7L9dR6knZsQ0ZjlQXbUFGbFGVYIaaXvtdVlBPAgMBAAECgYAESxPuR8JQAYMjoJ3FLoVZg3LoPhIqq+eNwIVJ6kemsmU0brA75cm/mS2Ajmf/ubOeTJXEMFzqVZaRpnCezAsObhplpyDiHx+S42wdy/t402znwTFvBpTOUtaUbEeYmACv4Uggz7XBsShCQnLGSDIsTslwGA1jW94tqwP1G9hDIQJBAPnCAxBK/H14DFT4WJg06PaH48+IYcRI86uePb2xbd/SgL1L36gFxh50iZ/lCOGxkRMk+MW6ArNyxljyhV9iW9kCQQDY16exfgcyWHmNnzDe0FlTBEtZcZfbG22MWoNjnDbCer67cVGEnnDhePFdZj7uPzcXMcktpPKif723S1SJ0LxnAkEAxf9jlGAOCJ3KEPaMraWMZhzWoij5cLVwz0X0plRpyX3E58ylsztYk75JeIQG5X1yiF3QBlhvWbmMuukQiMyeCQJAIekv33EPHQ97CuvPT7kTjwkH45gBIJHcguuQyp4ebjGV7GhfUDca/hfU3z9jLg0Sx3zQsmOuUj1Z5PVR5i+PlwJBAJyBEqNMrqGMpLXo+7592uSL41ql4THnSJxYH3JFfbTB08EnNl4T3aJ1x0xDZkwf2vMiraOjXMhvvAAGJR9FuPM=";

    public static final char SEPARATOR_CHAR = '.';

    public String createJWT() throws Exception {
        String header = "{\"alg\":\"RSA\"}";
        header = new String(Base64.encodeBase64(header.getBytes(StandardCharsets.UTF_8)));
        log.info("header:{}", header);
        String account = "yingrongbi";
        String iss = "{\"account\":\"" + account + "\"}";

        JWTBodyVo bodyVo = new JWTBodyVo();
        long now = System.currentTimeMillis();
        bodyVo.setIat(now);
        bodyVo.setExp(now + 60 * 60 * 24 * 1000);
        bodyVo.setIss(iss);

        String body = new String(Base64.encodeBase64(
                JSON.toJSONString(bodyVo).getBytes(StandardCharsets.UTF_8)));

        log.info("body:{}", body);

        String sign = RSAUtil.sign(header + SEPARATOR_CHAR + body, privateKey);
        log.info("sign:{}", sign);
        sign = new String(Base64.encodeBase64(sign.getBytes(StandardCharsets.UTF_8)));

        return header + SEPARATOR_CHAR + body + SEPARATOR_CHAR + sign;

    }

    public boolean verifyToken(String token) {
        try {
            String[] split = token.split("\\.");
            String header = split[0];
            String body = split[1];
            String sign = split[2];
            sign = new String(Base64.decodeBase64(sign.getBytes(StandardCharsets.UTF_8)));

            boolean verify = RSAUtil.verify(header + SEPARATOR_CHAR + body, publicKey, sign);
            if (!verify) return false;

            //校验有效期
            body = new String(Base64.decodeBase64(body.getBytes(StandardCharsets.UTF_8)));
            log.info("body:{}", body);
            JSONObject bodyObject = JSONObject.parseObject(body);
            Long exp = bodyObject.getLong("exp");
            if (exp < System.currentTimeMillis()) return false;

            return true;
        } catch (Exception e) {
            log.error("", e);
            return false;
        }

    }

    public static void main(String[] args) throws Exception {
        JWTUtil jwtUtil = new JWTUtil();
        String jwt = jwtUtil.createJWT();
        log.info("jwt:{}", jwt);
//        String token = "eyJhbGciOiJSU0EifQ==.eyJleHAiOjE2MzYwMDkxMzc2NjcsImlhdCI6MTYzNTkyMjczNzY2NywiaXNzIjoie1wiYWNjb3VudFwiOlwieWluZ3JvbmdiaVwifSJ9.alhqV0lieDB2c21yMEp0dTNqWmhzN29ZYVRVR3NSaERNR1ZlTDBpcXcrUERLOWF6NXhkajV5a3dEUm4yUkE5dHU5Ly9IOVJDNkVZQk4xV3VSSVhqczRuYmI4bFRJckExSnlOTXNrNUFVRVRYaC9rOUkzNVdOcUJJNm5VSkV0ZlVvV3plRkJsZzVzOVk3akRsUTA2NDZEUnYyTForT2YyL3JIakg2eGd1VmlnPQ==";
        boolean verifyToken = jwtUtil.verifyToken(jwt);
        log.info("verifyToken:{}", verifyToken);
    }
}
