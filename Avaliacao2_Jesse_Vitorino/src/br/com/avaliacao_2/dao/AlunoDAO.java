package br.com.avaliacao_2.dao;

import static br.com.avaliacao_2.dao.ConexaoDAO.con;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import br.com.avaliacao_2.dto.AlunoDTO;
import java.sql.SQLException;
import java.util.List;

public class AlunoDAO {

    private ResultSet rs = null;
    private Statement stmt = null;
    SimpleDateFormat data_format = new SimpleDateFormat("dd/MM/yyyy");

    public AlunoDAO() {

    }

    public boolean inserirAluno(AlunoDTO alunoDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO aluno (id, nome_al, email_al, data_al, tel_al) VALUES ("
                    + "nextval('serial_id'), "
                    + "'" + alunoDTO.getNome_al() + "', "
                    + "'" + alunoDTO.getEmail_al() + "', "
                    + "to_date('" + data_format.format(alunoDTO.getData_al()) + "','dd/MM/yyyy'), "
                    + "'" + alunoDTO.getTel_al() + "')";

            stmt.execute(comando.toUpperCase());
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

    public boolean alterarAluno(AlunoDTO alunoDTO) {
    try {
        ConexaoDAO.ConectDB();
        stmt = ConexaoDAO.con.createStatement();
        
        // Verificar se a data é válida
        if (alunoDTO.getData_al() != null) {
            String dataFormatada = data_format.format(alunoDTO.getData_al());
            
            // Verificar se a data formatada não está vazia
            if (dataFormatada != null && !dataFormatada.isEmpty()) {
                String comando = "UPDATE aluno SET "
                        + "nome_al = '" + alunoDTO.getNome_al() + "', "
                        + "email_al = '" + alunoDTO.getEmail_al() + "', "
                        + "data_al = to_date('" + dataFormatada + "','dd/MM/yyyy'), "
                        + "tel_al = '" + alunoDTO.getTel_al() + "' "
                        + "WHERE id = " + alunoDTO.getId();

                stmt.executeUpdate(comando.toUpperCase());
                ConexaoDAO.con.commit();
                stmt.close();
                return true;
            }
        }
        
        return false;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return false;
    } finally {
        ConexaoDAO.CloseDB();
    }
}


    public boolean excluirAluno(AlunoDTO alunoDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "DELETE FROM aluno WHERE id = "
                    + alunoDTO.getId();

            stmt.execute(comando);
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

    public ResultSet consultarAluno(AlunoDTO alunoDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "SELECT id, nome_al, email_al, tel_al, data_al "
                            + "FROM aluno "
                            + "WHERE nome_al ILIKE '" + alunoDTO.getNome_al() + "%' "
                            + "ORDER BY nome_al";
                    break;
                case 2:
                    comando = "SELECT nome_al, email_al, tel_al, data_al "
                            + "FROM aluno "
                            + "WHERE id = " + alunoDTO.getId();
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public List<AlunoDTO> listarAlunos() {
        List<AlunoDTO> alunos = new ArrayList<>();

        try {
            ConexaoDAO.ConectDB();
            String query = "SELECT * FROM aluno";

            stmt = ConexaoDAO.con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                AlunoDTO aluno = new AlunoDTO();
                aluno.setId(rs.getInt("id"));
                aluno.setNome_al(rs.getString("nome_al"));
                aluno.setEmail_al(rs.getString("email_al"));
                aluno.setTel_al(rs.getString("tel_al"));
                aluno.setData_al(rs.getDate("data_al"));

                alunos.add(aluno);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConexaoDAO.CloseDB();
        }

        return alunos;
    }

}
