package jo.edu.htu.convertor.web;

import jo.edu.htu.currency.convertor.CurrenciesResult;
import jo.edu.htu.currency.convertor.ListAvailableCurrenciesHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CurrenciesSelectionServlet extends HttpServlet {

    private ListAvailableCurrenciesHandler listAvailableCurrenciesHandler;

    public CurrenciesSelectionServlet(ListAvailableCurrenciesHandler listAvailableCurrenciesHandler) {
        this.listAvailableCurrenciesHandler = listAvailableCurrenciesHandler;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrenciesResult currenciesResult = listAvailableCurrenciesHandler.listAll();
        req.setAttribute("codes", currenciesResult.getCodes());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/selectCurrencies.jsp");
        requestDispatcher.forward(req, resp);
    }

}
