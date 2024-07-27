package dio.dio_spring_security_jwt.security;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.h2.server.web.WebServlet;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    private static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };
    
    
    protected void configure(HttpSecurity http) throws Exception {
    	//antigo código
//        http.headers().frameOptions().disable();
//        http.cors().and().csrf().disable()
//                .addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers(SWAGGER_WHITELIST).permitAll()
//                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers(HttpMethod.POST,"/login").permitAll()
//                .antMatchers(HttpMethod.POST,"/users").permitAll()
//                .antMatchers(HttpMethod.GET,"/users").hasAnyRole("USERS","MANAGERS")
//                .antMatchers("/managers").hasAnyRole("MANAGERS")
//                .anyRequest().authenticated()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        //novo código
    	http.headers().frameOptions().disable();
//        http.csrf(AbstractHttpConfigurer::disable)
        http.cors().and().csrf().disable()
        .addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
        .authorizeHttpRequests()
                		.requestMatchers(HttpMethod.DELETE).hasRole("MANAGERS")
                		.requestMatchers(SWAGGER_WHITELIST).permitAll()
                		.requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/users").permitAll()
                        .requestMatchers(HttpMethod.GET,"/users").hasAnyRole("USERS","MANAGERS")
                        .requestMatchers("/managers").hasAnyRole("MANAGERS")
                        .anyRequest().authenticated()
                        .and()
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                        .requestMatchers("/admin/**").hasAnyRole("ADMIN","MANAGERS")
//                        .requestMatchers("/managers/**").hasAnyRole("ADMIN","MANAGERS")
//                        .requestMatchers("/user/**").hasAnyRole("USERS", "ADMIN","MANAGERS")
//                        .requestMatchers("/login/**").permitAll()
//                        .anyRequest().authenticated())
    }
    @Bean //HABILITANDO ACESSAR O H2-DATABSE NA WEB
    public ServletRegistrationBean h2servletRegistration(){
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
//    	ServletRegistrationBean registrationBean = new ServletRegistrationBean<WebServlet>();
//    	registrationBean.setServlet(new WebServlet());
//        registrationBean.addUrlMappings("/h2-console/*");
//        return registrationBean;
//    	ServletRegistrationBean registrationBean = new ServletRegistrationBean();
//    	registrationBean.setServlet(new WebServlet());
//    	return new ServletRegistrationBean();
    	
        ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<MyServlet>(new MyServlet(), "/myServlet");
        registrationBean.setName("MyServlet");
        registrationBean.setUrlMappings(Arrays.asList("/h2-console/*"));
        return registrationBean;
    }
}