/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_2.dao;

import static br.com.avaliacao_2.dao.ConexaoDAO.con;
import br.com.avaliacao_2.dto.AlunoDTO;
import br.com.avaliacao_2.dto.CursoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesse
 */
public class AlunoDAO {

    /**
     * Método construtor da classe
     */
    public AlunoDAO() {

    }
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;

    /**
     * Método utilizado para inserir um objeto alunoDTO no banco de dados
     *
     * @param alunoDTO, que vem da classe AlunoCTR
     * @return Um boolean
     */
    /**
     * Método utilizado para inserir um objeto alunoDTO no banco de dados
     *
     * @param alunoDTO, que vem da classe AlunoCTR
     * @return Um boolean
     */
    public boolean inserirAluno(AlunoDTO alunoDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO aluno (id, nome_al, email_al, data_al,tel_al) VALUES ("
                    + "nextval('serial_id'), "
                    + "'" + alunoDTO.getNome_al() + "', "
                    + "'" + alunoDTO.getEmail_al() + "', "
                    + "'" + alunoDTO.getTel_al() + "', "
                    + "'" + alunoDTO.getData_al() + "')";

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
            //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
            //console com o que esta acontecendo.
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
            //Independente de dar erro ou não ele vai fechar o banco de dados.
        } finally {
            ConexaoDAO.CloseDB();
        }

    }//Fecha metodo inserir aluno

    public boolean alterarAluno(AlunoDTO alunoDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "UPDATE aluno SET nome_al = '" + alunoDTO.getNome_al() + "', "
                    + "email_al = '" + alunoDTO.getEmail_al() + "', "
                    + "data_al = '" + alunoDTO.getData_al() + "' "
                    + "tel_al = '" + alunoDTO.getTel_al() + "' "
                    + "WHERE id = " + alunoDTO.getId();
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
    }
//Fecha metodo alterar aluno

    public boolean excluirAluno(int id) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "DELETE FROM aluno WHERE id_al = " + id;
            stmt.executeUpdate(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }//Fecha metodo excluir aluno

    }

    public AlunoDTO consultarAluno(int id) {
        AlunoDTO aluno = null;
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT * FROM aluno WHERE id = " + id;
            rs = stmt.executeQuery(comando.toUpperCase());
            if (rs.next()) {
                aluno = new AlunoDTO();
                aluno.setId(rs.getInt("id"));
                aluno.setNome_al(rs.getString("nome_al"));
                aluno.setEmail_al(rs.getString("email_al"));
                aluno.setTel_al(rs.getString("tel_al"));
                aluno.setData_al(rs.getDate("data_al"));
            }
            rs.close();
            stmt.close();
            return aluno;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
//fecha metodo consultar aluno

    public List<AlunoDTO> listarAlunos() {
        List<AlunoDTO> alunos = new ArrayList<>();
        AlunoDAO alunoDAO = new AlunoDAO();

        try {
            String query = "SELECT * FROM alunoview_aluno";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                AlunoDTO aluno = new AlunoDTO();
                aluno.setId(rs.getInt("id"));
                aluno.setNome_al(rs.getString("nome_al"));
                aluno.setEmail_al(rs.getString("email_al"));
                aluno.setTel_al(rs.getString("tel_al"));
                aluno.setData_al(rs.getDate("data_al"));

                // Adicionar aluno à lista de alunos
                alunos.add(aluno);
            }

            rs.close();
            stmt.close();

        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());

        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
        return alunos;
    }

}//fecha classe aluno dao
