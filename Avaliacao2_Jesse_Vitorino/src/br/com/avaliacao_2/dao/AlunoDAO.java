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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
            String comando = "INSERT INTO aluno (id, nome_al, email_al, data_al, tel_al) VALUES ("
                    + "nextval('serial_id'), "
                    + "'" + alunoDTO.getNome_al() + "', "
                    + "'" + alunoDTO.getEmail_al() + "', "
                    + "'" + alunoDTO.getData_al() + "', "
                    + "'" + alunoDTO.getTel_al() + "')";

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
                    + "data_al = '" + alunoDTO.getData_al() + "', " // Verifique se há uma vírgula após essa linha
                    + "tel_al = '" + alunoDTO.getTel_al() + "' " // Remova a vírgula após essa linha
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
            String comando = "DELETE FROM aluno WHERE aluno = ";
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

    public ResultSet consultarAluno(AlunoDTO alunoDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "SELECT a.id, a.nome_al, a.email_al,data_al, a.tel_al "
                            + "FROM aluno a "
                            + "WHERE a.nome_al ILIKE '" + alunoDTO.getNome_al() + "%' "
                            + "ORDER BY a.nome_al";
                    break;
                case 2:
                    comando = "SELECT a.nome_al, a.email_al,data_al, a.tel_al "
                            + "FROM aluno a "
                            + "WHERE a.id = " + alunoDTO.getId();

                    break;
            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarFornecedor

    
    //metodo listar jcombobox
    public List<AlunoDTO> listarAlunos() {
        List<AlunoDTO> alunos = new ArrayList<>();
        AlunoDAO alunoDAO = new AlunoDAO();

        try {
            ConexaoDAO.ConectDB();
            String query = "SELECT * from aluno";

            Statement stmt = ConexaoDAO.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                AlunoDTO aluno = new AlunoDTO();
                aluno.setId(rs.getInt("id"));
                aluno.setNome_al(rs.getString("nome_al"));
                aluno.setEmail_al(rs.getString("email_al"));
                aluno.setData_al(rs.getDate("data_al"));
                aluno.setTel_al(rs.getString("tel_al"));
                

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
