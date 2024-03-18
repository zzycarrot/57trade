package com.test.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Slf4j
public class JWTUtils {
    // 创建token密钥的key,并且使用 HMAC-SHA-256 加密算法
    static SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("57Tradetoken57Tradetoken57Tradetoken57Tradetoken57Tradetoken57Tradetoken"));

//    SecretKey key = Jwts.SIG.HS256.key().build();
    /**
     * 生成token
     * @param claims claims
     * @return jwt
     */
    public static String genToken(Map<String,Object> claims){
        // 2. 构建jwt,将签发人设置为joe,并且使用密钥将签名jwt生成为jws
        String jws =  Jwts.builder().
                        claims(claims). // 自定义载荷数据
                        signWith(key).   // token加签认证
                        expiration(new Date(System.currentTimeMillis()+7200*1000)). // 设置token过期时间为2H
                        compact();  // 生成token字符串
        System.out.println(jws);
        return jws;
    }

    /**
     * token 校验
     * @param token jws
     * @return msg
     */
    public static Claims checkToken(String token){

        String msg = null;
        try {
            Jws<Claims> claimsJws = Jwts.parser().
                    verifyWith(key).
                    build().
                    parseSignedClaims(token);
            // 获取载荷的一些数据信息
            Claims payload = claimsJws.getPayload(); // payload 为一个map对象
            String issuer = payload.getIssuer();
            Date expiration = payload.getExpiration();
            String name = (String)payload.get("name");
            String role = (String)payload.get("role");
            // 测试就直接打印出去了...
            System.out.println("标准载荷：issuer===>"+issuer+"\texpiration=>"+expiration + "自定义载荷数据："+name+"\t"+role);
            log.info("密钥正确");
            return payload;
        } catch (SignatureException se) {
            msg = "密钥错误";
            log.info(msg);
            return null;
        }catch (MalformedJwtException me) {
            msg = "密钥算法或者密钥转换错误";
            log.info(msg);
            return null;
        }catch (MissingClaimException mce) {
            msg = "密钥缺少校验数据";
            log.info(msg);
            return null;
        }catch (ExpiredJwtException mce) {
            msg = "密钥已过期";
            log.info(msg);
            return null;
        }catch (JwtException jwte) {
            msg = "密钥解析错误";
            log.info(msg);
            return null;
        }
    }
}
