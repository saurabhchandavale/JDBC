package com.jdbc.practice;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBCImage {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");
            Statement st = con.createStatement();

            String q = "insert into images(pic) values(?)";
            PreparedStatement patmt = con.prepareStatement(q);
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            patmt.setBinaryStream(1,fis,fis.available());
            patmt.executeUpdate();
            //System.out.println("Done");
            JOptionPane.showMessageDialog(null,"success");



        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }






