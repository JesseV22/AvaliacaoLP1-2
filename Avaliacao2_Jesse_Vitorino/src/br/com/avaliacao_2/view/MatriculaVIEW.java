package br.com.avaliacao_2.view;

import br.com.avaliacao_2.ctr.MatriculaCTR;
import br.com.avaliacao_2.dao.AlunoDAO;
import br.com.avaliacao_2.dao.CursoDAO;
import br.com.avaliacao_2.dto.AlunoDTO;
import br.com.avaliacao_2.dto.CursoDTO;
import br.com.avaliacao_2.dto.MatriculaDTO;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Jesse
 */
public class MatriculaVIEW extends javax.swing.JInternalFrame {

    SimpleDateFormat data_matmat = new SimpleDateFormat("dd/mm/yyyy");

    MatriculaDTO matriculaDTO = new MatriculaDTO(); //Cria um objeto matriculaDTO
    MatriculaCTR matriculaCTR = new MatriculaCTR(); //Cria um objeto matriculaCTR

    int gravar_alterar; //Variavel usada para saber se esta alterando ou incluindo

    ResultSet rs; //Variavel usada para preenchimeto da tabela e dos campos
    DefaultTableModel modelo_jtl_consultar_mar; //Variavel para guardar o modelo da tabela

    public MatriculaVIEW() {
        initComponents();

        // Chama o método liberaCampos
        liberaCampos(false);

        // Chama o método liberaBotoes
        liberaBotoes(true, false, false, false, true);

        // Inicializa o modelo_jtl_consultar_mar
        modelo_jtl_consultar_mar = (DefaultTableModel) jtl_consultar_mar.getModel();

        // Criar o JComboBox para os alunos
        JComboBox<String> cbAluno = new JComboBox<>();

        // Adicionar o JComboBox ao painel ou frame do CursoView
        // ...
        // Carregar os alunos no JComboBox
        matriculaCTR.carregarAlunosNoComboBox(cbAluno);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        data_mat = new javax.swing.JFormattedTextField();
        comboBoxCursos = new javax.swing.JComboBox<>();
        comboBoxAlunos = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        pesquisa_nome_mar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnPesquisar_pro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_consultar_mar = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnNovo3 = new javax.swing.JButton();
        btnSalvar3 = new javax.swing.JButton();
        btnCancelar3 = new javax.swing.JButton();
        btnExcluir3 = new javax.swing.JButton();
        btnSair3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel1.setText("ALUNO");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("CURSO");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setText("DATA");

        try {
            data_mat.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data_mat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_matActionPerformed(evt);
            }
        });

        comboBoxCursos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                comboBoxCursosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        comboBoxAlunos.setToolTipText("");
        comboBoxAlunos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                comboBoxAlunosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(data_mat, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(comboBoxCursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxAlunos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(data_mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26))
        );

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel5.setText("NOME");

        btnPesquisar_pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_2/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar_proActionPerformed(evt);
            }
        });

        jtl_consultar_mar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ALUNO", "CURSO", "DATA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtl_consultar_mar);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pesquisa_nome_mar, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar_pro))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pesquisa_nome_mar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(btnPesquisar_pro))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_2/view/imagens/educacao.png"))); // NOI18N
        jLabel2.setText("Matricula");

        btnNovo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_2/view/imagens/novo.png"))); // NOI18N
        btnNovo3.setText("NOVO");
        btnNovo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovo3ActionPerformed(evt);
            }
        });

        btnSalvar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_2/view/imagens/salvar.png"))); // NOI18N
        btnSalvar3.setText("SALVAR");
        btnSalvar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar3ActionPerformed(evt);
            }
        });

        btnCancelar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_2/view/imagens/cancelar.png"))); // NOI18N
        btnCancelar3.setText("CANCELAR");
        btnCancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar3ActionPerformed(evt);
            }
        });

        btnExcluir3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_2/view/imagens/excluir.png"))); // NOI18N
        btnExcluir3.setText("EXCLUIR");
        btnExcluir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir3ActionPerformed(evt);
            }
        });

        btnSair3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_2/view/imagens/sair.png"))); // NOI18N
        btnSair3.setText("SAIR");
        btnSair3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar3)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnSair3)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo3)
                    .addComponent(btnSalvar3)
                    .addComponent(btnCancelar3)
                    .addComponent(btnExcluir3)
                    .addComponent(btnSair3))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(363, 363, 363)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovo3ActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        gravar_alterar = 1;
    }//GEN-LAST:event_btnNovo3ActionPerformed

    private void btnSalvar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar3ActionPerformed
        if (gravar_alterar == 1) {
            gravar();
            gravar_alterar = 0;
        } else {
            if (gravar_alterar == 2) {
                alterar();
                gravar_alterar = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Erro no Sistema!!!");
            }
        }

        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
    }//GEN-LAST:event_btnSalvar3ActionPerformed

    private void btnCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar3ActionPerformed
        limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_mar.setNumRows(0);
        liberaBotoes(true, false, false, false, true);
        gravar_alterar = 0;
    }//GEN-LAST:event_btnCancelar3ActionPerformed

    private void btnExcluir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir3ActionPerformed
        excluir();
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
    }//GEN-LAST:event_btnExcluir3ActionPerformed

    private void btnSair3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSair3ActionPerformed

    private void btnPesquisar_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar_proActionPerformed
        preencheTabela(pesquisa_nome_mar.getText());
    }//GEN-LAST:event_btnPesquisar_proActionPerformed

    private void data_matActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_matActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_data_matActionPerformed

    private void comboBoxAlunosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_comboBoxAlunosAncestorAdded
        AlunoDAO dao = new AlunoDAO();
        List<AlunoDTO> lista = dao.listarAlunos();

        //Remove todos os itens de um combobox
        comboBoxAlunos.removeAllItems();

        //para cada item da lista monte um objeto fornecedor
        for (AlunoDTO aluno : lista) {
            comboBoxAlunos.addItem(aluno.getNome_al());
    }//GEN-LAST:event_comboBoxAlunosAncestorAdded
    }
    private void comboBoxCursosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_comboBoxCursosAncestorAdded
        CursoDAO dao = new CursoDAO();
        List<CursoDTO> lista = dao.listarCursos();

        //Remove todos os itens de um combobox
        comboBoxCursos.removeAllItems();

        //para cada item da lista monte um objeto fornecedor
        for (CursoDTO curso : lista) {
            comboBoxCursos.addItem(curso.getNome_cur());
    }//GEN-LAST:event_comboBoxCursosAncestorAdded
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }//Fecha método setPosicao()

    private void gravar() {
        try {
            matriculaDTO.setData_mat(data_matmat.parse(data_mat.getText()));
            List<AlunoDTO> AlunoVIEW = null;
            List<CursoDTO> CursoVIEW = null;

            matriculaDTO.setAlunos(AlunoVIEW);
            matriculaDTO.setCursos(CursoVIEW);

            JOptionPane.showMessageDialog(null,
                    matriculaCTR.inserirMatricula(matriculaDTO)
            );
        } catch (Exception e) {
            System.out.println("Erro ao Gravar: " + e.getMessage());
        }
    }

    private void alterar() {
        try {
            MatriculaDTO matriculaDTO = new MatriculaDTO();
            matriculaDTO.setData_mat(data_matmat.parse(data_mat.getText()));
            List<AlunoDTO> AlunoVIEW = null;
            List<CursoDTO> CursoVIEW = null;

            matriculaDTO.setAlunos(AlunoVIEW);
            matriculaDTO.setCursos(CursoVIEW);

            JOptionPane.showMessageDialog(null,
                    matriculaCTR.alterarMatricula(matriculaDTO)
            );
        } catch (Exception e) {
            System.out.println("Erro ao Alterar: " + e.getMessage());
        }
    }

    private void excluir() {
        if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir o Aluno?", "Aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,
                    matriculaCTR.excluirMatricula(matriculaDTO)
            );
        }
    }
    //Fecha método excluir()
    //Método utilizado para liberar/bloquear os campos da tela.
    // * @param a, boolean com true(libera) false(bloqueia).

    private void liberaCampos(boolean a) {

        data_mat.setEnabled(a);

    }//Fecha método liberaCampos(boolean a)

    /**
     * Método utilizado para liberar os botões da tela.
     *
     * @param a, boolean com true(libera) false(bloqueia) para o btnNovo.
     * @param b, boolean com true(libera) false(bloqueia) para o btnSalvar.
     * @param c, boolean com true(libera) false(bloqueia) para o btnCancelar.
     * @param d, boolean com true(libera) false(bloqueia) para o btnExcluir.
     * @param e, boolean com true(libera) false(bloqueia) para o btnSair.
     */
    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) {
        btnNovo3.setEnabled(a);
        btnSalvar3.setEnabled(b);
        btnCancelar3.setEnabled(c);
        btnExcluir3.setEnabled(d);
        btnSair3.setEnabled(e);
    }//Fecha método liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e)

    /**
     * Método utilizado para limpar os campos da tela.
     */
    private void limpaCampos() {

        data_mat.setText("");
    }//Fecha método limpaCampos()

    /**
     * Método utilizado para preencher/contruir a Jtable.
     *
     * @param nome_al, String com o nome do aluno
     */
    private void preencheTabela(String aluno_id) {
        try {
            // Limpa todas as linhas
            modelo_jtl_consultar_mar.setNumRows(0);

            
            rs = matriculaCTR.consultarMatricula(matriculaDTO, 1); // 1 = é a pesquisa por nome na classe DAO

            List<CursoDTO> CursoVIEW = null; // Declaração da lista CursoVIEW
            matriculaDTO.setCursos(CursoVIEW); // Atribuição da lista à propriedade cursos
            List<AlunoDTO> AlunoVIEW = null; // Declaração da lista AlunoVIEW
            matriculaDTO.setAlunos(AlunoVIEW); // Atribuição da lista à propriedade cursos

            while (rs.next()) {
                modelo_jtl_consultar_mar.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("nome_mar")
                });
            }
        } catch (SQLException erTab) {
            System.out.println("Erro SQL: " + erTab);
        } finally {
            matriculaCTR.CloseDB();
        }
    }
