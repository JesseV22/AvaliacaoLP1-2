/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_2.dao;

import br.com.avaliacao_2.dto.CursoDTO;
import br.com.avaliacao_2.dao.CursoDAO;
import br.com.avaliacao_2.dto.AlunoDTO;
import br.com.avaliacao_2.dao.ConexaoDAO;
import br.com.avaliacao_2.dto.ProfessorDTO;
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
public class CursoDAO {

    /**
     * Método construtor da classe
     */
    public CursoDAO() {

    }

    // Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    // Manipular o banco de dados
    private Statement stmt = null;

    /**
     * Método utilizado para inserir um objeto cursoDTO no banco de dados
     *
     * @param cursoDTO, que vem da classe CursoCTR
     * @return Um boolean
     */
    public boolean inserirCurso(CursoDTO cursoDTO) {
        try {
            // Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            // Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            // Comando SQL que sera executado no banco de dados
            String comando = "Insert into curso (nome_cur, descricao_cur, id) values ( "
                    + "'" + cursoDTO.getNome_cur() + "', "
                    + "'" + cursoDTO.getDescri_cur() + "', "
                    + "nextval('serial_id')) ";

            // Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            // Da um commit no banco de dados
            ConexaoDAO.con.commit();
            // Fecha o statement
            stmt.close();
            return true;
        } catch (Exception e) {
            // Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
            System.out.println(e.getMessage());
            return false;
        } finally {
            // Independente de dar erro ou não ele vai fechar o banco de dados.
            // Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }

    public boolean alterarCurso(CursoDTO cursoDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "UPDATE curso SET nome_cur = '" + cursoDTO.getNome_cur() + "', "
                    + "descri_cur = '" + cursoDTO.getDescri_cur() + "' "
                    + "WHERE id = " + cursoDTO.getId();
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

    public boolean excluirCurso(int id) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "DELETE FROM curso WHERE id = " + id;
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

    public CursoDTO consultarCurso(CursoDTO cursoDTO, int id) {
        CursoDTO curso = null;
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT * FROM curso WHERE id = " + id;
            rs = stmt.executeQuery(comando.toUpperCase());
            // Verifica se a consulta retornou algum resultado
            if (rs.next()) {
                // Cria um novo objeto CursoDTO com os dados retornados na consulta
                curso = new CursoDTO();
                curso.setId(rs.getInt("id"));
                curso.setNome_cur(rs.getString("nome_cur"));
                curso.setDescri_cur(rs.getString("descri_cur"));
            }

            // Fecha o ResultSet e o Statement
            rs.close();
            stmt.close();
            return curso;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            ConexaoDAO.CloseDB();
        }

    }

    public List<AlunoDTO> obterAlunosDoCurso(int idCurso) {
    List<AlunoDTO> listaAlunos = new ArrayList<>();
    try {
        // Estabelecer a conexão com o banco de dados (assumindo que já existe uma classe de conexão)

        // Criar a consulta SQL para obter os alunos do curso
        String consulta = "SELECT * FROM aluno WHERE curso_id = ?";

        // Preparar a declaração SQL
        PreparedStatement stmt = ConexaoDAO.con.prepareStatement(consulta);
        stmt.setInt(1, idCurso);

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

    public List<ProfessorDTO> obterProfessoresDoCurso(int idCurso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<CursoDTO> listarCursos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
