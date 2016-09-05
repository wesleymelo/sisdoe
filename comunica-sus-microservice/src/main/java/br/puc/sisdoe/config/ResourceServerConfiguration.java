package br.puc.sisdoe.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    Logger log = LoggerFactory.getLogger(ResourceServerConfiguration.class);

    @Autowired
    TokenStore tokenStore;
    
    @Autowired
    JwtAccessTokenConverter tokenConverter;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
        		.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/resultadoExame/").hasAuthority("RESULTADO_EXAME_READ")
                .antMatchers("/index.html").hasAnyAuthority("RESULTADO_EXAME_READ", "RESULTADO_EXAME_WRITE")
        		.anyRequest().authenticated();
    }
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        log.info("Configuring ResourceServerSecurityConfigurer ");
        resources.resourceId("comunicaSusApi").tokenStore(tokenStore);
    }
    
	@Bean
	public RequestMappingHandlerAdapter  annotationMethodHandlerAdapter()
	{
	    final RequestMappingHandlerAdapter annotationMethodHandlerAdapter = new RequestMappingHandlerAdapter();
	    final MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();

	    List<HttpMessageConverter<?>> httpMessageConverter = new ArrayList<HttpMessageConverter<?>>();
	    httpMessageConverter.add(mappingJacksonHttpMessageConverter);

	    String[] supportedHttpMethods = { "POST", "PUT", "DELETE", "GET", "HEAD" };

	    annotationMethodHandlerAdapter.setMessageConverters(httpMessageConverter);
	    annotationMethodHandlerAdapter.setSupportedMethods(supportedHttpMethods);

	    return annotationMethodHandlerAdapter;
	}
        
}
