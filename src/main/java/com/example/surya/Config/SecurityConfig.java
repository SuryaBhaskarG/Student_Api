
package com.example.surya.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

@EnableWebSecurity
public class SecurityConfig {

	@Bean
	 UserDetailsService userDetailsService() {

		UserDetails admin = User.withUsername("Surya").password(passwordEncoder()
				.encode("Surya")).roles("ADMIN")
				.build();
		UserDetails user = User.withUsername("user").password(passwordEncoder()
				.encode("user")).roles("USER").build();
		return new InMemoryUserDetailsManager(admin, user);

	}

	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.csrf().disable().
				authorizeHttpRequests()
				.requestMatchers("/students/welcome")
				.permitAll().and()
				.authorizeHttpRequests()
				.requestMatchers("/students/**")
				.authenticated().and()
				.formLogin().and()
				.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}











/*
 * 
 * package com.example.surya.Config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import org.springframework.security.core.userdetails.User;
 * import org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity
 * 
 * @EnableMethodSecurity public class SecurityConfig {
 * 
 * @Bean public UserDetailsService userDetailsService() { UserDetails admin =
 * User.withUsername("Surya") .password(passwordEncoder().encode("Surya"))
 * .roles("ADMIN") .build(); UserDetails user = User.withUsername("user")
 * .password(passwordEncoder().encode("user")) .roles("USER") .build(); return
 * new InMemoryUserDetailsManager(admin, user); }
 * 
 * 
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
 * throws Exception { return http.csrf().disable() .authorizeRequests()
 * .requestMatchers("/students/welcome") .permitAll() .and()
 * .authorizeRequests() .requestMatchers("/students/**") .authenticated() .and()
 * .formLogin().disable() .build(); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); } }
 * 
 * 
 * 
 * 
 * 
 * 
 */