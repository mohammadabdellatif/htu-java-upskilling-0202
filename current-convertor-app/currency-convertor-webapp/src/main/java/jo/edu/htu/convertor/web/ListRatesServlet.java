package jo.edu.htu.convertor.web;

import jo.edu.htu.currency.convertor.ListRatesHandler;
import jo.edu.htu.currency.convertor.ListRatesRequest;
import jo.edu.htu.currency.convertor.ListRatesResult;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

//@WebServlet(name = "ListRatesServlet", urlPatterns = "/rates", loadOnStartup = 1)
public class ListRatesServlet extends HttpServlet {
    private ListRatesHandler ratesHandler;

    public ListRatesServlet(ListRatesHandler listRatesHandler) {
        this.ratesHandler = listRatesHandler;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("handle service request");
        HashSet<String> toCodes = new HashSet<>();
        String fromCode = request.getParameter("fromCode");
        String[] toCodesParams = request.getParameterValues("toCodes");
        if (fromCode == null || toCodesParams == null || toCodesParams.length == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should pass fromCode and toCodes parameters");
            return;
        }

        toCodes.addAll(Arrays.asList(toCodesParams));
        ListRatesRequest listRequest = new ListRatesRequest(fromCode, toCodes);
        // call the model
        ListRatesResult rates = ratesHandler.getRates(listRequest);


        // forward the view rendering to another resource
        request.setAttribute("rates", rates.getAllRates());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/rates.jsp");
        requestDispatcher.forward(request, response);

    }


    @Override
    public void destroy() {

    }
}
