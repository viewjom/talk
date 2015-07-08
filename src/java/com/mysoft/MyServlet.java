package com.mysoft;

//import com.mysoft.DAO;

import java.io.IOException;
import java.sql.SQLException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MyServlet", urlPatterns = {"/posts"})
public class MyServlet extends HttpServlet {

/*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>My first Servlet</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        // request.getRequestDispatcher("WEB-INF/posts.jsp").forward(request,response);
        
         try {
            request.setAttribute("posts", DAO.getPosts());
            } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/posts.jsp").forward(request,response);
         
    }
    
    
    


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
    
    
    

}
