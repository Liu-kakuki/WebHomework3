package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "doneServlet", urlPatterns = "/doneServlet")
public class doneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Object a = request.getSession().getAttribute("a");
        Object b = request.getSession().getAttribute("b");
        Integer c = (Integer) a + (Integer) b;
        out.println("a="+a);
        out.println("<br>");
        out.println("b="+b);
        out.println("<br>");
        out.println("c=a+b="+a+"+"+b+"="+c);
    }
}
