package br.puc.sisdoe.filters.pos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomPostFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object run() {
        final RequestContext ctx = RequestContext.getCurrentContext();
        //HttpServletRequest request = ctx.getRequest();
        logger.info("in zuul filter " + ctx.getRequest().getRequestURI());
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
        return 10;
    }

    @Override
    public String filterType() {
        return "post";
    }

}
