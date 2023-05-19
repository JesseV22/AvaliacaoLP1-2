package br.com.avaliacao_2.dao;

import java.sql.*;

public class ConexaoDAO {
    public static Connection con = null;

    public ConexaoDAO() {
    }

    public static void ConectDB() {
        try {
            // Dados para conectar com o banco de dados Postgres
            String dsn = "avaliacao_2"; // nome do banco de dados (igual ao criado no Postgres)
            String user = "postgres"; // nome do usuário utilizado para se conectar
            String senha = "postdba"; // senha do usuário acima informado

            DriverManager.registerDriver(new org.postgresql.Driver());

            String url = "jdbc:postgresql://localhost:5432/" + dsn;

            con = DriverManager.getConnection(url, user, senha);

            con.setAutoCommit(false);
            if (con == null) {
                System.out.println("erro ao abrir o banco");
            }
        } catch (SQLException e) {
            System.out.println("Problema ao abrir a base de dados! " + e.getMessage());
        }
    }

    public static void CloseDB() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Problema ao fechar a base de dados! " + e.getMessage());
        }
    }
    
    // Método para realizar a ligação entre os alunos do cursoVIEW e do AlunoVIEW
    public void realizarLigacaoAlunos() {
        try {
            // Consulta para obter a lista de alunos do cursoVIEW
            String cursoviewQuery = "SELECT * FROM cursoview_alunos";
            PreparedStatement cursoviewStatement = con.prepareStatement(cursoviewQuery);
            ResultSet cursoviewResult = cursoviewStatement.executeQuery();

            // Consulta para obter os alunos cadastrados no banco do AlunoVIEW
            String alunoviewQuery = "SELECT * FROM alunoview_alunos WHERE numero_identificacao = ?";
            PreparedStatement alunoviewStatement = con.prepareStatement(alunoviewQuery);

            while (cursoviewResult.next()) {
                int numeroIdentificacao = cursoviewResult.getInt("numero_identificacao");

                // Realiza a ligação utilizando o número de identificação do aluno
                alunoviewStatement.setInt(1, numeroIdentificacao);
                ResultSet alunoviewResult = alunoviewStatement.executeQuery();

                // Exibe os resultados da ligação
                while (alunoviewResult.next()) {
                    int alunoCursoViewId = cursoviewResult.getInt("id");
                    String alunoCursoViewNome = cursoviewResult.getString("nome");

                    int alunoAlunoViewId = alunoviewResult.getInt("id");
                    String alunoAlunoViewNome = alunoviewResult.getString("nome");

                    System.out.println("Aluno do cursoVIEW: " + alunoCursoViewId + " - " + alunoCursoViewNome);
                    System.out.println("Aluno do AlunoVIEW: " + alunoAlunoViewId + " - " + alunoAlunoViewNome);
                    System.out.println("---------------------------------------");
                }

                alunoviewResult.close();
            }

            cursoviewResult.close();
            alunoviewStatement.close();
            cursoviewStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
