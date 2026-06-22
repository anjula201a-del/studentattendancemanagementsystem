/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import lk.ijse.studentattendancemanagementsystem.db.DBConnection;
/**
 *
 * @author ACER
 */
public class CrudUtil {
     private static PreparedStatement getPreparedStatement(String sql, Object...values)throws SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
         PreparedStatement pstm = conn.prepareStatement(sql);
            
            int i = 0;
            for (Object value : values) {
                ++i;
                pstm.setObject(i, value);
            }
            return pstm;
        
    }
    
      public static boolean executeUpdate(String sql, Object...values) throws SQLException {
       PreparedStatement pstm=getPreparedStatement(sql,values);
       int result= pstm.executeUpdate();
       return result>0;
       
    }
      
      
      
       public static ResultSet executeQuery(String sql, Object...values) throws SQLException {
         PreparedStatement pstm=getPreparedStatement(sql,values);
       ResultSet result= pstm.executeQuery();
       return result;
       
}
}
