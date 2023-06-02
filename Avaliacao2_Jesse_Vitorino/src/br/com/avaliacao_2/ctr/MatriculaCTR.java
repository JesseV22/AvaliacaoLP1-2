/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_2.ctr;

import java.sql.ResultSet;
import br.com.avaliacao_2.dto.MatriculaDTO;
import br.com.avaliacao_2.dao.MatriculaDAO;
import br.com.avaliacao_2.dao.ConexaoDAO;
import br.com.avaliacao_2.dto.AlunoDTO;
import br.com.avaliacao_2.dao.AlunoDAO;
import br.com.avaliacao_2.dao.CursoDAO;
import br.com.avaliacao_2.dto.CursoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Jesse
 */
public class MatriculaCTR {

    MatriculaDAO matriculaDAO = new MatriculaDAO();
    AlunoDAO alunoDAO = new AlunoDAO();
    CursoDAO professorDAO = new CursoDAO();

    

    /**
     * Método construtor da classe
     */
    public MatriculaCTR() {
    }

    /**
     * Método utilizado para controlar o acesso ao método inserirMatricula da
     * classe MatriculaAO
     *
     * @param matriculaDTO, que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String inserirMatricula(MatriculaDTO matriculaDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (matriculaDAO.inserirMatricula(matriculaDTO)) {
                return "Matricula Cadastrado com Sucesso!!!";
            } else {
                return "Matricula NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Matricula NÃO Cadastrado";
        }
    }//Fecha o método inserirMatricula

    /**
     * Método utilizado para controlar o acesso ao método alterarMatricula da
     * classe MatriculaDAO
     *
     * @param matriculaDTO, que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String alterarMatricula(MatriculaDTO matriculaDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (matriculaDAO.alterarMatricula(matriculaDTO)) {
                return "Matricula Alterado com Sucesso!!!";
            } else {
                return "Matricula NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Matricula NÃO Alterado!!!";
        }
    }//Fecha o método alterarMatricula

    /**
     * Método utilizado para controlar o acesso ao método excluirMatricula da
     * classe MatriculaDAO
     *
     * @param matriculaDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirMatricula(MatriculaDTO matriculaDTO) {
        try {
            // Obtém o ID da matricula do objeto MatriculaDTO
            int id = matriculaDTO.getId();

            // Chama o método da classe DAO para excluir a matricula
            if (matriculaDAO.excluirMatricula(id)) {
                return "Matricula Excluído com Sucesso!!!";
            } else {
                return "Matricula NÃO Excluído!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Matricula NÃO Excluído!!!";
        }
    }

    /**
     * Método utilizado para controlar o acesso ao método consultarMatricula da
     * classe MatriculaDAO
     *
     * @param matriculaDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do matricula
     */
    public ResultSet consultarMatricula(MatriculaDTO matriculaDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = (ResultSet) matriculaDAO.consultarMatricula(matriculaDTO, opcao);
        return rs;
    }

//Fecha o método consultarMatricula
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB

     public List<AlunoDTO> listarAlunosDoMatricula(int idMatricula) {
        List<AlunoDTO> listaAlunos = new ArrayList<>();

        try {
            // Chamar o método da classe DAO para obter os alunos do curso
            List<AlunoDTO> alunosDoCurso = matriculaDAO.obterAlunosDoMatricula(idMatricula);

            // Adicionar os alunos à lista de retorno
            listaAlunos.addAll(alunosDoCurso);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaAlunos;
    }//Fecha o método lista

    public List<CursoDTO> listarCursoesDaMatricula(int idMatricula) {
        List<CursoDTO> listaCursoes = new ArrayList<>();

        try {
            // Chamar o método da classe DAO para obter os professores do curso
            List<CursoDTO> professoresDoCurso = matriculaDAO.obterCursosDaMatricula(idMatricula);

            // Adicionar os professores à lista de retorno
            listaCursoes.addAll(professoresDoCurso);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaCursoes;
    }

    public void carregarAlunosNoComboBox(JComboBox<String> comboBox) {
        List<AlunoDTO> lista = alunoDAO.listarAlunos();

        comboBox.removeAllItems();// Usar removeAllItems() em vez de removeAll()

        for (AlunoDTO aluno : lista) {
            comboBox.addItem(aluno.getNome_al());
        }

    }

    public void carregarCursoesNoComboBox(JComboBox<String> comboBox) {
        List<CursoDTO> lista = professorDAO.listarCursos();

        comboBox.removeAllItems();

        for (CursoDTO professor : lista) {
            comboBox.addItem(professor.getNome_cur());
        }
    }
}//Fecha classe MatriculaCTR
