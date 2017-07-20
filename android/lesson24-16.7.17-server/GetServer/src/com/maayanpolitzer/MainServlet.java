package com.maayanpolitzer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hackeru on 16/07/2017.
 */
@WebServlet(name = "MainServlet", urlPatterns = "/MyServer")
public class MainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("wow");
        response.getWriter().write("your response from doPost() is " + data);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("age");
        try {
            int number = Integer.parseInt(str);
            System.out.println(number);
            response.getWriter().write(String.valueOf(++number));
        }catch (NumberFormatException e){
            response.getWriter().write("error with your age (" + str + ")");
        }



    }
}
