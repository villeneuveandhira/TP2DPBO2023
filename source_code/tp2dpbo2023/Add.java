/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tp2dpbo2023;

// import
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author vil
 */
public class Add extends javax.swing.JFrame {
    private int id;
    private dbConnection db = new dbConnection();
    private Menu Menu;
    String ImagePath = "";
    /**
     * Creates new form AddGrup
     */
    public Add(Menu Menu, int id) {
        initComponents();
        this.Menu = Menu;
        this.id = id;
        ImageIcon ii = null;
        ResultSet res = db.selectQuery("SELECT * FROM obat WHERE id_obat=" + this.id);
        try {
            if (res.next()) {
                TextKodeObat.setText(res.getString("kode_obat"));
                TextNamaObat.setText(res.getString("nama_obat"));
                ImagePath = "src\\assets\\"+res.getString("foto_obat");
                ii = new ImageIcon(ImagePath);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image image = ii.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
 
        LabelImageObat.setIcon(new ImageIcon(image));
        LabelImageObat.setVerticalAlignment(SwingConstants.CENTER);
        if(this.Menu.getIsUpdated()){
            ButtonOk.setText("Update");
        }else{
            ButtonOk.setText("Add");
        }
    }
    
    public Add(Menu Menu){
        initComponents();
        this.db = new dbConnection();
        this.Menu = Menu;
        if(this.Menu.getIsUpdated()){
            ButtonOk.setText("Update");
        }
        else{
            ButtonOk.setText("Add");
        }
    }
    
    private void notification() {
        Menu.onData();
    }
    
    private void addData(){
        String kode = TextKodeObat.getText();
        String nama = TextNamaObat.getText();
        String Path = "src\\assets";
        File directory = new File(Path);
        if(!directory.exists()){
            directory.mkdirs();
        }
        File file1 = new File(ImagePath);
        String fotoObat = this.ImagePath.substring(ImagePath.lastIndexOf('\\') + 1);
        File file2 = new File( Path+"\\"+ fotoObat);
        System.out.println(file2);
        try {
            Files.copy(file1.toPath(), file2.toPath());
        } catch (IOException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (kode.isEmpty() && nama.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data masih belum lengkap!!");
        } else {
            // Add New Data
            String sql = "INSERT INTO obat(kode_obat, nama_obat, foto_obat) VALUES ('"+kode+"','"+nama+"','"+fotoObat+"')";
            db.updateQuery(sql);
            // notification status
            notification();
            dispose();
            // Show Information
            System.out.println("Data added !!");
            JOptionPane.showMessageDialog(null, "Data added !!");
        }
    }
    
    private void updateData(){
        // get data from form
        String kode = TextKodeObat.getText();
        String nama = TextNamaObat.getText();
        String Path = "src\\assets";
        File file1 = new File(ImagePath);
        String fotoObat = this.ImagePath.substring(ImagePath.lastIndexOf('\\') + 1);
        File file2 = new File( Path+"\\"+ fotoObat);
        System.out.println(file2);
        try {
            Files.copy(file1.toPath(), file2.toPath());
        } catch (IOException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (kode.isEmpty() && nama.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data masih belum lengkap!!");
        } else {
            // Update Data in Database
            String sql = "UPDATE obat SET kode_obat='"+kode+"', nama_obat='" +nama+ "', foto_obat='" +fotoObat+ "' WHERE id_obat=" + this.id;
            int affectedRow = db.updateQuery(sql);
            // notification status
            notification();
            dispose();
            if (affectedRow > 0) {
                // Show Information
                JOptionPane.showMessageDialog(null, "Update data success !!");
            } else {
                JOptionPane.showMessageDialog(null, "Update data failed !!");
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

        ButtonBrowse = new javax.swing.JButton();
        LabelImageObat = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        TextKodeObat = new javax.swing.JTextField();
        labelRating = new javax.swing.JLabel();
        ButtonOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TextNamaObat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonBrowse.setText("Browse");
        ButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBrowseActionPerformed(evt);
            }
        });

        LabelImageObat.setText("          Example");
        LabelImageObat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelNama.setText("Kode Obat");

        TextKodeObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextKodeObatActionPerformed(evt);
            }
        });

        labelRating.setText("Nama Obat");

        ButtonOk.setText("Add");
        ButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOkActionPerformed(evt);
            }
        });

        jLabel1.setText("Foto");

        TextNamaObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNamaObatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(labelRating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TextKodeObat, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextNamaObat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelImageObat, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonOk)
                            .addComponent(ButtonBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNama)
                    .addComponent(TextKodeObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRating))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelImageObat, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(ButtonBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(ButtonOk)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser browseImageFile = new JFileChooser();
        //Filter image extensions
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);

        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            ImagePath = selectedImageFile.getAbsolutePath();
            JOptionPane.showMessageDialog(null, ImagePath);
            //Display image on jlable
            ImageIcon ii = new ImageIcon(ImagePath);
            //            Resize image to fit jlabel
            Image image = ii.getImage().getScaledInstance(LabelImageObat.getWidth(), LabelImageObat.getHeight(), Image.SCALE_SMOOTH);

            LabelImageObat.setIcon(new ImageIcon(image));
        }
    }//GEN-LAST:event_ButtonBrowseActionPerformed

    private void TextKodeObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextKodeObatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextKodeObatActionPerformed

    private void ButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOkActionPerformed
        // TODO add your handling code here:
        if(Menu.getIsUpdated()){
            updateData();
        }else{
            addData();
        }

    }//GEN-LAST:event_ButtonOkActionPerformed

    private void TextNamaObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNamaObatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNamaObatActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AddGrup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddGrup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddGrup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddGrup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddGrup().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBrowse;
    private javax.swing.JButton ButtonOk;
    private javax.swing.JLabel LabelImageObat;
    private javax.swing.JTextField TextKodeObat;
    private javax.swing.JTextField TextNamaObat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelRating;
    // End of variables declaration//GEN-END:variables
}
