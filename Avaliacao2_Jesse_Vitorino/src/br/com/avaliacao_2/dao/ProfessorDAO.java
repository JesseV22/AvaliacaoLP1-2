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
import java.util.ArrayList;
import java.util.List;
import br.com.avaliacao_2.dao.ProfessorDAO;

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
     * @param professorDTO, que vem da classe ProfessorCTRINSERT
     * @return Um boolean
     */
    public boolean inserirProfessor(ProfessorDTO professorDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO professor (id, nome_prof, email_prof, especialidade, end_prof, tel_prof) VALUES ( "
                    + "nextval('serial_id'), "
                    + "'" + professorDTO.getNome() + "', "
                    + "'" + professorDTO.getEmail() + "', "
                    + "'" + professorDTO.getEspecialidade() + "', "
                    + "'" + professorDTO.getEnd_prof() + "', "
                    + "'" + professorDTO.getTel_prof() + "') ";

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
            //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
            //console com o que esta acontecendo.
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {//Independente de dar erro ou não ele vai fechar o banco de dados.
            ConexaoDAO.CloseDB();
        }
    }//Fecha metodo inserir professor

public boolean alterarProfessor(ProfessorDTO professorDTO) {
    try {
        ConexaoDAO.ConectDB();
        stmt = ConexaoDAO.con.createStatement();
        String comando = "UPDATE professor SET "
                + "nome_prof = '" + professorDTO.getNome() + "', "
                + "email_prof = '" + professorDTO.getEmail() + "', "
                + "especialidade = '" + professorDTO.getEspecialidade() + "', "
                + "end_prof = '" + professorDTO.getEnd_prof() + "', "
                + "tel_prof = '" + professorDTO.getTel_prof() + "' "
                + "WHERE id = " + professorDTO.getId();
        stmt.executeUpdate(comando.toUpperCase());
        ConexaoDAO.con.commit();
        stmt.close();
        return true;
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return false;
    } finally {
        ConexaoDAO.CloseDB();
    }
        
    }//Fecha metodo alterar professor

    
    /**
     * Método utilizado para excluir um
     *
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

    public ResultSet consultarProfessor(ProfessorDTO professorDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "SELECT id, nome_prof, email_prof, especialidade, tel_prof, end_prof FROM professor WHERE nome_prof ILIKE '" + professorDTO.getNome()+ "%' ORDER BY nome_prof";
                    break;
                case 2:
                    comando = "SELECT nome_prof, email_prof, especialidade, tel_prof, end_prof FROM professor WHERE id = " + professorDTO.getId();
                    break;
            }
            rs = stmt.executeQuery(comando);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }//fecha metodo consultar professor

    public List<ProfessorDTO> listarProfessores() {
        List<ProfessorDTO> professores = new ArrayList<>();
        ProfessorDAO professorDAO = new ProfessorDAO();

        try {
            ConexaoDAO.ConectDB();
            String query = "SELECT * FROM professor";

            Statement stmt = ConexaoDAO.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                ProfessorDTO professor = new ProfessorDTO();
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome_prof"));
                professor.setEmail(rs.getString("email_prof"));
                professor.setEspecialidade(rs.getString("especialidade"));

                // Adicionar professor à lista de professores
                professores.add(professor);
            }

            rs.close();
            stmt.close();
            //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
            //console com o que esta acontecendo.

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally { //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }

        return professores;
    }

}
