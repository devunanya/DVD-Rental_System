package com.DVD.System;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ihunanyachi
 */
import java.io.File;
import java.sql.*;
import javax.swing.*;
public class databaseConnection {
    
    Connection conn = null;
    
    public static Connection ConnecrDb(){
        try{
            File db = new File("DVD_Rental_System_Database.sqlite");
       
       File dbpath = db.getAbsoluteFile();
       String dbpaths = dbpath.getAbsolutePath();
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:"+dbpaths);
            return conn;
            
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
   
}
