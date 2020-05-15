package jo.edu.htu.convertor.web.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

//@WebFilter("/*")
public class LastAccessCookieFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // before
        System.out.println("inside last access cookie filter");
        HttpServletResponse httpResp = (HttpServletResponse) response;
        httpResp.addCookie(new Cookie("lastAccessTime", LocalDateTime.now().toString()));

        chain.doFilter(request, response);// continue normal request handling
        // after
        System.out.println("after handling response, inside last access cookie");
    }

    @Override
    public void destroy() {

    }
}
