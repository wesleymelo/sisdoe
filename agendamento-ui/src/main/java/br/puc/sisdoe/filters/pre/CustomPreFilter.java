package br.puc.sisdoe.filters.pre;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomPreFilter extends ZuulFilter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        logger.info(ctx.getRequest().getHeader("Authorization"));
        
        
        /*
        if(request.getMethod().equalsIgnoreCase("post")){
        	StringBuffer jb = new StringBuffer();
        	String line = null;
        	try {
        		BufferedReader reader = request.getReader();
        		while ((line = reader.readLine()) != null)
        			jb.append(line);
        	} catch (Exception e) {}
        	
        	System.out.println(String.format("JSON REQUEST %s",jb.toString()));
        	logger.info(String.format("JSON REQUEST %s",jb.toString()));        	
        }
        */
        
        
        return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}
}
