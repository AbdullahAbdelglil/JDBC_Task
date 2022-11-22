package org.example;
import java.sql.*;
public class SingleToneConnection {
    private String dbUrl="jdbc:mysql://localhost:3306/jdbctask?useSSL=false";
    private String userName="student";
    private String passWord="Abdullah2002";
    protected boolean connected=false;

    Connection myConnection;
    private SingleToneConnection(){

    }

    private static SingleToneConnection connection=null;

    public static SingleToneConnection getInstance(){
        if (connection==null){
            connection=new SingleToneConnection();
        }
        return connection;
    }

    public  Connection connectToDatabase(){
        try{
            myConnection =DriverManager.getConnection(dbUrl,userName,passWord);
            connected=true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return myConnection;
    }

    //override to test
    public void connectToDatabase(String url,String name,String pass){
        try{
            myConnection =DriverManager.getConnection(url,name,pass);
            System.out.println(dbUrl);
            connected=true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
