package br.com.avaliacao_2.dao;

import br.com.avaliacao_2.dto.CursoDTO;
import br.com.avaliacao_2.dao.CursoDAO;
import br.com.avaliacao_2.dto.CursoDTO;
import br.com.avaliacao_2.dao.ConexaoDAO;
import static br.com.avaliacao_2.dao.ConexaoDAO.con;
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
            String comando = "INSERT INTO curso (nome_cur, descri_cur, id , carga_cur) VALUES ( "
                    + "nextval('serial_id') ,"
                    + "'" + cursoDTO.getNome_cur() + "', "
                    + "'" + cursoDTO.getDescri_cur() + "', "
                    + "'" + cursoDTO.getCarga_cur() + "')";

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
            String comando = "UPDATE curso SET nome_cur = '"
                    + cursoDTO.getNome_cur() + "', "
                    + "descri_cur = '" + cursoDTO.getDescri_cur() + "', "
                    + "carga_cur = '" + cursoDTO.getCarga_cur() + "' "
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

    public ResultSet consultarCurso(CursoDTO cursoDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "SELECT id, nome_cur, descri_cur, carga_cur FROM curso WHERE nome_cur ILIKE '" + cursoDTO.getNome_cur() + "%' ORDER BY nome_cur";
                    break;
                case 2:
                    comando = "SELECT nome_cur, descri_cur, carga_cur FROM curso WHERE id = " + cursoDTO.getId();
                    break;
            }
            rs = stmt.executeQuery(comando);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<CursoDTO> listarCursos() {
        List<CursoDTO> cursos = new ArrayList<>();
        CursoDAO cursoDAO = new CursoDAO();

        try {
            String query = "SELECT * FROM cursoview_curso";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                CursoDTO curso = new CursoDTO();
                curso.setId(rs.getInt("id"));
                curso.setNome_cur(rs.getString("nome_cur"));
                curso.setDescri_cur(rs.getString("descri_cur"));
                curso.setCarga_cur(rs.getString("carga_cur"));

                // Adicionar curso à lista de cursos
                cursos.add(curso);
            }

            rs.close();
            stmt.close();

        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (SQLException e) {
            System.out.println(e.getMessage());

        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
        return cursos;
    }

}
