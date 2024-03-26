package com.test.trade_platfoem;

import com.test.Delete.DeleteImage;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//@SpringBootTest
class ApplicationTests {


//    @Test
//    public void deleteImage() {
//        String filename = "c848d6300de542b88bbef1a1332a7732.png";
//        DeleteImage deleteImage = new DeleteImage();
//        deleteImage.deleteImage(filename);
//    }
//
//    @Test
//    public void comprassImg() throws IOException {
//        Thumbnails.of("C:\\Users\\ez_zz\\Desktop\\pic\\山.png")
//                .size(640, 480)
//                .toFile("C:\\Users\\ez_zz\\Desktop\\pic\\山comp.png");
//
//    }

    // 创建token密钥的key,并且使用 HMAC-SHA-256 加密算法
//    SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("57Tradetoken57Tradetoken57Tradetoken57Tradetoken57Tradetoken57Tradetoken"));
//
//    SecretKey key = Jwts.SIG.HS256.key().build();
//    /**
//     * 生成token
//     * @return
//     */
//    @Test
//    public void genToken(){
//        // 2. 构建jwt,将签发人设置为joe,并且使用密钥将签名jwt生成为jws
//        String jws =  Jwts.builder().
//                subject("Joe").  // setSubject 设置jwt针对的用户
//                        issuer("张三").   // issuer 签发人
//                        claim("name","zhangsan"). // 自定义载荷数据
//                        claim("role","admin"). // 自定义载荷数据
//                        signWith(key).   // token加签认证
//                        expiration(new Date(System.currentTimeMillis()+7200*1000)). // 设置token过期时间为2H
//                        compact();  // 生成token字符串
//        System.out.println(jws);
//    }
//
//    @Test
//    public void checkToken(){
//        String jws =  Jwts.builder().
//                subject("Joe").  // setSubject 设置jwt针对的用户
//                        issuer("张三").   // issuer 签发人
//                        claim("username","zhangsan"). // 自定义载荷数据
//                        claim("role","admin"). // 自定义载荷数据
//                        signWith(key).   // token加签认证
//                        expiration(new Date(System.currentTimeMillis()+7200*1000)). // 设置token过期时间为2H
//                        compact();  // 生成token字符串
////        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UiLCJpc3MiOiLlvKDkuIkiLCJuYW1lIjoiemhhbmdzYW4iLCJyb2xlIjoiYWRtaW4iLCJleHAiOjE3MTAzMjQyNDd9.C528Fuwf1_HGm8uz6fcVCdcniNtatr46g88K8liCqd4";
//        String token = jws;
//        System.out.println(token);
//        String msg = null;
//        try{
//            Jws<Claims> claimsJws = Jwts.parser().
//                    verifyWith(key).
//                    build().
//                    parseSignedClaims(token);
//            // 获取载荷的一些数据信息
//            Claims payload = claimsJws.getPayload(); // payload 为一个map对象
//            String issuer = payload.getIssuer();
//            Date expiration = payload.getExpiration();
//            String name = (String)payload.get("name");
//            String role = (String)payload.get("role");
//            // 测试就直接打印出去了...
//            System.out.println("标准载荷：issuer===>"+issuer+"\texpiration=>"+expiration + "自定义载荷数据："+name+"\t"+role);
//            System.out.println("token正确");
//        } catch (SignatureException se) {
//            System.out.println("密钥错误");
//        }catch (MalformedJwtException me) {
//            System.out.println("密钥算法或者密钥转换错误");
//        }catch (MissingClaimException mce) {
//            System.out.println("密钥缺少校验数据");
//        }catch (ExpiredJwtException mce) {
//            System.out.println("密钥已过期");
//        }catch (JwtException jwte) {
//            System.out.println("密钥解析错误");
//        }
//    }
////
//
//    /**
//     * token 校验
//     * @param key  密钥
//     * @param token jws
//     * @return
//     */
//    public String checkToken(SecretKey key, String token){
//
//        String msg = null;
//        try {
//            Jws<Claims> claimsJws = Jwts.parser().
//                    verifyWith(key).
//                    build().
//                    parseSignedClaims(token);
//            // 获取载荷的一些数据信息
//            Claims payload = claimsJws.getPayload(); // payload 为一个map对象
//            String issuer = payload.getIssuer();
//            Date expiration = payload.getExpiration();
//            String name = (String)payload.get("name");
//            String role = (String)payload.get("role");
//            // 测试就直接打印出去了...
//            System.out.println("标准载荷：issuer===>"+issuer+"\texpiration=>"+expiration + "自定义载荷数据："+name+"\t"+role);
//            return "token正确";
//        } catch (SignatureException se) {
//            msg = "密钥错误";
//            return  msg;
//        }catch (MalformedJwtException me) {
//            msg = "密钥算法或者密钥转换错误";
//            return  msg;
//        }catch (MissingClaimException mce) {
//            msg = "密钥缺少校验数据";
//            return  msg;
//        }catch (ExpiredJwtException mce) {
//            msg = "密钥已过期";
//            return  msg;
//        }catch (JwtException jwte) {
//            msg = "密钥解析错误";
//            return  msg;
//        }
//    }

}
