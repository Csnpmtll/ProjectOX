import com.mongodb.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;

public class registers extends javax.swing.JFrame {

    public registers() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeadRegister = new javax.swing.JLabel();
        titleName = new javax.swing.JLabel();
        titlePassword = new javax.swing.JLabel();
        titleConfirmPass = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        titleUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(499, 430));
        setSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);

        HeadRegister.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        HeadRegister.setForeground(new java.awt.Color(255, 51, 51));
        HeadRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeadRegister.setText("REGISTER");
        getContentPane().add(HeadRegister);
        HeadRegister.setBounds(110, 20, 250, 50);

        titleName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        titleName.setForeground(new java.awt.Color(255, 51, 51));
        titleName.setText("Nickname");
        getContentPane().add(titleName);
        titleName.setBounds(40, 150, 160, 30);

        titlePassword.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        titlePassword.setForeground(new java.awt.Color(255, 51, 51));
        titlePassword.setText("Password");
        getContentPane().add(titlePassword);
        titlePassword.setBounds(40, 200, 160, 30);

        titleConfirmPass.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        titleConfirmPass.setForeground(new java.awt.Color(255, 51, 51));
        titleConfirmPass.setText("Confirm Password");
        getContentPane().add(titleConfirmPass);
        titleConfirmPass.setBounds(40, 250, 160, 30);
        getContentPane().add(txtNickname);
        txtNickname.setBounds(220, 150, 240, 30);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(220, 200, 240, 30);
        getContentPane().add(txtConfirmPassword);
        txtConfirmPassword.setBounds(220, 250, 240, 30);

        btnSubmit.setBackground(new java.awt.Color(0, 255, 0));
        btnSubmit.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit);
        btnSubmit.setBounds(60, 330, 160, 40);

        btnCancel.setBackground(new java.awt.Color(255, 51, 51));
        btnCancel.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        btnCancel.setText("Cancel");
        getContentPane().add(btnCancel);
        btnCancel.setBounds(260, 330, 160, 40);

        titleUsername.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        titleUsername.setForeground(new java.awt.Color(255, 51, 51));
        titleUsername.setText("Username");
        getContentPane().add(titleUsername);
        titleUsername.setBounds(40, 100, 160, 30);
        getContentPane().add(txtUsername);
        txtUsername.setBounds(220, 100, 240, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\AUNZ\\Documents\\NetBeansProjects\\Registers\\img\\pic1.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static boolean booleancheckUsername = false;
    public static boolean booleancheckNickname = false;
    public void submitRegister(){
        MongoClientURI url  = new MongoClientURI("mongodb://59160625:7571323955a@ds155862.mlab.com:55862/ox59160625");
        MongoClient client = new MongoClient(url);
        MongoDatabase db = client.getDatabase(url.getDatabase());
      
        MongoCollection<Document> user = db.getCollection("register");
        
        List<Document> addData = new ArrayList<Document>();

        addData.add(new Document("Username",txtUsername.getText())
                .append("Password", txtPassword.getText())
                .append("NickName", txtNickname.getText())
               
        );
        user.insertMany(addData);
            JLabel label = new JLabel("สมัครเรียบร้อย");
            label.setFont(new Font("TH SarabunPSK", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label);
        
        client.close(); 
    }
    
    public boolean checkConfirmPass(){
        if(txtPassword.getText().equals(txtConfirmPassword.getText())){
            System.out.println("รหัสผ่านตรงกัน");
            return true;
        }else {
            return false;
        }
    }
    
    public void checkUsername(){
        MongoClientURI url  = new MongoClientURI("mongodb://59160625:7571323955a@ds155862.mlab.com:55862/ox59160625");
        MongoClient client = new MongoClient(url);
        MongoDatabase db = client.getDatabase(url.getDatabase());
        
        MongoCollection<Document> user = db.getCollection("register");
       
        try {
            Document myDoc = user.find(eq("Username", txtUsername.getText())).first();
            System.out.println(myDoc.toJson());
            booleancheckUsername = true;
        } catch (Exception e) {
            System.out.println("ไอดีไม่ซ้ำ");
            //ดักไอดีซ้ำและคืนค่า Boolean
            booleancheckUsername = false;
        }      
    }
    
    public void checkNickname(){
        MongoClientURI url  = new MongoClientURI("mongodb://59160625:7571323955a@ds155862.mlab.com:55862/ox59160625");
        MongoClient client = new MongoClient(url);
        MongoDatabase db = client.getDatabase(url.getDatabase());
        
        MongoCollection<Document> user = db.getCollection("register");
       
        try {
            Document myDoc = user.find(eq("NickName", txtNickname.getText())).first();
            System.out.println(myDoc.toJson());
            booleancheckNickname = true;
            
        } catch (Exception e) {
            System.out.println("ชื่อไม่ซ้ำ");
            booleancheckNickname = false;
        }      
    }
    
    public boolean checkEmpty(){
        if(txtUsername.getText().equals("")||txtPassword.getText().equals("")||txtNickname.getText().equals("")){
            System.out.println("กรุณาเติมคำลงช่องว่างให้ครบ");
            return true;
        }else {
            return false;
        }     
    }
    
    public void reset(){
        txtUsername.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        txtNickname.setText("");
    }
    
    public void submit(){
        MongoClientURI url  = new MongoClientURI("mongodb://59160625:7571323955a@ds155862.mlab.com:55862/ox59160625");
       
        MongoClient client = new MongoClient(url);
        MongoDatabase db = client.getDatabase(url.getDatabase());
      
        MongoCollection<Document> user = db.getCollection("register");
        
        List<Document> addData = new ArrayList<Document>();

        addData.add(new Document("Username",txtUsername.getText())
                .append("Password", txtPassword.getText())
                .append("NickName", txtNickname.getText()) 
        );
        user.insertMany(addData);
        JOptionPane.showMessageDialog(this, "สมัครเรียบร้อย");
    
        client.close(); 
    }
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        checkConfirmPass();
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
    }//GEN-LAST:event_btnSubmitActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeadRegister;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel titleConfirmPass;
    private javax.swing.JLabel titleName;
    private javax.swing.JLabel titlePassword;
    private javax.swing.JLabel titleUsername;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
