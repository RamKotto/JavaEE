package com.saraevdv.app;

import com.saraevdv.dto.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductListServlet", urlPatterns = "/products")
public class ProductListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("text/html");

        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productList.add(new Product((long) i, "Product #" + i, i + 10L));
        }

        printWriter.println("<html><body>");
        for (Product product : productList) {
            printWriter.println("<h1>" + product + "</h1>");
        }
        printWriter.println("</body></html>");
        printWriter.close();
    }

}
