/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group7.core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Daniel
 */
public class dbcon {
   String host ="jdbc:derby://localhost:1527/7chan";
   String user = "daniel";
   String pass = "root";
   Connection con;
   public dbcon() throws SQLException{
       con = DriverManager.getConnection(host,user,pass);
   }
   
   public ResultSet do_query(String query){
       try {
           Statement stmt = con.createStatement();
           return stmt.executeQuery(query);
       } catch (SQLException ex) {
           return null;
       }
   }
}
