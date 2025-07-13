package com.example.jwt.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    // Define your secret key (should be at least 256 bits for HS256 — 32 bytes)
    private static final String SECRET_KEY = "mysecretdemo12345678901234567890";

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(HttpServletRequest request) {
        try {
            // Step 1: Read Authorization header
            String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authHeader == null || !authHeader.startsWith("Basic ")) {
                return ResponseEntity.status(401).body("Missing or invalid Authorization header");
            }

            // Step 2: Decode Base64 username:password using java.util.Base64
            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

            // Split into username and password
            String[] values = credentials.split(":", 2);
            if (values.length != 2) {
                return ResponseEntity.status(400).body("Invalid credentials format");
            }

            String username = values[0];
            String password = values[1];

            // Step 3: Validate credentials (manual check)
            if (!username.equals("user") || !password.equals("pwd")) {
                return ResponseEntity.status(401).body("Invalid username or password");
            }

            // Step 4: Generate JWT token
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

            String token = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 600_000)) // 10 mins expiry
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();

            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
}
