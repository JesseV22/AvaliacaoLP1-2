/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_2.dto;

import java.util.Date;
/**
 *
 * @author Jesse
 */
public class MatriculaDTO {
    private  String aluno_mar , curso_mar ;
    private int id_mar ;
    private Date data_mar;

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
     * @return the id_mar
     */
    public int getId_mar() {
        return id_mar;
    }

    /**
     * @param id_mar the id_mar to set
     */
    public void setId_mar(int id_mar) {
        this.id_mar = id_mar;
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
    
    
}
