package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "addServlet",urlPatterns = "/addServlet")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String query = request.getQueryString();
        String str = "^a=(-?[1-9]\\d*|0)&b=(-?[1-9]\\d*|0)$";
        Pattern pattern = Pattern.compile(str);
        Matcher m = pattern.matcher(query);
        boolean x = false;
        while (m.find()) {
            x = true;
            Integer a = Integer.parseInt(m.group(1));
            Integer b = Integer.parseInt(m.group(2));
            request.getSession().setAttribute("a", a);
            request.getSession().setAttribute("b", b);
        }
        if(!x){
            out.println("参数错误");
        }else{
            request.getRequestDispatcher("/doneServlet").forward(request,response);
        }
    }
}
