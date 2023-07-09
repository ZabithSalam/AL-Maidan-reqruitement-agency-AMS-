/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.almaidan_ams;

import com.itextpdf.io.image.ImageData;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

//PDFGeneration imports


import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.HorizontalAlignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import java.util.Properties;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author Zabith
 */
public class CreateApplication extends javax.swing.JFrame {

        
    
    public CreateApplication() {
        initComponents();
        
        txtImageName1.setVisible(false);
        txtImageName2.setVisible(false);
            
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Image icon = Toolkit.getDefaultToolkit().getImage("res/almaidan logo_#path260.png");
        setIconImage(icon);
        //connection();
        connectDB();
        

        // Create and associate a KeyStroke with the Enter key
        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        jButtonSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enterKey, "enter");
        jButtonSave.getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonSaveActionPerformed(e);
            }
        });
        
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
    
    public void storeIntoDatabase() throws SQLException{
        
       
        
        try {
            
             // Your existing code...
                String Ref,appliedFor,cPeriod,salary,religion,fullName,nationality,dob,living_town
                ,mStatus,childrens,height,weight,complexions,edu,num,dateIssue,dateExpiry,age,country01,c01Duration,
                c01Period,country02,c02duration,c02period,country03,c03duration,c03period,remarks
                ,note,photo1,photo2;

       
            
        
        
        Ref=txtRef.getText();
        appliedFor=txtAppliedFor.getText();
        cPeriod=txtContractPeriod.getText();
        salary=txtSalary.getText();
        religion=txtReligion.getText();
        fullName=txtName.getText();
        nationality=txtNationality.getText();
        dob=txtDob.getText();
        living_town=txtTown.getText();
        mStatus = (String) maritalStatus.getSelectedItem();
        childrens=txtNoOfChildrens.getText();
        height=txtHeight.getText();
        weight=txtWeight.getText();
        complexions=txtComplexions.getText();
        edu=txtEducation.getText();
        num=txtNumber.getText();
        dateIssue=txtDateIssue.getText();
        dateExpiry=txtDateExpiry.getText();
        age=txtAge.getText();
        country01=country1.getText();
        c01Duration=txtc1Duration.getText();
        c01Period=txtc1Period.getText();
        country02=country2.getText();
        c02duration=txtc2Duration.getText();
        c02period=txtc2Period.getText();
        country03=country3.getText();
        c03duration=txtc3duration.getText();
        c03period=txtc3Period.getText();
        remarks=jTextAreaRemarks.getText();
        boolean cooking= jCheckBoxCooking.isSelected();
        boolean babysitting=jCheckBoxBabySitting.isSelected();
        boolean cleaning=jCheckBoxCleaning.isSelected();
        boolean whashing=jCheckBoxWashing.isSelected();
        boolean sewing=jCheckBoxSewing.isSelected();
        boolean driving=jCheckBoxDriving.isSelected();
        note=txtNote.getText();
        boolean Epoor=jRadioButtonPoor.isSelected();
        boolean Efair=jRadioButtonFair.isSelected();
        boolean Efluent=jRadioButtonFluent.isSelected();
        boolean Apoor=jRadioButtonArabicPoor.isSelected();
        boolean Afair=jRadioButtonArabicFair.isSelected();
        boolean Afluent=jRadioButtonArabicfluent.isSelected();
        photo1=txtImageName1.getText();
        photo2=txtImageName2.getText();
        
        
            pst = con.prepareStatement("insert into emp(Ref,appliedFor,cPeriod,salary,religion,fullname,nationality,"
                    + "dob,living_town,mStatus,childrens,height,weight,complexions,edu,num,dateIssue,dateExpiry,age,country1,c1Duration,c1Period,"
                    + "country2,c2duration,c2period,country3,c3duration,c3period,remarks,cooking,babysitting,cleaning,whashing,sewing,driving,note,"
                    + "Epoor,Efair,Efluent,Apoor,Afair,Afluent,photo1,photo2)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            pst.setString(1, Ref);
            pst.setString(2, appliedFor);
            pst.setString(3, cPeriod);
            pst.setString(4, salary);
            pst.setString(5, religion);
            pst.setString(6, fullName);
            pst.setString(7, nationality);
            pst.setString(8, dob);
            pst.setString(9, living_town);
            pst.setString(10, mStatus);
            pst.setString(11, childrens);
            pst.setString(12, height);
            pst.setString(13, weight);
            pst.setString(14, complexions);
            pst.setString(15, edu);
            pst.setString(16, num);
            pst.setString(17, dateIssue);
            pst.setString(18, dateExpiry);
            pst.setString(19, age);
            
            pst.setString(20, country01);
            pst.setString(21, c01Duration);
            pst.setString(22, c01Period);
            pst.setString(23, country02);
            pst.setString(24, c02duration);
            pst.setString(25, c02period);
            pst.setString(26, country03);
            pst.setString(27, c03duration);
            pst.setString(28, c03period);
            pst.setString(29, remarks);
            
            pst.setBoolean(30, cooking);
            pst.setBoolean(31, babysitting);
            pst.setBoolean(32, cleaning);
            pst.setBoolean(33, whashing);
            pst.setBoolean(34, sewing);
            pst.setBoolean(35, driving);
            pst.setString(36, note);
            pst.setBoolean(37, Epoor);
            pst.setBoolean(38, Efair);
            pst.setBoolean(39, Efluent);
            pst.setBoolean(40, Apoor);
            pst.setBoolean(41, Afair);
            pst.setBoolean(42, Afluent);
            pst.setString(43, photo1);
            pst.setString(44, photo2);
            
            int status = pst.executeUpdate();
            if(status == 1){
                //JOptionPane.showMessageDialog(null, "Data Saved To the Database Successfully!");
                System.err.println("Record saved into database");
            }
            else{
                System.out.println("Record Failed");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        languageEnglish = new javax.swing.ButtonGroup();
        languageArabic = new javax.swing.ButtonGroup();
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
        maritalStatus = new javax.swing.JComboBox<>();
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
        lblReference15 = new javax.swing.JLabel();
        txtc1Duration = new javax.swing.JTextField();
        lblReference16 = new javax.swing.JLabel();
        txtc1Period = new javax.swing.JTextField();
        lblReference17 = new javax.swing.JLabel();
        txtc2Duration = new javax.swing.JTextField();
        txtc3duration = new javax.swing.JTextField();
        lblReference19 = new javax.swing.JLabel();
        lblReference20 = new javax.swing.JLabel();
        txtc2Period = new javax.swing.JTextField();
        lblReference21 = new javax.swing.JLabel();
        txtc3Period = new javax.swing.JTextField();
        lblReference18 = new javax.swing.JLabel();
        lblReference22 = new javax.swing.JLabel();
        lblReference23 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBoxWashing = new javax.swing.JCheckBox();
        jCheckBoxCooking = new javax.swing.JCheckBox();
        jCheckBoxCleaning = new javax.swing.JCheckBox();
        jCheckBoxBabySitting = new javax.swing.JCheckBox();
        jCheckBoxDriving = new javax.swing.JCheckBox();
        jCheckBoxSewing = new javax.swing.JCheckBox();
        txtNote = new javax.swing.JTextField();
        lblReference24 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtonPoor = new javax.swing.JRadioButton();
        jRadioButtonFluent = new javax.swing.JRadioButton();
        jRadioButtonFair = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButtonArabicfluent = new javax.swing.JRadioButton();
        jRadioButtonArabicFair = new javax.swing.JRadioButton();
        jRadioButtonArabicPoor = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaRemarks = new javax.swing.JTextArea();
        UploadPhoto2 = new javax.swing.JButton();
        jButtonuploadPhoto1 = new javax.swing.JButton();
        photo2 = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        Uphoto1 = new javax.swing.JLabel();
        txtImageName1 = new javax.swing.JTextField();
        txtImageName2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        country1 = new javax.swing.JTextField();
        country2 = new javax.swing.JTextField();
        country3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New AL-Maidan Application Management System");

        lblReference.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference.setText("Reference No.");

        txtRef.setBackground(new java.awt.Color(214, 217, 223));
        txtRef.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtRef.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRelegion.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblRelegion.setText("Religion");

        txtReligion.setBackground(new java.awt.Color(214, 217, 223));
        txtReligion.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtReligion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRelegion1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblRelegion1.setText("Post Applied For ");

        txtAppliedFor.setBackground(new java.awt.Color(214, 217, 223));
        txtAppliedFor.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtAppliedFor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRelegion2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblRelegion2.setText("Contract Period ");

        txtContractPeriod.setBackground(new java.awt.Color(214, 217, 223));
        txtContractPeriod.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtContractPeriod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRelegion3.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblRelegion3.setText("Monthly Salary");

        txtSalary.setBackground(new java.awt.Color(214, 217, 223));
        txtSalary.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtSalary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText("Detail of Applicant");

        txtName.setBackground(new java.awt.Color(214, 217, 223));
        txtName.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblReference1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference1.setText("Full Name");

        txtNationality.setBackground(new java.awt.Color(214, 217, 223));
        txtNationality.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtNationality.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        txtDob.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtDob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDobActionPerformed(evt);
            }
        });

        lblReference4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference4.setText("Living Town");

        txtTown.setBackground(new java.awt.Color(214, 217, 223));
        txtTown.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtTown.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTownActionPerformed(evt);
            }
        });

        lblReference5.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference5.setText("Marital Status ");

        maritalStatus.setBackground(new java.awt.Color(214, 217, 223));
        maritalStatus.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        maritalStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SINGLE", "MARRIED" }));
        maritalStatus.setBorder(null);
        maritalStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maritalStatusActionPerformed(evt);
            }
        });

        lblReference6.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference6.setText("No. of Childrens ");

        txtNoOfChildrens.setBackground(new java.awt.Color(214, 217, 223));
        txtNoOfChildrens.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtNoOfChildrens.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNoOfChildrens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoOfChildrensActionPerformed(evt);
            }
        });

        txtHeight.setBackground(new java.awt.Color(214, 217, 223));
        txtHeight.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtHeight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        txtWeight.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtWeight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWeightActionPerformed(evt);
            }
        });

        txtComplexions.setBackground(new java.awt.Color(214, 217, 223));
        txtComplexions.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtComplexions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        txtEducation.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtEducation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        txtNumber.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        lblReference12.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference12.setText("Date of Issue");

        txtDateIssue.setBackground(new java.awt.Color(214, 217, 223));
        txtDateIssue.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtDateIssue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDateIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateIssueActionPerformed(evt);
            }
        });

        lblReference13.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference13.setText("Date of Expiry");

        txtDateExpiry.setBackground(new java.awt.Color(214, 217, 223));
        txtDateExpiry.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtDateExpiry.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDateExpiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateExpiryActionPerformed(evt);
            }
        });

        lblReference14.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference14.setText("Age");

        txtAge.setBackground(new java.awt.Color(214, 217, 223));
        txtAge.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtAge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setText("Passport Details");

        lblReference15.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReference15.setText("Country");

        txtc1Duration.setBackground(new java.awt.Color(214, 217, 223));
        txtc1Duration.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtc1Duration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc1Duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc1DurationActionPerformed(evt);
            }
        });

        lblReference16.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference16.setText("Period");

        txtc1Period.setBackground(new java.awt.Color(214, 217, 223));
        txtc1Period.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtc1Period.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc1Period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc1PeriodActionPerformed(evt);
            }
        });

        lblReference17.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReference17.setText("Country");

        txtc2Duration.setBackground(new java.awt.Color(214, 217, 223));
        txtc2Duration.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtc2Duration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc2Duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc2DurationActionPerformed(evt);
            }
        });

        txtc3duration.setBackground(new java.awt.Color(214, 217, 223));
        txtc3duration.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtc3duration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc3duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc3durationActionPerformed(evt);
            }
        });

        lblReference19.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReference19.setText("Country");

        lblReference20.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference20.setText("Period");

        txtc2Period.setBackground(new java.awt.Color(214, 217, 223));
        txtc2Period.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtc2Period.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc2Period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc2PeriodActionPerformed(evt);
            }
        });

        lblReference21.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference21.setText("Period");

        txtc3Period.setBackground(new java.awt.Color(214, 217, 223));
        txtc3Period.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtc3Period.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtc3Period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtc3PeriodActionPerformed(evt);
            }
        });

        lblReference18.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference18.setText("Duration");

        lblReference22.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference22.setText("Duration");

        lblReference23.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference23.setText("Duration");

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel4.setText("Work Experience");

        jCheckBoxWashing.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jCheckBoxWashing.setText("Washing");
        jCheckBoxWashing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxWashingActionPerformed(evt);
            }
        });

        jCheckBoxCooking.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jCheckBoxCooking.setText("Cooking");

        jCheckBoxCleaning.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jCheckBoxCleaning.setText("Cleaning");

        jCheckBoxBabySitting.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jCheckBoxBabySitting.setText("Baby Sitting");

        jCheckBoxDriving.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jCheckBoxDriving.setText("Driving");

        jCheckBoxSewing.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jCheckBoxSewing.setText("Sewing");

        txtNote.setBackground(new java.awt.Color(214, 217, 223));
        txtNote.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtNote.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoteActionPerformed(evt);
            }
        });

        lblReference24.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblReference24.setText("Note");

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setText("Knowledge of Languages");

        languageEnglish.add(jRadioButtonPoor);
        jRadioButtonPoor.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jRadioButtonPoor.setText("Poor");

        languageEnglish.add(jRadioButtonFluent);
        jRadioButtonFluent.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jRadioButtonFluent.setText("Fluent");

        languageEnglish.add(jRadioButtonFair);
        jRadioButtonFair.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jRadioButtonFair.setText("Fair");

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel6.setText("English");

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel7.setText("Arabic");

        languageArabic.add(jRadioButtonArabicfluent);
        jRadioButtonArabicfluent.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jRadioButtonArabicfluent.setText("Fluent");

        languageArabic.add(jRadioButtonArabicFair);
        jRadioButtonArabicFair.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jRadioButtonArabicFair.setText("Fair");

        languageArabic.add(jRadioButtonArabicPoor);
        jRadioButtonArabicPoor.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jRadioButtonArabicPoor.setText("Poor");

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel8.setText("Remarks");

        jTextAreaRemarks.setBackground(new java.awt.Color(214, 217, 223));
        jTextAreaRemarks.setColumns(20);
        jTextAreaRemarks.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jTextAreaRemarks.setRows(5);
        jTextAreaRemarks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextAreaRemarks);

        UploadPhoto2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        UploadPhoto2.setText("Upload Photo");
        UploadPhoto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadPhoto2ActionPerformed(evt);
            }
        });

        jButtonuploadPhoto1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jButtonuploadPhoto1.setText("Upload Photo");
        jButtonuploadPhoto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonuploadPhoto1ActionPerformed(evt);
            }
        });

        photo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jButtonSave.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        Uphoto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Uphoto1.setMaximumSize(new java.awt.Dimension(208, 212));
        Uphoto1.setMinimumSize(new java.awt.Dimension(208, 212));

        txtImageName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImageName1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jButton1.setText("Main menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        country1.setBackground(new java.awt.Color(214, 217, 223));
        country1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        country1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        country1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                country1ActionPerformed(evt);
            }
        });

        country2.setBackground(new java.awt.Color(214, 217, 223));
        country2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        country2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        country2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                country2ActionPerformed(evt);
            }
        });

        country3.setBackground(new java.awt.Color(214, 217, 223));
        country3.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        country3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        country3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                country3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CreateEmpApplicationLayout = new javax.swing.GroupLayout(CreateEmpApplication);
        CreateEmpApplication.setLayout(CreateEmpApplicationLayout);
        CreateEmpApplicationLayout.setHorizontalGroup(
            CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblReference19)
                                    .addComponent(lblReference15)
                                    .addComponent(lblReference17))
                                .addGap(18, 18, 18)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(country3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                        .addComponent(country2, javax.swing.GroupLayout.Alignment.LEADING))
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
                                        .addComponent(txtc3Period, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(28, 28, 28)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                        .addComponent(jRadioButtonArabicPoor)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonArabicFair)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonArabicfluent))
                                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jRadioButtonPoor)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonFair)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonFluent))))
                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBoxCooking)
                                        .addComponent(jCheckBoxWashing))
                                    .addGap(18, 18, 18)
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBoxBabySitting)
                                        .addComponent(jCheckBoxSewing))
                                    .addGap(18, 18, 18)
                                    .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBoxDriving)
                                        .addComponent(jCheckBoxCleaning)))
                                .addComponent(jLabel4)
                                .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                    .addComponent(lblReference24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNote))))
                        .addGap(488, 488, 488))
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblReference1)
                                    .addComponent(lblReference6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateEmpApplicationLayout.createSequentialGroup()
                                        .addComponent(txtName)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblReference2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblReference3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblReference4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblReference5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(maritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                                .addComponent(lblReference13)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDateExpiry, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                                .addComponent(txtNoOfChildrens, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblReference7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblReference8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblReference9)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateEmpApplicationLayout.createSequentialGroup()
                                                .addComponent(txtComplexions, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblReference10))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateEmpApplicationLayout.createSequentialGroup()
                                                .addComponent(lblReference14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtEducation, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                                .addComponent(txtImageName1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtImageName2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(148, 148, 148))
                                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jButtonuploadPhoto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(Uphoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(23, 23, 23)
                                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(photo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(UploadPhoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addComponent(lblReference)
                                .addGap(4, 4, 4)
                                .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblRelegion1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAppliedFor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblRelegion2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContractPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblRelegion3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblRelegion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtReligion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addComponent(lblReference11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(lblReference12)
                                .addGap(18, 18, 18)
                                .addComponent(txtDateIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        CreateEmpApplicationLayout.setVerticalGroup(
            CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReference, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRelegion1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAppliedFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRelegion2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContractPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRelegion3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRelegion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReference1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReference2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReference3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReference4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReference5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReference6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoOfChildrens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReference7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReference8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReference9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComplexions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReference10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEducation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonuploadPhoto1)
                            .addComponent(UploadPhoto2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Uphoto1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(photo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtImageName1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtImageName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReference11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReference12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDateIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReference13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDateExpiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReference14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxCooking)
                                    .addComponent(jCheckBoxBabySitting))
                                .addGap(18, 18, 18)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBoxSewing)
                                    .addComponent(jCheckBoxWashing)))
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addComponent(jCheckBoxDriving)
                                .addGap(17, 17, 17)
                                .addComponent(jCheckBoxCleaning))
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
                                        .addComponent(country2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblReference24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblReference21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtc3Period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtc3duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblReference23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(country3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblReference19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(30, 30, 30)
                                        .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(CreateEmpApplicationLayout.createSequentialGroup()
                                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jRadioButtonPoor)
                                                    .addComponent(jRadioButtonFluent)
                                                    .addComponent(jRadioButtonFair))
                                                .addGap(18, 18, 18)
                                                .addGroup(CreateEmpApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jRadioButtonArabicPoor)
                                                    .addComponent(jRadioButtonArabicfluent)
                                                    .addComponent(jRadioButtonArabicFair)
                                                    .addComponent(jLabel7))))))))
                        .addGap(25, 25, 25)))
                .addContainerGap(200, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(CreateEmpApplication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CreateEmpApplication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        
    
    private void txtImageName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImageName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImageName1ActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        
        
        try {
            pst = con.prepareStatement("select * from emp where Ref = ?");
        
            
                String Refe =txtRef.getText();
                
                pst.setString(1, Refe);
                
                ResultSet resultSet = pst.executeQuery();
                
                
                if(resultSet.next() == false){
     
        
        if(txtRef.getText().equals("")){
               
                   JOptionPane.showMessageDialog(null, "Reference No. required!");
                   
        }
        else if(txtImageName1.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Photo required!");
        }
        else if(txtImageName2.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Photo large required!");
        }
        else{   
                    // Create an instance of JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Set the file filter to only allow PDF files
        FileNameExtensionFilter pdfFilter = new FileNameExtensionFilter("PDF Files", "pdf");
        fileChooser.setFileFilter(pdfFilter);

        // Show the Save dialog box and handle the user's selection
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File fileToSave = fileChooser.getSelectedFile();
            
            // Ensure the file has the ".pdf" extension
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                fileToSave = new File(filePath + ".pdf");
            }

            try {
                // Call the PDF-generating method and pass the file to save
                PDFGenerate(fileToSave);
            } catch (MalformedURLException ex) {
                Logger.getLogger(CreateApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                storeIntoDatabase();
            } catch (SQLException ex) {
                Logger.getLogger(CreateApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
               }
        
        }
     else{
     
          JOptionPane.showMessageDialog(null, "Reference No. already exist!");          
                    
     }
        } catch (SQLException ex) {
            Logger.getLogger(CreateApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    
    
    private void jButtonuploadPhoto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonuploadPhoto1ActionPerformed

        uploadSmallImage();
    }//GEN-LAST:event_jButtonuploadPhoto1ActionPerformed

    private void UploadPhoto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadPhoto2ActionPerformed
        uploadLargeImage();
    }//GEN-LAST:event_UploadPhoto2ActionPerformed

    private void txtNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoteActionPerformed

    private void jCheckBoxWashingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxWashingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxWashingActionPerformed

    private void txtc3PeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc3PeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc3PeriodActionPerformed

    private void txtc2PeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc2PeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc2PeriodActionPerformed

    private void txtc3durationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc3durationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc3durationActionPerformed

    private void txtc2DurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc2DurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc2DurationActionPerformed

    private void txtc1PeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc1PeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc1PeriodActionPerformed

    private void txtc1DurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtc1DurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtc1DurationActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         close();
         WelcomeFrame wf = new WelcomeFrame();
         wf.setVisible(true);
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CreateApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void maritalStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maritalStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maritalStatusActionPerformed

    private void country1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_country1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_country1ActionPerformed

    private void country2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_country2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_country2ActionPerformed

    private void country3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_country3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_country3ActionPerformed
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
        
    public String newpath = "uploads/photoSmall";
    public String newpath2 = "uploads/photoLarge";
    
    public void uploadLargeImage(){
            JFileChooser chooser2 = new JFileChooser();
            String newpath2 = "uploads/photoLarge";
            
            chooser2.showOpenDialog(null);
            File f2 = chooser2.getSelectedFile();
            filename2 = f2.getAbsolutePath();
            String path2 = f2.getAbsolutePath();
            
            
            try {
                BufferedImage bi2 = ImageIO.read(new File(path2));
                Image img2 = bi2.getScaledInstance(129, 141, Image.SCALE_SMOOTH);
                photo2.setIcon(new ImageIcon(img2));
                File directory = new File(newpath2);
                if(!directory.exists()){
                    directory.mkdirs();
                }
                
                String extension = filename2.substring(filename2.lastIndexOf('.') + 1);
                String textFieldData = txtRef.getText(); // Assuming 'txtRef' is the name of your text field
                String updatedFilename = "ImageLarge_" + textFieldData + "." + extension;
                txtImageName2.setText(updatedFilename);
                File sourceFile = new File(filename2);
                File destinationFile = new File(newpath2 + "/" + updatedFilename);

                Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                
            } catch (IOException ex) {
                Logger.getLogger(CreateApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
           
    }
    
    
    public void uploadSmallImage(){
        
            JFileChooser chooser = new JFileChooser();
            
            
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            filename = f.getAbsolutePath();
            String path2 = f.getAbsolutePath();
            try {
                BufferedImage bi2 = ImageIO.read(new File(path2));
                Image img2 = bi2.getScaledInstance(129, 141, Image.SCALE_SMOOTH);
                Uphoto1.setIcon(new ImageIcon(img2));
                File directory2 = new File(newpath);
                if(!directory2.exists()){
                    directory2.mkdirs();
                }
                
                String extension = filename.substring(filename.lastIndexOf('.') + 1);
                String textFieldData = txtRef.getText(); 
                String updatedFilename2 = "ImageSmall_" + textFieldData + "." + extension;
                txtImageName1.setText(updatedFilename2);
                File sourceFile2 = new File(filename);
                File destinationFile2 = new File(newpath + "/" + updatedFilename2);

                Files.copy(sourceFile2.toPath(), destinationFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
                
            } catch (IOException ex) {
                Logger.getLogger(CreateApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
           
    }
    
    
    
    
    
    public void PDFGenerate(File fileToSave) throws MalformedURLException{
        
        
        
        
        
        //text fields
        String referenceNo = txtRef.getText();
        String appliedFor = txtAppliedFor.getText();
        String religion = txtReligion.getText();
        
        //String newpdfpath = "Applications";

        try {
//             File directory3= new File(newpdfpath);
//                if(!directory3.exists()){
//                    directory3.mkdirs();
//                }
                
                //String updatedFilename3 =  referenceNo + ".pdf";
                //File destinationFile2 = new File(newpdfpath + "/" + updatedFilename3);
            
            PdfWriter pdfWriter = new PdfWriter(fileToSave);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
      
            
            
            
            
        
            PdfFont font = PdfFontFactory.createFont("res/courbd.ttf", "Identity-H", true);
            // Set page margins to 0
            document.setMargins(0, 0, 0, 0);

            //color code
            int red = Integer.parseInt("8c", 16);
            int green = Integer.parseInt("75", 16);
            int blue = Integer.parseInt("52", 16);

            int bgred = Integer.parseInt("ee", 16);
            int bggreen = Integer.parseInt("e3", 16);
            int bgblue = Integer.parseInt("af", 16);

            // Create a table with a single column
            Table table = new Table(1);
            table.setWidth(UnitValue.createPercentValue(100));
            // Load and add the header image
            com.itextpdf.layout.element.Image headerImage = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/header.png"));
            table.addCell(new Cell().add(headerImage.setAutoScale(true))
                    .setBorder(Border.NO_BORDER)
            );
           
                         // Add the passport photo
            com.itextpdf.layout.element.Image imgw = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/flight.png"));


            float targetWidth7 = 2 * 266; // Convert inches to points (assuming DPI of 72)
            float targetHeight7 = 2 * 266;

            float photoWidth7 = imgw.getImageScaledWidth();
            float photoHeight7 = imgw.getImageScaledHeight();

            float scaleWidth7 = targetWidth7 / photoWidth7;
            float scaleHeight7 = targetHeight7 / photoHeight7;

            // Use the minimum scale factor to maintain aspect ratio
            float scale7 = Math.min(scaleWidth7, scaleHeight7);

            float scaledWidth7 = photoWidth7 * scale7;
            float scaledHeight7 = photoHeight7 * scale7;

            imgw.scaleAbsolute(scaledWidth7, scaledHeight7);

            float pageWidth7 = pdfDocument.getDefaultPageSize().getWidth();
            float pageHeight7 = pdfDocument.getDefaultPageSize().getHeight();

            float photoX7 = pageWidth7 - scaledWidth7 - 60; // Adjust the X position as needed
            float photoY7 = pageHeight7 - scaledHeight7 - 328; // Adjust the Y position as needed

            imgw.setFixedPosition(1, photoX7, photoY7);
            imgw.setOpacity(0.2f);
            document.add(imgw);
            
            // Set table properties
            table.setTextAlignment(TextAlignment.CENTER);

            document.add(table);

            // Create a table with two columns and two rows
            Table table1 = new Table(2);
            table1.setMargins(20, 0, 0, 20);
            table1.setWidth(UnitValue.createPercentValue(50));
            table1.setHorizontalAlignment(HorizontalAlignment.LEFT);

            DeviceRgb borderColor = new DeviceRgb(55, 155, 244);
            Border border = new SolidBorder(borderColor, 2);
            DeviceRgb borderColor2 = new DeviceRgb(red, green, blue);
            Border border2 = new SolidBorder(borderColor, 1);
            Border border4 = new SolidBorder(borderColor, 2);
            DeviceRgb backgroundColor = new DeviceRgb(bgred, bggreen, bgblue);
            
            
            table1.addCell(new Cell().add(new Paragraph("Reference No."))
                    .setBorder(border2)
                    .setFontSize(10)
                    
            );
            
            table1.addCell(new Cell().add(referenceNo)
                    .setBorder(border)
                   // .setBackgroundColor(backgroundColor)
                    .setFontSize(9)
                    .setFont(font)
            );

            table1.addCell(new Cell().add("Religion")
                    .setBorder(border2)
                    .setFontSize(10)
                    .setBorderBottom(Border.NO_BORDER)
            );
            
            table1.addCell(new Cell().add(religion)
                    .setBorder(border)
                   // .setBackgroundColor(backgroundColor)
                    .setFontSize(9)
                    .setFont(font)
                    .setBorderBottom(Border.NO_BORDER)
            );

            document.add(table1);

            
            // Create a table with three columns and three rows
            Table table2 = new Table(3);
            table2.setMargins(0, 0, 0, 20);
            table2.setWidth(UnitValue.createPercentValue(50));
            table2.setHorizontalAlignment(HorizontalAlignment.LEFT);

            table2.addCell(new Cell().add("Post Applied For")
                    .setBorder(border2)
                    
                    .setWidth(UnitValue.createPercentValue(23))
                    .setFontSize(8)
            );
            table2.addCell(new Cell().add(appliedFor)
                    .setBorder(border)
                   // .setBackgroundColor(backgroundColor)
                    .setWidth(UnitValue.createPercentValue(46))
                    .setFontSize(9)
                    .setFont(font)
            );
            
             // arabic letter
            com.itextpdf.layout.element.Image arabic1 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/1.png"));
            com.itextpdf.layout.element.Image arabic2 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/2.png"));
            com.itextpdf.layout.element.Image arabic3 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/3.png"));
            com.itextpdf.layout.element.Image arabic4 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/4.png"));
            com.itextpdf.layout.element.Image arabic5 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/5.png"));
            com.itextpdf.layout.element.Image arabic6 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/6.png"));
            com.itextpdf.layout.element.Image arabic7 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/7.png"));


            float Width = 2 * 15; // Convert inches to points (assuming DPI of 72)
            float Height = 2 * 5;
            float Width2 = 2 * 30; // Convert inches to points (assuming DPI of 72)
            float Height2 = 2 * 5;
            float Width3 = 2 * 32; // Convert inches to points (assuming DPI of 72)
            float Height3 = 2 * 7;
            float Width4 = 2 * 10; // Convert inches to points (assuming DPI of 72)
            float Height4 = 2 * 5;
            float Width5 = 2 * 3; // Convert inches to points (assuming DPI of 72)
            float Height5 = 2 * 3;
            
            arabic1.scaleAbsolute(Width, Height);
            arabic1.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            arabic2.scaleAbsolute(Width2, Height2);
            arabic2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            arabic3.scaleAbsolute(Width, Height);
            arabic3.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            arabic4.scaleAbsolute(Width3, Height3);
            arabic4.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            arabic5.scaleAbsolute(Width, Height);
            arabic5.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            arabic6.scaleAbsolute(Width2, Height2);
            arabic6.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            arabic7.scaleAbsolute(Width2, Height2);
            arabic7.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            
            table2.addCell(new Cell().add(arabic1)
                    .setBorder(border2)
                  .setBorderTop(border)
            );

            table2.addCell(new Cell().add("Monthly Salary")
                    .setBorder(border2)
                    .setWidth(UnitValue.createPercentValue(23))
                    .setFontSize(8)
            );
            String salary = txtSalary.getText();
            table2.addCell(new Cell().add(salary)
                    .setBorderTop(border)
                    .setBorderLeft(border)
                    .setBorderRight(border)
                    //.setBackgroundColor(backgroundColor)
                    .setWidth(UnitValue.createPercentValue(46))
                    .setFontSize(9)
                    .setFont(font)
            );
            table2.addCell(new Cell().add(arabic2)
                    .setBorder(border2)
                    .setWidth(UnitValue.createPercentValue(23))
                    .setFontSize(8)
                    
                    .setTextAlignment(TextAlignment.RIGHT)
            );

            table2.addCell(new Cell().add("Contract Period")
                    .setBorder(border2)
                    .setWidth(UnitValue.createPercentValue(23))
                    .setFontSize(8)
            );
            String contractPeriod = txtContractPeriod.getText();
            table2.addCell(new Cell().add(contractPeriod)
                    .setBorderTop(border)
                    .setBorderLeft(border)
                    .setBorderRight(border)
                    .setBorderBottom(border)
                    //.setBackgroundColor(backgroundColor)
                    .setWidth(UnitValue.createPercentValue(46))
                    .setFontSize(9)
                    .setFont(font)
            );
            table2.addCell(new Cell().add(arabic3)
                    .setBorder(border2)
                    .setWidth(UnitValue.createPercentValue(23))
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.RIGHT)
            );

            document.add(table2);

            
            Table detailofapp = new Table(2);
              detailofapp.addCell(new Cell().add("DETAIL OF APPLICANT")
                      .setTextAlignment(TextAlignment.LEFT)
                      .setBorder(Border.NO_BORDER)
                      .setBold()
                      .setFontSize(9)
              );
              detailofapp.addCell(new Cell().add(arabic4)
                      .setTextAlignment(TextAlignment.RIGHT)
                      .setBorder(Border.NO_BORDER)
              );
            detailofapp.setWidth(UnitValue.createPercentValue(50));
            detailofapp.setMargins(0, 0, 0, 20);
            document.add(detailofapp);
            
            // Create a table with three columns and three rows
            Table table3 = new Table(3);
            
            table3.setMargins(0, 20, 0, 20);
            table3.setWidth(UnitValue.createPercentValue(100));
            
            table3.setHorizontalAlignment(HorizontalAlignment.CENTER);
            
            DeviceRgb fontcolor1 = new DeviceRgb(227, 9, 38);
            
            table3.addCell(new Cell().add("Full Name")
                    .setBorder(border2)
                    .setWidth(UnitValue.createPercentValue(15))
                    .setFontSize(8)
            );
            String name = txtName.getText();
            table3.addCell(new Cell().add(name)
                    .setBorder(border)
                    .setWidth(UnitValue.createPercentValue(70))
                    //.setBackgroundColor(backgroundColor)
                    .setFontSize(9)
                    .setFont(font)
                    .setFontColor(fontcolor1)
            );
              com.itextpdf.layout.element.Image arabic34 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/34.png"));
              arabic34.scaleAbsolute(Width2, Height2);
              arabic34.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              table3.addCell(new Cell().add(arabic34)
                    .setBorder(border2)
                    .setWidth(UnitValue.createPercentValue(15))
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.RIGHT)
            );

            document.add(table3);

            
                    // Create the outer table with two columns
              Table outerTable = new Table(2);
              outerTable.setWidth(UnitValue.createPercentValue(100));
              
              DeviceRgb fontcolor2 = new DeviceRgb(2, 108, 0);
              
              Table leftTable = new Table(3);
              leftTable.addCell(new Cell().add("Nationality")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              leftTable.addCell(new Cell().add("SRI LANKAN")
                      .setFontSize(8)
                      .setFont(font)
                      .setBorder(border)
                      .setFontColor(fontcolor2)
                      //.setBackgroundColor(backgroundColor)
              );
              leftTable.addCell(new Cell().add(arabic5)
                      .setBorder(border2)
              );
              leftTable.addCell(new Cell().add("Date of Birth")
                      .setBorder(border2)
                      .setFontSize(8)
              );
              String dob = txtDob.getText();
              leftTable.addCell(new Cell().add(dob)
                      //.setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setFontSize(9)
                    .setFont(font)
                      .setFontColor(fontcolor2)
              );
              leftTable.addCell(new Cell().add(arabic6)
                      .setBorder(border2)
                      .setFontSize(8)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              leftTable.addCell(new Cell().add("Living Town")
                      .setBorder(border2)
                      .setFontSize(8)
              );
              String town = txtTown.getText();
              town = town.replace("\n", "\n\r");
              leftTable.addCell(new Cell().add(town)
                      //.setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setFontSize(9)
                    .setFont(font)
                      .setFontColor(fontcolor2)
              );
              leftTable.addCell(new Cell().add(arabic7)
                      .setBorder(border2)
                      .setFontSize(8)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              leftTable.addCell(new Cell().add("Marital Status")
                      .setBorder(border2)
                      .setFontSize(8)
              );
              String maritalstatus = (String) maritalStatus.getSelectedItem();
              leftTable.addCell(new Cell().add(maritalstatus)
                      //.setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setFontSize(9)
                    .setFont(font)
                      .setFontColor(fontcolor2)
              );
                com.itextpdf.layout.element.Image arabic8 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/8.png"));

                arabic8.scaleAbsolute(Width2, Height2);
                arabic8.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            
              leftTable.addCell(new Cell().add(arabic8)
                      .setBorder(border2)
                      .setFontSize(8)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              leftTable.addCell(new Cell().add("No. of Childrens")
                      .setBorder(border2)
                      .setFontSize(8)
                      .setBorderBottom(Border.NO_BORDER)
              );
              String childrens = txtNoOfChildrens.getText();
              leftTable.addCell(new Cell().add(childrens)
                     // .setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setFontSize(9)
                    .setFont(font)
                      .setBorderBottom(Border.NO_BORDER)
                      .setFontColor(fontcolor2)
              );
              
                com.itextpdf.layout.element.Image arabic9 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/9.png"));

                arabic9.scaleAbsolute(Width2, Height2);
                arabic9.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              
              leftTable.addCell(new Cell().add(arabic9)
                      .setBorder(border2)
                      .setFontSize(8)
                      .setTextAlignment(TextAlignment.RIGHT)
                      .setBorderBottom(Border.NO_BORDER)
              );

              // Create the right table with two columns and one row
              Table subTablel = new Table(4);
              subTablel.addCell(new Cell().add("Height/Weight")
                      .setBorder(border2)
                      .setFontSize(8)
              );
              String weight = txtWeight.getText();
              subTablel.addCell(new Cell().add(weight+" KG")
                     // .setBackgroundColor(backgroundColor).setBorder(border)
                      .setFontSize(9)
                      .setFontColor(fontcolor2)
                    .setFont(font)
                      .setBorder(border)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              
              String height = txtHeight.getText();
              subTablel.addCell(new Cell().add(height)
                     // .setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setFontSize(9)
                      .setFontColor(fontcolor2)
                    .setFont(font)
              );
               com.itextpdf.layout.element.Image arabic10 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/10.png"));

                arabic10.scaleAbsolute(Width2, Height2);
                arabic10.setHorizontalAlignment(HorizontalAlignment.RIGHT);
                
              subTablel.addCell(new Cell().add(arabic10)
                      .setBorder(border2)
                      .setFontSize(8)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              
              Table subTablel2 = new Table(3);
              subTablel2.addCell(new Cell().add("Complexions")
                      .setBorderTop(Border.NO_BORDER)
                      .setBorder(border2)
                      .setFontSize(8)
              );
              String complexions = txtComplexions.getText();
              subTablel2.addCell(new Cell().add(complexions)
                      //.setBackgroundColor(backgroundColor)
                      .setBorderTop(Border.NO_BORDER)
                      .setFontColor(fontcolor2)
                      .setBorder(border)
                      .setFontSize(9)
                    .setFont(font)
              );
              
              com.itextpdf.layout.element.Image arabic11 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/11.png"));
              arabic11.scaleAbsolute(Width, Height);
              arabic11.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              
              subTablel2.addCell(new Cell().add(arabic11)
                      .setBorderTop(Border.NO_BORDER)
                      .setBorder(border2)
                      .setFontSize(8)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              subTablel2.addCell(new Cell().add("Education Qualifications")
                      .setBorder(border2)
                      .setFontSize(8)
                      .setHeight(25)
              );
              String education = txtEducation.getText();
              education = education.replace("\n", "\n\r");
              subTablel2.addCell(new Cell().add(new Paragraph(education))
                      //.setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setFontSize(9)
                    .setFont(font)
                      .setFontColor(fontcolor2)
              );
              
              com.itextpdf.layout.element.Image arabic12 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/12.png"));
              arabic12.scaleAbsolute(Width2, Height2);
              arabic12.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              
              subTablel2.addCell(new Cell().add(arabic12)
                      .setBorder(border2)
                      .setFontSize(8)
                      .setTextAlignment(TextAlignment.RIGHT)
              );


              com.itextpdf.layout.element.Image arabic29 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/29.png"));
              arabic29.scaleAbsolute(Width3, Height3);
              arabic29.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              // Create the right table with two columns and one row
              Table rightTable = new Table(2);
              
              DeviceRgb fontcolor3 = new DeviceRgb(213, 39, 118);
              
              rightTable.addCell(new Cell().add("PASSPORT DETAIL")
                      .setTextAlignment(TextAlignment.LEFT)
                      .setBorder(Border.NO_BORDER)
                      .setBold()
                      .setFontSize(9)
              );
              rightTable.addCell(new Cell().add(arabic29)
                      .setTextAlignment(TextAlignment.RIGHT)
                      .setBorder(Border.NO_BORDER)
                      .setBold()
                      .setFontSize(9)
              );

              // Create a separate table below the header in the right table
              Table subTable = new Table(3);
              subTable.addCell(new Cell().add("Number")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              String number = txtNumber.getText();
              subTable.addCell(new Cell().add(number)
                      .setFontSize(9)
                    .setFont(font)
                     // .setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setFontColor(fontcolor3)
              );
              com.itextpdf.layout.element.Image arabic30 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/30.png"));
              arabic30.scaleAbsolute(Width4, Height4);
              arabic30.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              subTable.addCell(new Cell().add(arabic30)
                      .setFontSize(8)
                      .setTextAlignment(TextAlignment.RIGHT)
                      .setBorder(border2)
              );
              subTable.addCell(new Cell().add("Date Of Issue")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              String dateIssue = txtDateIssue.getText();
              subTable.addCell(new Cell().add(dateIssue)
                      .setFontSize(9)
                    .setFont(font)
                      //.setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setFontColor(fontcolor3)
              );
              com.itextpdf.layout.element.Image arabic31 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/31.png"));
              arabic31.scaleAbsolute(Width2, Height2);
              arabic31.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              subTable.addCell(new Cell().add(arabic31)
                      .setFontSize(8)
                      .setTextAlignment(TextAlignment.RIGHT)
                      .setBorder(border2)
              );
              subTable.addCell(new Cell().add("Date Of Expiry")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              String expiry = txtDateExpiry.getText();
              subTable.addCell(new Cell().add(expiry)
                      .setFontSize(9)
                    .setFont(font)
                     // .setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setFontColor(fontcolor3)
              );
              com.itextpdf.layout.element.Image arabic32 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/32.png"));
              arabic32.scaleAbsolute(Width2, Height2);
              arabic32.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              subTable.addCell(new Cell().add(arabic32)
                      .setFontSize(8)
                      .setTextAlignment(TextAlignment.RIGHT)
                      .setBorder(border2)
              );
              subTable.addCell(new Cell().add("Age")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              String age = txtAge.getText();
              subTable.addCell(new Cell().add(age)
                      .setFontSize(9)
                    .setFont(font)
                     // .setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setFontColor(fontcolor3)
              );
              com.itextpdf.layout.element.Image arabic33 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/33.png"));
              arabic33.scaleAbsolute(Width4, Height4);
              arabic33.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              subTable.addCell(new Cell().add(arabic33)
                      .setFontSize(8)
                      .setTextAlignment(TextAlignment.RIGHT)
                      .setBorder(border2)
              );
              
              
              //create left table 2 
              
              // Create the right table with two columns and one row
              Table rightTable2 = new Table(2);
              rightTable2.addCell(new Cell().add("PPREVIOUS EMPLOYMENT ABROAD")
                      .setTextAlignment(TextAlignment.LEFT)
                      .setBorder(Border.NO_BORDER)
                      .setBold()
                      .setFontSize(9)
                      .setWidth(UnitValue.createPercentValue(65))
              );
              
              com.itextpdf.layout.element.Image arabic13 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/13.png"));
              arabic13.scaleAbsolute(Width3, Height3);
              arabic13.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              
              rightTable2.addCell(new Cell().add(arabic13)
                      .setTextAlignment(TextAlignment.RIGHT)
                      .setBorder(Border.NO_BORDER)
                      .setBold()
                      .setFontSize(9)
                      .setWidth(UnitValue.createPercentValue(35))
              );

              // Create a separate table below the header in the right table
              
              com.itextpdf.layout.element.Image arabic14 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/14.png"));
              arabic14.scaleAbsolute(Width4, Height4);
              arabic14.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              
              
                Table titleTable = new Table(5);
                titleTable.addCell(new Cell().add(new Paragraph("Country"))
                      .setFontSize(8)
                      .setBorder(border2)
                      .setWidth(UnitValue.createPercentValue(14))
                        .setBorderRight(Border.NO_BORDER)
                        .setBorderBottom(Border.NO_BORDER)
                );
                titleTable.addCell(new Cell().add(arabic14)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setWidth(UnitValue.createPercentValue(15))
                        .setBorderLeft(Border.NO_BORDER)
                        .setBorderBottom(Border.NO_BORDER)
                );
                titleTable.addCell(new Cell().add("Duration")
                      .setFontSize(8)
                      .setBorder(border2)
                      .setWidth(UnitValue.createPercentValue(24))
                        .setBorderRight(Border.NO_BORDER)   
                        .setBorderBottom(Border.NO_BORDER)
              );
                
              com.itextpdf.layout.element.Image arabic15 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/15.png"));
              arabic15.scaleAbsolute(Width4, Height4);
              arabic15.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              
              titleTable.addCell(new Cell().add("Period")
                      .setFontSize(8)
                      .setBorder(border2)
                      .setBorderRight(Border.NO_BORDER)
                      .setBorderBottom(Border.NO_BORDER)
              );
              titleTable.addCell(new Cell().add(arabic15)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setBorderLeft(Border.NO_BORDER)
                      .setBorderBottom(Border.NO_BORDER)
              );
               
                
                Table subTable3 = new Table(3);
              
                
              String countryOne = country1.getText();
              DeviceRgb fontcolorWhite = new DeviceRgb(255, 255, 255);
              if(countryOne.equals("")){
                  
              subTable3.addCell(new Cell().add("COUNTRY")
                      .setFontSize(8)
                      .setBorder(border2)
                      .setFontColor(fontcolorWhite)
                      .setBackgroundColor(fontcolorWhite)
                      .setTextAlignment(TextAlignment.CENTER)
                       .setWidth(UnitValue.createPercentValue(24))
                      .setFont(font)
                      
              );
              
              }else{
              
              subTable3.addCell(new Cell().add(countryOne)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.CENTER)
                       .setWidth(UnitValue.createPercentValue(24))
                      
              );
              }
              
              String c1duration = txtc1Duration.getText();
              subTable3.addCell(new Cell().add(c1duration)
                      .setFontSize(9)
                    .setFont(font)
                     // .setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setWidth(UnitValue.createPercentValue(20))
              );
              String c1period = txtc1Period.getText();
              subTable3.addCell(new Cell().add(c1period)
                      .setFontSize(9)
                    .setFont(font)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
              );
              String countryTwo = country2.getText();
              if(countryTwo.equals("")){
                  
              subTable3.addCell(new Cell().add("COUNTRY")
                      .setFontSize(8)
                      .setBorder(border2)
                      .setFontColor(fontcolorWhite)
                      .setBackgroundColor(fontcolorWhite)
                      .setTextAlignment(TextAlignment.CENTER)
                       .setWidth(UnitValue.createPercentValue(24))
                      .setFont(font)
                      
              );
              
              }else{
              
              subTable3.addCell(new Cell().add(countryTwo)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.CENTER)
                       .setWidth(UnitValue.createPercentValue(24))
                      
              );
              }
              String c2Duration = txtc2Duration.getText();
              subTable3.addCell(new Cell().add(c2Duration)
                      .setFontSize(9)
                    .setFont(font)
                      //.setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setWidth(UnitValue.createPercentValue(20))
              );
              String c2period = txtc2Period.getText();
              subTable3.addCell(new Cell().add(c2period)
                      .setFontSize(9)
                    .setFont(font)
                      .setBorder(border)
                      //.setBackgroundColor(backgroundColor)
              );
              String countryThree = country3.getText();
               if(countryThree.equals("")){
                  
              subTable3.addCell(new Cell().add(new Paragraph("COUNTRY"))
                      .setFontSize(8)
                      .setBorder(border2)
                      .setFontColor(fontcolorWhite)
                      .setBackgroundColor(fontcolorWhite)
                      .setTextAlignment(TextAlignment.CENTER)
                       .setWidth(UnitValue.createPercentValue(24))
                      .setFont(font)
                      
              );
              
              }else{
              
              subTable3.addCell(new Cell().add(countryThree)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.CENTER)
                       .setWidth(UnitValue.createPercentValue(24))
                      
              );
              }
              String c3duration = txtc3Period.getText();
              subTable3.addCell(new Cell().add(c3duration)
                      .setFontSize(9)
                    .setFont(font)
                      //.setBackgroundColor(backgroundColor)
                      .setBorder(border)
                      .setWidth(UnitValue.createPercentValue(20))
              );
              String c3period = txtc3Period.getText();
              subTable3.addCell(new Cell().add(c3period)
                      .setFontSize(9)
                    .setFont(font)
                      .setBorder(border)
                      //.setBackgroundColor(backgroundColor)
              );

              com.itextpdf.layout.element.Image arabic16 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/16.png"));
              arabic16.scaleAbsolute(Width3, Height3);
              arabic16.setHorizontalAlignment(HorizontalAlignment.RIGHT);
               // Create the right table with two columns and one row
              Table rightTable3 = new Table(2);
              rightTable3.addCell(new Cell().add("WORK EXPERIENCE")
                      .setTextAlignment(TextAlignment.LEFT)
                      .setBorder(Border.NO_BORDER)
                      .setBold()
                      .setFontSize(9)
                      .setWidth(UnitValue.createPercentValue(65))
              );
              rightTable3.addCell(new Cell().add(arabic16)
                      .setTextAlignment(TextAlignment.RIGHT)
                      .setBorder(Border.NO_BORDER)
                      .setBold()
                      .setFontSize(8)
                      .setWidth(UnitValue.createPercentValue(35))
              );

              // Create a separate table below the header in the right table
              Table subTable5 = new Table(6);
              
              com.itextpdf.layout.element.Image arabic18 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/18.png"));
              arabic18.scaleAbsolute(Width4, Height4);
              arabic18.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              
              subTable5.addCell(new Cell().add("Cooking")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              boolean isSelected = jCheckBoxCooking.isSelected();
              if(isSelected){
                  com.itextpdf.layout.element.Image symbol = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/symbol.png"));
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  subTable5.addCell(new Cell().add(symbol)
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }else{
                  subTable5.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }
              
              subTable5.addCell(new Cell().add(arabic18)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              com.itextpdf.layout.element.Image arabic17 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/17.png"));
              arabic17.scaleAbsolute(Width2, Height2);
              arabic17.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              subTable5.addCell(new Cell().add("Baby Sitting")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              boolean isSelected2 = jCheckBoxBabySitting.isSelected();
              if(isSelected2){
                  com.itextpdf.layout.element.Image symbol = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/symbol.png"));
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  subTable5.addCell(new Cell().add(symbol)
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }else{
                  subTable5.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }
              subTable5.addCell(new Cell().add(arabic17)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              
              com.itextpdf.layout.element.Image arabic19 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/19.png"));
              arabic19.scaleAbsolute(Width4, Height4);
              arabic19.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              
              subTable5.addCell(new Cell().add("Washing")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              boolean isSelected3 = jCheckBoxWashing.isSelected();
              if(isSelected3){
                  com.itextpdf.layout.element.Image symbol = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/symbol.png"));
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  subTable5.addCell(new Cell().add(symbol)
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }else{
                  subTable5.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }
              subTable5.addCell(new Cell().add(arabic19)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              com.itextpdf.layout.element.Image arabic20 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/20.png"));
              arabic20.scaleAbsolute(Width4, Height4);
              arabic20.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              subTable5.addCell(new Cell().add("Sewing")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              boolean isSelected4 = jCheckBoxSewing.isSelected();
              if(isSelected4){
                  com.itextpdf.layout.element.Image symbol = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/symbol.png"));
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  subTable5.addCell(new Cell().add(symbol)
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }else{
                  subTable5.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }
              subTable5.addCell(new Cell().add(arabic20)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
               com.itextpdf.layout.element.Image arabic21 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/21.png"));
              arabic21.scaleAbsolute(Width, Height);
              arabic21.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              subTable5.addCell(new Cell().add("Cleaning")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              boolean isSelected5 = jCheckBoxCleaning.isSelected();
              if(isSelected5){
                  com.itextpdf.layout.element.Image symbol = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/symbol.png"));
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  subTable5.addCell(new Cell().add(symbol)
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }else{
                  subTable5.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }
              subTable5.addCell(new Cell().add(arabic21)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
               com.itextpdf.layout.element.Image arabic22 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/22.png"));
              arabic22.scaleAbsolute(Width4, Height4);
              arabic22.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              subTable5.addCell(new Cell().add("Driving")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              
              boolean isSelected6 = jCheckBoxDriving.isSelected();
              if(isSelected6){
                  com.itextpdf.layout.element.Image symbol = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/symbol.png"));
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  subTable5.addCell(new Cell().add(symbol)
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }else{
                  subTable5.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(10))
                  );
              }
              subTable5.addCell(new Cell().add(arabic22)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              
              
              
              // Create the right table with two columns and one row
              Table rightTable4 = new Table(2);
              rightTable4.addCell(new Cell().add("Note")
                      .setFontSize(8)
                      .setWidth(UnitValue.createPercentValue(10))
                      .setBorder(border2)
              );
              
              String note = txtNote.getText();
              rightTable4.addCell(new Cell().add(note)
                      .setFontSize(9)
                    .setFont(font)
                      .setWidth(UnitValue.createPercentValue(90))
                      .setBorder(border2)
              );
              
              com.itextpdf.layout.element.Image arabic23 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/23.png"));
              arabic23.scaleAbsolute(Width3, Height3);
              arabic23.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              
               // Create the right table with two columns and one row
              Table kOfW = new Table(2);
              kOfW.addCell(new Cell().add("KNOWLEDGE OF LANGUAGES")
                      .setTextAlignment(TextAlignment.LEFT)
                      .setBorder(Border.NO_BORDER)
                      .setBold()
                      .setFontSize(9)
                      .setWidth(UnitValue.createPercentValue(65))
              );
              kOfW.addCell(new Cell().add(arabic23)
                      .setTextAlignment(TextAlignment.RIGHT)
                      .setBorder(Border.NO_BORDER)
                      .setBold()
                      .setFontSize(8)
                      .setWidth(UnitValue.createPercentValue(35))
              );
              
              
              
              Table headerlast = new Table(5);
              
              com.itextpdf.layout.element.Image arabic24 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/24.png"));
              arabic24.scaleAbsolute(Width2, Height2);
              arabic24.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              
              headerlast.addCell(new Cell().add("English ")
                      .setFontSize(8)
                      .setBorder(border2)
                      .setBorderRight(Border.NO_BORDER)
                      .setBorderBottom(Border.NO_BORDER)
                      .setWidth(UnitValue.createPercentValue(14))

              );
              headerlast.addCell(new Cell().add(arabic24)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.RIGHT)
                      .setBorderBottom(Border.NO_BORDER)
                      .setBorderLeft(Border.NO_BORDER)
              );
              headerlast.addCell(new Cell().add("Arabic")
                      .setBorderBottom(Border.NO_BORDER)
                      .setBorderRight(Border.NO_BORDER)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setWidth(UnitValue.createPercentValue(14))

              );
              com.itextpdf.layout.element.Image arabic25 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/25.png"));
              arabic25.scaleAbsolute(Width2, Height2);
              arabic25.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              
              headerlast.addCell(new Cell().add(arabic25)
                       .setBorderLeft(Border.NO_BORDER)
                      .setBorderBottom(Border.NO_BORDER)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.RIGHT)
                      
              );
              headerlast.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                      .setBorder(Border.NO_BORDER)
                     // .setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(23))
              );
              
              
              
              Table subTablekOfW = new Table(5);
              
              subTablekOfW.addCell(new Cell().add("Poor")
                      .setFontSize(8)
                      .setBorder(border2)
                     
              );
              com.itextpdf.layout.element.Image symbol = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/symbol.png"));
              boolean isLSelected = jRadioButtonPoor.isSelected();
              if(isLSelected){
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  
                  subTablekOfW.addCell(new Cell().add(symbol)
                      .setFontSize(8)
                      .setBorder(border)
                      //.setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(12))
                  );
              }else{
                  subTablekOfW.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                      //.setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(12))
                    );
              }
              
              boolean isLSelected2 = jRadioButtonArabicPoor.isSelected();
              if(isLSelected2){
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  
                  subTablekOfW.addCell(new Cell().add(symbol)
                      .setFontSize(8)
                      .setBorder(border)
                      //.setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(12))
                  );
              }else{
                  subTablekOfW.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                      //.setBackgroundColor(backgroundColor)
                      .setWidth(UnitValue.createPercentValue(12))
                    );
              }
              com.itextpdf.layout.element.Image arabic26 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/26.png"));
              arabic26.scaleAbsolute(Width4, Height4);
              arabic26.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              subTablekOfW.addCell(new Cell().add(arabic26)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.RIGHT)

              );
              subTablekOfW.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                      .setBorder(Border.NO_BORDER)
                     // .setBackgroundColor(backgroundColor)
              );
               subTablekOfW.addCell(new Cell().add("Fair")
                      .setFontSize(8)
                      .setBorder(border2)
              );
              boolean isLSelected3 = jRadioButtonFair.isSelected();
              if(isLSelected3){
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  
                  subTablekOfW.addCell(new Cell().add(symbol)
                      .setFontSize(8)
                      .setBorder(border)
                      //.setBackgroundColor(backgroundColor)
                  );
              }else{
                  subTablekOfW.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                      //.setBackgroundColor(backgroundColor)
                    );
              }
              boolean isLSelected4 = jRadioButtonArabicFair.isSelected();
              if(isLSelected4){
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  
                  subTablekOfW.addCell(new Cell().add(symbol)
                      .setFontSize(8)
                      .setBorder(border)
                      //.setBackgroundColor(backgroundColor)
                  );
              }else{
                  subTablekOfW.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                      //.setBackgroundColor(backgroundColor)
                    );
              }
              com.itextpdf.layout.element.Image arabic27 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/27.png"));
              arabic27.scaleAbsolute(Width4, Height4);
              arabic27.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              subTablekOfW.addCell(new Cell().add(arabic27)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              subTablekOfW.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setBorder(Border.NO_BORDER)
              );
              
              Table subTablekOfW2 = new Table(5);
              
              subTablekOfW2.addCell(new Cell().add("Fluent")
                      .setFontSize(8)
                      .setBorder(border2)
                      .setBorderTop(Border.NO_BORDER)
              );
              boolean isLSelected5 = jRadioButtonFluent.isSelected();
              if(isLSelected5){
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  
                  subTablekOfW2.addCell(new Cell().add(symbol)
                     .setFontSize(8)
                      .setBorder(border)
                      .setWidth(UnitValue.createPercentValue(12))
                     // .setBackgroundColor(backgroundColor)
                      .setBorderTop(Border.NO_BORDER)
                    );
              }else{
                    subTablekOfW2.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                      .setWidth(UnitValue.createPercentValue(12))
                     // .setBackgroundColor(backgroundColor)
                      .setBorderTop(Border.NO_BORDER)
                    );
              }
              
              boolean isLSelected6 = jRadioButtonArabicfluent.isSelected();
              if(isLSelected6){
                  symbol.scaleAbsolute(Width5, Height5);
                  symbol.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  
                  subTablekOfW2.addCell(new Cell().add(symbol)
                     .setFontSize(8)
                      .setBorder(border)
                      .setWidth(UnitValue.createPercentValue(12))
                     // .setBackgroundColor(backgroundColor)
                      .setBorderTop(Border.NO_BORDER)
                    );
              }else{
                    subTablekOfW2.addCell(new Cell().add("")
                      .setFontSize(8)
                      .setBorder(border)
                      .setWidth(UnitValue.createPercentValue(12))
                     // .setBackgroundColor(backgroundColor)
                      .setBorderTop(Border.NO_BORDER)
                    );
              }
              com.itextpdf.layout.element.Image arabic28 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/28.png"));
              arabic28.scaleAbsolute(Width4, Height4);
              arabic28.setHorizontalAlignment(HorizontalAlignment.RIGHT);
              subTablekOfW2.addCell(new Cell().add(arabic28)
                      .setFontSize(8)
                      .setBorder(border2)
                      .setBorderTop(Border.NO_BORDER)
                      .setTextAlignment(TextAlignment.RIGHT)
              );
              float Width6 = 2 * 29; // Convert inches to points (assuming DPI of 72)
              float Height6 = 2 * 7;
              com.itextpdf.layout.element.Image checkedBy = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/checkedBy.png"));
              checkedBy.scaleAbsolute(Width6, Height6);
              checkedBy.setHorizontalAlignment(HorizontalAlignment.CENTER);
              subTablekOfW2.addCell(new Cell().add(checkedBy)
                      .setBorder(border2)
                      .setBorder(Border.NO_BORDER)
                      
              );
              rightTable4.setMargins(8, 0, 0, 0);
              
              // Add the tables to the outer table
              outerTable.addCell(new Cell()
                      .add(leftTable)
                      .add(subTablel)
                      .add(subTablel2)
                      .add(rightTable2)
                      .add(titleTable)
                      .add(subTable3)
                      .add(rightTable3)
                      .add(subTable5)
                      .add(rightTable4)
                      .add(kOfW)
                      .add(headerlast)
                      .add(subTablekOfW)
                      .add(subTablekOfW2)
                      .setBorder(Border.NO_BORDER)
              );
              outerTable.addCell(new Cell()
                      .add(rightTable)
                      .add(subTable)
                      .setBorder(Border.NO_BORDER)
              );

        outerTable.setMargins(0, 20, 0, 20);
        
        // Add the outer table to the document
        document.add(outerTable);

        // Create the right table with two columns and one row
              Table remarks = new Table(1);
              remarks.addCell(new Cell().add("Remarks")
                     .setFontSize(7)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setHeight(10)
                      .setBorderBottom(Border.NO_BORDER)
              );
              DeviceRgb fontcolor4 = new DeviceRgb(213, 39, 118);
              String remark = jTextAreaRemarks.getText();
              remarks.addCell(new Cell().add(remark)
                      .setBorderTop(Border.NO_BORDER)
                      .setFontSize(11)
                      .setBorder(border)
                     // .setBackgroundColor(backgroundColor)
                      .setHeight(18)
                      .setFont(font)
                      .setFontColor(fontcolor4)
              );
              remarks.setMargins(5, 20, 20, 20);
                      
              document.add(remarks);
        
             // Table footer = new Table(1);
              
              DeviceRgb bgcolor = new DeviceRgb(0, 0, 0);
               DeviceRgb fontcolor = new DeviceRgb(255, 255, 255);
              Border border3 = new SolidBorder(bgcolor, 2);
              
              
              
//              footer.addCell(new Cell().add("@ newalmaidan@gmail.com")
//                      .setFontSize(12)
//                      .setBorder(border3)
//                      .setBackgroundColor(bgcolor)
//                      .setTextAlignment(TextAlignment.CENTER)
//                      .setFontColor(fontcolor)
//              );
//                      footer.setMargins(3, 0, 0, 0);

              Table footerTable = new Table(1);
            footerTable.setWidth(pdfDocument.getDefaultPageSize().getWidth() - document.getLeftMargin() - document.getRightMargin());

            // Create a new footer cell
            Cell footerCell = new Cell().add("@ newalmaidan@gmail.com")
                      .setFontSize(12)
                      .setBorder(border3)
                      .setBackgroundColor(bgcolor)
                      .setTextAlignment(TextAlignment.CENTER)
                      .setFontColor(fontcolor);
            
            //document.add(footerCell);
            footerTable.addCell(footerCell);
            
            // Set the fixed position of the footer table
            float x = document.getLeftMargin();
            float y = pdfDocument.getDefaultPageSize().getBottom() + document.getBottomMargin();
            footerTable.setFixedPosition( x, y, pdfDocument.getDefaultPageSize().getWidth());

            // Add the footer table to the current page
            new Document(pdfDocument).add(footerTable);
            
            
            // Add the passport photo
            com.itextpdf.layout.element.Image title = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/title.png"));


            float targetWidth3 = 2 * 86; // Convert inches to points (assuming DPI of 72)
            float targetHeight3 = 2 * 86;

            float photoWidth3 = title.getImageScaledWidth();
            float photoHeight3 = title.getImageScaledHeight();

            float scaleWidth3 = targetWidth3 / photoWidth3;
            float scaleHeight3 = targetHeight3 / photoHeight3;

            // Use the minimum scale factor to maintain aspect ratio
            float scale3 = Math.min(scaleWidth3, scaleHeight3);

            float scaledWidth3 = photoWidth3 * scale3;
            float scaledHeight3 = photoHeight3 * scale3;

            title.scaleAbsolute(scaledWidth3, scaledHeight3);

            float pageWidth3 = pdfDocument.getDefaultPageSize().getWidth();
            float pageHeight3 = pdfDocument.getDefaultPageSize().getHeight();

            float photoX3 = pageWidth3 - scaledWidth3 - 105; // Adjust the X position as needed
            float photoY3 = pageHeight3 - scaledHeight3 - 148; // Adjust the Y position as needed

            title.setFixedPosition(1, photoX3, photoY3);

            document.add(title);
            
            
            
            // Add the passport photo
            String name1 = txtImageName1.getText();
            com.itextpdf.layout.element.Image passportPhoto = new com.itextpdf.layout.element.Image(ImageDataFactory.create(newpath+"/"+name1));


            float targetWidth = 2 * 48; // Convert inches to points (assuming DPI of 72)
            float targetHeight = 2 * 48;

            float photoWidth = passportPhoto.getImageScaledWidth();
            float photoHeight = passportPhoto.getImageScaledHeight();

            float scaleWidth = targetWidth / photoWidth;
            float scaleHeight = targetHeight / photoHeight;

            // Use the minimum scale factor to maintain aspect ratio
            float scale = Math.min(scaleWidth, scaleHeight);

            float scaledWidth = photoWidth * scale;
            float scaledHeight = photoHeight * scale;

            passportPhoto.scaleAbsolute(scaledWidth, scaledHeight);

            float pageWidth = pdfDocument.getDefaultPageSize().getWidth();
            float pageHeight = pdfDocument.getDefaultPageSize().getHeight();

            float photoX = pageWidth - scaledWidth - 20; // Adjust the X position as needed
            float photoY = pageHeight - scaledHeight - 148; // Adjust the Y position as needed

            passportPhoto.setFixedPosition(1, photoX, photoY);

            document.add(passportPhoto);
            
            String name2 = txtImageName2.getText();
            // Add the large passport photo
            com.itextpdf.layout.element.Image passportPhoto2 = new com.itextpdf.layout.element.Image(ImageDataFactory.create(newpath2+"/"+name2));


            float targetWidth2 = 2 * 171; // Convert inches to points (assuming DPI of 72)
            float targetHeight2 = 2 * 171;

            float photoWidth2 = passportPhoto2.getImageScaledWidth();
            float photoHeight2 = passportPhoto2.getImageScaledHeight();

            float scaleWidth2 = targetWidth2 / photoWidth2;
            float scaleHeight2 = targetHeight2 / photoHeight2;

            // Use the minimum scale factor to maintain aspect ratio
            float scale2 = Math.min(scaleWidth2, scaleHeight2);

            float scaledWidth2 = photoWidth2 * scale2;
            float scaledHeight2 = photoHeight2 * scale2;

            passportPhoto2.scaleAbsolute(scaledWidth2, scaledHeight2);

            float pageWidth2 = pdfDocument.getDefaultPageSize().getWidth();
            float pageHeight2 = pdfDocument.getDefaultPageSize().getHeight();

            float photoX2 = pageWidth2 - scaledWidth2 - 45; // Adjust the X position as needed
            float photoY2 = pageHeight2 - scaledHeight2 - 394; // Adjust the Y position as needed

            passportPhoto2.setFixedPosition(1, photoX2, photoY2);

            document.add(passportPhoto2);
            
            if(isLSelected6 || isLSelected5 || isLSelected4 || isLSelected3 || isLSelected2 || isLSelected){
            
            }else{
            
                com.itextpdf.layout.element.Image crossline = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/line.png"));

                float targetWidth6 = 2 * 68; // Convert inches to points (assuming DPI of 72)
                float targetHeight6 = 2 * 78;

                float photoWidth6 = crossline.getImageScaledWidth();
                float photoHeight6 = crossline.getImageScaledHeight();

                float scaleWidth6 = targetWidth6 / photoWidth6;
                float scaleHeight6 = targetHeight6 / photoHeight6;

                // Use the minimum scale factor to maintain aspect ratio
                float scale6 = Math.min(scaleWidth6, scaleHeight6);

                float scaledWidth6 = photoWidth6 * scale6;
                float scaledHeight6 = photoHeight6 * scale6;

                crossline.scaleAbsolute(scaledWidth6, scaledHeight6);

                float pageWidth6 = pdfDocument.getDefaultPageSize().getWidth();
                float pageHeight6 = pdfDocument.getDefaultPageSize().getHeight();

                float photoX6 = pageWidth6 - scaledWidth6 - 400; // Adjust the X position as needed
                float photoY6 = pageHeight6 - scaledHeight6 - 675; // Adjust the Y position as needed

                crossline.setFixedPosition(1, photoX6, photoY6);

                document.add(crossline);
                
            }
            
            
            
            if(countryOne.equals("") && countryTwo.equals("") && countryThree.equals("")){
            com.itextpdf.layout.element.Image crossline2 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("res/line.png"));

                float targetWidth8 = 2 * 68; // Convert inches to points (assuming DPI of 72)
                float targetHeight8 = 2 * 28;

                float photoWidth8 = crossline2.getImageScaledWidth();
                float photoHeight8 = crossline2.getImageScaledHeight();

                float scaleWidth8 = targetWidth8 / photoWidth8;
                float scaleHeight8 = targetHeight8 / photoHeight8;

                // Use the minimum scale factor to maintain aspect ratio
                float scale8 = Math.min(scaleWidth8, scaleHeight8);

                float scaledWidth8 = photoWidth8 * scale8;
                float scaledHeight8 = photoHeight8 * scale8;

                crossline2.scaleAbsolute(scaledWidth8, scaledHeight8);

                float pageWidth8 = pdfDocument.getDefaultPageSize().getWidth();
                float pageHeight8 = pdfDocument.getDefaultPageSize().getHeight();

                float photoX8 = pageWidth8 - scaledWidth8 - 380; // Adjust the X position as needed
                float photoY8 = pageHeight8 - scaledHeight8 - 485; // Adjust the Y position as needed

                crossline2.setFixedPosition(1, photoX8, photoY8);

                document.add(crossline2);
            }else{
            
                
            }
            
            
            
            
            document.close();

            JOptionPane.showMessageDialog(null, "Application Created Successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public static void main(String args[]) {
        
        
                
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateApplication().setVisible(true);
               

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CreateEmpApplication;
    private javax.swing.JLabel Uphoto1;
    private javax.swing.JButton UploadPhoto2;
    private javax.swing.JTextField country1;
    private javax.swing.JTextField country2;
    private javax.swing.JTextField country3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonuploadPhoto1;
    private javax.swing.JCheckBox jCheckBoxBabySitting;
    private javax.swing.JCheckBox jCheckBoxCleaning;
    private javax.swing.JCheckBox jCheckBoxCooking;
    private javax.swing.JCheckBox jCheckBoxDriving;
    private javax.swing.JCheckBox jCheckBoxSewing;
    private javax.swing.JCheckBox jCheckBoxWashing;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButtonArabicFair;
    private javax.swing.JRadioButton jRadioButtonArabicPoor;
    private javax.swing.JRadioButton jRadioButtonArabicfluent;
    private javax.swing.JRadioButton jRadioButtonFair;
    private javax.swing.JRadioButton jRadioButtonFluent;
    private javax.swing.JRadioButton jRadioButtonPoor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaRemarks;
    private javax.swing.ButtonGroup languageArabic;
    private javax.swing.ButtonGroup languageEnglish;
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
    private javax.swing.JComboBox<String> maritalStatus;
    private javax.swing.JLabel photo2;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtAppliedFor;
    private javax.swing.JTextField txtComplexions;
    private javax.swing.JTextField txtContractPeriod;
    private javax.swing.JTextField txtDateExpiry;
    private javax.swing.JTextField txtDateIssue;
    private javax.swing.JTextField txtDob;
    private javax.swing.JTextField txtEducation;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtImageName1;
    private javax.swing.JTextField txtImageName2;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNationality;
    private javax.swing.JTextField txtNoOfChildrens;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtReligion;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtTown;
    private javax.swing.JTextField txtWeight;
    private javax.swing.JTextField txtc1Duration;
    private javax.swing.JTextField txtc1Period;
    private javax.swing.JTextField txtc2Duration;
    private javax.swing.JTextField txtc2Period;
    private javax.swing.JTextField txtc3Period;
    private javax.swing.JTextField txtc3duration;
    // End of variables declaration//GEN-END:variables
    
    byte[] photo = null;
    String filename = null;
    String filename2 = null;

}

