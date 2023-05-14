/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_2.dao;
import br.com.avaliacao_2.dto.AlunoDTO;
import java.sql.ResultSet;
import java.sql.Statement;

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
    public boolean inserirAluno(AlunoDTO alunoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into aluno()
    
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into aluno (nome_al,email_al, "
                    + "id_al ,curso_id,data_al) values ( "
                    + "'" + alunoDTO.getNome_al() + "', "
                    + "'" + alunoDTO.getLogradouro_cli()+ "', "
                    + alunoDTO.getNumero_cli()+ ", "
                    + "'" + alunoDTO.getBairro_cli()+ "', "
                    + "'" + alunoDTO.getCidade_cli()+ "', "
                    + "'" + alunoDTO.getEstado_cli()+ "', "
                    + "'" + alunoDTO.getCep_cli()+ "', "
                    + "'" + alunoDTO.getCpf_cli()+ "', "
                    + "'" + alunoDTO.getRg_cli()+ "') ";
            
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método inserirCliente
}
