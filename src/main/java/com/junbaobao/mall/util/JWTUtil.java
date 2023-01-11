package com.junbaobao.mall.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * @author:Tlimited
 */
@Service
public class JWTUtil {


    private final String JWTSEC = "CAKE";


    /**
     * 生成jwt
     * 使用Hs256算法, 私匙使用固定JWT_SEC秘钥
     *
     * @param jwtSec    jwt秘钥 此秘钥一定要保留好在服务端, 不能暴露出去, 否则sign就可以被伪造, 如果对接多个客户端建议改造成多个
     * @param ttlMillis jwt过期时间(毫秒)
     * @param username  用户名 可根据需要传递的信息添加更多, 因为浏览器get传参url限制，不建议放置过多的参数
     * @return
     */
    public String createJWT(String openId) {
        //30天
        long ttlMillis = 30L * 86400*1000;
        // 指定签名的时候使用的签名算法，也就是header那部分
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 创建payload的私有声明（根据特定的业务需要添加）
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("openId", openId);

        // 添加payload声明
        // 设置jwt的body
        JwtBuilder builder = Jwts.builder()
                // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                // 设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(UUID.randomUUID().toString())
                // iat: jwt的签发时间
                .setIssuedAt(now)
                // 代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串
                .setSubject(openId)
                // 设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, JWTSEC.getBytes(StandardCharsets.UTF_8));
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            // 设置过期时间
            builder.setExpiration(exp);
        }
        return builder.compact();
    }


    /**
     * Token的解密
     *
     * @param jwtSec jwt秘钥 此秘钥一定要保留好在服务端, 不能暴露出去, 否则sign就可以被伪造, 如果对接多个客户端建议改造成多个
     * @param token  加密后的token
     * @return
     */
    public Claims parseJWT(String token) {
        // 得到DefaultJwtParser
        Claims claims = Jwts.parser()
                // 设置签名的秘钥
                .setSigningKey(JWTSEC.getBytes(StandardCharsets.UTF_8))
                // 设置需要解析的jwt
                .parseClaimsJws(token).getBody();
        return claims;
    }


    @Test
    public void a() {
        // 生成jwt
        String jwt = createJWT("admin"); // 10秒过期
        System.out.println(jwt); // 生成token
        // 解析jwt
        Claims claims = parseJWT(jwt);
        // 获取用户名信息
        Object username = claims.get("openId");
        System.out.println("用户名:" + username); // 解析token
    }
}

