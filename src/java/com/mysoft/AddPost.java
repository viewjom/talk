
package com.mysoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddPost", urlPatterns = {"/add"})
public class AddPost extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
          String txt = request.getParameter("txt");
       //   String text = new String(txt.getText().getBytes("utf-8"));
              
          //response.setContentType("text/html;charset=UTF-8");
        try {
            DAO.addPost(txt);
        } catch (SQLException  | ClassNotFoundException e){
            e.printStackTrace();
        }
       // response.setContentType("text/html; charset=UTF-8");
        response.sendRedirect("/posts");
    }
    
    
   

    

}
