/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DVD.System;

import java.awt.HeadlessException;
import java.io.File;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
/**
 *
 * @author Ihunanyachi
 */
public class AdminMainFrame extends javax.swing.JFrame {
Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
    /**
     * Creates new form AdminMainFrame
     */
    public AdminMainFrame() {
        initComponents();
        conn = databaseConnection.ConnecrDb();
        UpDate_TableCustomer();
        Update_TableDVD();
        Update_TableDVD_Rental();
        UpdateSales();
       
    }
 private void UpDate_TableCustomer(){
  try{
    String sql = "select ID,Name,Surname,Email,DOB,Address,City,Post_Code,Phone,Image,Gender from customer";
    pst = conn.prepareStatement(sql);
    rs = pst.executeQuery();
    table_allCustomer.setModel(DbUtils.resultSetToTableModel(rs));
    rs.close();
    pst.close();
}  
    catch(SQLException e){
    JOptionPane.showMessageDialog(null, e);
    
}finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
}
 private void UpDate_TableCustomerDelete(){
 String ID = txt_deleteCustomer.getText();
        try{
           String sql = "select ID,Name,Surname,Email,DOB,Address,City,Post_Code,Phone,Gender from customer where ID='"+ID+"'";
           pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_deleteCustomer.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            pst.close();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
        finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
}
 private void UpdateTableCustomerEdit(){
    String ID = txt_customerEdit.getText();
        try{
           String sql = "select ID,Name,Surname,Email,DOB,Address,City,Post_Code,Phone,Gender from customer where ID='"+ID+"'";
           pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_customerEdit.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            pst.close();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
        finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
}
 /**
  * updates the sales table automatically 
  * when items are added to it
  */
private void UpdateSales(){
    try{
        String sql = "select * from sales";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        table_sales.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
        pst.close();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
}
private void DVDdeleteTable(){
    try{
           String ID = txt_deletedvd.getText();
         String sql = "select dvd_id,title,genre,rated,date_released,availability from DVD where dvd_id='"+ID+"'";
           pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_deletedvd.setModel(DbUtils.resultSetToTableModel(rs)); 
            rs.close();
            pst.close();
       }catch(SQLException e){
           JOptionPane.showConfirmDialog(null, e);
       }finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
}
private void DVDEditTable(){
    try{
           String ID = txt_dvd_edit.getText();
         String sql = "select dvd_id,title,genre,rated,date_released,availability from DVD where dvd_id='"+ID+"'";
           pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_editDVD.setModel(DbUtils.resultSetToTableModel(rs)); 
            rs.close();
            pst.close();
       }catch(SQLException e){
           JOptionPane.showConfirmDialog(null, e);
       }finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
}
private void Update_TableDVD(){
    try{
    String sql = "select dvd_id,title,genre,rated,date_released,availability from DVD";
    pst = conn.prepareStatement(sql);
    rs = pst.executeQuery();
    table_DVD.setModel(DbUtils.resultSetToTableModel(rs));
    rs.close();
    pst.close();
}  
    catch(SQLException e){
    JOptionPane.showMessageDialog(null, e);
    
}finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
    
}

/**
 * Updates the DVD current rentals table
 */
private void Update_TableDVD_Rental(){
    try{
    String sql = "select * from currentRentals";
    pst = conn.prepareStatement(sql);
    rs = pst.executeQuery();
    table_currentRental.setModel(DbUtils.resultSetToTableModel(rs));
    rs.close();
    pst.close();
}  
    catch(SQLException e){
    JOptionPane.showMessageDialog(null, e);
    
}finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        } 
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cmd_customer = new javax.swing.JButton();
        cmd_signOut = new javax.swing.JButton();
        cmd_dvd = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        tab_customer = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_surname = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_city = new javax.swing.JTextField();
        txt_postcode = new javax.swing.JTextField();
        txt_image = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_address = new javax.swing.JTextArea();
        combo_gender = new javax.swing.JComboBox();
        txt_phone = new javax.swing.JTextField();
        cmd_AddCustomer = new javax.swing.JButton();
        cmd_attach = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txt_DOB = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cmd_attach1 = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_phone1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txt_email1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_name1 = new javax.swing.JTextField();
        txt_surname1 = new javax.swing.JTextField();
        cmd_updateCustomer = new javax.swing.JButton();
        txt_city1 = new javax.swing.JTextField();
        txt_id1 = new javax.swing.JTextField();
        txt_image1 = new javax.swing.JTextField();
        txt_postcode1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_address1 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_customerEdit = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        txt_customerEdit = new javax.swing.JTextField();
        btn_male1 = new javax.swing.JRadioButton();
        btn_female1 = new javax.swing.JRadioButton();
        txt_DOB1 = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txt_deleteCustomer = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_deleteCustomer = new javax.swing.JTable();
        cmd_deleteCustomer = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txt_phone2 = new javax.swing.JTextField();
        image2 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_image2 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txt_email2 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txt_name2 = new javax.swing.JTextField();
        txt_surname2 = new javax.swing.JTextField();
        txt_postcode2 = new javax.swing.JTextField();
        txt_city2 = new javax.swing.JTextField();
        combo_gender2 = new javax.swing.JComboBox();
        txt_id2 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txt_address2 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_search = new javax.swing.JTable();
        txt_srchname = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txt_srchsurname = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txt_srchid = new javax.swing.JTextField();
        cmd_search = new javax.swing.JButton();
        txt_DOB2 = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_allCustomer = new javax.swing.JTable();
        tab_dvd = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_dvdid = new javax.swing.JTextField();
        txt_title = new javax.swing.JTextField();
        combo_genre = new javax.swing.JComboBox();
        combo_rated = new javax.swing.JComboBox();
        check_available = new javax.swing.JCheckBox();
        txt_imagepath = new javax.swing.JTextField();
        cmd_AddDVD = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        txt_dvdimage = new javax.swing.JLabel();
        cmd_imagepath = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        txt_dvdprice = new javax.swing.JTextField();
        txt_date = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        combo_genre1 = new javax.swing.JComboBox();
        cmd_updateDVD = new javax.swing.JButton();
        combo_rated1 = new javax.swing.JComboBox();
        txt_dvdid1 = new javax.swing.JTextField();
        txt_title1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        check_available1 = new javax.swing.JCheckBox();
        jLabel51 = new javax.swing.JLabel();
        txt_imagepath1 = new javax.swing.JTextField();
        cmd_DVDimageAttach = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        txt_dvdimage1 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        table_editDVD = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        txt_dvd_edit = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        txt_dvdprice1 = new javax.swing.JTextField();
        txt_date1 = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        cmd_deletedvd = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        table_deletedvd = new javax.swing.JTable();
        jLabel63 = new javax.swing.JLabel();
        txt_deletedvd = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        txt_imagepath2 = new javax.swing.JTextField();
        txt_dvdid2 = new javax.swing.JTextField();
        txt_srchDVDid = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        combo_rated2 = new javax.swing.JComboBox();
        check_available2 = new javax.swing.JCheckBox();
        jLabel56 = new javax.swing.JLabel();
        combo_genre2 = new javax.swing.JComboBox();
        txt_dvdimage2 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        table_searchDVD = new javax.swing.JTable();
        txt_title2 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txt_srchDVDtitle = new javax.swing.JTextField();
        cmd_serachDVD = new javax.swing.JButton();
        cmd_rentDVD = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        txt_dvdprice2 = new javax.swing.JTextField();
        txt_date2 = new com.toedter.calendar.JDateChooser();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        table_DVD = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        table_currentRental = new javax.swing.JTable();
        viewReciept = new javax.swing.JButton();
        sendEmail = new javax.swing.JButton();
        returnDVD = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        table_sales = new javax.swing.JTable();
        cmd_print_sales = new javax.swing.JButton();
        cmd_srch_sales = new javax.swing.JButton();
        txt_srch_sales = new com.toedter.calendar.JDateChooser();
        txt_srch_sales1 = new com.toedter.calendar.JDateChooser();
        cmd_resetTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Work Area - RENTAPP");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Main Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        cmd_customer.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ikwerreninja\\Downloads\\customers-icon.gif")); // NOI18N
        cmd_customer.setText("Customer");
        cmd_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_customerActionPerformed(evt);
            }
        });

        cmd_signOut.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ikwerreninja\\Downloads\\signouticon.jpg")); // NOI18N
        cmd_signOut.setText("Sign Out");
        cmd_signOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_signOutActionPerformed(evt);
            }
        });

        cmd_dvd.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ikwerreninja\\Downloads\\dvdicon2.jpg")); // NOI18N
        cmd_dvd.setText("DVDs");
        cmd_dvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_dvdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmd_customer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmd_dvd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmd_signOut, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmd_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(cmd_dvd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(cmd_signOut, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel68.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ikwerreninja\\Desktop\\dvd rental store frontpage.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 961, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLayeredPane1.add(jPanel2);
        jPanel2.setBounds(10, 0, 990, 590);
        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.PALETTE_LAYER);

        jPanel3.setPreferredSize(new java.awt.Dimension(975, 502));

        jLabel9.setText("Name :");

        jLabel10.setText("Gender :");

        jLabel11.setText("ID :");

        jLabel12.setText("Address :");

        jLabel13.setText("Post Code :");

        jLabel14.setText("Telephone/Mobile :");

        jLabel15.setText("Image Path: ");

        jLabel17.setText("Surname :");

        jLabel18.setText("Email :");

        jLabel19.setText("DOB :");

        jLabel20.setText("City :");

        txt_image.setEnabled(false);

        txt_address.setColumns(20);
        txt_address.setRows(5);
        jScrollPane1.setViewportView(txt_address);

        combo_gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Gender", "Male", "Female" }));

        cmd_AddCustomer.setText("    Add   Customer");
        cmd_AddCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmd_AddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_AddCustomerActionPerformed(evt);
            }
        });

        cmd_attach.setText("Browse");
        cmd_attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_attachActionPerformed(evt);
            }
        });

        txt_DOB.setDateFormatString("yyyy-MM-d");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel14))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(307, 307, 307)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_postcode)
                            .addComponent(txt_image, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmd_AddCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel19))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combo_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(41, 41, 41)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(cmd_attach))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txt_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel19))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmd_attach)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_image, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_postcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmd_AddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tab_customer.addTab("Add Customer ", jPanel3);

        jLabel22.setText("Name :");

        jLabel23.setText("Address :");

        jLabel24.setText("Gender :");

        jLabel25.setText("ID :");

        cmd_attach1.setText("Browse");
        cmd_attach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_attach1ActionPerformed(evt);
            }
        });

        jLabel27.setText("Post Code :");

        jLabel28.setText("Telephone/Mobile :");

        jLabel29.setText("Image Path: ");

        jLabel30.setText("Surname :");

        jLabel31.setText("Email :");

        jLabel32.setText("DOB :");

        jLabel33.setText("City :");

        cmd_updateCustomer.setText("Update\n Customer");
        cmd_updateCustomer.setActionCommand("UpdateCustomer");
        cmd_updateCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmd_updateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_updateCustomerActionPerformed(evt);
            }
        });

        txt_image1.setEnabled(false);

        txt_address1.setColumns(20);
        txt_address1.setRows(5);
        jScrollPane4.setViewportView(txt_address1);

        table_customerEdit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_customerEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_customerEditMouseClicked(evt);
            }
        });
        table_customerEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table_customerEditKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(table_customerEdit);

        jLabel34.setText("Customer ID :");

        txt_customerEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_customerEditActionPerformed(evt);
            }
        });
        txt_customerEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_customerEditKeyReleased(evt);
            }
        });

        buttonGroup1.add(btn_male1);
        btn_male1.setText("Male");
        btn_male1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_male1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(btn_female1);
        btn_female1.setText("Female");
        btn_female1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_female1ActionPerformed(evt);
            }
        });

        txt_DOB1.setDateFormatString("yyyy-MM-d");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel34)
                .addGap(40, 40, 40)
                .addComponent(txt_customerEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel33))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_city1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_phone1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(253, 253, 253)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel29))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_postcode1)
                                    .addComponent(txt_image1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addGap(83, 83, 83)
                                        .addComponent(txt_DOB1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel24))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(txt_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_male1)
                                                .addGap(28, 28, 28)
                                                .addComponent(btn_female1)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_surname1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_email1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(cmd_updateCustomer)
                        .addGap(71, 71, 71)
                        .addComponent(cmd_attach1)
                        .addGap(48, 48, 48)))
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txt_customerEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txt_surname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(txt_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel31)
                                .addComponent(jLabel24)
                                .addComponent(btn_male1)
                                .addComponent(btn_female1))
                            .addComponent(txt_email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25))
                            .addComponent(txt_DOB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel23))))
                    .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmd_attach1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(txt_phone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_city1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(txt_image1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(txt_postcode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(32, 32, 32)
                .addComponent(cmd_updateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        tab_customer.addTab("Edit Customer ", jPanel4);

        jLabel21.setText("Customer ID :");

        txt_deleteCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_deleteCustomerKeyReleased(evt);
            }
        });

        table_deleteCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table_deleteCustomer);

        cmd_deleteCustomer.setText("Delete");
        cmd_deleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_deleteCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(txt_deleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(396, 396, 396)
                        .addComponent(cmd_deleteCustomer)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_deleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(cmd_deleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        tab_customer.addTab("Delete Customer ", jPanel5);

        jLabel35.setText("Email :");

        txt_phone2.setEnabled(false);

        jLabel37.setText("Gender :");

        jLabel38.setText("ID :");

        jLabel39.setText("Image Path: ");

        jLabel40.setText("Surname :");

        jLabel41.setText("Post Code :");

        jLabel42.setText("Telephone/Mobile :");

        txt_image2.setEnabled(false);

        jLabel43.setText("Name :");

        jLabel44.setText("Address :");

        txt_email2.setEnabled(false);

        jLabel45.setText("City :");

        txt_name2.setEnabled(false);

        txt_surname2.setEnabled(false);

        txt_postcode2.setEnabled(false);

        txt_city2.setEnabled(false);

        combo_gender2.setEnabled(false);

        txt_id2.setEnabled(false);

        txt_address2.setColumns(20);
        txt_address2.setRows(5);
        txt_address2.setEnabled(false);
        jScrollPane6.setViewportView(txt_address2);

        table_search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_searchMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(table_search);

        txt_srchname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_srchnameActionPerformed(evt);
            }
        });
        txt_srchname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_srchnameKeyReleased(evt);
            }
        });

        jLabel46.setText("Name :");

        jLabel47.setText("DOB :");

        jLabel48.setText("Surname : ");

        jLabel49.setText("Customer ID :");

        cmd_search.setText("Search");
        cmd_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_searchActionPerformed(evt);
            }
        });

        txt_DOB2.setDateFormatString("yyyy-MM-d");
        txt_DOB2.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel46)
                .addGap(40, 40, 40)
                .addComponent(txt_srchname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_srchsurname, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_srchid, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmd_search, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel45))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_city2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_phone2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(253, 253, 253)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel39))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_postcode2)
                                    .addComponent(txt_image2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel37))
                                        .addGap(67, 67, 67))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addGap(81, 81, 81)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo_gender2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_DOB2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_surname2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_email2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(image2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7))
                .addGap(22, 22, 22))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(txt_srchname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48)
                            .addComponent(txt_srchsurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)
                            .addComponent(txt_srchid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(cmd_search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txt_surname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43)
                            .addComponent(txt_name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel35)
                                .addComponent(combo_gender2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel37))
                            .addComponent(txt_email2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel47)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel38))
                            .addComponent(txt_DOB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel44))))
                    .addComponent(image2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(txt_phone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_city2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(txt_image2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(txt_postcode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        tab_customer.addTab("Search Customer ", jPanel6);

        table_allCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(table_allCustomer);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab_customer.addTab("View All Customers ", jPanel7);

        jLayeredPane1.add(tab_customer);
        tab_customer.setBounds(10, 10, 990, 610);
        jLayeredPane1.setLayer(tab_customer, javax.swing.JLayeredPane.PALETTE_LAYER);

        tab_dvd.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("DVD ID:");

        jLabel2.setText("Title :");

        jLabel3.setText("Genre :");

        jLabel4.setText("Rated :");

        jLabel5.setText("Date Released :");

        jLabel6.setText("Availability :");

        jLabel7.setText("Upload DVD Photo :");

        combo_genre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Genre", "Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary", "Drama", "Family", "Fantasy", "Film-Noir", "Game-Show", "History", "Horror", "Music", "Musical", "Mystery", "News", "Reality-TV", "Romance", "Sci-Fi", "Sport", "Talk-Show", "Thriller", "War", "Western" }));

        combo_rated.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select PG", "G", "PG", "PG-13", "R", "NC-17", "R-18" }));

        check_available.setText("Available");
        check_available.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_availableActionPerformed(evt);
            }
        });

        cmd_AddDVD.setText("Add DVD");
        cmd_AddDVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_AddDVDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        cmd_imagepath.setText("Browse");
        cmd_imagepath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_imagepathActionPerformed(evt);
            }
        });

        jLabel65.setText("Price :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_genre, 0, 120, Short.MAX_VALUE)
                            .addComponent(txt_title)
                            .addComponent(txt_dvdid)))
                    .addComponent(cmd_AddDVD)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(check_available))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_imagepath, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(68, 68, 68))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel65))
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_dvdprice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(combo_rated, 0, 120, Short.MAX_VALUE)
                            .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(txt_dvdimage, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(482, 482, 482))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(550, 550, 550)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(cmd_imagepath)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_dvdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(combo_genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(combo_rated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dvdprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(check_available)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_imagepath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(cmd_AddDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(txt_dvdimage, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmd_imagepath)
                        .addGap(42, 42, 42)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(174, Short.MAX_VALUE))
        );

        tab_dvd.addTab("Add DVD ", jPanel8);

        combo_genre1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Genre", "Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary", "Drama", "Family", "Fantasy", "Film-Noir", "Game-Show", "History", "Horror", "Music", "Musical", "Mystery", "News", "Reality-TV", "Romance", "Sci-Fi", "Sport", "Talk-Show", "Thriller", "War", "Western" }));

        cmd_updateDVD.setText("Update DVD");
        cmd_updateDVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_updateDVDActionPerformed(evt);
            }
        });

        combo_rated1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select PG", "G", "PG", "PG-13", "R", "NC-17", "R-18" }));

        jLabel8.setText("Genre :");

        jLabel26.setText("Title :");

        jLabel36.setText("Date Released :");

        jLabel50.setText("Rated :");

        check_available1.setText("Available");
        check_available1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_available1ActionPerformed(evt);
            }
        });

        jLabel51.setText("DVD ID:");

        cmd_DVDimageAttach.setText("Browse");
        cmd_DVDimageAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_DVDimageAttachActionPerformed(evt);
            }
        });

        jLabel52.setText("Availability :");

        jLabel53.setText("Upload DVD Photo :");

        table_editDVD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_editDVD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_editDVDMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(table_editDVD);

        jLabel54.setText("DVD ID :");

        txt_dvd_edit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dvd_editKeyReleased(evt);
            }
        });

        jLabel66.setText("Price :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(442, 442, 442)
                        .addComponent(cmd_DVDimageAttach))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel54)
                        .addGap(27, 27, 27)
                        .addComponent(txt_dvd_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_dvdid1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel8))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_genre1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_title1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addGap(68, 68, 68)
                                .addComponent(combo_rated1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(check_available1)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_imagepath1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmd_updateDVD)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dvdprice1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(73, 73, 73)
                        .addComponent(txt_dvdimage1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txt_dvd_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txt_dvdimage1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmd_DVDimageAttach))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(txt_dvdid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txt_title1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(combo_genre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(combo_rated1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(txt_date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(txt_dvdprice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(check_available1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(txt_imagepath1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(cmd_updateDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        tab_dvd.addTab("Edit DVD ", jPanel9);

        cmd_deletedvd.setText("Delete");
        cmd_deletedvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_deletedvdActionPerformed(evt);
            }
        });

        table_deletedvd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(table_deletedvd);

        jLabel63.setText("DVD ID:");

        txt_deletedvd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_deletedvdKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel63)
                        .addGap(18, 18, 18)
                        .addComponent(txt_deletedvd, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(441, 441, 441)
                        .addComponent(cmd_deletedvd, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(txt_deletedvd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(cmd_deletedvd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        tab_dvd.addTab("Delete DVD ", jPanel10);

        txt_imagepath2.setEnabled(false);

        txt_dvdid2.setEnabled(false);

        jLabel55.setText("DVD ID:");

        combo_rated2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "     ", "G", "PG", "PG-13", "R", "NC-17", "R-18" }));
        combo_rated2.setEnabled(false);

        check_available2.setText("Available");
        check_available2.setEnabled(false);

        jLabel56.setText("Rated :");

        combo_genre2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "         ", "Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary", "Drama", "Family", "Fantasy", "Film-Noir", "Game-Show", "History", "Horror", "Music", "Musical", "Mystery", "News", "Reality-TV", "Romance", "Sci-Fi", "Sport", "Talk-Show", "Thriller", "War", "Western" }));
        combo_genre2.setEnabled(false);

        jLabel57.setText("Availability :");

        jLabel58.setText("Date Released :");

        jLabel59.setText("Upload DVD Photo :");

        jLabel60.setText("Title :");

        jLabel61.setText("DVD ID :");

        jLabel62.setText("Genre :");

        table_searchDVD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_searchDVD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_searchDVDMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(table_searchDVD);

        txt_title2.setEnabled(false);

        jLabel64.setText("Title :");

        cmd_serachDVD.setText("Search");
        cmd_serachDVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_serachDVDActionPerformed(evt);
            }
        });

        cmd_rentDVD.setText("Rent DVD");
        cmd_rentDVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_rentDVDActionPerformed(evt);
            }
        });

        jLabel67.setText("Price :");

        txt_dvdprice2.setEnabled(false);

        txt_date2.setDateFormatString("yyyy-MM-d");
        txt_date2.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel61)
                .addGap(28, 28, 28)
                .addComponent(txt_srchDVDid, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel64)
                .addGap(50, 50, 50)
                .addComponent(txt_srchDVDtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(cmd_serachDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_dvdid2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel62))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_genre2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_title2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addGap(68, 68, 68)
                                .addComponent(combo_rated2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(check_available2)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_imagepath2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_dvdprice2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_date2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(73, 73, 73)
                        .addComponent(txt_dvdimage2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185)
                        .addComponent(cmd_rentDVD)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(txt_srchDVDid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64)
                            .addComponent(txt_srchDVDtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmd_serachDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txt_dvdimage2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(txt_dvdid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(txt_title2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62)
                            .addComponent(combo_genre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(combo_rated2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel58)
                            .addComponent(txt_date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(txt_dvdprice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(check_available2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(txt_imagepath2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmd_rentDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        tab_dvd.addTab("Search DVD ", jPanel11);

        table_DVD.setBackground(new java.awt.Color(204, 204, 204));
        table_DVD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table_DVD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(table_DVD);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        tab_dvd.addTab("View All DVDs ", jPanel12);

        table_currentRental.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_currentRental.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_currentRentalMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(table_currentRental);

        viewReciept.setText("View Reciept");
        viewReciept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRecieptActionPerformed(evt);
            }
        });

        sendEmail.setText("Send Email");
        sendEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEmailActionPerformed(evt);
            }
        });

        returnDVD.setText("Return DVD");
        returnDVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnDVDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendEmail)
                .addGap(77, 77, 77)
                .addComponent(returnDVD)
                .addGap(62, 62, 62)
                .addComponent(viewReciept)
                .addGap(85, 85, 85))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewReciept, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        tab_dvd.addTab("Current Rentals", jPanel13);

        table_sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(table_sales);

        cmd_print_sales.setText("Print Table");
        cmd_print_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_print_salesActionPerformed(evt);
            }
        });

        cmd_srch_sales.setText("OK");
        cmd_srch_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_srch_salesActionPerformed(evt);
            }
        });

        txt_srch_sales.setDateFormatString("yyyy-MM-dd");

        txt_srch_sales1.setDateFormatString("yyyy-MM-dd");

        cmd_resetTable.setText("Reset Table");
        cmd_resetTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_resetTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(cmd_print_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmd_resetTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_srch_sales, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmd_srch_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_srch_sales1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(cmd_print_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_srch_sales1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_srch_sales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd_srch_sales)
                    .addComponent(cmd_resetTable))
                .addGap(29, 29, 29))
        );

        tab_dvd.addTab("Sales", jPanel15);

        jLayeredPane1.add(tab_dvd);
        tab_dvd.setBounds(10, 10, 990, 610);
        jLayeredPane1.setLayer(tab_dvd, javax.swing.JLayeredPane.PALETTE_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 53, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1220, 722));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * Set the position of the customer tab to the current position
 * which is at position zero
 * @param evt 
 */
    private void cmd_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_customerActionPerformed
    jLayeredPane1.setPosition(tab_customer, 0);
    jLayeredPane1.setPosition(tab_dvd, 3);
    }//GEN-LAST:event_cmd_customerActionPerformed
