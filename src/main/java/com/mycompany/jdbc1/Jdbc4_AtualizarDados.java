/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.jdbc1;

import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author crist
 */
public class Jdbc4_AtualizarDados {

    public static void main(String[] args) {
      Connection conn = null;
      PreparedStatement st = null;
      
      try{
          conn = DB.getConnection();
          st= conn.prepareStatement("UPDATE seller SET BaseSalary = BaseSalary + ? WHERE (DepartmentId = ?)");
          
          st.setDouble(1, 200.00);
          st.setInt(2, 2);
          
          int rowsAffected = st.executeUpdate();
          
          System.out.println("Done! Rows Affected: " + rowsAffected);
      }catch(SQLException e){
          e.printStackTrace();
      }finally{
          DB.closeStatement(st);
          DB.closeConnetion(); 
      }
    }
 }
