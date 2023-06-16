/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_2.dto;

import java.util.Date;
import java.util.List;
/**
 *
 * @author Jesse
 */
public class MatriculaDTO {

    private int id ,aluno_id, curso_id ;
    private Date data_mat;
    private String comboBoxAlunos,comboBoxCursos;
    private List<AlunoDTO> alunos; // atributo que representa o relacionamento 1-N com a tabela aluno
    private List<CursoDTO> cursos; // atributo que representa o relacionamento 1-N com a tabela aluno

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the aluno_id
     */
    public int getAluno_id() {
        return aluno_id;
    }

    /**
     * @param aluno_id the aluno_id to set
     */
    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    /**
     * @return the curso_id
     */
    public int getCurso_id() {
        return curso_id;
    }

    /**
     * @param curso_id the curso_id to set
     */
    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    /**
     * @return the data_mat
     */
    public Date getData_mat() {
        return data_mat;
    }

    /**
     * @param data_mat the data_mat to set
     */
    public void setData_mat(Date data_mat) {
        this.data_mat = data_mat;
    }

    /**
     * @return the alunos
     */
    public List<AlunoDTO> getAlunos() {
        return alunos;
    }

    /**
     * @param alunos the alunos to set
     */
    public void setAlunos(List<AlunoDTO> alunos) {
        this.alunos = alunos;
    }

    /**
     * @return the cursos
     */
    public List<CursoDTO> getCursos() {
        return cursos;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(List<CursoDTO> cursos) {
        this.cursos = cursos;
    }

    /**
     * @return the comboBoxAlunos
     */
    public String getComboBoxAlunos() {
        return comboBoxAlunos;
    }

    /**
     * @param comboBoxAlunos the comboBoxAlunos to set
     */
    public void setComboBoxAlunos(String comboBoxAlunos) {
        this.comboBoxAlunos = comboBoxAlunos;
    }

    /**
     * @return the comboBoxCursos
     */
    public String getComboBoxCursos() {
        return comboBoxCursos;
    }

    /**
     * @param comboBoxCursos the comboBoxCursos to set
     */
    public void setComboBoxCursos(String comboBoxCursos) {
        this.comboBoxCursos = comboBoxCursos;
    }

   
    
}
