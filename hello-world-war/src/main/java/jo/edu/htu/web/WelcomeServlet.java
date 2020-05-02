package jo.edu.htu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Enumeration;

@WebServlet(urlPatterns = {"/welcome", "/greetings"})
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setHeader("RESP-TIME", LocalDateTime.now().toString());

        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("name");
        name = name == null ? "Anonymous" : name;
        writer.println("Hello Mr. " + name + ", this content was generated by the servlet");
        writer.println("METHOD: " + req.getMethod());
        writer.println("URL: " + req.getRequestURI());
        writer.println("context path: " + req.getContextPath());
        writer.println("=================HEADERS==================");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            writer.println(header + "=" + req.getHeader(header));
        }
        writer.println("===================Parameters=============");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameter = parameterNames.nextElement();
            writer.println(parameter + "=" + req.getParameter(parameter));
        }
        writer.flush();

    }
}
