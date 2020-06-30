/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.now.arifikhsanudin.netbeanspostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author arifikhsanudin
 */
public class Repository {
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;
    private final String url = "jdbc:postgresql://localhost/netbeans_siakad";
    private final String user = "postgres";
    private final String password = "postgres";
    
    public Repository() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ArrayList<String> getUsers() {
        ArrayList<String> list = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT * from students");
            while (resultSet.next()) {
                list.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
