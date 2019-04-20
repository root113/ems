package sample;

import java.sql.*;

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
        ps = con.prepareStatement("SELECT * FROM sys.info WHERE username=? AND password=?");
        ps.setString(1,username);
        ps.setString(2,password);

        //String query = "SELECT * FROM sys.info WHERE username='" + username + "' AND password='" + password + "'";

        rs = ps.executeQuery();
        System.out.println("Hi");
    }
}
