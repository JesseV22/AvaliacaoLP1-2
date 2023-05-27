
package br.com.avaliacao_2.dto;

/**
 *
 * @author Jesse
 */
public class ProfessorDTO {

    private int id;
    private String nome;
    private String email;
    private String especialidade , tel_prof, end_prof;

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
     * @return the tel_prof
     */
    public String getTel_prof() {
        return tel_prof;
    }

    /**
     * @param tel_prof the tel_prof to set
     */
    public void setTel_prof(String tel_prof) {
        this.tel_prof = tel_prof;
    }

    /**
     * @return the end_prof
     */
    public String getEnd_prof() {
        return end_prof;
    }

    /**
     * @param end_prof the end_prof to set
     */
    public void setEnd_prof(String end_prof) {
        this.end_prof = end_prof;
    }
    

    
}
