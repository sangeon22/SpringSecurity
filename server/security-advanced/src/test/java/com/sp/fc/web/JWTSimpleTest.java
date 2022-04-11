//package com.sp.fc.web;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import javax.xml.bind.DatatypeConverter;
//import java.util.Base64;
//import java.util.Date;
//import java.util.Map;
//
//public class JWTSimpleTest {
//
//    private void printToken(String token){
//        String[] tokens = token.split("\\.");
//        System.out.println("header: " + new String(Base64.getDecoder().decode(tokens[0])));
//        System.out.println("body: " + new String(Base64.getDecoder().decode(tokens[1])));
//    }
//
//    @DisplayName("1. jjwt 를 이용한 토큰 테스트")
//    @Test
//    void test_1() {
//        String okta_token = Jwts.builder().addClaims(
//                        Map.of("name", "sangeon", "price", 3000)
//                ).signWith(SignatureAlgorithm.HS256, "sangeon")
//                .compact();
//        System.out.println(okta_token);
//        printToken(okta_token);
//
//        Jws<Claims> tokenInfo = Jwts.parser().setSigningKey("sangeon").parseClaimsJws(okta_token);
//        System.out.println(tokenInfo);
//    }
//
//
//    @DisplayName("2. java-jwt 를 이용한 토큰 테스트")
//    @Test
//    void test_2() {
//
//        String oauth0_token = JWT.create().withClaim("name", "sangeon").withClaim("price", 3000)
//                .sign(Algorithm.HMAC256("sangeon"));
//        System.out.println(oauth0_token);
//        printToken(oauth0_token);
//        DecodedJWT verified = JWT.require(Algorithm.HMAC256("sangeon")).build().verify(oauth0_token);
//        System.out.println(verified.getClaims());
//
///*
//        JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.
//        signkey를 관리하는 방식이 내부적으로 다름, jjwt는 해싱한뒤 처리하기때문이다.
//        Jws<Claims> tokenInfo = Jwts.parser().setSigningKey("sangeon").parseClaimsJws(oauth0_token);
//        System.out.println(tokenInfo);
//
//        jwt에서도 jjwt처럼 같은 키 방식으로 만들고 검증하면 같은 방식으로 검증이 된다.
//        byte[] SEC_KEY = DatatypeConverter.parseBase64Binary("sangeon");
//        String oauth0_token = JWT.create().withClaim("name", "sangeon").withClaim("price", 3000)
//                .sign(Algorithm.HMAC256("SEC_KEY"));
//                */
//    }
//
//    @DisplayName("3. 만료 시간 테스트")
//    @Test
//    void test_3() throws InterruptedException {
//        final Algorithm AL = Algorithm.HMAC256("sangeon");
//        String token = JWT.create().withSubject("a1234")
//                .withNotBefore(new Date(System.currentTimeMillis() + 1000))
//                .withExpiresAt(new Date(System.currentTimeMillis() + 3000))
//                .sign(AL);
//
////        Thread.sleep(2000);
//        try {
//            DecodedJWT verify = JWT.require(AL).build().verify(token);
//            System.out.println(verify.getClaims());
//        }catch (Exception ex){
//            System.out.println("유효하지 않은 토큰입니다...");
//            DecodedJWT decode = JWT.decode(token);
//            System.out.println(decode.getClaims());
//        }
//
//    }
//
//
//
//}
