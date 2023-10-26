package com.spring.security.demosecurity.secur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.spring.security.demosecurity.service.UserService;

@Configuration
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }

//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//
//		UserDetails borhan = User.builder().username("borhan").password("{noop}1234").roles("EMPLOYEE").build();
//
//		UserDetails safwan = User.builder().username("safwan").password("{noop}1234").roles("EMPLOYEE", "MANAGER")
//				.build();
//
//		UserDetails test = User.builder().username("Test").password("{noop}1234").roles("EMPLOYEE", "MANAGER", "ADMIN")
//				.build();
//
//		return new InMemoryUserDetailsManager(borhan, safwan, test);
//	}

//	@SuppressWarnings("removal")
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(configurer -> configurer.anyRequest().authenticated()).formLogin(
//				form -> form.loginPage("/shoMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll())
//				.logout(logout -> logout.permitAll());
//		return http.build();
//	}
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/employees/**").hasRole("EMPLOYEE")
                                .requestMatchers("/employees/**").hasRole("MANAGER")
                                .requestMatchers("/employees/**").hasRole("ADMIN")
                                .requestMatchers("/register/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .defaultSuccessUrl("/home", true)
//                                .defaultSuccessUrl("/employees/list", true)
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );

        return http.build();
    }

}