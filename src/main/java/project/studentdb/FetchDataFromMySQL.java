/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.studentdb;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class FetchDataFromMySQL {
    private Connection connection = null;
    public ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private final String url = "jdbc:mysql://localhost:3306/school";
    private final String username = "root";
    private final String password = "Qwerty@123";    
    
    FetchDataFromMySQL() {   
        try {
            connection = DriverManager.getConnection(url,username, password);
        } catch (SQLException e) {
             // Capture the stack trace as a string
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();

            // Show the stack trace in a dialog box
            JOptionPane.showMessageDialog(null, "An exception occurred:\n" + e.getMessage() + "\n\n" + stackTrace, "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    
    public ResultSet fetchData(String query) {
        try {
               preparedStatement = connection.prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
             return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
