package rename_app;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;


/**
 *
 * @author brand
 */



public class NewJFrame extends javax.swing.JFrame {
    
    ArrayList<String[]> readableFileArray = new ArrayList<String[]>();
    String[] newFileNameList;
    public void getDirectoryFiles(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setFileHidingEnabled(true);
        int returnVal = chooser.showOpenDialog(null);
        int i = 1;
        if(returnVal == JFileChooser.APPROVE_OPTION){
            String dirPath = chooser.getSelectedFile().getAbsolutePath();
            File dir = new File(dirPath);
            //dir.getAbsoluteFile();
            int numFiles = 0; // size of array, updates as arraylist grows
            //ArrayList<String[]> readableFileArray = new ArrayList<String[]>();
            //jTextArea1.append(dir.getPath()+"\n");
            if(dir.isDirectory()){
                String newName = jTextField1.getText();
                String ext = jTextField3.getText();
                
                if(ext == null){
                    jTextArea1.append("Rename failed! Problem with extension name\n");
                }
                if(newName == null){
                        jTextArea1.append("Rename failed! Problem with file name\n");
                }
                
                for(final File file : dir.listFiles()) // iterates through file array
                {
                    try {
                        
                        jTextArea2.append(file.getName()+"\n");
                        if(file.isDirectory()){
                            ;
                        }
                        else if(file.renameTo(new File(dirPath+"\\"+newName+"("+i+")"+ext))){
                            i++;
                            jTextArea1.append(file.getName()+" Rename succesful to"+newName+ext+"\n");
                        }else{
                            jTextArea1.append("Rename failed\n");
                            jTextArea1.append("File Name already in use\n");
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }

                }

                }
            }
    }

    public void getSingleFile(){
        JFileChooser chooser = new JFileChooser();

          String responce;
          chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
          // hopefully makes it so hidden files and folders don't show?
          chooser.setFileHidingEnabled(true);
          int returnVal = chooser.showOpenDialog(null);
          if(returnVal == JFileChooser.APPROVE_OPTION){
                if(chooser.getSelectedFile().isFile()){ // if a single file
                    String dirPath = chooser.getSelectedFile().getAbsolutePath();
                    String pPath = dirPath.substring(0,dirPath.lastIndexOf("\\",dirPath.length()-1));
                    pPath = pPath.replace(' ','\\');
                    String newName = jTextField1.getText();
                    String ext = jTextField3.getText();
                    if(ext == null){
                        jTextArea1.append("Rename failed! Problem with extension name\n");
                    }
                    if(newName == null){
                        jTextArea1.append("Rename failed! Problem with file name\n");
                    }
                    File file = chooser.getSelectedFile().getAbsoluteFile();
                    jTextArea2.append(file.getName()+"\n");
                    //jTextArea2.append(pPath+"\n");
                    try {
                        
                        if(file.renameTo(new File(pPath+"\\"+newName+ext))){
                            jTextArea1.append(file.getName()+" Rename succesful to"+newName+ext+"\n");
                        }else{
                            jTextArea1.append("Rename failed\n");
                            jTextArea1.append("File Name already in use\n");
                        }
                    } catch (Exception e) {
                    // TODO: handle exception
                        e.printStackTrace();
                    }
                    
                }
          }
          
    }
    
    public static void findAndReplace(ArrayList<String[]> list, String find, 
                                     String replace){
        ArrayList<String[]> outputArray = new ArrayList<String[]>();
        for(int i=0; i < list.size(); i++){
           String[] fileData = list.get(i);
           fileData[1] = fileData[1].replaceAll(find,replace);
           outputArray.add(fileData);
        }
        for(int i=0; i < outputArray.size(); i++) 
           System.out.println(Arrays.asList(outputArray.get(i)));
   }
   
    
   public static void nameAndNumber(ArrayList<String[]> list, String name){
        ArrayList<String[]> outputArray = new ArrayList<String[]>();
        int count = 1;
        for(int i=0; i < list.size(); i++){
           String[] fileData = list.get(i);
           fileData[1] = name + count;
           outputArray.add(fileData);
           count++;
        }
        for(int i=0; i < outputArray.size(); i++)
           System.out.println(Arrays.asList(outputArray.get(i)));
   }
    /**
     * Creates new form NewJFrame
     */
    
    public static String[] fileDataGetter(File file){
      String filePath = file.getPath();
      String fileName = file.getName();
      int dotPoint = fileName.lastIndexOf("."); //where ext is, last "."
      String nameSansExt = fileName.substring(0,dotPoint);
      String ext = fileName.substring(dotPoint,fileName.length());
      String[] fileData = new String[] {filePath,nameSansExt,ext};
      return fileData;
   }
    
    
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        label_rename_files = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        label_rename_files1 = new java.awt.Label();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        Title = new java.awt.Label();
        jButton3 = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(78, 74, 105));

        jPanel1.setBackground(new java.awt.Color(100, 155, 219));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Browse for file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("Filename");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextArea2.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        label_rename_files.setBackground(new java.awt.Color(100, 155, 219));
        label_rename_files.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label_rename_files.setText("Selected Files:");

        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        label_rename_files1.setBackground(new java.awt.Color(100, 155, 219));
        label_rename_files1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label_rename_files1.setText("Output");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Browse for directory");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField3.setText(".Extension");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_rename_files, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_rename_files1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_rename_files, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_rename_files1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        Title.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Title.setPreferredSize(new java.awt.Dimension(145, 50));
        Title.setText("Rename Files Application");

        jButton3.setText("Help");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //INCREMENT CHECKBOX    
    //THIS IS SINGLE FILE BUTTON
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // This is the event for the OK button on the top part of the GUI
        getSingleFile();
            // .... do some operation on value ...
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    //THIS IS DIRECTORY BUTTON
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        getDirectoryFiles();
        //jTextArea2.append(Arrays.asList(fileData));
    }//GEN-LAST:event_jButton2ActionPerformed

    //THIS IS THE HELP BUTTON
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        helpFrame s = new helpFrame();
        s.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /*
    * Rename Button
    */
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label Title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private java.awt.Label label_rename_files;
    private java.awt.Label label_rename_files1;
    // End of variables declaration//GEN-END:variables
}

