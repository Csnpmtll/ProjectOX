
import java.net.UnknownHostException;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.lang.ClassCastException;

public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        txtConPass = new javax.swing.JPasswordField();

        jLabel3.setText("Password : ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 450));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 30)); // NOI18N
        jLabel1.setText("REGISTER");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 10, 160, 35);

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsername);
        txtUsername.setBounds(320, 60, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Username ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 60, 100, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Confirm Password  ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 150, 160, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Password  ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 110, 100, 20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 50, 110, 110);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(30, 180, 100, 40);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(30, 240, 100, 40);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(80, 320, 100, 50);

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit);
        btnSubmit.setBounds(220, 320, 100, 50);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(360, 320, 100, 50);
        getContentPane().add(txtPass);
        txtPass.setBounds(320, 100, 150, 30);

        txtConPass.setToolTipText("");
        getContentPane().add(txtConPass);
        txtConPass.setBounds(320, 140, 150, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
       
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        checkEmpty();
        checkUser();
        checkPassword();
        
        if(checkUser()){
            JOptionPane.showMessageDialog(null, "Usernameนี้มีผู้ใช้แล้ว");
            clearText();
        }else{
            if(checkEmpty()){
            JOptionPane.showMessageDialog(null, "กรุณาใส่ข้อมูลให้ครบ");
        } else if(!checkEmpty()){
            if(!checkPassword()){
                JOptionPane.showMessageDialog(null, "Password ไม่ถูกต้อง");
                txtPass.setText(null);
                txtConPass.setText(null);
            }else{
                submitRegister();
                clearText();
            }
        }
       
            
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearText();       
    }//GEN-LAST:event_btnClearActionPerformed

  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtConPass;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
public void submitRegister(){
        MongoClientURI uri = new MongoClientURI("mongodb://natnatsuda:natsuda29@ds151012.mlab.com:51012/projectox");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        MongoCollection<Document> user = db.getCollection("User");
        List<Document> seedData = new ArrayList<Document>();
       
        seedData.add(new Document("UserName", txtUsername.getText()).append("Password", txtPass.getText()));
          
            user.insertMany(seedData);
            JOptionPane.showMessageDialog(this, "successfully");
            client.close();
}
public void clearText(){
    txtUsername.setText(null);
    txtPass.setText(null);
    txtConPass.setText(null);

}
public boolean checkUser() {
    MongoClientURI uri = new MongoClientURI("mongodb://natnatsuda:natsuda29@ds151012.mlab.com:51012/projectox");
    MongoClient client = new MongoClient(uri);
    MongoDatabase db = client.getDatabase(uri.getDatabase());
    MongoCollection<Document> user = db.getCollection("User");
    
    try {
        Document doc = user.find(eq("UserName", txtUsername.getText())).first();
        System.out.println(doc.toJson());
        return true;
    } catch (Exception e){
        return false;
    }
   
}
public boolean checkPassword(){
    if(txtPass.getText().equals(txtConPass.getText())) {
        return true;
    }
    else{
        return false;
    }
}
public boolean checkEmpty(){
    if(txtUsername.getText().isEmpty() || txtPass.getText().isEmpty() || txtConPass.getText().isEmpty()){
        return true;
    }else {
        return false;
    }
}

}
