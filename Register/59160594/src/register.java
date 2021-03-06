import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import java.awt.Font;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class register extends javax.swing.JFrame {

    /**
     * Creates new form register
     */
    public register() {
        initComponents();
    }
    public static boolean booleancheckUsername = false;
    public static boolean booleancheckNickname = false;
    public void submitRegister(){
        MongoClientURI url  = new MongoClientURI("mongodb://peerapat1599:pee0817910017@ds257732.mlab.com:57732/peeregister");
        MongoClient client = new MongoClient(url);
        MongoDatabase db = client.getDatabase(url.getDatabase());     
        MongoCollection<Document> user = db.getCollection("user");    
        
        List<Document> addData = new ArrayList<>();

        addData.add(new Document("Username",jTextField1.getText())
                .append("Password", tpw.getText())
                .append("NickName", jTextField2.getText())
               
        );
        user.insertMany(addData);
            JLabel label = new JLabel("สมัครเรียบร้อย");
            label.setFont(new Font("TH SarabunPSK", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label);
        
        client.close(); 
    }
     public boolean checkConfirmPass(){
        if(tpw.getText().equals(tcpw.getText())){
            System.out.println("รหัสผ่านตรงกัน");
            return true;
        }else {
            return false;
        }
    }
    public void checkUsername(){
        MongoClientURI url  = new MongoClientURI("mongodb://peerapat1599:pee0817910017@ds257732.mlab.com:57732/peeregister");
        MongoClient client = new MongoClient(url);
        MongoDatabase db = client.getDatabase(url.getDatabase());
        
        MongoCollection<Document> user = db.getCollection("user");
       
        try {
            Document myDoc = user.find(eq("Username", jTextField1.getText())).first();
            System.out.println(myDoc.toJson());
            booleancheckUsername = true;
        } catch (Exception e) {
            System.out.println("ไอดีไม่ซ้ำ");
            //ดักไอดีซ้ำและคืนค่า Boolean
            booleancheckUsername = false;
        }      
    }
    
    public void checkNickname(){
        MongoClientURI url  = new MongoClientURI("mongodb://peerapat1599:pee0817910017@ds257732.mlab.com:57732/peeregister");
        MongoClient client = new MongoClient(url);
        MongoDatabase db = client.getDatabase(url.getDatabase());
        
        MongoCollection<Document> user = db.getCollection("user");
       
        try {
            Document myDoc = user.find(eq("NickName", jTextField2.getText())).first();
            System.out.println(myDoc.toJson());
            booleancheckNickname = true;
            
        } catch (Exception e) {
            System.out.println("ชื่อไม่ซ้ำ");
            booleancheckNickname = false;
        }      
    }
    
    public boolean checkEmpty(){
        if(jTextField1.getText().equals("")||tpw.getText().equals("")||jTextField2.getText().equals("")){
            System.out.println("กรุณาเติมคำลงช่องว่างให้ครบ");
            return true;
        }else {
            return false;
        }     
    }
    
    public void reset(){
        jTextField1.setText("");
        tpw.setText("");
        tcpw.setText("");
        jTextField2.setText("");
    }
     public void cleartext(){
        jTextField1.setText("");
        jTextField2.setText("");
        tpw.setText("");
        tcpw.setText("");
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register = new javax.swing.JLabel();
        pw = new javax.swing.JLabel();
        user1 = new javax.swing.JLabel();
        cpw = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        tpw = new javax.swing.JPasswordField();
        tcpw = new javax.swing.JPasswordField();
        ok = new javax.swing.JButton();
        close = new javax.swing.JButton();
        fbg = new javax.swing.JLabel();
        fbg2 = new javax.swing.JLabel();
        fbg3 = new javax.swing.JLabel();
        fbg4 = new javax.swing.JLabel();
        fbg5 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(660, 440));
        setResizable(false);
        getContentPane().setLayout(null);

        register.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        register.setForeground(new java.awt.Color(255, 0, 0));
        register.setText("REGISTER");
        getContentPane().add(register);
        register.setBounds(240, 20, 220, 80);

        pw.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        pw.setText("Password");
        getContentPane().add(pw);
        pw.setBounds(120, 170, 90, 50);

        user1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        user1.setText("User");
        getContentPane().add(user1);
        user1.setBounds(160, 120, 50, 30);

        cpw.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cpw.setText("Confirm password");
        getContentPane().add(cpw);
        cpw.setBounds(50, 230, 160, 50);

        name.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        name.setText("Name");
        getContentPane().add(name);
        name.setBounds(150, 290, 60, 50);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(210, 120, 320, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(210, 300, 320, 30);
        getContentPane().add(tpw);
        tpw.setBounds(210, 180, 320, 30);
        getContentPane().add(tcpw);
        tcpw.setBounds(210, 240, 320, 30);

        ok.setBackground(new java.awt.Color(0, 255, 0));
        ok.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok);
        ok.setBounds(410, 350, 120, 50);

        close.setBackground(new java.awt.Color(255, 0, 0));
        close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        close.setText("Close");
        getContentPane().add(close);
        close.setBounds(210, 350, 120, 50);

        fbg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qqq.png"))); // NOI18N
        getContentPane().add(fbg);
        fbg.setBounds(230, 30, 230, 60);

        fbg2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fbg2.setForeground(new java.awt.Color(0, 51, 153));
        fbg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qqq.png"))); // NOI18N
        getContentPane().add(fbg2);
        fbg2.setBounds(150, 120, 60, 30);

        fbg3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fbg3.setForeground(new java.awt.Color(0, 51, 153));
        fbg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qqq.png"))); // NOI18N
        getContentPane().add(fbg3);
        fbg3.setBounds(110, 180, 100, 30);

        fbg4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fbg4.setForeground(new java.awt.Color(0, 51, 153));
        fbg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qqq.png"))); // NOI18N
        getContentPane().add(fbg4);
        fbg4.setBounds(40, 240, 170, 30);

        fbg5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fbg5.setForeground(new java.awt.Color(0, 51, 153));
        fbg5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qqq.png"))); // NOI18N
        getContentPane().add(fbg5);
        fbg5.setBounds(140, 300, 70, 30);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/240_F_212079465_HJnp3Ckv50ZGCD6x7WpOEs7hnElbEetM.jpg"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 660, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        checkUsername();
        checkNickname();
        checkEmpty();
        checkConfirmPass();
        if(booleancheckUsername){
            JLabel label = new JLabel("มีไอดีนี้อยู่ในระบบแล้ว");
            label.setFont(new Font("TH SarabunPSK", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
            reset();
        }else if(booleancheckNickname){
            JLabel label = new JLabel("มีชื่อผู้เล่นนี้อยู่ในระบบแล้ว");
            label.setFont(new Font("TH SarabunPSK", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
            reset();
        }else{  if(checkEmpty()){
                JLabel label = new JLabel("กรุณากรอกข้อมูลให้ครบถ้วน");
                label.setFont(new Font("TH SarabunPSK", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                reset();

            }else if(!checkEmpty()){
                if(!checkConfirmPass()){
                    JLabel label = new JLabel("Password ไม่ตรงกัน");
                    label.setFont(new Font("TH SarabunPSK ", Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    reset();
                }else{
                    submitRegister();
                    reset();
                }
            }
        }
    }//GEN-LAST:event_okActionPerformed

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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton close;
    private javax.swing.JLabel cpw;
    private javax.swing.JLabel fbg;
    private javax.swing.JLabel fbg2;
    private javax.swing.JLabel fbg3;
    private javax.swing.JLabel fbg4;
    private javax.swing.JLabel fbg5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel name;
    private javax.swing.JButton ok;
    private javax.swing.JLabel pw;
    private javax.swing.JLabel register;
    private javax.swing.JPasswordField tcpw;
    private javax.swing.JPasswordField tpw;
    private javax.swing.JLabel user1;
    // End of variables declaration//GEN-END:variables
}
