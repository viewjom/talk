
package com.mysoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DeletePost", urlPatterns = {"/delete"})
public class DeletePost extends HttpServlet {


    
       


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
        try {
            DAO.deletePost(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/posts");
        
         
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}

