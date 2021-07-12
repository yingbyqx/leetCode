package com.ying;

import cn.hutool.json.JSONUtil;
import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CityBrainJWTUtil {
    /**
     *         jwt需要的相关依赖
     *         <dependency>
     *             <groupId>io.jsonwebtoken</groupId>
     *             <artifactId>jjwt</artifactId>
     *             <version>0.7.0</version>
     *         </dependency>
     */

    /**
     * 部门系統编码标识串（向实施人员索取）
     */
    private static String appSecret = "sjaqtsgzpt_JmMpaZq5Hadr8CAwEAAQ";

    public static void main(String[] args) throws Exception{
        /**
         * accountId 账号id
         * realmId 租户id
         * realmName 租户名
         * lastName 姓名
         * nickNameCn 昵称
         * account 登录账号（用户唯一标识）
         * namespace 账号类型标识
         * clientId 应用标识
         * tenantId 租户id
         * tenantName 租户名
         */
        String issuer = "{\"accountId\":\"78d2317c0f4241ea96a88be864203234\",\"lastName\":\"screen\"," +
                "\"clientId\":\"\",\"realmId\":\"78d2317c0f4241ea96a88be864203234\"," +
                "\"tenantName\":\"screen\",\"realmName\":\"screen\",\"namespace\":\"\"," +
                "\"tenantId\":\"78d2317c0f4241ea96a88be864203234\",\"nickNameCn\":\"screen\"," +
                "\"tenantUserId\":\"78d2317c0f4241ea96a88be864203234\",\"account\":\"screen\"}";
        Map<String, Object> userInfo = JSONUtil.parseObj(issuer);
        //模拟生成Authorization
        String Authorization = createJWT(appSecret, String.valueOf(userInfo.get("lastName")),appSecret, issuer);
//        String Authorization = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmZ19jOUFBZGJHNUplSDlWQWdNQkFBRSIsImlzcyI6IntcImFjY291bnRJZFwiOlwiNzhkMjMxN2MwZjQyNDFlYTk2YTg4YmU4NjQyMDMyMzRcIixcImxhc3ROYW1lXCI6XCJzY3JlZW5cIixcImNsaWVudElkXCI6XCJcIixcInJlYWxtSWRcIjpcIjc4ZDIzMTdjMGY0MjQxZWE5NmE4OGJlODY0MjAzMjM0XCIsXCJ0ZW5hbnROYW1lXCI6XCJzY3JlZW5cIixcInJlYWxtTmFtZVwiOlwic2NyZWVuXCIsXCJuYW1lc3BhY2VcIjpcIlwiLFwidGVuYW50SWRcIjpcIjc4ZDIzMTdjMGY0MjQxZWE5NmE4OGJlODY0MjAzMjM0XCIsXCJuaWNrTmFtZUNuXCI6XCJzY3JlZW5cIixcInRlbmFudFVzZXJJZFwiOlwiNzhkMjMxN2MwZjQyNDFlYTk2YTg4YmU4NjQyMDMyMzRcIixcImFjY291bnRcIjpcInNjcmVlblwifSIsImlhdCI6MTYyMzQyNDg5Niwic3ViIjoic2NyZWVuIiwiZXhwIjoxNjIzNDUzNjk2fQ.ojj1Xl1gNx7e2C1GZHRg1W7c8AtA1Lhp9rwR1-jA2W0";
        System.out.println(Authorization);
//        Thread.sleep(6000);
        //验证解析Authorization
        Map<String, Object> resMap = validateJWT(Authorization);
        System.out.println("信息：" + resMap.get("msg"));
        System.out.println("部门系统编码标识串：" + resMap.get("id"));
        System.out.println("金华大屏系统登录的用户姓名：" + resMap.get("username"));
        System.out.println("金华大屏系统登录的用户名信息：" + resMap.get("issuer"));
        //解析后得到id与appSecret进行匹配
        if (appSecret.equals(resMap.get("id"))) {
            System.out.println("部门系统标识串匹配成功，进行内部登录并重定向至相页面");
        } else {
            System.out.println("不通过！");
        }
    }


    /**
     * 生成Jwt的方法
     *
     * @param id        部门系統编码标识串
     * @param subject   用户昵称
     * @return Token String 凭证
     */
    public static String createJWT(String id, String subject, String appSecret, String issuer) {
        // 签名方法 HS256
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 生成Jwt的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // 生成秘钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(appSecret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        // 设置JWT所存储的信息
        JwtBuilder builder = Jwts.builder().setId(id).setIssuer(issuer).setIssuedAt(now).setSubject(subject)
                .signWith(signatureAlgorithm, signingKey);
        // 设置过期时间
        long expMillis = nowMillis + 1000 * 60 * 60 * 6;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);
        // 构建JWT并将其序列化为紧凑的URL安全字符串
        return builder.compact();
    }


    /**
     * 解析Jwt字符串
     *
     * @param jwt Jwt字符串
     * @return Claims 解析后的对象
     */
    public static Claims parseJWT(String jwt) {
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(appSecret))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    /**
     * 验证JWT
     *
     * @param jwt jwt字符串
     * @return JOSNObject 解析结果
     * success 成功标识
     *      true：成功
     *      false：失败
     * Claim 声明对象
     * code 错误码
     *      10001：过期 或 未登录
     */
    public static Map<String, Object> validateJWT(String jwt) {
        Map<String, Object> resMap = new HashMap<>();
        Claims claims = null;
        try {
            claims = parseJWT(jwt);
            resMap.put("code", 200);
            resMap.put("msg", "有效token");
            resMap.put("id", claims.getId());
            resMap.put("username", claims.getSubject());
            resMap.put("issuer", claims.getIssuer());
        } catch (ExpiredJwtException e) {
            resMap.put("code", 10000);
            resMap.put("msg", "token已过期");
            resMap.put("id", "");
            resMap.put("username", "");
            resMap.put("issuer", "");
        } catch (Exception e) {
            resMap.put("code", 10001);
            resMap.put("msg", "无效token");
            resMap.put("id", "");
            resMap.put("username", "");
            resMap.put("issuer", "");
        }
        return resMap;
    }

}
