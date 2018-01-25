/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * Restaurar.java
 *
 * Created on 17/07/2011, 15:34:05
 */
package restaurar_backup;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author michel
 */
public class Restaurar extends javax.swing.JFrame {

    Connection con = null; //variável para usar em conexão de banco de dados.
    Process proc;

    /**
     * Creates new form Restaurar
     */
    public Restaurar() {
        initComponents();

        try {
            con = Conexao.conectar();//Conecta ao banco de dados 
            JFC_Backup.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 2);
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

        JB_BT_Restaurar_Mysql = new javax.swing.JButton();
        JFC_Backup = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JB_BT_Restaurar_Mysql.setText("Restaurar Backup");
        JB_BT_Restaurar_Mysql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_BT_Restaurar_MysqlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(JB_BT_Restaurar_Mysql)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(JFC_Backup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JFC_Backup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_BT_Restaurar_Mysql))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_BT_Restaurar_MysqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_BT_Restaurar_MysqlActionPerformed
        String dbUserName = "root";// username
        String dbPassword = "";//Password
        try {
            JFC_Backup.setVisible(true);
            String bd = "esporte";
            int result = JFC_Backup.showOpenDialog(null);

            if (result == JFileChooser.OPEN_DIALOG) {

                File bkp;
                bkp = JFC_Backup.getSelectedFile();
                String arq = bkp.getPath();
                System.out.println("bd " + bd);
                System.out.println("arq " + arq);

                String[] restoreCmd = new String[]{"C:\\wamp64\\bin\\mysql\\mysql5.7.19\\bin\\mysql.exe", "--user=" + dbUserName, "--password=" + dbPassword, "-e", "source " + arq};
                Process runtimProcess;

                runtimProcess = Runtime.getRuntime().exec(restoreCmd);
                int proceCom = runtimProcess.waitFor();

                if (proceCom == 0) {
                    JOptionPane.showMessageDialog(null, "Backup Restaurado com sucesso !");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao restaurar backup. \n Verifique as configurações ou entre em contato com o suporte !");
                }
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 2);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 2);
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 2);
        }
    }//GEN-LAST:event_JB_BT_Restaurar_MysqlActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Restaurar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_BT_Restaurar_Mysql;
    private javax.swing.JFileChooser JFC_Backup;
    // End of variables declaration//GEN-END:variables
}
