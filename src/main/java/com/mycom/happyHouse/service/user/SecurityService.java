package com.mycom.happyHouse.service.user;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SecurityService {
	private static final String SECRET_KEY = "asdfasfdasdfasafsdfweffasafsdfweffasafsdfweffasafsdfwefwfasddf"; // 임시
	
	// 로그인 서비스 던질 때 같이
	// header.payload(claim).signature
	public String createToken(String subject, long expTime) {
		if(expTime <= 0) {
			throw new RuntimeException("만료시간이 0보다 커야 합니다.");
		}
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
		
		return Jwts.builder()
				.setSubject(subject)
				.signWith(signingKey, signatureAlgorithm)
				.setExpiration(new Date(System.currentTimeMillis() + expTime))
				.compact();
	}
	
	// 토큰 검증하는 메서드 -> boolean안에 넣어서
	public String getSubject(String token) {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.build()
				.parseClaimsJws(token)
				.getBody();
		
		return claims.getSubject();
	}
}
