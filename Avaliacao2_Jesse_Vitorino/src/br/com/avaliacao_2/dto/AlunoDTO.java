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
public class AlunoDTO {
    private String nome_al,email_al;
    private int id ,curso_id;
    private Date data_al;
    private CursoDTO curso; // atributo que representa a chave estrangeira para a tabela curso

    /**
     * @return the nome_al
     */
    public String getNome_al() {
        return nome_al;
    }

    /**
     * @param nome_al the nome_al to set
     */
    public void setNome_al(String nome_al) {
        this.nome_al = nome_al;
    }

    /**
     * @return the email_al
     */
    public String getEmail_al() {
        return email_al;
    }

    /**
     * @param email_al the email_al to set
     */
    public void setEmail_al(String email_al) {
        this.email_al = email_al;
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
     * @return the data_al
     */
    public Date getData_al() {
        return data_al;
    }

    /**
     * @param data_al the data_al to set
     */
    public void setData_al(Date data_al) {
        this.data_al = data_al;
    }

    /**
     * @return the curso
     */
    public CursoDTO getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(CursoDTO curso) {
        this.curso = curso;
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


}