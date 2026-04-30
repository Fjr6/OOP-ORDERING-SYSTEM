/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.User;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UserDao {

    public static void save(User user) {
        String query = "INSERT INTO user(name,email,mobileNumber,address,password,securityQuestion,answer,status) " +
                       "VALUES('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" +
                       user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" +
                       user.getAnswer() + "','" + user.getStatus() + "')";
        
        DbOperations.setDataorDelete(query, "Registered Successfully! Wait for Admin Approval!");
    }
    
    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData(
                "SELECT * FROM user WHERE email='" + email + "' AND password='" + password + "'"
            );

            if (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
}