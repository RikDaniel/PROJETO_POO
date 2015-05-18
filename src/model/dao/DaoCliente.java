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
import model.Cliente;

/**
 *
 * @author Mayana
 */
public class DaoCliente {
    
        private Connection conexao;
    
    public DaoCliente() throws SQLException {
        this.conexao = CriaConexao.fazerConexao();
    }
    
    
            public void cadastroDeCliente( Cliente cliente) throws SQLException{
        String sql = "INSERT INTO CLIENTE (CPF, NOME, TELEFONE, GENERO) VALUES (?,?,?,?)"; // aqui teremos a query de inserção no banco de dados
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setString(2, cliente.getCpf());
                psmt.setString(1, cliente.getNome());                
                psmt.setString(3, cliente.getTelefone());
                psmt.setString(4, cliente.getGenero());
                DaoEndereco end = new DaoEndereco();
                end.cadastroDeEndereco (cliente.getEndereco());
                DaoAnimal a = new DaoAnimal();
                a.cadastroDeAnimal (cliente.getAnimal());
                
                psmt.execute();
            }
        
    }   
   public void removerCliente(Cliente cliente) throws SQLException{
       String sql = "DELETE FROM CLIENTE WHERE  CPF LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setString(1, cliente.getCpf());
                psmt.execute();
            }
       
   }
   public void atualizarCliente(Cliente cliente, int cpf) throws SQLException{
       String sql = " UPDATE CLIENTE SET CPF = ?,NOME = ?, TELEFONE = ?, GENERO = ? WHERE COD LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setString(1, cliente.getCpf());
                psmt.setString(2, cliente.getNome());                
                psmt.setString(3, cliente.getTelefone());
                psmt.setString(4, cliente.getGenero());
               
               psmt.setString(5, cliente.getCpf());
               
               psmt.execute();
            } 
   }
   
   public List<Cliente> selecionarCliente(String cpf) throws SQLException{
       List<Cliente> listaDao = new ArrayList<>();
       
       String sql = "SELECT * FROM CLIENTE WHERE CPF LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setString(1, cpf);
            try (ResultSet rs = psmt.executeQuery()) {
               while(rs.next()){
                   Cliente listaCliente = new Cliente();
                   
                   listaCliente.setCpf(rs.getString("CPF"));
                   listaCliente.setNome(rs.getString("NOME"));                   
                   listaCliente.setTelefone(rs.getString("TELEFONE"));
                   listaCliente.setGenero(rs.getString("GENERO"));
                   listaDao.add(listaCliente);
               }
           }
            }
       
        
        
       return listaDao;
   }
}