/**
 * Set the position of the dvd tab to the current position
 * which is at position zero
 * @param evt 
 */
    private void cmd_dvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_dvdActionPerformed
jLayeredPane1.setPosition(tab_dvd, 0);
jLayeredPane1.setPosition(tab_customer, 3);
    }//GEN-LAST:event_cmd_dvdActionPerformed

    private void cmd_AddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_AddCustomerActionPerformed
        if (txt_id.getText().isEmpty()|| txt_name.getText().isEmpty() || txt_surname.getText().isEmpty()
                || txt_email.getText().isEmpty() || ((JTextField)txt_DOB.getDateEditor().getUiComponent()).getText().isEmpty() || txt_address.getText().isEmpty()
                || txt_city.getText().isEmpty() || txt_postcode.getText().isEmpty() || txt_phone.getText().isEmpty()
                || txt_image.getText().isEmpty() || combo_gender.getSelectedItem()=="Select Gender"){
            JOptionPane.showMessageDialog(null, "Please Fill out Every Detail");
        }
        else{
        try{
            String sql = "insert into customer(ID,Name,Surname,Email,DOB,Address,City,Post_Code,Phone,Image,Gender) values(?,?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, txt_id.getText());
            pst.setString(2, txt_name.getText());
            pst.setString(3, txt_surname.getText());
            pst.setString(4, txt_email.getText());
            pst.setString(5, ((JTextField)txt_DOB.getDateEditor().getUiComponent()).getText());
            pst.setString(6, txt_address.getText());
            pst.setString(7, txt_city.getText());
            pst.setString(8, txt_postcode.getText());
            pst.setString(9, txt_phone.getText());
            pst.setString(10, txt_image.getText());
            pst.setObject(11, combo_gender.getSelectedItem());
            pst.execute();
       JOptionPane.showMessageDialog(null, "Customer Added Successfully!");
         txt_id.setText(null);
        txt_name.setText(null);
        txt_surname.setText(null);
        txt_email.setText(null);
        txt_DOB.setDate(null);
        txt_address.setText(null);
        txt_city.setText(null);
        txt_postcode.setText(null);
        txt_phone.setText(null);
        combo_gender.setSelectedIndex(0);
        txt_image.setText(null);
        ((JTextField)txt_DOB.getDateEditor().getUiComponent()).setText(null);
       rs.close();
       pst.close();
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "There is a problem with your update variables "+'\n'+"Please Check and Correct Your Values");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There is a problem with your update variables "+'\n'+"Please Check and Correct Your Values");
    }
        finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
      
        
        UpDate_TableCustomer();
        }
    }//GEN-LAST:event_cmd_AddCustomerActionPerformed

    private void cmd_attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_attachActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        txt_image.setText(filename);
        
       /* try{
          File image = new File(filename);  
          FileInputStream fis = new FileInputStream(image);
          ByteArrayOutputStream bos = new ByteArrayOutputStream();
          byte[] buf = new byte[1024];
          for(int readNum; (readNum = fis.read(buf)) != -1;){
            bos.write(buf,0,readNum);
          }
          person_image = bos.toByteArray();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }*/
    }//GEN-LAST:event_cmd_attachActionPerformed

    private void txt_deleteCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_deleteCustomerKeyReleased
       String ID = txt_deleteCustomer.getText();
        try{
           String sql = "select ID,Name,Surname,Email,DOB,Address,City,Post_Code,Phone,Gender from customer where ID='"+ID+"'";
           pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_deleteCustomer.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            pst.close();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
        finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        
    }//GEN-LAST:event_txt_deleteCustomerKeyReleased

    private void cmd_deleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_deleteCustomerActionPerformed
       if(txt_deleteCustomer.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(null, "Please Make Selection");
       }
       else{
       
        int confirmDelete = JOptionPane.showConfirmDialog(null, "Do you really wish to delete!!", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if(confirmDelete == 0 ){
        try{
            String sql = "delete from customer where ID =? ";
            pst =  conn.prepareStatement(sql);
            pst.setString(1, txt_deleteCustomer.getText());
            pst.execute();
        JOptionPane.showMessageDialog(null, "Deleted");
        rs.close();
        pst.close();
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
            
        }   catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "You selection does not exist");
            }
        finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        }
        UpDate_TableCustomer();
        txt_deleteCustomer.setText("");
        UpDate_TableCustomerDelete();
    }
    }//GEN-LAST:event_cmd_deleteCustomerActionPerformed

    private void cmd_signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_signOutActionPerformed
        new Login_Form().setVisible(true);
        dispose();
    }//GEN-LAST:event_cmd_signOutActionPerformed

    private void cmd_attach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_attach1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        txt_image1.setText(filename);
        
       /* try{
          File image = new File(filename);  
          FileInputStream fis = new FileInputStream(image);
          ByteArrayOutputStream bos = new ByteArrayOutputStream();
          byte[] buf = new byte[1024];
          for(int readNum; (readNum = fis.read(buf)) != -1;){
            bos.write(buf,0,readNum);
          }
          person_image2 = bos.toByteArray();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }*/
    }//GEN-LAST:event_cmd_attach1ActionPerformed
    /**
     * This method the customer table on the database when the button
     * is click.
     * @param evt 
     */
    private void cmd_updateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_updateCustomerActionPerformed
        if(txt_id1.getText().isEmpty()|| txt_name1.getText().isEmpty() || txt_surname1.getText().isEmpty()
                || txt_email1.getText().isEmpty() || ((JTextField)txt_DOB1.getDateEditor().getUiComponent()).getText().isEmpty() || txt_address1.getText().isEmpty()
                || txt_city1.getText().isEmpty() || txt_postcode1.getText().isEmpty() || txt_phone1.getText().isEmpty()
                || txt_image1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill out Every Detail");
        }else{
        try{
            String value1 = txt_id1.getText();
             String value2 = txt_name1.getText();
              String value3 = txt_surname1.getText();
               String value4 = ((JTextField)txt_DOB1.getDateEditor().getUiComponent()).getText();
                String value5 = txt_email1.getText();
             String value6 = txt_address1.getText();
              String value7 = txt_city1.getText();
               String value8 = txt_postcode1.getText();
                String value9 = txt_phone1.getText();
             String value10 = Gender;
             String value11 = txt_image1.getText();
             
             
              
            String sql;
            sql = "update customer set ID='"+value1+"', Name='"+value2+"', Surname='"+value3+"', DOB='"+value4+"', Email='"+value5+"', Address='"+value6+"', City='"+value7+"', Post_Code='"+value8+"', Phone='"+value9+"', Image='"+value11+"', Gender='"+value10+"' where ID='"+value1+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Updated!");
          rs.close();
          pst.close();
        }catch(HeadlessException e){
             JOptionPane.showMessageDialog(null, "There is a problem with your update variables "+'\n'+"Please Check and Correct Your Values");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There is a problem with your update variables "+'\n'+"Please Check and Correct Your Values");
    }
        finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        txt_id1.setText(null);
        txt_name1.setText(null);
        txt_surname1.setText(null);
        txt_email1.setText(null);
        txt_DOB1.setDate(null);
        txt_address1.setText(null);
        txt_city1.setText(null);
        txt_postcode1.setText(null);
        txt_phone1.setText(null);
        txt_image1.setText(null);
        btn_female1.setSelected(false);
        btn_male1.setSelected(false);
        
        UpDate_TableCustomer();
        txt_customerEdit.setText("");
        UpdateTableCustomerEdit();
                }
    }//GEN-LAST:event_cmd_updateCustomerActionPerformed

    private void txt_customerEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_customerEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_customerEditActionPerformed
    /**
     * This populates the table with the customer that 
     * his or her ID is entered in the textfiled.
     * @param evt 
     */
    private void txt_customerEditKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_customerEditKeyReleased
        String ID = txt_customerEdit.getText();
        try{
           String sql = "select ID,Name,Surname,Email,DOB,Address,City,Post_Code,Phone,Gender from customer where ID='"+ID+"'";
           pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_customerEdit.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            pst.close();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
        finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
    }//GEN-LAST:event_txt_customerEditKeyReleased

    private void table_customerEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_customerEditMouseClicked
       int row = table_customerEdit.getSelectedRow();
            String Table_click = (table_customerEdit.getModel().getValueAt(row, 0).toString());
            try{
                String sql = "select Image from customer where ID='"+Table_click+"' ";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next()){
                    String imagedata = rs.getString("Image");
                    format = new ImageIcon(imagedata);
                    image.setIcon(format);
                    rs.close();
                    pst.close();
                }
                
            }catch(SQLException e){
            }finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        try{
            
            String sql = "select * from customer where ID='"+Table_click+"' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("ID");
                txt_id1.setText(add1);
                String add2 = rs.getString("Name");
                txt_name1.setText(add2);
                String add3 = rs.getString("Surname");
                txt_surname1.setText(add3);
                Date add4 = rs.getDate("DOB");
                txt_DOB1.setDate(add4);
                String add5 = rs.getString("Email");
                txt_email1.setText(add5);
                String add6 = rs.getString("Address");
                txt_address1.setText(add6);
                String add7 = rs.getString("City");
                txt_city1.setText(add7);
                String add8 = rs.getString("Post_Code");
                txt_postcode1.setText(add8);
                String add9 = rs.getString("Phone");
                txt_phone1.setText(add9);
                String add10 = rs.getString("Gender");
                if("Female".equals(add10)){
                    btn_female1.doClick();
                }
                else if("Male".equals(add10)){
                    btn_male1.doClick();
                }
                String add11 = rs.getString("Image");
                txt_image1.setText(add11);
               
rs.close();
pst.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        txt_customerEdit.setText(null);
    }//GEN-LAST:event_table_customerEditMouseClicked

    private void btn_male1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_male1ActionPerformed
       Gender = "Male";
    }//GEN-LAST:event_btn_male1ActionPerformed

    private void btn_female1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_female1ActionPerformed
        Gender = "Female";
    }//GEN-LAST:event_btn_female1ActionPerformed

    private void table_customerEditKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_customerEditKeyReleased
      
    }//GEN-LAST:event_table_customerEditKeyReleased

    private void cmd_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_searchActionPerformed
        
  
         try{
           String sql = "select ID,Name,Surname,Email,DOB,Address,City,Post_Code,Phone,Gender from customer where ID=? or Name=? or Surname=?";
           pst = conn.prepareStatement(sql);
           pst.setString(1, txt_srchid.getText());
            pst.setString(2, txt_srchname.getText());
             pst.setString(3, txt_srchsurname.getText());
            rs = pst.executeQuery();
            table_search.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            pst.close();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
        finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
         txt_srchid.setText(null);
         txt_srchname.setText(null);
         txt_srchsurname.setText(null);
    }//GEN-LAST:event_cmd_searchActionPerformed

    private void table_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_searchMouseClicked
        int row = table_search.getSelectedRow();
            String Table_click = (table_search.getModel().getValueAt(row, 0).toString());
            try{
                String sql = "select Image from customer where ID='"+Table_click+"' ";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next()){
                   String addimage = rs.getString("Image");
                   format = new ImageIcon(addimage);
                   image2.setIcon(format);
                   rs.close();
                   pst.close();
                }
                
            }catch(SQLException e){
            }finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        try{
            
            String sql = "select * from customer where ID='"+Table_click+"' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("ID");
                txt_id2.setText(add1);
                String add2 = rs.getString("Name");
                txt_name2.setText(add2);
                String add3 = rs.getString("Surname");
                txt_surname2.setText(add3);
                Date add4 = rs.getDate("DOB");
                txt_DOB2.setDate(add4);
                String add5 = rs.getString("Email");
                txt_email2.setText(add5);
                String add6 = rs.getString("Address");
                txt_address2.setText(add6);
                String add7 = rs.getString("City");
                txt_city2.setText(add7);
                String add8 = rs.getString("Post_Code");
                txt_postcode2.setText(add8);
                String add9 = rs.getString("Phone");
                txt_phone2.setText(add9);
                String add10 = rs.getString("Gender");
                combo_gender2.addItem(add10);
                
                rs.close();
                pst.close();
               

            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_table_searchMouseClicked

    private void cmd_deletedvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_deletedvdActionPerformed
      if(txt_deletedvd.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Please make a selection!");
      }
      else{ 
        int confirmDelete = JOptionPane.showConfirmDialog(null, "Do you really wish to delete!!", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if(confirmDelete == 0 ){
        try{
            String sql = "delete from DVD where dvd_id =? ";
            pst =  conn.prepareStatement(sql);
            pst.setString(1, txt_deletedvd.getText());
            pst.execute();
        JOptionPane.showMessageDialog(null, "Deleted");
        rs.close();
        pst.close();
            
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Delete Entry is wrong");
           }finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        
        }
        txt_deletedvd.setText("");
        DVDdeleteTable();
      }
    }//GEN-LAST:event_cmd_deletedvdActionPerformed

    private void txt_deletedvdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_deletedvdKeyReleased
        try{
           String ID = txt_deletedvd.getText();
         String sql = "select dvd_id,title,genre,rated,date_released,availability from DVD where dvd_id='"+ID+"'";
           pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_deletedvd.setModel(DbUtils.resultSetToTableModel(rs)); 
            rs.close();
            pst.close();
       }catch(SQLException e){
           JOptionPane.showConfirmDialog(null, e);
       }finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
    }//GEN-LAST:event_txt_deletedvdKeyReleased

    private void sendEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEmailActionPerformed
  if(table_currentRental.getSelectedRow() == 0 || table_currentRental.getSelectedRow() > 0 ){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        Session session;
    session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("thompsonamadi@gmail.com", "just4free4u");
                }
                

            }
            
    );
        try{
           Message message = new MimeMessage(session); 
           message.setFrom(new InternetAddress("thompsonamadi@gmail.com"));
           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerEmail));
           message.setSubject("Your Rental is Due");
           message.setText("Hello sir/madam, your rental period is over. Please return your DVD ASAP./n Thank you.");
           Transport.send(message);
           JOptionPane.showMessageDialog(null, "Message sent!");
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, e);
    }
  }
  else{
      JOptionPane.showMessageDialog(null, "Please make a selection!!!");
  }
        
    }//GEN-LAST:event_sendEmailActionPerformed

    private void txt_srchnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_srchnameKeyReleased

    }//GEN-LAST:event_txt_srchnameKeyReleased

    private void txt_srchnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_srchnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_srchnameActionPerformed

    private void check_availableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_availableActionPerformed
    availability = "Available";
       
    }//GEN-LAST:event_check_availableActionPerformed

    private void cmd_AddDVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_AddDVDActionPerformed
        if(txt_dvdid.getText().isEmpty() || txt_title.getText().isEmpty() || combo_genre.getSelectedItem()=="Select Genre" 
         || combo_rated.getSelectedItem()=="Select PG" || ((JTextField)txt_date.getDateEditor().getUiComponent()).getText().isEmpty()
         || !check_available.isSelected() || txt_imagepath.getText().isEmpty() || txt_dvdprice.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Please Enter All Fields!");
        }else{
        try{
            String sql = "insert into DVD(dvd_id,title,genre,rated,date_released,availability,image,price) values(?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, txt_dvdid.getText());
            pst.setString(2, txt_title.getText());
            pst.setObject(3, combo_genre.getSelectedItem());
            pst.setObject(4, combo_rated.getSelectedItem());
            pst.setString(5, ((JTextField)txt_date.getDateEditor().getUiComponent()).getText());
            pst.setString(6, availability);
            pst.setString(7, txt_imagepath.getText());
            pst.setString(8, txt_dvdprice.getText());
            
          
            pst.execute();
       JOptionPane.showMessageDialog(null, "DVD Added Successfully!");
       rs.close();
       pst.close();
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
    }finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        Update_TableDVD();
           txt_dvdid.setText(null);
           txt_title.setText(null);
           combo_genre.setSelectedIndex(0);
           combo_rated.setSelectedIndex(0);
           ((JTextField)txt_date.getDateEditor().getUiComponent()).setText(null);
           txt_imagepath.setText(null);
           txt_dvdprice.setText(null);
           check_available.setSelected(false);
        }
    }//GEN-LAST:event_cmd_AddDVDActionPerformed

    private void cmd_imagepathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_imagepathActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        txt_imagepath.setText(filename);
    }//GEN-LAST:event_cmd_imagepathActionPerformed

    private void txt_dvd_editKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dvd_editKeyReleased
       try{
           String ID = txt_dvd_edit.getText();
         String sql = "select dvd_id,title,genre,rated,date_released,availability from DVD where dvd_id='"+ID+"'";
           pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_editDVD.setModel(DbUtils.resultSetToTableModel(rs)); 
            rs.close();
            pst.close();
       }catch(SQLException e){
           JOptionPane.showConfirmDialog(null, e);
       }finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
    }//GEN-LAST:event_txt_dvd_editKeyReleased

    private void table_editDVDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_editDVDMouseClicked
        int row = table_editDVD.getSelectedRow();
            String Table_click = (table_editDVD.getModel().getValueAt(row, 0).toString());
            try{
                String sql = "select image from dvd where dvd_id='"+Table_click+"' ";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next()){
                    String imagedata = rs.getString("image");
                    format = new ImageIcon(imagedata);
                   txt_dvdimage1.setIcon(format);
                   rs.close();
                   pst.close();
                }
                
            }catch(SQLException e){
            }finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        try{
            
            String sql = "select * from DVD where dvd_id='"+Table_click+"' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("dvd_id");
                txt_dvdid1.setText(add1);
                String add2 = rs.getString("title");
                txt_title1.setText(add2);
                
                String add3 = rs.getString("genre");
                if("Action".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Adventure".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Animation".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Biography".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else  if("Comedy".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Crime".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Documentary".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Drama".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Family".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Fantasy".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Film-Noir".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Game-Show".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("History".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Horror".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else  if("Action".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else  if("Music".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Musical".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Mystery".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("News".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Reality-TV".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else  if("Romance".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Sci-Fi".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else  if("Sport".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else  if("Talk-Show".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Thriller".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else  if("War".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                else if("Western".equals(add3)){
                combo_genre1.setSelectedItem(add3);
                }
                String add5 = rs.getString("rated");
                if("G".equals(add5)){
                combo_rated1.setSelectedItem(add5);
                }
                else  if("PG".equals(add5)){
                combo_rated1.setSelectedItem(add5);
                }
                else  if("PG-13".equals(add5)){
                combo_rated1.setSelectedItem(add5);
                }
                else if("R".equals(add5)){
                combo_rated1.setSelectedItem(add5);
                }
               else  if("NC-17".equals(add5)){
                combo_rated1.setSelectedItem(add5);
                }
               else if("R-18".equals(add5)){
                combo_rated1.setSelectedItem(add5);
                }
                Date add4 = rs.getDate("date_released");
                txt_date1.setDate(add4);
                 String add6 = rs.getString("availability");
                if("Available".equals(add6)){
                    check_available1.setSelected(true);
                }else if ("".equals(add6)){
                  check_available1.setSelected(false);
                }
               
                String add11 = rs.getString("image");
                txt_imagepath1.setText(add11);
                String add12 = rs.getString("price");
               txt_dvdprice1.setText(add12);
                rs.close();
                pst.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
    }//GEN-LAST:event_table_editDVDMouseClicked

    private void cmd_updateDVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_updateDVDActionPerformed
 if(txt_dvdid1.getText().isEmpty() || txt_title1.getText().isEmpty() || combo_genre1.getSelectedItem()=="Select Genre" 
         || combo_rated1.getSelectedItem()=="Select PG" || ((JTextField)txt_date1.getDateEditor().getUiComponent()).getText().isEmpty()
         ||  txt_imagepath1.getText().isEmpty() || txt_dvdprice1.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Please Enter All Fields!");
        }else{
        String value1 = txt_dvdid1.getText();
        String value2 = txt_title1.getText();
        Object value3 = combo_genre1.getSelectedItem();
        Object value4 = combo_rated1.getSelectedItem();
        String value5 = ((JTextField)txt_date1.getDateEditor().getUiComponent()).getText();
        String value6 = check_available1.getText();
        String value7 = txt_imagepath1.getText();
        String value8 = txt_dvdprice1.getText();
 
        try{
          String sql = "update DVD set dvd_id='"+value1+"',title='"+value2+"',genre='"+value3+"',rated='"+value4+"',date_released='"+value5+"',availability='"+value6+"',image='"+value7+"',price='"+value8+"' where dvd_id='"+value1+"'";
          pst = conn.prepareStatement(sql);
          pst.execute();
          
          JOptionPane.showMessageDialog(null, "DVD Updated Successfully!");
          rs.close();
          pst.close();
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
    }finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        Update_TableDVD();
           txt_dvdid1.setText(null);
           txt_title1.setText(null);
           combo_genre1.setSelectedIndex(0);
           combo_rated1.setSelectedIndex(0);
           ((JTextField)txt_date1.getDateEditor().getUiComponent()).setText(null);
           txt_imagepath1.setText(null);
           txt_dvdprice1.setText(null);
           check_available1.setSelected(false);
           txt_dvd_edit.setText("");
           DVDEditTable();
 }
    }//GEN-LAST:event_cmd_updateDVDActionPerformed

    private void cmd_serachDVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_serachDVDActionPerformed
        try{
          String sql = "select * from DVD where dvd_id = ? or title=?";
          pst = conn.prepareStatement(sql);
          pst.setString(1, txt_srchDVDid.getText());
          pst.setString(2, txt_srchDVDtitle.getText());
          rs = pst.executeQuery();
          table_searchDVD.setModel(DbUtils.resultSetToTableModel(rs));
          rs.close();
          pst.close();
         
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e, "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        
    }//GEN-LAST:event_cmd_serachDVDActionPerformed

    private void table_searchDVDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_searchDVDMouseClicked
            txt_srchDVDid.setText(null);
            txt_srchDVDtitle.setText(null);
        int row = table_searchDVD.getSelectedRow();
            String Table_click = (table_searchDVD.getModel().getValueAt(row, 0).toString());
            try{
                String sql = "select image from dvd where dvd_id='"+Table_click+"' ";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next()){
                    String imagedata = rs.getString("image");
                    format = new ImageIcon(imagedata);
                   txt_dvdimage2.setIcon(format);
                   rs.close();
                   pst.close();
                }
                
            }catch(SQLException e){
            }
            finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
            
        }
        try{
            
            String sql = "select * from DVD where dvd_id='"+Table_click+"' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("dvd_id");
                txt_dvdid2.setText(add1);
                String add2 = rs.getString("title");
                txt_title2.setText(add2);
                
                String add3 = rs.getString("genre");
                if("Action".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Adventure".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Animation".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Biography".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else  if("Comedy".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Crime".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Documentary".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Drama".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Family".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Fantasy".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Film-Noir".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Game-Show".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("History".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Horror".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else  if("Action".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else  if("Music".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Musical".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Mystery".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("News".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Reality-TV".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else  if("Romance".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Sci-Fi".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else  if("Sport".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else  if("Talk-Show".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Thriller".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else  if("War".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                else if("Western".equals(add3)){
                combo_genre2.setSelectedItem(add3);
                }
                String add5 = rs.getString("rated");
                if("G".equals(add5)){
                combo_rated2.setSelectedItem(add5);
                }
                else  if("PG".equals(add5)){
                combo_rated2.setSelectedItem(add5);
                }
                else  if("PG-13".equals(add5)){
                combo_rated2.setSelectedItem(add5);
                }
                else if("R".equals(add5)){
                combo_rated2.setSelectedItem(add5);
                }
               else  if("NC-17".equals(add5)){
                combo_rated2.setSelectedItem(add5);
                }
               else if("R-18".equals(add5)){
                combo_rated2.setSelectedItem(add5);
                }
                Date add4 = rs.getDate("date_released");
                txt_date2.setDate(add4);
                Double add7 = rs.getDouble("price");
                txt_dvdprice2.setText(add7.toString());
               
                 String add6 = rs.getString("availability");
                if("Available".equals(add6)){
                    check_available2.setSelected(true);
                }else if ("Unavailable".equals(add6)){
                  check_available2.setSelected(false);
                }
               
                String add11 = rs.getString("image");
                txt_imagepath2.setText(add11);
               
                rs.close();
                pst.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                rs.close();
            pst.close();
            }catch(SQLException e){
                
            }
             
        }
    }//GEN-LAST:event_table_searchDVDMouseClicked

    private void cmd_rentDVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_rentDVDActionPerformed
       if(!txt_dvdid2.getText().isEmpty()){
        String dvd1 = txt_dvdid2.getText();
        String dvd2 = txt_title2.getText();
        String dvd3 = combo_genre2.getSelectedItem().toString();
        String dvd4 = combo_rated2.getSelectedItem().toString();
        double dvd5 = Double.parseDouble(txt_dvdprice2.getText());
        
        RentDVD_Frame d = new RentDVD_Frame();
        d.getDVDdetails(dvd1,dvd2,dvd3,dvd4,dvd5);
       
        d.setVisible(true);
        dispose();
    }
        else{
     JOptionPane.showMessageDialog(null, "Please Select DVD to be rented!!!");           
    }
    }//GEN-LAST:event_cmd_rentDVDActionPerformed

    private void table_currentRentalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_currentRentalMouseClicked
        row = table_currentRental.getSelectedRow();
      table_clicked = (table_currentRental.getModel().getValueAt(row, 0)).toString();
        
        try{
            String sql = "select * from currentRentals where customer_id='"+table_clicked+"'";
         pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
             if(rs.next()){
                 customerid = rs.getString("customer_id");
                 customerEmail = rs.getString("customer_email");
                 customerName = rs.getString("customer_name");
                 dvdtitle = rs.getString("dvd_title");
                 dvdgenre = rs.getString("dvd_genre");
                 dvdprice = rs.getDouble("dvd_price");
                 dvdrentedDate = rs.getString("rented_date");
                 dvdreturnDate = rs.getString("return_date");
                 dvdid = rs.getString("dvd_id");
                 
                 pst.close();
                 rs.close();
             }
       }catch(SQLException e){
            
       }finally{
            try{
                pst.close();
                rs.close();
            }catch(SQLException e){
                
            }
        }
    }//GEN-LAST:event_table_currentRentalMouseClicked

    private void viewRecieptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRecieptActionPerformed
        if(table_currentRental.getSelectedRow() == 0 || table_currentRental.getSelectedRow() > 0 ){

        Receipt_ReturnDVD receipt = new Receipt_ReturnDVD();
        receipt.getReceipt( customerName, customerEmail, dvdid, dvdtitle, dvdgenre, dvdprice, dvdrentedDate, dvdreturnDate);
        receipt.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Make a Selection!!!");
        }
    }//GEN-LAST:event_viewRecieptActionPerformed

    private void returnDVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnDVDActionPerformed
    if(table_currentRental.getSelectedRow() == 0 || table_currentRental.getSelectedRow() > 0 ){
        availability = "Available";
       
         Calendar cal = Calendar.getInstance();
    int month = cal.get(Calendar.MONTH);
    int year = cal.get(Calendar.YEAR);
    int day = cal.get(Calendar.DAY_OF_MONTH);
    String dated;
    dated = (String)(day+"-"+(month+1)+"-"+year);
    formatter =  DateTimeFormat.forPattern("dd-MM-yyyy");
    localdate1 = formatter.parseLocalDate(dated);
    localdate2 = formatter.parseLocalDate(dvdreturnDate);
    
    

    if(localdate1.isEqual(localdate2) || localdate1.isBefore(localdate2)){
      
            try {
                String sql = "update DVD set availability='"+availability+"' where dvd_id='"+dvdid+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                pst.close();
                rs.close();
                sql="delete from currentRentals where customer_id='"+customerid+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                pst.close();
                rs.close();
                JOptionPane.showMessageDialog(null, "DVD Has Been Returned Successfully!!!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }finally{
                try{
                    pst.close();
                    rs.close();
                }catch(SQLException e){
                    
                }
            }
            
            Update_TableDVD();
            Update_TableDVD_Rental();
            
       
    }
        
     else {
        int duecharge = 10;
       while(localdate1.isAfter(localdate2)){
           duecharge+=5;
           String i = localdate2.plusDays(1).toString();
            formatter =  DateTimeFormat.forPattern("yyyy-MM-dd");
           localdate2 = formatter.parseLocalDate(i);
           
          }
       
        JOptionPane.showMessageDialog(null, "Customer Overdue Charge is : N "+duecharge, "Overdue Charge", JOptionPane.INFORMATION_MESSAGE);
        try {
                String sql = "update DVD set availability='"+availability+"' where dvd_id='"+dvdid+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                pst.close();
                rs.close();
                
                sql="delete from currentRentals where customer_id='"+customerid+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                pst.close();
                rs.close();
                JOptionPane.showMessageDialog(null, "DVD Has Been Returned Successfully!!!");
                
 //Inserting values into the sales table               
  
       
        
                 
            String sale_type = "OverDue Charge";
            String sale_item = "DVD";
            String sale_state = "Returned";
            int sale_amount = duecharge;
            String sale_item_title = dvdtitle;
            //inserting gotten values to the sales table
            String query = "insert into sales(sale_type,sale_item,sale_item_title,sale_amount,sale_state) values(?,?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, sale_type);
            pst.setString(2, sale_item);
            pst.setString(3, sale_item_title);
            pst.setDouble(4, sale_amount);
            pst.setString(5, sale_state);
            pst.execute();
            pst.close();
            rs.close();
            
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }finally{
                try{
                    pst.close();
                    rs.close();
                }catch(SQLException e){
                    
                }
            }
            
            Update_TableDVD();
            Update_TableDVD_Rental();
         CalculatorFrame c = new CalculatorFrame();
        c.getPrice(duecharge);
        c.setPrice();
        dispose();
        c.setVisible(true);
                }
     }
        else{
            JOptionPane.showMessageDialog(null, "Please make a selection");
        }
    }//GEN-LAST:event_returnDVDActionPerformed

    private void cmd_DVDimageAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_DVDimageAttachActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        txt_imagepath1.setText(filename);
    }//GEN-LAST:event_cmd_DVDimageAttachActionPerformed

    private void check_available1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_available1ActionPerformed
        availability = "Available";
    }//GEN-LAST:event_check_available1ActionPerformed

    private void cmd_srch_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_srch_salesActionPerformed
        String search_sales1 = ((JTextField)txt_srch_sales.getDateEditor().getUiComponent()).getText();
        String search_sales2 = ((JTextField)txt_srch_sales1.getDateEditor().getUiComponent()).getText();
        
        try{
            String sql = "SELECT * FROM sales where sale_date between '"+search_sales1+"' and '"+search_sales2+"' ";
            pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                table_sales.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
       
        }
    }//GEN-LAST:event_cmd_srch_salesActionPerformed

    private void cmd_print_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_print_salesActionPerformed
         MessageFormat header = new MessageFormat("General Sales");
      MessageFormat footer = new MessageFormat("Page{0,number,integer}");
      try{
          table_sales.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_cmd_print_salesActionPerformed

    private void cmd_resetTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_resetTableActionPerformed
        UpdateSales();
    }//GEN-LAST:event_cmd_resetTableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminMainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btn_female1;
    private javax.swing.JRadioButton btn_male1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox check_available;
    private javax.swing.JCheckBox check_available1;
    private javax.swing.JCheckBox check_available2;
    private javax.swing.JButton cmd_AddCustomer;
    private javax.swing.JButton cmd_AddDVD;
    private javax.swing.JButton cmd_DVDimageAttach;
    private javax.swing.JButton cmd_attach;
    private javax.swing.JButton cmd_attach1;
    private javax.swing.JButton cmd_customer;
    private javax.swing.JButton cmd_deleteCustomer;
    private javax.swing.JButton cmd_deletedvd;
    private javax.swing.JButton cmd_dvd;
    private javax.swing.JButton cmd_imagepath;
    private javax.swing.JButton cmd_print_sales;
    private javax.swing.JButton cmd_rentDVD;
    private javax.swing.JButton cmd_resetTable;
    private javax.swing.JButton cmd_search;
    private javax.swing.JButton cmd_serachDVD;
    private javax.swing.JButton cmd_signOut;
    private javax.swing.JButton cmd_srch_sales;
    private javax.swing.JButton cmd_updateCustomer;
    private javax.swing.JButton cmd_updateDVD;
    private javax.swing.JComboBox combo_gender;
    private javax.swing.JComboBox combo_gender2;
    private javax.swing.JComboBox combo_genre;
    private javax.swing.JComboBox combo_genre1;
    private javax.swing.JComboBox combo_genre2;
    private javax.swing.JComboBox combo_rated;
    private javax.swing.JComboBox combo_rated1;
    private javax.swing.JComboBox combo_rated2;
    private javax.swing.JLabel image;
    private javax.swing.JLabel image2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton returnDVD;
    private javax.swing.JButton sendEmail;
    private javax.swing.JTabbedPane tab_customer;
    private javax.swing.JTabbedPane tab_dvd;
    private javax.swing.JTable table_DVD;
    private javax.swing.JTable table_allCustomer;
    private javax.swing.JTable table_currentRental;
    private javax.swing.JTable table_customerEdit;
    private javax.swing.JTable table_deleteCustomer;
    private javax.swing.JTable table_deletedvd;
    private javax.swing.JTable table_editDVD;
    private javax.swing.JTable table_sales;
    private javax.swing.JTable table_search;
    private javax.swing.JTable table_searchDVD;
    private com.toedter.calendar.JDateChooser txt_DOB;
    private com.toedter.calendar.JDateChooser txt_DOB1;
    private com.toedter.calendar.JDateChooser txt_DOB2;
    private javax.swing.JTextArea txt_address;
    private javax.swing.JTextArea txt_address1;
    private javax.swing.JTextArea txt_address2;
    private javax.swing.JTextField txt_city;
    private javax.swing.JTextField txt_city1;
    private javax.swing.JTextField txt_city2;
    private javax.swing.JTextField txt_customerEdit;
    private com.toedter.calendar.JDateChooser txt_date;
    private com.toedter.calendar.JDateChooser txt_date1;
    private com.toedter.calendar.JDateChooser txt_date2;
    private javax.swing.JTextField txt_deleteCustomer;
    private javax.swing.JTextField txt_deletedvd;
    private javax.swing.JTextField txt_dvd_edit;
    private javax.swing.JTextField txt_dvdid;
    private javax.swing.JTextField txt_dvdid1;
    private javax.swing.JTextField txt_dvdid2;
    private javax.swing.JLabel txt_dvdimage;
    private javax.swing.JLabel txt_dvdimage1;
    private javax.swing.JLabel txt_dvdimage2;
    private javax.swing.JTextField txt_dvdprice;
    private javax.swing.JTextField txt_dvdprice1;
    private javax.swing.JTextField txt_dvdprice2;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_email1;
    private javax.swing.JTextField txt_email2;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_id1;
    private javax.swing.JTextField txt_id2;
    private javax.swing.JTextField txt_image;
    private javax.swing.JTextField txt_image1;
    private javax.swing.JTextField txt_image2;
    private javax.swing.JTextField txt_imagepath;
    private javax.swing.JTextField txt_imagepath1;
    private javax.swing.JTextField txt_imagepath2;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_name1;
    private javax.swing.JTextField txt_name2;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_phone1;
    private javax.swing.JTextField txt_phone2;
    private javax.swing.JTextField txt_postcode;
    private javax.swing.JTextField txt_postcode1;
    private javax.swing.JTextField txt_postcode2;
    private javax.swing.JTextField txt_srchDVDid;
    private javax.swing.JTextField txt_srchDVDtitle;
    private com.toedter.calendar.JDateChooser txt_srch_sales;
    private com.toedter.calendar.JDateChooser txt_srch_sales1;
    private javax.swing.JTextField txt_srchid;
    private javax.swing.JTextField txt_srchname;
    private javax.swing.JTextField txt_srchsurname;
    private javax.swing.JTextField txt_surname;
    private javax.swing.JTextField txt_surname1;
    private javax.swing.JTextField txt_surname2;
    private javax.swing.JTextField txt_title;
    private javax.swing.JTextField txt_title1;
    private javax.swing.JTextField txt_title2;
    private javax.swing.JButton viewReciept;
    // End of variables declaration//GEN-END:variables
private ImageIcon format = null;
private String filename = null;
int s = 0;
byte[] person_image = null;
byte[] person_image2 = null;
String Gender;
String availability;
String customerEmail;
String customerName;
String dvdtitle;
String dvdgenre;
double dvdprice;
String dvdrentedDate;
String dvdreturnDate;
String dvdid;
String customerid;
DateTimeFormatter formatter;
LocalDate localdate1;
LocalDate localdate2;
String table_clicked;
int row;
}
