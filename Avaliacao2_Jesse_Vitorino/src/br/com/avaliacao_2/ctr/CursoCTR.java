/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_2.ctr;

import java.sql.ResultSet;
import br.com.avaliacao_2.dto.CursoDTO;
import br.com.avaliacao_2.dao.CursoDAO;
import br.com.avaliacao_2.dao.ConexaoDAO;
import br.com.avaliacao_2.dto.AlunoDTO;
import br.com.avaliacao_2.dao.AlunoDAO;
import br.com.avaliacao_2.dto.ProfessorDTO;
import br.com.avaliacao_2.dao.ProfessorDAO;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author Jesse
 */
public class CursoCTR {

    CursoDAO cursoDAO = new CursoDAO();
    AlunoDAO alunoDAO = new AlunoDAO();
    ProfessorDAO professorDAO = new ProfessorDAO();

    /**
     * Método construtor da classe
     */
    public CursoCTR() {
    }

    /**
     * Método utilizado para controlar o acesso ao método inserirCurso da classe
     * CursoAO
     *
     * @param cursoDTO, que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String inserirCurso(CursoDTO cursoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (cursoDAO.inserirCurso(cursoDTO)) {
                return "Curso Cadastrado com Sucesso!!!";
            } else {
                return "Curso NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Curso NÃO Cadastrado";
        }
    }//Fecha o método inserirCurso

    /**
     * Método utilizado para controlar o acesso ao método alterarCurso da classe
     * CursoDAO
     *
     * @param cursoDTO, que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String alterarCurso(CursoDTO cursoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (cursoDAO.alterarCurso(cursoDTO)) {
                return "Curso Alterado com Sucesso!!!";
            } else {
                return "Curso NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Curso NÃO Alterado!!!";
        }
    }//Fecha o método alterarCurso

    /**
     * Método utilizado para controlar o acesso ao método excluirCurso da classe
     * CursoDAO
     *
     * @param cursoDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirCurso(CursoDTO cursoDTO) {
        try {
            // Obtém o ID do curso do objeto CursoDTO
            int id = cursoDTO.getId();

            // Chama o método da classe DAO para excluir o curso
            if (cursoDAO.excluirCurso(id)) {
                return "Curso Excluído com Sucesso!!!";
            } else {
                return "Curso NÃO Excluído!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Curso NÃO Excluído!!!";
        }
    }

    /**
     * Método utilizado para controlar o acesso ao método consultarCurso da
     * classe CursoDAO
     *
     * @param cursoDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do curso
     */
    public ResultSet consultarCurso(CursoDTO cursoDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = (ResultSet) cursoDAO.consultarCurso(cursoDTO, opcao);
        return rs;
    }

//Fecha o método consultarCurso
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB

    public List<AlunoDTO> listarAlunosDoCurso(int idCurso) {
        List<AlunoDTO> listaAlunos = new ArrayList<>();

        try {
            // Chamar o método da classe DAO para obter os alunos do curso
            List<AlunoDTO> alunosDoCurso = cursoDAO.obterAlunosDoCurso(idCurso);

            // Adicionar os alunos à lista de retorno
            listaAlunos.addAll(alunosDoCurso);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaAlunos;
    }//Fecha o método lista

    public List<ProfessorDTO> listarProfessoresDoCurso(int idCurso) {
        List<ProfessorDTO> listaProfessores = new ArrayList<>();

        try {
            // Chamar o método da classe DAO para obter os professores do curso
            List<ProfessorDTO> professoresDoCurso = cursoDAO.obterProfessoresDoCurso(idCurso);

            // Adicionar os professores à lista de retorno
            listaProfessores.addAll(professoresDoCurso);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaProfessores;
    }

    public void carregarAlunosNoComboBox(JComboBox<String> comboBox) {
        List<AlunoDTO> lista = alunoDAO.listarAlunos();

        comboBox.removeAllItems();// Usar removeAllItems() em vez de removeAll()

        for (AlunoDTO aluno : lista) {
            comboBox.addItem(aluno.getNome_al());
        }

    }

    public void carregarProfessoresNoComboBox(JComboBox<String> comboBox) {
        List<ProfessorDTO> lista = professorDAO.listarProfessores();

        comboBox.removeAllItems();

        for (ProfessorDTO professor : lista) {
            comboBox.addItem(professor.getNome());
        }
    }

}//Fecha classe CursoCTR
