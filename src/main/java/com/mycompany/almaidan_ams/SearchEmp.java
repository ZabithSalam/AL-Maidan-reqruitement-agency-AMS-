/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.almaidan_ams;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Zabith
 */
public class SearchEmp extends javax.swing.JFrame {

    /**
     * Creates new form SearchEmp
     */
    public SearchEmp() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JFrame frame = new JFrame();
frame.setLayout(null);
        //connection();
        connectDB();
        Image icon = Toolkit.getDefaultToolkit().getImage("res/almaidan logo_#path260.png");
        setIconImage(icon);
        txtRef.setEditable(false);
        txtRef.setEditable(false);
                    txtAppliedFor.setEditable(false);
                    txtContractPeriod.setEditable(false);
                    txtSalary.setEditable(false);
                    txtReligion.setEditable(false);
                    txtName.setEditable(false);
                    txtNationality.setEditable(false);
                    txtDob.setEditable(false);
                    txtTown.setEditable(false);
                    maritalStatus.setEditable(false);
                    txtNoOfChildrens.setEditable(false);
                    txtHeight.setEditable(false);
                    txtWeight.setEditable(false);
                    txtComplexions.setEditable(false);
                    txtEducation.setEditable(false);
                    txtNumber.setEditable(false);
                    txtDateIssue.setEditable(false);
                    txtDateExpiry.setEditable(false);
                    txtAge.setEditable(false);
                    country1.setEditable(false);
                    txtc1Duration.setEditable(false);
                    txtc1Period.setEditable(false);
                    country2.setEditable(false);
                    txtc2Duration.setEditable(false);
                    txtc2Period.setEditable(false);
                    country3.setEditable(false);
                    txtc3duration.setEditable(false);
                    txtc3Period.setEditable(false);
                    jTextAreaRemarks.setEditable(false);
                    txtElanguage.setEditable(false);
                    txtAlanguage.setEditable(false);
                    txtWcooking.setEditable(false);
                    txtWbabySitting.setEditable(false);
                    txtWWashing.setEditable(false);
                    txtWSewing.setEditable(false);
                    txtWCleaning.setEditable(false);
                    txtWDriving.setEditable(false);
                    
                    
                    
       
        
                    
                    

    }
    
        Connection con;
        PreparedStatement pst;
        
