/**
 * Copyright 2015-现在 广州市领课网络科技有限公司
 */
package com.roncoo.education.common.core.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author wujing
 */
@Slf4j
public final class JwtUtil {

    private static final String TOKEN_SECRET = "eyJhbGciOiJIUzI1NiJ9";
    private static final String ISSUER = "RONCOO";
    public static final String USERID = "userId";
    // 1个月
    public static final Long DATE = 30 * 24 * 3600 * 1000L;

    /**
     * @param userId
     * @param date
     * @return
     * @throws IllegalArgumentException
     * @throws JWTCreationException
     * @throws UnsupportedEncodingException
     */
    public static String create(Long userId, Long date) {
        try {
            return JWT.create().withIssuer(ISSUER).withClaim(USERID, userId.toString()).withExpiresAt(new Date(System.currentTimeMillis() + date)).sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e) {
            log.error("JWT生成失败", e);
            return "";
        }
    }

    /**
     * @param token
     * @return
     * @throws JWTVerificationException
     * @throws IllegalArgumentException
     * @throws UnsupportedEncodingException
     */
    public static DecodedJWT verify(String token) throws JWTVerificationException, IllegalArgumentException {
        return JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer(ISSUER).build().verify(token);
    }

    /**
     * @return
     */
    public static Long getUserId(DecodedJWT decodedJWT) {
        return Long.valueOf(decodedJWT.getClaim(USERID).asString());
    }

}
