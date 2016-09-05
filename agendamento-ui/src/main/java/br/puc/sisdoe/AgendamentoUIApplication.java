package br.puc.sisdoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableZuulProxy
@EnableOAuth2Sso
public class AgendamentoUIApplication extends WebSecurityConfigurerAdapter {
	
	public static void main(String[] args) {
		SpringApplication.run(AgendamentoUIApplication.class, args);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		
		http
			.csrf().disable()
			//.csrf()
			//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
			.logout().and()
			.authorizeRequests()
			.antMatchers("/css/**", "/js/**", "/fonts/**", "/font-awesome/**").permitAll()
			.antMatchers("/agendamento.html").hasAnyAuthority("AGENDAMENTO_READ", "AGENDAMENTO_WRITE")
			.anyRequest().authenticated();
			// @formatter:on
	}
}
