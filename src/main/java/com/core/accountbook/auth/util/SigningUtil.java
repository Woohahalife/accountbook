package com.core.accountbook.auth.util;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class SigningUtil {
    public static Key getSigningKey(String secretKey) {
        byte[] decodeKey = Decoders.BASE64URL.decode(secretKey);
        return Keys.hmacShaKeyFor(decodeKey);
    }
}
