
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.gridfs.*;
import com.mongodb.util.JSON;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.*;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boss
 */
public class Register extends javax.swing.JFrame {
    private String s;
    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }
    public int checkUsername(){
        try{
            MongoClientURI uri = new MongoClientURI("mongodb://admin:admin1234@ds251622.mlab.com:51622/oxgame");
            MongoClient mongoClient = new MongoClient(uri);
            DB database = mongoClient.getDB("oxgame");
            DBCollection collection = database.getCollection("user");
            BasicDBObject query = new BasicDBObject();
            query.put("username", jTextField1.getText());
            int num=collection.find(query).count();
            if(num==0){
                return 1;
            }else{
                return 0;
            } 
        } catch (MongoException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }return 0;
    }
    public void insert(){
        try{
            MongoClientURI uri = new MongoClientURI("mongodb://admin:admin1234@ds251622.mlab.com:51622/oxgame");
            MongoClient mongoClient = new MongoClient(uri);
            DB db = mongoClient.getDB("oxgame");
            DBCollection collection = db.getCollection("user");
            //Load our image
            byte[] imageBytes = LoadImage(s);
            //Connect to database
            //Create GridFS object
            GridFS fs = new GridFS( db ,"user");
            //Save image into database
            GridFSInputFile in = fs.createFile( imageBytes );
            in.save();
            //Find saved image
            GridFSDBFile out = fs.findOne( new BasicDBObject( "_id" , in.getId() ) );
            //Save loaded image from database into new image file
            FileOutputStream outputImage = new FileOutputStream(s);
            out.writeTo( outputImage );
            outputImage.close();
            BasicDBObject document = new BasicDBObject();
            document.put("username", jTextField1.getText());
            document.put("password", jPasswordField1.getPassword());
            document.put("name", jTextField2.getText());
            document.put("win", 0);
            document.put("lose", 0);
            document.put("draw", 0);
            document.put("match", 0); 
            BasicDBObject imagedetail = new BasicDBObject();
            imagedetail.put("image", in);
            document.put("image", imagedetail);
            collection.insert(document);
            cleartext();
            Lobby x= new Lobby();
            x.show();
            this.hide();
        }catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cleartext(){
        jTextField1.setText("");
        jTextField2.setText("");
        jPasswordField1.setText("");
        jPasswordField2.setText("");
    }
    public static byte[] LoadImage(String filePath) throws Exception {
        File file = new File(filePath);
        int size = (int)file.length();
        byte[] buffer = new byte[size];
        FileInputStream in = new FileInputStream(file);
        in.read(buffer);
        in.close();
        return buffer;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        insertButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        IMAGE = new javax.swing.JLabel();
        InsertImage = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(892, 672));
        setResizable(false);
        setSize(new java.awt.Dimension(892, 672));

        jPanel1.setLayout(null);

        insertButton.setText("REGISTER");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });
        jPanel1.add(insertButton);
        insertButton.setBounds(350, 530, 210, 70);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("USERNAME :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(120, 180, 200, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("PASSWORD :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 250, 200, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("CONFIRM-PASSWORD :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(120, 320, 200, 60);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("NAME :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(120, 390, 170, 50);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(310, 180, 210, 50);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(310, 390, 210, 50);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(310, 250, 210, 50);
        jPanel1.add(jPasswordField2);
        jPasswordField2.setBounds(310, 320, 210, 50);

        jPanel2.setLayout(null);
        jPanel2.add(IMAGE);
        IMAGE.setBounds(0, 0, 250, 250);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(590, 180, 250, 250);

        InsertImage.setText("INSERT IMAGE");
        InsertImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertImageActionPerformed(evt);
            }
        });
        jPanel1.add(InsertImage);
        InsertImage.setBounds(650, 450, 140, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        jLabel5.setText("Register");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(280, 10, 380, 130);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OXbackground.png"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 890, 670);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertImageActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                BufferedImage im = ImageIO.read(selectedFile);
                IMAGE.setIcon(new ImageIcon(im.getScaledInstance(IMAGE.getWidth(), IMAGE.getHeight(), WIDTH)));
                s = path;
            } catch (IOException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("ไม่มีข้อมูล");
        }
    }//GEN-LAST:event_InsertImageActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        try{
            if(!jTextField1.equals("") && !jTextField2.equals("") && !jPasswordField1.equals("") && !jPasswordField2.equals("")){
            if(checkUsername()==1){
                 if(jPasswordField1.getText().equals(jPasswordField2.getText())){
                    insert();
                 }else{
                    JOptionPane.showMessageDialog(rootPane, "Password must be the same.");
                    jPasswordField1.setText("");
                    jPasswordField2.setText("");
                 }
             }else{
                 JOptionPane.showMessageDialog(rootPane, "This username is already exist.");
                 jTextField1.setText("");
             }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Null data");
            }
        }catch (MongoException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_insertButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IMAGE;
    private javax.swing.JButton InsertImage;
    private javax.swing.JLabel background;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
