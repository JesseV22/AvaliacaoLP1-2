/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_2.dao;

import br.com.avaliacao_2.dto.AlunoDTO;
import br.com.avaliacao_2.dto.CursoDTO;
import br.com.avaliacao_2.dto.MatriculaDTO;
import br.com.avaliacao_2.dto.ProfessorDTO;
import java.sql.Date;
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
public class MatriculaDAO {

    /**
     * Método construtor da classe
     */
    public MatriculaDAO() {

    }
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;

    /**
     * Método utilizado para inserir um objeto matriculaDTO no banco de dados
     *
     * @param matriculaDTO, que vem da classe MatriculaCTR
     * @return Um boolean
     */
    public boolean inserirMatricula(MatriculaDTO matriculaDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "INSERT INTO matricula (aluno_id, curso_id, data_mat) "
                    + "VALUES (" + matriculaDTO.getAluno_mar() + ", " + matriculaDTO.getAluno_mar() + ", "
                    + "'" + matriculaDTO.getData_mar() + "')";

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha metodo inserir matricula

    /**
     * Método utilizado para alterar um objeto matriculaDTO no banco de dados
     *
     * @param matriculaDTO, que vem da classe MatriculaCTR
     * @return Um boolean
     */
    public boolean alterarMatricula(MatriculaDTO matriculaDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "UPDATE matricula SET aluno_id = " + matriculaDTO.getAluno_mar() + ", "
                    + "curso_id = " + matriculaDTO.getCurso_mar() + ", "
                    + "data_mat = '" + matriculaDTO.getData_mar() + "' "
                    + "WHERE id_mat = " + matriculaDTO.getId();
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
    }//Fecha metodo alterar matricula

    /**
     * Método utilizado para excluir um
     *
     * @param id
     * @return
     */
    public boolean excluirMatricula(int id) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "DELETE FROM matricula WHERE id_mat = " + id;
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

    public MatriculaDTO consultarMatricula(MatriculaDTO matriculaDTO, int id) {
        MatriculaDTO matricula = null;
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT * FROM matricula WHERE id = " + id;
            rs = stmt.executeQuery(comando.toUpperCase());
            if (rs.next()) {
                matricula = new MatriculaDTO();
                matricula.setId(rs.getInt("id"));
                matricula.setAluno_mar(String.valueOf(rs.getInt("aluno_mar")));
                matricula.setCurso_mar(String.valueOf(rs.getInt("curso_mar")));
                matricula.setData_mar(rs.getDate("data_mar"));
            }
            rs.close();
            stmt.close();
            return matricula;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }//fecha metodo consultar aluno

    public List<AlunoDTO> obterAlunosDoMatricula(int idMatricula) {
        List<AlunoDTO> listaAlunos = new ArrayList<>();
        try {
            // Estabelecer a conexão com o banco de dados (assumindo que já existe uma classe de conexão)

            // Criar a consulta SQL para obter os alunos do curso
            String consulta = "SELECT * FROM aluno WHERE matricula_id = ?";

            // Preparar a declaração SQL
            PreparedStatement stmt = ConexaoDAO.con.prepareStatement(consulta);
            stmt.setInt(1, idMatricula);

            // Executar a consulta e obter o resultado
            ResultSet rs = stmt.executeQuery();

            // Percorrer o resultado e criar objetos AlunoDTO
            while (rs.next()) {
                AlunoDTO aluno = new AlunoDTO();
                aluno.setId(rs.getInt("id"));
                aluno.setNome_al(rs.getString("nome"));
                // Preencher outros atributos do aluno, se necessário

                // Adicionar o aluno à lista de alunos
                listaAlunos.add(aluno);
            }

            // Fechar o ResultSet, o PreparedStatement e a conexão
            rs.close();
            stmt.close();
            // Fechar a conexão com o banco de dados

        } catch (SQLException e) {
            System.out.println("Erro ao obter os alunos do curso: " + e.getMessage());
        }
        return listaAlunos;
    }

    public List<ProfessorDTO> obterProfessoresDoCurso(int idMatricula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<CursoDTO> listarCursos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
