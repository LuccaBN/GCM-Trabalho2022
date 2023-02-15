package br.ucsal.gcm.vhshop.authentication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
	CustomUserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}
	 
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.csrf().disable().authorizeRequests().antMatchers("/api/users/**","/api/tapes/**").permitAll().and().httpBasic();

		
		security.csrf().disable().authorizeRequests()
				.antMatchers("/login*","/register", "/registrar", "/*.{js,html,css}").permitAll().antMatchers("/resources/**").permitAll().anyRequest()
				.authenticated().and().formLogin((form) -> form.loginPage("/login").loginProcessingUrl("/logar").defaultSuccessUrl("/tapes", false).failureUrl("/login?error=true").permitAll())
				.logout((logout) -> logout.logoutUrl("/logout").permitAll().deleteCookies("JSESSIONID"));
	} 
}