//    public void connection(){
//        Properties props = new Properties();
//        try {
//            props.load(new FileInputStream("config.properties"));
//            String dbHost = props.getProperty("db.host");
//            String dbName = props.getProperty("db.name");
//            String dbUser = props.getProperty("db.user");
//            String dbPassword = props.getProperty("db.password");
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://" + dbHost + "/" + dbName, dbUser, dbPassword);
//
//        } catch (ClassNotFoundException ex){
//            ex.printStackTrace();
//        } catch (SQLException ex){
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
    
    public void connectDB(){
        
        try {

            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:database/al-maidan_db.db");
            System.out.println("Connection Successfull");

        } catch (Exception e){
            System.out.println("Connection Failed"+e);
        }
    }
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    public void getdata(){
        try {
        String Ref,appliedFor,cPeriod,salary,religion,fullName,nationality,dob,living_town
                ,mStatus,childrens,height,weight,complexions,edu,num,dateIssue,dateExpiry,age,country01,c01Duration,
                c01Period,country02,c02duration,c02period,country03,c03duration,c03period,remarks
                ,note,photo1,photo2;
        
        
        
        
        
        
            pst = con.prepareStatement("select * from emp where Ref = ? OR num = ?");
            
                String RefFind =txtFindRefNo.getText();
                String numValue =txtFindRefNo.getText();
                
                pst.setString(1, RefFind);
                pst.setString(2, numValue);
                
                ResultSet resultSet = pst.executeQuery();
                
                
                if(resultSet.next() == false || RefFind.equals("") || numValue.equals("")){
                    JOptionPane.showMessageDialog(null, "Sorry record not found");
                    
                    txtRef.setText("");
                    txtAppliedFor.setText("");
                    txtContractPeriod.setText("");
                    txtSalary.setText("");
                    txtReligion.setText("");
                    txtName.setText("");
                    txtNationality.setText("");
                    txtDob.setText("");
                    txtTown.setText("");
                    maritalStatus.setText("");
                    txtNoOfChildrens.setText("");
                    txtHeight.setText("");
                    txtWeight.setText("");
                    txtComplexions.setText("");
                    txtEducation.setText("");
                    txtNumber.setText("");
                    txtDateIssue.setText("");
                    txtDateExpiry.setText("");
                    txtAge.setText("");
                    country1.setText("");
                    txtc1Duration.setText("");
                    txtc1Period.setText("");
                    country2.setText("");
                    txtc2Duration.setText("");
                    txtc2Period.setText("");
                    country3.setText("");
                    txtc3duration.setText("");
                    txtc3Period.setText("");
                    txtElanguage.setText("");
                    txtAlanguage.setText("");
                    txtWcooking.setText("");
                    txtWbabySitting.setText("");
                    txtWWashing.setText("");
                    txtWSewing.setText("");
                    txtWCleaning.setText("");
                    txtWDriving.setText("");
                    jTextAreaRemarks.setText("");
                    txtNote.setText("");
                    Uphoto1.setIcon(new ImageIcon(""));
                    Uphoto2.setIcon(new ImageIcon(""));
                    
                }else{
                    txtRef.setText(resultSet.getString("Ref"));
                    txtAppliedFor.setText(resultSet.getString("appliedFor"));
                    txtContractPeriod.setText(resultSet.getString("cPeriod"));
                    txtSalary.setText(resultSet.getString("salary"));
                    txtReligion.setText(resultSet.getString("religion"));
                    txtName.setText(resultSet.getString("fullName"));
                    txtNationality.setText(resultSet.getString("nationality"));
                    txtDob.setText(resultSet.getString("dob"));
                    txtTown.setText(resultSet.getString("living_town"));
                    maritalStatus.setText(resultSet.getString("mStatus"));
                    txtNoOfChildrens.setText(resultSet.getString("childrens"));
                    txtHeight.setText(resultSet.getString("height"));
                    txtWeight.setText(resultSet.getString("weight"));
                    txtComplexions.setText(resultSet.getString("complexions"));
                    txtEducation.setText(resultSet.getString("edu"));
                    txtNumber.setText(resultSet.getString("num"));
                    txtDateIssue.setText(resultSet.getString("dateIssue"));
                    txtDateExpiry.setText(resultSet.getString("dateExpiry"));
                    txtAge.setText(resultSet.getString("age"));
                    country1.setText(resultSet.getString("country1"));
                    txtc1Duration.setText(resultSet.getString("c1duration"));
                    txtc1Period.setText(resultSet.getString("c1Period"));
                    country2.setText(resultSet.getString("country2"));
                    txtc2Duration.setText(resultSet.getString("c2duration"));
                    txtc2Period.setText(resultSet.getString("c2period"));
                    country3.setText(resultSet.getString("country3"));
                    txtc3duration.setText(resultSet.getString("c3duration"));
                    txtc3Period.setText(resultSet.getString("c3period"));
                    jTextAreaRemarks.setText(resultSet.getString("remarks"));
                    txtNote.setText(resultSet.getString("note"));
                    
                    
                    
                    
                    
                    if(resultSet.getString("Epoor").equals("1")){
                        txtElanguage.setText("Poor");
                    }
                    else if(resultSet.getString("Efair").equals("1")){
                        txtElanguage.setText("Fair");
                    }
                    else if(resultSet.getString("Efluent").equals("1")){
                        txtElanguage.setText("Fluent");
                    }
                    else{
                        txtElanguage.setText("");
                    }
                    
                    if(resultSet.getString("Apoor").equals("1")){
                        txtAlanguage.setText("Poor");
                    }
                    else if(resultSet.getString("Afair").equals("1")){
                        txtAlanguage.setText("Fair");
                    }
                    else if(resultSet.getString("Afluent").equals("1")){
                        txtAlanguage.setText("Fluent");
                    }
                    else{
                        txtAlanguage.setText("");
                    }
                    
                    
                    if(resultSet.getString("cooking").equals("1")){
                        txtWcooking.setText("COOKING");
                    }
                    else{
                        txtWcooking.setText("");
                    }
                    
                    if(resultSet.getString("babysitting").equals("1")){
                        txtWbabySitting.setText("BABY SITTING");
                    }
                    else{
                        txtWbabySitting.setText("");
                    }
                    
                    if(resultSet.getString("cleaning").equals("1")){
                        txtWWashing.setText("CLEANING");
                    }
                    else{
                        txtWWashing.setText("");
                    }
                    
                    if(resultSet.getString("whashing").equals("1")){
                        txtWSewing.setText("WASHING");
                    }
                    else{
                        txtWSewing.setText("");
                    }
                    if(resultSet.getString("sewing").equals("1")){
                        txtWCleaning.setText("SEWING");
                    }
                    else{
                        txtWCleaning.setText("");
                    }
                    if(resultSet.getString("driving").equals("1")){
                        txtWDriving.setText("DRIVING");
                    }
                    else{
                        txtWDriving.setText("");
                    }
                    
                    
                    String imagePath = "uploads/photoSmall/" + resultSet.getString("photo1");
                    ImageIcon originalIcon = new ImageIcon(imagePath);
                    Image originalImage = originalIcon.getImage();

                    // Set the desired width and height
                    int photowidth = 129;
                    int photoheight = 141;

                    // Create a scaled instance of the image with the new dimensions
                    Image scaledImage = originalImage.getScaledInstance(photowidth, photoheight, Image.SCALE_SMOOTH);

                    // Create a new ImageIcon with the scaled image
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    
                    Uphoto1.setIcon(scaledIcon);
                    
                    String imagePath2 = "uploads/photoLarge/" + resultSet.getString("photo2");
                    ImageIcon originalIcon2 = new ImageIcon(imagePath2);
                    Image originalImage2 = originalIcon2.getImage();

                    // Create a scaled instance of the image with the new dimensions
                    Image scaledImage2 = originalImage2.getScaledInstance(photowidth, photoheight, Image.SCALE_SMOOTH);

                    // Create a new ImageIcon with the scaled image
                    ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
                    
                    Uphoto2.setIcon(scaledIcon2);
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateApplication.class.getName()).log(Level.SEVERE, null, ex);
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

        CreateEmpApplication = new javax.swing.JPanel();
        lblReference = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        lblRelegion = new javax.swing.JLabel();
        txtReligion = new javax.swing.JTextField();
        lblRelegion1 = new javax.swing.JLabel();
        txtAppliedFor = new javax.swing.JTextField();
        lblRelegion2 = new javax.swing.JLabel();
        txtContractPeriod = new javax.swing.JTextField();
        lblRelegion3 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblReference1 = new javax.swing.JLabel();
        txtNationality = new javax.swing.JTextField();
        lblReference2 = new javax.swing.JLabel();
        lblReference3 = new javax.swing.JLabel();
        txtDob = new javax.swing.JTextField();
        lblReference4 = new javax.swing.JLabel();
        txtTown = new javax.swing.JTextField();
        lblReference5 = new javax.swing.JLabel();
        lblReference6 = new javax.swing.JLabel();
        txtNoOfChildrens = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        lblReference7 = new javax.swing.JLabel();
        lblReference8 = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        txtComplexions = new javax.swing.JTextField();
        lblReference9 = new javax.swing.JLabel();
        lblReference10 = new javax.swing.JLabel();
        txtEducation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblReference11 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        lblReference12 = new javax.swing.JLabel();
        txtDateIssue = new javax.swing.JTextField();
        lblReference13 = new javax.swing.JLabel();
        txtDateExpiry = new javax.swing.JTextField();
        lblReference14 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();
        lblReference24 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Uphoto2 = new javax.swing.JLabel();
        Uphoto1 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtFindRefNo = new javax.swing.JTextField();
        maritalStatus = new javax.swing.JTextField();
        txtWSewing = new javax.swing.JTextField();
        txtWcooking = new javax.swing.JTextField();
        txtWbabySitting = new javax.swing.JTextField();
        txtWWashing = new javax.swing.JTextField();
        txtWCleaning = new javax.swing.JTextField();
        txtWDriving = new javax.swing.JTextField();
        txtElanguage = new javax.swing.JTextField();
        txtAlanguage = new javax.swing.JTextField();
        jTextAreaRemarks = new javax.swing.JTextField();
        lblReference15 = new javax.swing.JLabel();
        txtc3Period = new javax.swing.JTextField();
        txtc3duration = new javax.swing.JTextField();
        lblReference21 = new javax.swing.JLabel();
        lblReference23 = new javax.swing.JLabel();
        country3 = new javax.swing.JTextField();
        lblReference19 = new javax.swing.JLabel();
        lblReference17 = new javax.swing.JLabel();
        country2 = new javax.swing.JTextField();
        country1 = new javax.swing.JTextField();
        lblReference18 = new javax.swing.JLabel();
        lblReference22 = new javax.swing.JLabel();
        txtc2Duration = new javax.swing.JTextField();
        txtc1Duration = new javax.swing.JTextField();
        txtc1Period = new javax.swing.JTextField();
        lblReference16 = new javax.swing.JLabel();
        lblReference20 = new javax.swing.JLabel();
        txtc2Period = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New AL-Maidan Application Management System");

        lblReference.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference.setText("Reference No.");

        txtRef.setBackground(new java.awt.Color(214, 217, 223));
        txtRef.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtRef.setForeground(new java.awt.Color(38, 117, 191));
        txtRef.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRef.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblRelegion.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblRelegion.setText("Religion");

        txtReligion.setBackground(new java.awt.Color(214, 217, 223));
        txtReligion.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtReligion.setForeground(new java.awt.Color(38, 117, 191));
        txtReligion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtReligion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtReligion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReligionActionPerformed(evt);
            }
        });

        lblRelegion1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblRelegion1.setText("Applied For ");

        txtAppliedFor.setBackground(new java.awt.Color(214, 217, 223));
        txtAppliedFor.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtAppliedFor.setForeground(new java.awt.Color(38, 117, 191));
        txtAppliedFor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAppliedFor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblRelegion2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblRelegion2.setText("Contract Period ");

        txtContractPeriod.setBackground(new java.awt.Color(214, 217, 223));
        txtContractPeriod.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtContractPeriod.setForeground(new java.awt.Color(38, 117, 191));
        txtContractPeriod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtContractPeriod.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblRelegion3.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblRelegion3.setText("Monthly Salary");

        txtSalary.setBackground(new java.awt.Color(214, 217, 223));
        txtSalary.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtSalary.setForeground(new java.awt.Color(38, 117, 191));
        txtSalary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSalary.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText("Detail of Applicant");

        txtName.setEditable(false);
        txtName.setBackground(new java.awt.Color(214, 217, 223));
        txtName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(38, 117, 191));
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblReference1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference1.setText("Full Name");

        txtNationality.setBackground(new java.awt.Color(214, 217, 223));
        txtNationality.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtNationality.setForeground(new java.awt.Color(38, 117, 191));
        txtNationality.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNationality.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNationalityActionPerformed(evt);
            }
        });

        lblReference2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference2.setText("Nationality");

        lblReference3.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference3.setText("DOB");

        txtDob.setBackground(new java.awt.Color(214, 217, 223));
        txtDob.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtDob.setForeground(new java.awt.Color(38, 117, 191));
        txtDob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDob.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtDob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDobActionPerformed(evt);
            }
        });

        lblReference4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference4.setText("Living Town");

        txtTown.setBackground(new java.awt.Color(214, 217, 223));
        txtTown.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtTown.setForeground(new java.awt.Color(38, 117, 191));
        txtTown.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTown.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtTown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTownActionPerformed(evt);
            }
        });

        lblReference5.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference5.setText("Marital Status ");

        lblReference6.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference6.setText("No. of Childrens ");

        txtNoOfChildrens.setBackground(new java.awt.Color(214, 217, 223));
        txtNoOfChildrens.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtNoOfChildrens.setForeground(new java.awt.Color(38, 117, 191));
        txtNoOfChildrens.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNoOfChildrens.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNoOfChildrens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoOfChildrensActionPerformed(evt);
            }
        });

        txtHeight.setBackground(new java.awt.Color(214, 217, 223));
        txtHeight.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtHeight.setForeground(new java.awt.Color(38, 117, 191));
        txtHeight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtHeight.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHeightActionPerformed(evt);
            }
        });

        lblReference7.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference7.setText("Height");

        lblReference8.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference8.setText("Weight");

        txtWeight.setBackground(new java.awt.Color(214, 217, 223));
        txtWeight.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtWeight.setForeground(new java.awt.Color(38, 117, 191));
        txtWeight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtWeight.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWeightActionPerformed(evt);
            }
        });

        txtComplexions.setBackground(new java.awt.Color(214, 217, 223));
        txtComplexions.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtComplexions.setForeground(new java.awt.Color(38, 117, 191));
        txtComplexions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtComplexions.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtComplexions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplexionsActionPerformed(evt);
            }
        });

        lblReference9.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference9.setText("Complexions ");

        lblReference10.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference10.setText("Education");

        txtEducation.setBackground(new java.awt.Color(214, 217, 223));
        txtEducation.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtEducation.setForeground(new java.awt.Color(38, 117, 191));
        txtEducation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEducation.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtEducation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEducationActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setText("Previous Employment Abroad");

        lblReference11.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference11.setText("Number");

        txtNumber.setBackground(new java.awt.Color(214, 217, 223));
        txtNumber.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtNumber.setForeground(new java.awt.Color(38, 117, 191));
        txtNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        lblReference12.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference12.setText("Date of Issue");

        txtDateIssue.setBackground(new java.awt.Color(214, 217, 223));
        txtDateIssue.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtDateIssue.setForeground(new java.awt.Color(38, 117, 191));
        txtDateIssue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDateIssue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtDateIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateIssueActionPerformed(evt);
            }
        });

        lblReference13.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference13.setText("Date of Expiry");

        txtDateExpiry.setBackground(new java.awt.Color(214, 217, 223));
        txtDateExpiry.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtDateExpiry.setForeground(new java.awt.Color(38, 117, 191));
        txtDateExpiry.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDateExpiry.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtDateExpiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateExpiryActionPerformed(evt);
            }
        });

        lblReference14.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference14.setText("Age");

        txtAge.setBackground(new java.awt.Color(214, 217, 223));
        txtAge.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtAge.setForeground(new java.awt.Color(38, 117, 191));
        txtAge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAge.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setText("Passport Details");

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel4.setText("Work Experience");

        txtNote.setBackground(new java.awt.Color(214, 217, 223));
        txtNote.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtNote.setForeground(new java.awt.Color(38, 117, 191));
        txtNote.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNote.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoteActionPerformed(evt);
            }
        });

        lblReference24.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference24.setText("Note");

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setText("Knowledge of Languages");

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel6.setText("English");

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel7.setText("Arabic");

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel8.setText("Remarks");

        Uphoto2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        Uphoto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Uphoto1.setMaximumSize(new java.awt.Dimension(208, 212));
        Uphoto1.setMinimumSize(new java.awt.Dimension(208, 212));

        btnFind.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jButton2.setText("Main menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtFindRefNo.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtFindRefNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindRefNoActionPerformed(evt);
            }
        });
        txtFindRefNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindRefNoKeyPressed(evt);
            }
        });

        maritalStatus.setBackground(new java.awt.Color(214, 217, 223));
        maritalStatus.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        maritalStatus.setForeground(new java.awt.Color(38, 117, 191));
        maritalStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        maritalStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        maritalStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maritalStatusActionPerformed(evt);
            }
        });

        txtWSewing.setBackground(new java.awt.Color(214, 217, 223));
        txtWSewing.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtWSewing.setForeground(new java.awt.Color(38, 117, 191));
        txtWSewing.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtWSewing.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtWSewing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWSewingActionPerformed(evt);
            }
        });

        txtWcooking.setBackground(new java.awt.Color(214, 217, 223));
        txtWcooking.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtWcooking.setForeground(new java.awt.Color(38, 117, 191));
        txtWcooking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtWcooking.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtWcooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWcookingActionPerformed(evt);
            }
        });

        txtWbabySitting.setBackground(new java.awt.Color(214, 217, 223));
        txtWbabySitting.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtWbabySitting.setForeground(new java.awt.Color(38, 117, 191));
        txtWbabySitting.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtWbabySitting.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtWbabySitting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWbabySittingActionPerformed(evt);
            }
        });

        txtWWashing.setBackground(new java.awt.Color(214, 217, 223));
        txtWWashing.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtWWashing.setForeground(new java.awt.Color(38, 117, 191));
        txtWWashing.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtWWashing.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtWWashing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWWashingActionPerformed(evt);
            }
        });

        txtWCleaning.setBackground(new java.awt.Color(214, 217, 223));
        txtWCleaning.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtWCleaning.setForeground(new java.awt.Color(38, 117, 191));
        txtWCleaning.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtWCleaning.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtWCleaning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWCleaningActionPerformed(evt);
            }
        });

        txtWDriving.setBackground(new java.awt.Color(214, 217, 223));
        txtWDriving.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtWDriving.setForeground(new java.awt.Color(38, 117, 191));
        txtWDriving.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtWDriving.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtWDriving.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWDrivingActionPerformed(evt);
            }
        });

        txtElanguage.setBackground(new java.awt.Color(214, 217, 223));
        txtElanguage.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtElanguage.setForeground(new java.awt.Color(38, 117, 191));
        txtElanguage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtElanguage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtElanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtElanguageActionPerformed(evt);
            }
        });

        txtAlanguage.setBackground(new java.awt.Color(214, 217, 223));
        txtAlanguage.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtAlanguage.setForeground(new java.awt.Color(38, 117, 191));
        txtAlanguage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAlanguage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtAlanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlanguageActionPerformed(evt);
            }
        });

        jTextAreaRemarks.setBackground(new java.awt.Color(214, 217, 223));
        jTextAreaRemarks.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jTextAreaRemarks.setForeground(new java.awt.Color(255, 0, 153));
        jTextAreaRemarks.setBorder(null);
        jTextAreaRemarks.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextAreaRemarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAreaRemarksActionPerformed(evt);
            }
        });

        lblReference15.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReference15.setText("Country");

        txtc3Period.setBackground(new java.awt.Color(214, 217, 223));
        txtc3Period.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtc3Period.setForeground(new java.awt.Color(38, 117, 191));
        txtc3Period.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc3Period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc3PeriodActionPerformed(evt);
            }
        });

        txtc3duration.setBackground(new java.awt.Color(214, 217, 223));
        txtc3duration.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtc3duration.setForeground(new java.awt.Color(38, 117, 191));
        txtc3duration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc3duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc3durationActionPerformed(evt);
            }
        });

        lblReference21.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference21.setText("Period");

        lblReference23.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference23.setText("Duration");

        country3.setBackground(new java.awt.Color(214, 217, 223));
        country3.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        country3.setForeground(new java.awt.Color(38, 117, 191));
        country3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        country3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                country3ActionPerformed(evt);
            }
        });

        lblReference19.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReference19.setText("Country");

        lblReference17.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReference17.setText("Country");

        country2.setBackground(new java.awt.Color(214, 217, 223));
        country2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        country2.setForeground(new java.awt.Color(38, 117, 191));
        country2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        country2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                country2ActionPerformed(evt);
            }
        });

        country1.setBackground(new java.awt.Color(214, 217, 223));
        country1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        country1.setForeground(new java.awt.Color(38, 117, 191));
        country1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        country1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                country1ActionPerformed(evt);
            }
        });

        lblReference18.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference18.setText("Duration");

        lblReference22.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference22.setText("Duration");

        txtc2Duration.setBackground(new java.awt.Color(214, 217, 223));
        txtc2Duration.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtc2Duration.setForeground(new java.awt.Color(38, 117, 191));
        txtc2Duration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc2Duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc2DurationActionPerformed(evt);
            }
        });

        txtc1Duration.setBackground(new java.awt.Color(214, 217, 223));
        txtc1Duration.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtc1Duration.setForeground(new java.awt.Color(38, 117, 191));
        txtc1Duration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc1Duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc1DurationActionPerformed(evt);
            }
        });

        txtc1Period.setBackground(new java.awt.Color(214, 217, 223));
        txtc1Period.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtc1Period.setForeground(new java.awt.Color(38, 117, 191));
        txtc1Period.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc1Period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc1PeriodActionPerformed(evt);
            }
        });

        lblReference16.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference16.setText("Period");

        lblReference20.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference20.setText("Period");

        txtc2Period.setBackground(new java.awt.Color(214, 217, 223));
        txtc2Period.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtc2Period.setForeground(new java.awt.Color(38, 117, 191));
        txtc2Period.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc2Period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc2PeriodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CreateEmpApplicationLayout = new javax.swing.GroupLayout(CreateEmpApplication);
        CreateEmpApplication.setLayout(CreateEmpApplicationLayout);
        CreateEmpApplicationLayout.setHorizontalGroup(
            CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblReference9)
                            .addComponent(lblReference6)
                            .addComponent(lblReference10)
                            .addComponent(lblReference4)
                            .addComponent(lblReference2)
                            .addComponent(lblReference1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(lblReference3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNoOfChildrens, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtComplexions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblReference5)
                                    .addComponent(lblReference7)
                                    .addComponent(lblReference8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtEducation, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(48, 48, 48)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtElanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAlanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRelegion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRelegion1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRelegion3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRelegion2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblReference, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CreateEmpApplicationLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(txtAppliedFor))
                                            .addComponent(txtReligion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRef, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtContractPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CreateEmpApplicationLayout.createSequentialGroup()
                                    .addComponent(lblReference14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                    .addComponent(lblReference11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CreateEmpApplicationLayout.createSequentialGroup()
                                    .addComponent(lblReference12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDateIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CreateEmpApplicationLayout.createSequentialGroup()
                                    .addComponent(lblReference13, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDateExpiry, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                            .addComponent(txtWcooking, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtWbabySitting, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtWCleaning, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtWWashing, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtWSewing, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtWDriving, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblReference19)
                                            .addComponent(lblReference15)
                                            .addComponent(lblReference17))
                                        .addGap(18, 18, 18)
                                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(country3, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(country2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(country1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblReference18)
                                            .addComponent(lblReference22)
                                            .addComponent(lblReference23))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtc2Duration, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtc1Duration, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtc3duration, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                                .addComponent(lblReference16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtc1Period, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                                .addComponent(lblReference20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtc2Period, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateEmpApplicationLayout.createSequentialGroup()
                                                .addComponent(lblReference21)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtc3Period, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jLabel1)))))
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextAreaRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addComponent(txtFindRefNo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateEmpApplicationLayout.createSequentialGroup()
                                .addComponent(Uphoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Uphoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblReference24)
                                .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        CreateEmpApplicationLayout.setVerticalGroup(
            CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Uphoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Uphoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateEmpApplicationLayout.createSequentialGroup()
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addComponent(lblReference, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRelegion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(lblRelegion1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblRelegion2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContractPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblRelegion3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblReference24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addComponent(txtReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtAppliedFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateEmpApplicationLayout.createSequentialGroup()
                        .addContainerGap(302, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblReference1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblReference3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblReference2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblReference4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(maritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblReference5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoOfChildrens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReference6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReference7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblReference8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtComplexions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReference9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEducation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReference10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)))
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16)
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblReference11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(jTextAreaRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDateIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblReference12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDateExpiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblReference13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblReference15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblReference16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtc1Period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtc1Duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblReference18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(country1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblReference17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblReference20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtc2Period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtc2Duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblReference22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(country2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblReference21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtc3Period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtc3duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblReference23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(country3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblReference19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblReference14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45)
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtElanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtAlanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(21, 21, 21))
                        .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFindRefNo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(17, 17, 17)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtWbabySitting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWcooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtWSewing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtWWashing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtWCleaning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWDriving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 319, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreateEmpApplication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreateEmpApplication, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtWDrivingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWDrivingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWDrivingActionPerformed

    private void txtWCleaningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWCleaningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWCleaningActionPerformed

    private void txtWWashingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWWashingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWWashingActionPerformed

    private void txtWbabySittingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWbabySittingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWbabySittingActionPerformed

    private void txtWcookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWcookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWcookingActionPerformed

    private void txtWSewingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWSewingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWSewingActionPerformed

    private void maritalStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maritalStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maritalStatusActionPerformed

    private void txtFindRefNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindRefNoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtFindRefNoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         close();
         WelcomeFrame wf = new WelcomeFrame();
         wf.setVisible(true);
         
         try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CreateApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        getdata();
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoteActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtDateExpiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateExpiryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateExpiryActionPerformed

    private void txtDateIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateIssueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateIssueActionPerformed

    private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberActionPerformed

    private void txtEducationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEducationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEducationActionPerformed

    private void txtComplexionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplexionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplexionsActionPerformed

    private void txtWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWeightActionPerformed

    private void txtHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHeightActionPerformed

    private void txtNoOfChildrensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoOfChildrensActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoOfChildrensActionPerformed

    private void txtTownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTownActionPerformed

    private void txtDobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDobActionPerformed

    private void txtNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNationalityActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtElanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtElanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtElanguageActionPerformed

    private void txtAlanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlanguageActionPerformed

    private void txtReligionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReligionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReligionActionPerformed

    private void jTextAreaRemarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAreaRemarksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAreaRemarksActionPerformed

    private void txtFindRefNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindRefNoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            getdata();
        }
    }//GEN-LAST:event_txtFindRefNoKeyPressed

    private void txtc3PeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc3PeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc3PeriodActionPerformed

    private void txtc3durationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc3durationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc3durationActionPerformed

    private void country3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_country3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_country3ActionPerformed

    private void country2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_country2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_country2ActionPerformed

    private void country1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_country1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_country1ActionPerformed

    private void txtc2DurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc2DurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc2DurationActionPerformed

    private void txtc1DurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc1DurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc1DurationActionPerformed

    private void txtc1PeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc1PeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc1PeriodActionPerformed

    private void txtc2PeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc2PeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc2PeriodActionPerformed

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
            java.util.logging.Logger.getLogger(SearchEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchEmp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CreateEmpApplication;
    private javax.swing.JLabel Uphoto1;
    private javax.swing.JLabel Uphoto2;
    private javax.swing.JButton btnFind;
    private javax.swing.JTextField country1;
    private javax.swing.JTextField country2;
    private javax.swing.JTextField country3;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextAreaRemarks;
    private javax.swing.JLabel lblReference;
    private javax.swing.JLabel lblReference1;
    private javax.swing.JLabel lblReference10;
    private javax.swing.JLabel lblReference11;
    private javax.swing.JLabel lblReference12;
    private javax.swing.JLabel lblReference13;
    private javax.swing.JLabel lblReference14;
    private javax.swing.JLabel lblReference15;
    private javax.swing.JLabel lblReference16;
    private javax.swing.JLabel lblReference17;
    private javax.swing.JLabel lblReference18;
    private javax.swing.JLabel lblReference19;
    private javax.swing.JLabel lblReference2;
    private javax.swing.JLabel lblReference20;
    private javax.swing.JLabel lblReference21;
    private javax.swing.JLabel lblReference22;
    private javax.swing.JLabel lblReference23;
    private javax.swing.JLabel lblReference24;
    private javax.swing.JLabel lblReference3;
    private javax.swing.JLabel lblReference4;
    private javax.swing.JLabel lblReference5;
    private javax.swing.JLabel lblReference6;
    private javax.swing.JLabel lblReference7;
    private javax.swing.JLabel lblReference8;
    private javax.swing.JLabel lblReference9;
    private javax.swing.JLabel lblRelegion;
    private javax.swing.JLabel lblRelegion1;
    private javax.swing.JLabel lblRelegion2;
    private javax.swing.JLabel lblRelegion3;
    private javax.swing.JTextField maritalStatus;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtAlanguage;
    private javax.swing.JTextField txtAppliedFor;
    private javax.swing.JTextField txtComplexions;
    private javax.swing.JTextField txtContractPeriod;
    private javax.swing.JTextField txtDateExpiry;
    private javax.swing.JTextField txtDateIssue;
    private javax.swing.JTextField txtDob;
    private javax.swing.JTextField txtEducation;
    private javax.swing.JTextField txtElanguage;
    private javax.swing.JTextField txtFindRefNo;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNationality;
    private javax.swing.JTextField txtNoOfChildrens;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtReligion;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtTown;
    private javax.swing.JTextField txtWCleaning;
    private javax.swing.JTextField txtWDriving;
    private javax.swing.JTextField txtWSewing;
    private javax.swing.JTextField txtWWashing;
    private javax.swing.JTextField txtWbabySitting;
    private javax.swing.JTextField txtWcooking;
    private javax.swing.JTextField txtWeight;
    private javax.swing.JTextField txtc1Duration;
    private javax.swing.JTextField txtc1Period;
    private javax.swing.JTextField txtc2Duration;
    private javax.swing.JTextField txtc2Period;
    private javax.swing.JTextField txtc3Period;
    private javax.swing.JTextField txtc3duration;
    // End of variables declaration//GEN-END:variables
}
