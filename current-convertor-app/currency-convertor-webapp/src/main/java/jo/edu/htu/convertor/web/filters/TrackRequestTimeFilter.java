package jo.edu.htu.convertor.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TrackRequestTimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        System.out.println("inside trace request time");
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long endTime = System.currentTimeMillis();
        System.out.println("request for url: " + httpReq.getRequestURL() + " took " + (endTime - startTime) + " ms");
    }

    @Override
    public void destroy() {

    }
}
