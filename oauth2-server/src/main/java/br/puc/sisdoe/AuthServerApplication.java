package br.puc.sisdoe;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Controller
@EnableResourceServer
public class AuthServerApplication extends WebMvcConfigurerAdapter {
	
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal user) {
		return user;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/oauth/confirm_access").setViewName("authorize");
	}

	@Configuration
	@Order(-20)
	protected static class LoginConfig extends WebSecurityConfigurerAdapter {

	    @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
					.formLogin().loginPage("/login").permitAll()
				.and()
					.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).invalidateHttpSession(true).clearAuthentication(true).logoutSuccessUrl("/login").permitAll()
				.and()
					.requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
				.and()
					.authorizeRequests()
					.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
					.antMatchers("/**").authenticated()
			                .antMatchers("/oauth/**").permitAll()
			        .and()
				.csrf()
					.disable();
			// @formatter:on
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.parentAuthenticationManager(authenticationManagerBean());
			
			auth.inMemoryAuthentication()
			.withUser("wesley").password("wesley").roles("USER").authorities("AGENDAMENTO_READ", "AGENDAMENTO_WRITE", "DOADOR_READ", "DOADOR_WRITE", "LOCAL_DOACAO_READ", "LOCAL_DOACAO_WRITE")
			.and()
			.withUser("user").password("user").roles("USER").authorities("RESULTADO_EXAME_READ", "RESULTADO_EXAME_WRITE")
			.and()
			.withUser("admin").password("admin").roles("ADMIN").authorities("AGENDAMENTO_READ", "AGENDAMENTO_WRITE", "DOADOR_READ", "DOADOR_WRITE", "LOCAL_DOACAO_READ", "LOCAL_DOACAO_WRITE", "RESULTADO_EXAME_READ");
		}
	}

	@Configuration
	@EnableAuthorizationServer
	protected static class OAuth2AuthorizationConfig extends
			AuthorizationServerConfigurerAdapter {

		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;
		
	    @Bean
	    public TokenStore tokenStore() {
	        return new JwtTokenStore(jwtTokenEnhancer());
	    }

		@Bean
		public JwtAccessTokenConverter jwtTokenEnhancer() {
			
			JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "mySecretKey".toCharArray());
	        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("jwt"));
	        
			return converter;
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.inMemory()
			        .withClient("sisdoeAgendamentoOnlineClient")
			        .secret("secret")
			        .authorizedGrantTypes("password","authorization_code", "refresh_token")
			        .authorities("AGENDAMENTO_READ", "AGENDAMENTO_WRITE", "DOADOR_READ", "DOADOR_WRITE", "LOCAL_DOACAO_READ", "LOCAL_DOACAO_WRITE")
			        .resourceIds("agendamentoApi")
			        .scopes("agendamento", "doador", "localDoacao")
			        .autoApprove(true)
				.and()
				.withClient("sisdoeResultadoExameClient")
			        .secret("secret")
			        .authorizedGrantTypes("password","authorization_code", "refresh_token")
			        .authorities("RESULTADO_EXAME_READ", "RESULTADO_EXAME_WRITE")
			        .resourceIds("comunicaSusApi")
			        .scopes("resultadoExame")
			        .autoApprove(true);
		}

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints)
				throws Exception {
			endpoints.tokenStore(tokenStore()).tokenEnhancer(jwtTokenEnhancer()).authenticationManager(authenticationManager);
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServer)
				throws Exception {
			oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess(
					"isAuthenticated()");
		}

	}
}
