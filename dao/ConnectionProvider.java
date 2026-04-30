/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
/**
 *
 * @author fjrla
 */
public class ConnectionProvider {
    public static Connection getCon() {
        try{
          Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/cms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
            "root",
            "Gr@bme09153620234"
        );
            return con;
        
        } catch (Exception e){
             e.printStackTrace();
            return null;
        }
    }
}
