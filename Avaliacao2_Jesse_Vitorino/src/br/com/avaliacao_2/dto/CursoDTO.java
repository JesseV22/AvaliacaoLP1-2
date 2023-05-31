package br.com.avaliacao_2.dto;

import java.util.List;
import br.com.avaliacao_2.dto.MatriculaDTO;

/**
 *
 * @author Jesse
 */
public class CursoDTO {

    private String nome_cur, descri_cur, carga_cur;
    private int id;
    private MatriculaDTO matricula; // atributo que representa a chave estrangeira para a tabela curso

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
     * @return the carga_cur
     */
    public String getCarga_cur() {
        return carga_cur;
    }

    /**
     * @param carga_cur the carga_cur to set
     */
    public void setCarga_cur(String carga_cur) {
        this.carga_cur = carga_cur;
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
     * @return the matricula
     */
    public MatriculaDTO getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(MatriculaDTO matricula) {
        this.matricula = matricula;
    }

  

}
