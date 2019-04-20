package sample;

import javafx.fxml.FXMLLoader;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.lang.String;

public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    //Getters & Setters
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public DBConnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useUnicode=true&usetetimeCode=false&serverTimezone=Turkey","root","orapronobislucifer");
            st = con.createStatement();
        }
        catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
    public void checkUser(String username,String password) throws SQLException {
        try{
            ps = con.prepareStatement("SELECT * FROM sys.info WHERE username=? AND password=?");
            ps.setString(1,username);
            ps.setString(2,password);

            rs = ps.executeQuery();

            if(!rs.next()) {
                JOptionPane.showMessageDialog(null,"Wrong username or password. Please try again.");
            }
        }
        catch(SQLException sql){
            System.out.println(sql);
        }
        finally {
            con.close();
            ps.close();
            rs.close();
            st.close();
        }
    }

}
