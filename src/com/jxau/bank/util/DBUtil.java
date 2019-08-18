package com.jxau.bank.util;

import java.sql.*;

public class DBUtil {
    public static Connection getConn() {
        Connection conn=null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/banksystem?user=root&password=123456&useUnicode=true&characterEncoding=utf-8&useSSL=true");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn,PreparedStatement ps,ResultSet rs) {

        if(rs!=null) {
            try {
                rs.close();
                rs=null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if(ps!=null) {
            try {
                ps.close();
                ps=null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if(conn!=null) {
            try {
                conn.close();
                conn=null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
