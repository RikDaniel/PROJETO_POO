/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;
import model.Funcionario;
/**
 *
 * @author Mayana
 */
public class DaoFuncionario {
    private Connection conexao;
    
    public DaoFuncionario() throws SQLException {
        this.conexao = CriaConexao.fazerConexao();
    }
    
    
    
    
    public void cadastroDeFuncionario( Funcionario funcionario) throws SQLException{
        String sql = "INSERT INTO FUNCIONARIO (CPF, NOME, TELEFONE,GENERO, SALARIO, HORARIO, FUNCAO, SENHA ) VALUES (?,?,?,?,?,?,?,?,?)"; // aqui teremos a query de inserção no banco de dados
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setString(1, funcionario.getCpf());
                psmt.setString(2, funcionario.getNome());
                psmt.setString(3, funcionario.getTelefone());
                psmt.setString(4, funcionario.getGenero());
                psmt.setDouble(5, funcionario.getSalario());
                psmt.setDate(6, funcionario.getHorario());
                psmt.setString(7, funcionario.getFuncao());
                psmt.setString(8, funcionario.getSenha());
                DaoEndereco end = new DaoEndereco();
                end.cadastroDeEndereco (funcionario.getEndereco());
                
                psmt.execute();
            }
        
    }   
   public void removerFuncionario(Funcionario funcionario) throws SQLException{
       String sql = "DELETE FROM FUNCIONARIO WHERE  CPF LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setString(1, funcionario.getCpf());
                psmt.execute();
            }
       
   }
   public void atualizarFuncionario(Funcionario funcionario, String cpf) throws SQLException{
       String sql = " UPDATE FUNCIONARIO SET CPF = ?, NOME = ?, TELEFONE = ?, GENERO = ?, SALARIO = ?, HORARIO = ?, FUNCAO = ?, SENHA = ? WHERE COD LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setString(1, funcionario.getCpf());
                psmt.setString(2, funcionario.getNome());
                psmt.setString(3, funcionario.getTelefone());
                psmt.setString(4, funcionario.getGenero());
                psmt.setDouble(5, funcionario.getSalario());
                psmt.setDate(6, funcionario.getHorario());
                psmt.setString(7, funcionario.getFuncao());
                psmt.setString(8, funcionario.getSenha());
               
               psmt.setString(9, cpf);
               
               psmt.execute();
            } 
   }
   
   public List<Funcionario> selecionarFuncionario(String cpf) throws SQLException{
       List<Funcionario> listaDao = new ArrayList<>();
       
       String sql = "SELECT * FROM FUNCIONARIO WHERE CPF LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setString(1, cpf);
            try (ResultSet rs = psmt.executeQuery()) {
               while(rs.next()){
                   Funcionario listaFuncionario = new Funcionario();
                   
                   listaFuncionario.setCpf(rs.getString("CPF"));
                   listaFuncionario.setNome(rs.getString("NOME"));                   
                   listaFuncionario.setTelefone(rs.getString("TELEFONE"));
                   listaFuncionario.setGenero(rs.getString("GENERO"));
                   listaFuncionario.setSalario(rs.getDouble("SALARIO"));
                   listaFuncionario.setHorario(rs.getDate("HORARIO"));
                   listaFuncionario.setFuncao(rs.getString("FUNCAO"));
                   
                   listaDao.add(listaFuncionario);
               }
           }
            }
       
        
        
       return listaDao;
   }
    
}