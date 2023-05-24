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
            String comando = "INSERT INTO aluno (id, nome_al, email_al, curso_id, data_al) VALUES ("
                    + "nextval('serial_id'), "
                    + "'" + alunoDTO.getNome_al() + "', "
                    + "'" + alunoDTO.getEmail_al() + "', "
                    + alunoDTO.getCurso_id() + ", "
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
                    + "curso_id = " + alunoDTO.getCurso_id() + ", "
                    + "data_al = '" + alunoDTO.getData_al() + "' "
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
                aluno.setCurso_id(rs.getInt("curso_id"));
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
            ConexaoDAO.ConectDB();
            String query = "SELECT * from aluno";
            
            Statement stmt =  ConexaoDAO.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                AlunoDTO aluno = new AlunoDTO();
                aluno.setId(rs.getInt("id"));
                aluno.setNome_al(rs.getString("nome_al"));
                aluno.setEmail_al(rs.getString("email_al"));
                aluno.setCurso_id(rs.getInt("curso_id"));
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
    public List<CursoDTO> obterCursosDoAluno(int idAluno) {
    List<CursoDTO> listaCursos = new ArrayList<>();
    try {
        // Estabelecer a conexão com o banco de dados (assumindo que já existe uma classe de conexão)

        // Criar a consulta SQL para obter os cursos do aluno
        String consulta = "SELECT * FROM curso WHERE aluno_id = ?";

        // Preparar a declaração SQL
        PreparedStatement stmt = ConexaoDAO.con.prepareStatement(consulta);
        stmt.setInt(1, idAluno);

        // Executar a consulta e obter o resultado
        ResultSet rs = stmt.executeQuery();

        // Percorrer o resultado e criar objetos CursoDTO
        while (rs.next()) {
            CursoDTO curso = new CursoDTO();
            curso.setId(rs.getInt("id"));
            curso.setNome_cur(rs.getString("nome_cur"));
            curso.setDescri_cur(rs.getString("descri_cur"));
            // Preencher outros atributos do curso, se necessário

            // Adicionar o curso à lista de cursos
            listaCursos.add(curso);
        }

        // Fechar o ResultSet, o PreparedStatement e a conexão
        rs.close();
        stmt.close();
        // Fechar a conexão com o banco de dados

    } catch (SQLException e) {
        System.out.println("Erro ao obter os cursos do aluno: " + e.getMessage());
    }
    return listaCursos;
}

    

    

      

}//fecha classe aluno dao
