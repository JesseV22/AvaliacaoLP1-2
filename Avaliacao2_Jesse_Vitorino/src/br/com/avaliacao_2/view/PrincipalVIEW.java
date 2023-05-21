/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package br.com.avaliacao_2.view;

import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Jesse
 */
public class PrincipalVIEW extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalVIEW
     */
    public PrincipalVIEW() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon imageicon = new ImageIcon(getClass().getResource("imagens/Gerenciamento.png"));
        Image image = imageicon.getImage();

        desktopPane = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics graphics){
                graphics.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }

        ;
        menuBar = new javax.swing.JMenuBar();
        menuGerenciamento = new javax.swing.JMenu();
        itemMenuAluno = new javax.swing.JMenuItem();
        itemMenuCurso = new javax.swing.JMenuItem();
        itemMenuProfessor = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itemMenuMatricula = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuBar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                menuBarComponentHidden(evt);
            }
        });

        menuGerenciamento.setMnemonic('f');
        menuGerenciamento.setText("Gerenciamento Acadêmico");

        itemMenuAluno.setMnemonic('o');
        itemMenuAluno.setText("Aluno");
        itemMenuAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAlunoActionPerformed(evt);
            }
        });
        menuGerenciamento.add(itemMenuAluno);

        itemMenuCurso.setMnemonic('a');
        itemMenuCurso.setText("Curso");
        itemMenuCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCursoActionPerformed(evt);
            }
        });
        menuGerenciamento.add(itemMenuCurso);

        itemMenuProfessor.setText("Professor");
        itemMenuProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuProfessorActionPerformed(evt);
            }
        });
        menuGerenciamento.add(itemMenuProfessor);

        menuBar.add(menuGerenciamento);

        jMenu1.setText("Matricula");

        itemMenuMatricula.setMnemonic('s');
        itemMenuMatricula.setText("Matricula");
        itemMenuMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuMatriculaActionPerformed(evt);
            }
        });
        jMenu1.add(itemMenuMatricula);

        menuBar.add(jMenu1);

        menuSair.setMnemonic('h');
        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuBar.add(menuSair);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        sair();
    }//GEN-LAST:event_menuSairMouseClicked

    private void itemMenuAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAlunoActionPerformed
        abreAlunoVIEW();
    }//GEN-LAST:event_itemMenuAlunoActionPerformed

    private void itemMenuMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuMatriculaActionPerformed
       abreMatriculaVIEW();
    }//GEN-LAST:event_itemMenuMatriculaActionPerformed

    private void itemMenuCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCursoActionPerformed
       abreCursoVIEW();
    }//GEN-LAST:event_itemMenuCursoActionPerformed

    private void menuBarComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_menuBarComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_menuBarComponentHidden

    private void itemMenuProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuProfessorActionPerformed
        abreProfessorVIEW();
    }//GEN-LAST:event_itemMenuProfessorActionPerformed

     /**
     * Método para fechar o sistema.
     */ 
   private void sair(){
        Object[] options = { "Sair", "Cancelar" };
        if(JOptionPane.showOptionDialog(null, "Deseja Sair do Sistema", "Informação", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0){
            System.exit(0);
        } 
    } 
    /**
     * Método para abrir a classe AlunoVIEW.
     */
    private void abreAlunoVIEW(){
        AlunoVIEW alunoVIEW = new AlunoVIEW();
        this.desktopPane.add(alunoVIEW);
        alunoVIEW.setVisible(true); 
        alunoVIEW.setPosicao();

    }
    
    
    /**
     * Método para abrir a classe CursoVIEW.
     */
    private void abreCursoVIEW(){
        CursoVIEW cursoVIEW = new CursoVIEW();
        this.desktopPane.add(cursoVIEW);
        cursoVIEW.setVisible(true); 
        cursoVIEW.setPosicao();
    }
    
    
    /**
     * Método para abrir a classe MatriculaVIEW.
     */
    private void abreMatriculaVIEW(){
        MatriculaVIEW matriculaVIEW = new MatriculaVIEW();
        this.desktopPane.add(matriculaVIEW);
        matriculaVIEW.setVisible(true); 
        matriculaVIEW.setPosicao();
    }
    private void abreProfessorVIEW(){
        ProfessorVIEW professorVIEW = new ProfessorVIEW();
        this.desktopPane.add(professorVIEW);
        professorVIEW.setVisible(true); 
        professorVIEW.setPosicao();

    }
   
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
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalVIEW().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemMenuAluno;
    private javax.swing.JMenuItem itemMenuCurso;
    private javax.swing.JMenuItem itemMenuMatricula;
    private javax.swing.JMenuItem itemMenuProfessor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuGerenciamento;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables

}
