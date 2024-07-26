package dio.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends AuthenticationManager {
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {	
		auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}user123")
                .roles("USERS")
                .and()
                .withUser("admin")
                .password("{noop}master123")
                .roles("MANAGERS");
    }
}*/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        //return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
//        return (web) -> web.ignoring();
//    }
    
//    @Bean
////    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(org.springframework.security.core.userdetails.User.withUsername("user1")
//          .password("{noop}user123")
//          .roles("USER")
//          .build());
//        
//        manager.createUser(org.springframework.security.core.userdetails.User.withUsername("admin")
//          .password("{noop}admin")
//          .roles("USER", "ADMIN")
//          .build());
//        return manager;
//    }     
    
    @Autowired
    private SecurityDatabaseService securityService;
	
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    //Código atualizado do http security 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
          .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                  authorizationManagerRequestMatcherRegistry
                  		  .requestMatchers(HttpMethod.DELETE).hasRole("MANAGERS")
                          .requestMatchers("/admin/**").hasAnyRole("ADMIN","MANAGERS")
                          .requestMatchers("/managers/**").hasAnyRole("ADMIN","MANAGERS")
                          .requestMatchers("/user/**").hasAnyRole("USERS", "ADMIN","MANAGERS")
                          .requestMatchers("/login/**").permitAll()
                          .anyRequest().authenticated())
//          .formLogin(Customizer.withDefaults());
          .httpBasic();
          //.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
    

}


