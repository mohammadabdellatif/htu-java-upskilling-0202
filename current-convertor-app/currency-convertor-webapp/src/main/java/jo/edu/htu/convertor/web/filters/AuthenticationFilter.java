package jo.edu.htu.convertor.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession(true);
        if (session.getAttribute("currentUser") != null) {
            // the user is logged in, let him continue access the site
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpRes = (HttpServletResponse) response;
            httpRes.sendRedirect(httpReq.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {

    }
}
