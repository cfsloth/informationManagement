/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informantionmanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CláudioFilipedaSilva
 */
public class DatabaseConection {
    Connection c;
    Statement stmt;
        
    public DatabaseConection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/InformationManagement",
            "postgre", "claudiofilipe21");
    }
    
    public ResultSet execSelect(String query) throws SQLException{
        stmt = c.createStatement();
        return stmt.executeQuery(query);
    }
}
