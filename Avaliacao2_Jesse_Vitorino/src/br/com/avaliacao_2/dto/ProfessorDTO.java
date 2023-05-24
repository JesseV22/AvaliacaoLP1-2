
package br.com.avaliacao_2.dto;

/**
 *
 * @author Jesse
 */
public class ProfessorDTO {

    private int id;
    private String nome;
    private String email;
    private String especialidade;
    private CursoDTO curso; // atributo que representa a chave estrangeira para a tabela curso

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
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

}
