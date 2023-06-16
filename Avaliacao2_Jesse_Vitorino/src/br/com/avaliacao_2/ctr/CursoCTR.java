package br.com.avaliacao_2.ctr;

import java.sql.ResultSet;
import br.com.avaliacao_2.dto.CursoDTO;
import br.com.avaliacao_2.dao.CursoDAO;
import br.com.avaliacao_2.dao.ConexaoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class CursoCTR {

    private CursoDAO cursoDAO = new CursoDAO();

    public CursoCTR() {
    }

    public String inserirCurso(CursoDTO cursoDTO) {
        try {
            if (cursoDAO.inserirCurso(cursoDTO)) {
                return "Curso Cadastrado com Sucesso!!!";
            } else {
                return "Curso NÃO Cadastrado!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Curso NÃO Cadastrado";
        }
    }

    public String alterarCurso(CursoDTO cursoDTO) {
        try {
            if (cursoDAO.alterarCurso(cursoDTO)) {
                return "Curso Alterado com Sucesso!!!";
            } else {
                return "Curso NÃO Alterado!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Curso NÃO Alterado!!!";
        }
    }

    public String excluirCurso(CursoDTO cursoDTO) {
        try {
            if (cursoDAO.excluirCurso(cursoDTO)) {
                return "Curso Excluído com Sucesso!!!";
            } else {
                return "Curso NÃO Excluído!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Curso NÃO Excluído!!!";
        }
    }

    public ResultSet consultarCurso(CursoDTO cursoDTO, int opcao) {
        ResultSet rs = null;
        rs = cursoDAO.consultarCurso(cursoDTO, opcao);
        return rs;
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
