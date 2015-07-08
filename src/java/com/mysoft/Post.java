package com.mysoft;

/**
 * Created by barm on 10.06.2015.
 */
public class Post {
    int id;
    String txt;

   // public Post(){}

    public Post(int id, String txt){
        this.id = id;
        this.txt = txt;
    }

    public int getId() {
        return id;
    }

    public String getTxt() {
        return txt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString(){
        return "Post{" +
                "id=" + id +
                ", txt='" + txt + '\'' +
                '}';
    }

}