//Fecha método preencheTabela(String nome_al)

    private void preencheCampos(int id) {
        try {
            matriculaDTO.setId(id);
            rs = matriculaCTR.consultarMatricula(matriculaDTO, 2); // 2 = é a pesquisa no id na classe DAO
            if (rs.next()) {
                limpaCampos();

                data_mat.setText(rs.getString("data_mar"));

                // Criar uma lista de cursos e preenchê-la com os dados desejados
                List<CursoDTO> cursoVIEW = new ArrayList<>();
                List<AlunoDTO> alunoVIEW = new ArrayList<>();
                // Lógica para preencher a lista de cursos

                // Definir a lista de cursos no objeto matriculaDTO
                matriculaDTO.setCursos(cursoVIEW);
                matriculaDTO.setAlunos (alunoVIEW);

                gravar_alterar = 2;
                liberaCampos(true);
            }
        } catch (SQLException erTab) {
            System.out.println("Erro SQL: " + erTab);
        } finally {
            matriculaCTR.CloseDB();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar3;
    private javax.swing.JButton btnExcluir3;
    private javax.swing.JButton btnNovo3;
    private javax.swing.JButton btnPesquisar_pro;
    private javax.swing.JButton btnSair3;
    private javax.swing.JButton btnSalvar3;
    private javax.swing.JComboBox<Object> comboBoxAlunos;
    private javax.swing.JComboBox<String> comboBoxCursos;
    private javax.swing.JFormattedTextField data_mat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtl_consultar_mar;
    private javax.swing.JTextField pesquisa_nome_mar;
    // End of variables declaration//GEN-END:variables

}
