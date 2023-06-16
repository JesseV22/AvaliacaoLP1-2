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
    
    // Método para realizar a ligação entre os alunos do matriculaVIEW e do AlunoVIEW
    public void realizarLigacaoAlunos() {
        try {
            // Consulta para obter a lista de alunos do matriculaVIEW
            String matriculaviewQuery = "SELECT * FROM matriculaview_alunos";
            PreparedStatement matriculaviewStatement = con.prepareStatement(matriculaviewQuery);
            ResultSet matriculaviewResult = matriculaviewStatement.executeQuery();

            // Consulta para obter os alunos cadastrados no banco do AlunoVIEW
            String alunoviewQuery = "SELECT * FROM alunoview_alunos WHERE numero_identificacao = ?";
            PreparedStatement alunoviewStatement = con.prepareStatement(alunoviewQuery);

            while (matriculaviewResult.next()) {
                int numeroIdentificacao = matriculaviewResult.getInt("numero_identificacao");

                // Realiza a ligação utilizando o número de identificação do aluno
                alunoviewStatement.setInt(1, numeroIdentificacao);
                ResultSet alunoviewResult = alunoviewStatement.executeQuery();

                // Exibe os resultados da ligação
                while (alunoviewResult.next()) {
                    int alunoMatriculaViewId = matriculaviewResult.getInt("id");
                    String alunoMatriculaViewNome = matriculaviewResult.getString("nome");

                    int alunoAlunoViewId = alunoviewResult.getInt("id");
                    String alunoAlunoViewNome = alunoviewResult.getString("nome");

                    System.out.println("Aluno do matriculaVIEW: " + alunoMatriculaViewId + " - " + alunoMatriculaViewNome);
                    System.out.println("Aluno do AlunoVIEW: " + alunoAlunoViewId + " - " + alunoAlunoViewNome);
                    System.out.println("---------------------------------------");
                }

                alunoviewResult.close();
            }

            matriculaviewResult.close();
            alunoviewStatement.close();
            matriculaviewStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para realizar a ligação entre os cursos do matriculaVIEW e do CursoVIEW
    public void realizarLigacaoCursos() {
        try {
            // Consulta para obter a lista de cursos do matriculaVIEW
            String matriculaviewQuery = "SELECT * FROM matriculaview_cursos";
            PreparedStatement matriculaviewStatement = con.prepareStatement(matriculaviewQuery);
            ResultSet matriculaviewResult = matriculaviewStatement.executeQuery();

            // Consulta para obter os cursos cadastrados no banco do CursoVIEW
            String cursoviewQuery = "SELECT * FROM cursoview_cursos WHERE numero_identificacao = ?";
            PreparedStatement cursoviewStatement = con.prepareStatement(cursoviewQuery);

            while (matriculaviewResult.next()) {
                int numeroIdentificacao = matriculaviewResult.getInt("numero_identificacao");

                // Realiza a ligação utilizando o número de identificação do curso
                cursoviewStatement.setInt(1, numeroIdentificacao);
                ResultSet cursoviewResult = cursoviewStatement.executeQuery();

                // Exibe os resultados da ligação
                while (cursoviewResult.next()) {
                    int cursoMatriculaViewId = matriculaviewResult.getInt("id");
                    String cursoMatriculaViewNome = matriculaviewResult.getString("nome");

                    int cursoCursoViewId = cursoviewResult.getInt("id");
                    String cursoCursoViewNome = cursoviewResult.getString("nome");

                    System.out.println("Curso do matriculaVIEW: " + cursoMatriculaViewId + " - " + cursoMatriculaViewNome);
                    System.out.println("Curso do CursoVIEW: " + cursoCursoViewId + " - " + cursoCursoViewNome);
                    System.out.println("---------------------------------------");
                }

                cursoviewResult.close();
            }

            matriculaviewResult.close();
            cursoviewStatement.close();
            matriculaviewStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
