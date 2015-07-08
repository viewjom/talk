package com.mysoft;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by barm on 10.06.2015.
 */
public class DAO {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
       return  DriverManager.getConnection("jdbc:mysql://127.4.2.130:3306/talk","adminRBpTwhh","fT9JJp5d1aGb");
       
    }

  
    public static List<Post> getPosts() throws SQLException, ClassNotFoundException {
        // return posts;
        try(Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("select id, txt from posts");
        ResultSet resultSet = ps.executeQuery();) {

            ArrayList<Post> posts = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String txt = resultSet.getString(2);
                posts.add(new Post(id, txt));
            }
            return posts;
        }
    }

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            System.out.println(getPosts());
    }



/**
        try(){

        }catch (ClassNotFoundException c){
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
*/
    public static void deletePost(int id) throws SQLException, ClassNotFoundException{

        try(Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM posts WHERE id =?");
            ) {
            ps.setInt(1,id);
            ps.executeUpdate();
        }



      /**  Post d = null;
        for(Post p: posts){
            if(p.id == id){
                d=p;

            }
        }
        if (d != null){
            posts.remove(d);
        }*/
    }

    public static void addPost(String txt) throws SQLException, ClassNotFoundException {

        try(Connection c = getConnection();
               
                                   
          
                        
            PreparedStatement ps = c.prepareStatement("INSERT INTO posts (txt) VALUES (?)");
        ) {
            ps.setString(1, txt);
            ps.executeUpdate();
        }

     //   posts.add(new Post(posts.size(),txt));
    }

   
}
