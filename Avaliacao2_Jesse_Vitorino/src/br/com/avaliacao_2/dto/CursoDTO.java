 
package br.com.avaliacao_2.dto;

import java.util.List;

/**
 *
 * @author Jesse
 */
public class CursoDTO {
    private String nome_cur ,descri_cur  ;
    private int  id;
    private List<AlunoDTO> alunos; // atributo que representa o relacionamento 1-N com a tabela aluno

    /**
     * @return the nome_cur
     */
    public String getNome_cur() {
        return nome_cur;
    }

    /**
     * @param nome_cur the nome_cur to set
     */
    public void setNome_cur(String nome_cur) {
        this.nome_cur = nome_cur;
    }

    /**
     * @return the descri_cur
     */
    public String getDescri_cur() {
        return descri_cur;
    }

    /**
     * @param descri_cur the descri_cur to set
     */
    public void setDescri_cur(String descri_cur) {
        this.descri_cur = descri_cur;
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
