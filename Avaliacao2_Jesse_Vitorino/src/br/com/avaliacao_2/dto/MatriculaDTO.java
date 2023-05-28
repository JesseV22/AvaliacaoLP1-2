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
    private  String aluno_mar , curso_mar ;
    private int id ;
    private Date data_mar;
    private List<AlunoDTO> alunos; // atributo que representa o relacionamento 1-N com a tabela aluno
    private List<CursoDTO> cursos; // atributo que representa o relacionamento 1-N com a tabela aluno


    /**
     * @return the aluno_mar
     */
    public String getAluno_mar() {
        return aluno_mar;
    }

    /**
     * @param aluno_mar the aluno_mar to set
     */
    public void setAluno_mar(String aluno_mar) {
        this.aluno_mar = aluno_mar;
    }

    /**
     * @return the curso_mar
     */
    public String getCurso_mar() {
        return curso_mar;
    }

    /**
     * @param curso_mar the curso_mar to set
     */
    public void setCurso_mar(String curso_mar) {
        this.curso_mar = curso_mar;
    }



    /**
     * @return the data_mar
     */
    public Date getData_mar() {
        return data_mar;
    }

    /**
     * @param data_mar the data_mar to set
     */
    public void setData_mar(Date data_mar) {
        this.data_mar = data_mar;
    }

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
    
    
}
