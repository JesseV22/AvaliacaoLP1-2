/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_2.dao;

import br.com.avaliacao_2.dto.ProfessorDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import br.com.avaliacao_2.dto.ProfessorDTO;
import java.sql.SQLException;

/**
 *
 * @author Jesse
 */
public class ProfessorDAO {

    /**
     * Método construtor da classe
     */
    public ProfessorDAO() {

    }
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;

    /**
     * Método utilizado para inserir um objeto professorDTO no banco de dados
     *
     * @param professorDTO, que vem da classe ProfessorCTR
     * @return Um boolean
     */
    public boolean inserirProfessor(ProfessorDTO professorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "INSERT INTO professor (id ) "
                    + "VALUES (" + professorDTO.getNome() + ", " + professorDTO.getEmail() + ", "
                    + "'" + professorDTO.getEspecialidade() + "')";

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha metodo inserir professor

    public boolean alterarProfessor(ProfessorDTO pofessorDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "UPDATE pofessor SET aluno_id = " + pofessorDTO.getNome() + ", "
                    + "curso_id = " + pofessorDTO.getEmail() + ", "
                    + "data_mat = '" + pofessorDTO.getEspecialidade() + "' "
                    + "WHERE id_mat = " + pofessorDTO.getId();
            stmt.executeUpdate(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }//Fecha metodo alterar pofessor
        /**
     * Método utilizado para excluir um
     * @param id
     * @return 
     */
    public boolean excluirProfessor(int id) {
    try {
        ConexaoDAO.ConectDB();
        stmt = ConexaoDAO.con.createStatement();
        String comando = "DELETE FROM professor WHERE id_mat = " + id;
        stmt.executeUpdate(comando.toUpperCase());
        ConexaoDAO.con.commit();
        stmt.close();
        return true;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return false;
    } finally {
        ConexaoDAO.CloseDB();
    }
}
    public ProfessorDTO consultarProfessor(ProfessorDTO professorDTO, int id) {
    ProfessorDTO professor = null;
    try {
        ConexaoDAO.ConectDB();
        stmt = ConexaoDAO.con.createStatement();
        String comando = "SELECT * FROM professor WHERE id_mar = " + id;
        rs = stmt.executeQuery(comando.toUpperCase());
        if (rs.next()) {
            professor = new ProfessorDTO();
            professor.setId(rs.getInt("id"));
            professor.setNome(String.valueOf(rs.getInt("nome_prof")));
            professor.setEmail(String.valueOf(rs.getInt("email_prof")));
            professor.setEspecialidade(String.valueOf(rs.getInt("especialidade_prof")));
            
        }
        rs.close();
        stmt.close();
        return professor;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return null;
    } finally {
        ConexaoDAO.CloseDB();
    }
}//fecha metodo consultar professor

}
