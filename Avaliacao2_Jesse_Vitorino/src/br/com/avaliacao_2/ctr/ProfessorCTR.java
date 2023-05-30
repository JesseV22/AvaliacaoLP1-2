/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_2.ctr;

import java.sql.ResultSet;
import br.com.avaliacao_2.dto.ProfessorDTO;
import br.com.avaliacao_2.dao.ConexaoDAO;
import br.com.avaliacao_2.dao.ProfessorDAO;

import java.sql.SQLException;

/**
 *
 * @author Jesse
 */
public class ProfessorCTR {

    ProfessorDAO professorDAO = new ProfessorDAO();


    /**
     * Método construtor da classe
     */
    public ProfessorCTR() {
    }

    /**
     * Método utilizado para controlar o acesso ao método inserirProfessor da
     * classe ProfessorAO
     *
     * @param professorDTO, que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String inserirProfessor(ProfessorDTO professorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (professorDAO.inserirProfessor(professorDTO)) {
                return "Professor Cadastrado com Sucesso!!!";
            } else {
                return "Professor NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Professor NÃO Cadastrado";
        }
    }//Fecha o método inserirProfessor

    /**
     * Método utilizado para controlar o acesso ao método alterarProfessor da
     * classe ProfessorDAO
     *
     * @param professorDTO, que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String alterarProfessor(ProfessorDTO professorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (professorDAO.alterarProfessor(professorDTO)) {
                return "Professor Alterado com Sucesso!!!";
            } else {
                return "Professor NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Professor NÃO Alterado!!!";
        }
    }//Fecha o método alterarProfessor

    /**
     * Método utilizado para controlar o acesso ao método excluirProfessor da
     * classe ProfessorDAO
     *
     * @param professorDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirProfessor(ProfessorDTO professorDTO) {
        try {
            // Obtém o ID da professor do objeto ProfessorDTO
            int id = professorDTO.getId();

            // Chama o método da classe DAO para excluir a professor
            if (professorDAO.excluirProfessor(id)) {
                return "Professor Excluído com Sucesso!!!";
            } else {
                return "Professor NÃO Excluído!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Professor NÃO Excluído!!!";
        }
    }

    /**
     * Método utilizado para controlar o acesso ao método consultarProfessor da
     * classe ProfessorDAO
     *
     * @param professorDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do professor
     */
    public ResultSet consultarProfessor(ProfessorDTO professorDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = (ResultSet) professorDAO.consultarProfessor(professorDTO, opcao);
        return rs;
    }

//Fecha o método consultarProfessor
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB

}//Fecha classe ProfessorCTR
