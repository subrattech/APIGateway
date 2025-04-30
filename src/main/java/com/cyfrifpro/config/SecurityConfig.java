//package com.cyfrifpro.config;
//
//import java.nio.charset.StandardCharsets;
//
//import javax.crypto.spec.SecretKeySpec;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
//import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
//	private final JwtConfig jwtConfig;
//
//	public SecurityConfig(JwtConfig jwtConfig) {
//		this.jwtConfig = jwtConfig;
//	}
//
//	@Bean
//	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//		return http.csrf(ServerHttpSecurity.CsrfSpec::disable)
//				.authorizeExchange(exchanges -> exchanges.pathMatchers("/auth/**", "/manage/**", "/actuator/**")
//						.permitAll().anyExchange().authenticated())
//				.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtDecoder(jwtDecoder()))).build();
//	}
//
//	@Bean
//	public ReactiveJwtDecoder jwtDecoder() {
//		byte[] secretKeyBytes = jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8);
//		SecretKeySpec secretKey = new SecretKeySpec(secretKeyBytes, "HS256");
//		return NimbusReactiveJwtDecoder.withSecretKey(secretKey).build();
//	}
//}