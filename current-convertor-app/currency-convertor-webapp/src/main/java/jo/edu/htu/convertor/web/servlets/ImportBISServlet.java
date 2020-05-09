package jo.edu.htu.convertor.web.servlets;

import jo.edu.htu.currency.convertor.ImportRatesHandler;
import jo.edu.htu.currency.convertor.ImportRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImportBISServlet extends HttpServlet {

    private final ImportRatesHandler importRatesHandler;

    public ImportBISServlet(ImportRatesHandler importRatesHandler) {
        this.importRatesHandler = importRatesHandler;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToView(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileDate = req.getParameter("fileDate");
        System.out.println("fileDate parameter: " + fileDate);
        String bisFile = req.getParameter("bisFile");
        System.out.println("bisFile as parameter: " + bisFile);

        Part part = req.getPart("bisFile");
        System.out.println("name: " + part.getName());
        System.out.println("content-type: " + part.getContentType());
        System.out.println("size of the file: " + part.getSize());

        Path bisFilePath = Paths.get("m:","htu","uploaded-file","rates.csv");
        part.write(bisFilePath.toString());

        importRatesHandler.importRates(new ImportRequest(bisFilePath));

        forwardToView(req, resp);
    }

    private void forwardToView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/import-bis.jsp");
        requestDispatcher.forward(req, resp);
    }
}
