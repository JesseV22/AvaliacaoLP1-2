/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_2.ctr;

import java.sql.ResultSet;
import br.com.avaliacao_2.dto.AlunoDTO;
import br.com.avaliacao_2.dao.AlunoDAO;
import br.com.avaliacao_2.dao.ConexaoDAO;
import br.com.avaliacao_2.dto.CursoDTO;
import br.com.avaliacao_2.dao.CursoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;


/**
 *
 * @author Jesse
 */
public class AlunoCTR {

    AlunoDAO alunoDAO = new AlunoDAO();
    

    /**
     * Método construtor da classe
     */
    public AlunoCTR() {
    }

    /**
     * Método utilizado para controlar o acesso ao método inserirAluno da classe
     * AlunoAO
     *
     * @param alunoDTO, que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String inserirAluno(AlunoDTO alunoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (alunoDAO.inserirAluno(alunoDTO)) {
                return "Aluno Cadastrado com Sucesso!!!";
            } else {
                return "Aluno NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Aluno NÃO Cadastrado";
        }
    }//Fecha o método inserirAluno

    /**
     * Método utilizado para controlar o acesso ao método alterarAluno da classe
     * AlunoDAO
     *
     * @param alunoDTO, que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String alterarAluno(AlunoDTO alunoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (alunoDAO.alterarAluno(alunoDTO)) {
                return "Aluno Alterado com Sucesso!!!";
            } else {
                return "Aluno NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Aluno NÃO Alterado!!!";
        }
    }//Fecha o método alterarAluno

    /**
     * Método utilizado para controlar o acesso ao método excluirAluno da classe
     * AlunoDAO
     *
     * @param alunoDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirAluno(AlunoDTO alunoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (alunoDAO.excluirAluno(alunoDTO)) {
                return "Aluno Excluído com Sucesso!!!";
            } else {
                return "Aluno NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Aluno NÃO Excluído!!!";
        }
    }//Fecha o método excluirAluno

    /**
     * Método utilizado para controlar o acesso ao método consultarAluno da
     * classe AlunoDAO
     *
     * @param alunoDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do aluno
     */
    public ResultSet consultarAluno(AlunoDTO alunoDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = alunoDAO.consultarAluno(alunoDTO, opcao);
        return rs;
    }//Fecha o método consultarAluno
    
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB


  


}//Fecha classe AlunoCTR
