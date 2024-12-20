/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



/**
 *
 * @author Ana Luisa
 */
public class Login extends javax.swing.JFrame {
    
    SplashScreen inicio;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        
    }
    
    
    public Login(SplashScreen inicio){
        this.inicio = inicio;
        setProgress(0, "Carregando componentes do sistema");
        initComponents();
        setProgress(20, "Conectando ao banco de dados!");
        setProgress(40, "Carregando os módulos");
        setProgress(60, "Carregamento de módulos concluidos");
        setProgress(80, "Carregando interfaces");
        setProgress(100,"Bem vindo ao sistema!!");
        //this.setSize(410,500);
        
    }
    
    void setProgress(int percent, String informacao){
        SwingUtilities.invokeLater(() -> {
        inicio.getJLabel().setText(informacao);
        inicio.getJProgressBar().setValue(percent);
    });
    try {
        Thread.sleep(200); // Simula o tempo de carregamento
    } catch (InterruptedException e) {
        JOptionPane.showMessageDialog(this, "Erro na inicialização: " + e.getMessage());
    }
}
    
    //INICIANDO A CONEXAO
    Conectar con = new Conectar();
    Connection cn = con.conexao();
    
    public void Logar(String id, String senha){
       
    String sql = "SELECT nomeUs, senha FROM usuarios WHERE nomeUs = ? AND senha = ?";
    try (PreparedStatement pst = cn.prepareStatement(sql)) {
        pst.setString(1, id);
        pst.setString(2, senha);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            dispose();
            MenuPrincipal menu = new MenuPrincipal();
            JOptionPane.showMessageDialog(this, "Bem-vindo ao Sistema, " + id + "!");
            menu.userConect.setText(id);
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!", "Login", JOptionPane.WARNING_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage());
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

        painelLogin = new javax.swing.JPanel();
        painelCentral = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        txtsenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setLocation(new java.awt.Point(0, 0));
        setName("telaPrincipal"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        painelLogin.setLayout(new java.awt.BorderLayout());

        painelCentral.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setMinimumSize(new java.awt.Dimension(1360, 760));
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 760));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/login tela.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1370, 280));

        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/bt Entrar.png"))); // NOI18N
        btnEntrar.setBorder(null);
        btnEntrar.setBorderPainted(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEntrar.setName("btnEntrar"); // NOI18N
        btnEntrar.setPreferredSize(new java.awt.Dimension(135, 45));
        btnEntrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/entrar1.png"))); // NOI18N
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 200, 60));

        txtusuario.setBackground(new java.awt.Color(255, 255, 255));
        txtusuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtusuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), null));
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 200, 50));

        txtsenha.setBackground(new java.awt.Color(255, 255, 255));
        txtsenha.setActionCommand(null);
        txtsenha.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), null));
        txtsenha.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsenhaActionPerformed(evt);
            }
        });
        jPanel1.add(txtsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 200, 50));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Senha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, 80, -1));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Usuário:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 80, -1));

        painelCentral.add(jPanel1, java.awt.BorderLayout.CENTER);

        painelLogin.add(painelCentral, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelLogin);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyReleased
        txtusuario.setText(txtusuario.getText().toUpperCase());
    }//GEN-LAST:event_usuarioKeyReleased

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        String us = txtusuario.getText();
        String pass = txtsenha.getText();
        if(us.equals("") || pass.equals("")){
            JOptionPane.showMessageDialog(this, "Preencha os Campos", "Login", 0);
        }else{
            Logar(us, pass);
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    private void txtsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsenhaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtsenhaActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login tela = new Login();
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelCentral;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JPasswordField txtsenha;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
