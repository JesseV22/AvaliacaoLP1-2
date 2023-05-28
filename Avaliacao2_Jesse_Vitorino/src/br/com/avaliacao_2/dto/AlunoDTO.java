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
public class AlunoDTO {

    private String nome_al, email_al, tel_al;
    private int id;
    private Date data_al;
    private List<AlunoDTO> alunos; // atributo que representa o relacionamento 1-N com a tabela aluno

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
     * @return the tel_al
     */
    public String getTel_al() {
        return tel_al;
    }

    /**
     * @param tel_al the tel_al to set
     */
    public void setTel_al(String tel_al) {
        this.tel_al = tel_al;
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
    

   

}
