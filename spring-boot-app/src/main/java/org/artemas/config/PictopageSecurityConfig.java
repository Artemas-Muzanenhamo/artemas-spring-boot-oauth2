package org.artemas.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

@Configuration
@EnableGlobalAuthentication
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class PictopageSecurityConfig extends WebSecurityConfigurerAdapter{
	
	public Logger log = LoggerFactory.getLogger(PictopageSecurityConfig.class);
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//users and roles authentication
		auth.inMemoryAuthentication()
			.withUser("user1").password("secret1").roles("USER")
			.and()
			.withUser("user2").password("secret2").roles("USER", "ADMIN");	
	}
	
	
	/**
	 * This is a standard Spring Boot application 
	 * with Spring Security customization, just 
	 * allowing anonymous access to the static 
	 * (HTML) resources 
	 * (the CSS and JS resources are already accessible by default). 
	 * The HTML resources need to be available to anonymous users, 
	 * not just ignored by Spring Security, for reasons that will 
	 * become clear.
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//request authorization
	    http
	    	.httpBasic()
	    .and()
        	.authorizeRequests()
        	.antMatchers("/app/**", "/assets/css/**", "/common/bower_components/**","/index.html", "/home.html", "/login.html", "/").permitAll()
        	.anyRequest().authenticated()
        .and()
        	.formLogin()
        .and()
        	.csrf().csrfTokenRepository(csrfTokenRepository())
        .and()
        	.logout()
        .and()
        	//Spring Security filter chain, e.g. extending the SecurityConfiguration
        	.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
	}
	
	
	/**
	 * Angular wants the cookie name to be “XSRF-TOKEN” 
	 * and Spring Security provides it as a request 
	 * attribute, so we just need to transfer the 
	 * value from a request attribute to a cookie.
	 * 
	 * @author amuzanenhamo
	 *
	 */
	public class CsrfHeaderFilter extends OncePerRequestFilter {

		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
				FilterChain filterChain) throws ServletException, IOException {
			CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
			if (csrf != null) {
				Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
				String token = csrf.getToken();
				if (cookie == null || token != null && !token.equals(cookie.getValue())) {
					cookie = new Cookie("XSRF-TOKEN", token);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
			filterChain.doFilter(request, response);
		}
	}
	
	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}
	
}
