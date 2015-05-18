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

/**
 *
 * @author Mayana
 */
public class DaoEndereco {
        private Connection conexao;
    
    public DaoEndereco() throws SQLException {
        this.conexao = CriaConexao.fazerConexao();
    }
    
    
    
    
    public void cadastroDeEndereco( Endereco endereco) throws SQLException{
        String sql = "INSERT INTO ENDERECO (ID_ENDERECO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, BAIRRO, CIDADE, ESTADO) VALUES (?,?,?,?,?,?,?,?)"; // aqui teremos a query de inserção no banco de dados
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, endereco.getId_endereco());
                psmt.setString(2, endereco.getLogradouro());
                psmt.setInt(3, endereco.getNumero());
                psmt.setString(4, endereco.getComplemento());
                psmt.setString(5, endereco.getCep());
                psmt.setString(6, endereco.getBairro());
                psmt.setString(7, endereco.getCidade());
                psmt.setString(8, endereco.getEstado());
                
                
                
                psmt.execute();
            }
        
    }   
   public void removerEndereco(Endereco endereco) throws SQLException{
       String sql = "DELETE FROM ENDERECO WHERE  ID_ENDERECO LIKE ?,?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(3, endereco.getId_endereco());
                psmt.execute();
            }
       
   }
   public void atualizarEndereco(Endereco endereco, int id_endereco) throws SQLException{
       String sql = " UPDATE ENDERECO SET ID_ENDERECO = ?, LOGRADOURO = ?, NUMERO = ?, COMPLEMENTO = ?, CEP = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ? WHERE COD LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, endereco.getId_endereco());
                psmt.setString(2, endereco.getLogradouro());
                psmt.setInt(3, endereco.getNumero());
                psmt.setString(4, endereco.getComplemento());
                psmt.setString(5, endereco.getCep());
                psmt.setString(6, endereco.getBairro());
                psmt.setString(7, endereco.getCidade());
                psmt.setString(8, endereco.getEstado());
                
                
               
               psmt.setInt(9, id_endereco);
               
               psmt.execute();
            } 
   }
   
   public List<Endereco> selecionarEndereco(int id_endereco) throws SQLException{
       List<Endereco> listaDao = new ArrayList<>();
       
       String sql = "SELECT * FROM ENDERECO WHERE ID_ENDERECO LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, id_endereco);
           try (ResultSet rs = psmt.executeQuery()) {
               while(rs.next()){
                   Endereco listaEndereco = new Endereco();
                   
                   listaEndereco.setId_endereco(rs.getInt("ID_ENDERECO"));
                   listaEndereco.setLogradouro(rs.getString("LOGRADOURO"));
                   listaEndereco.setNumero(rs.getInt("NUMERO"));
                   listaEndereco.setComplemento(rs.getString("COMPLEMENTO"));
                   listaEndereco.setCep(rs.getString("CEP"));
                   listaEndereco.setBairro(rs.getString("BAIRRO"));
                   listaEndereco.setCidade(rs.getString("CIDADE"));
                   listaEndereco.setEstado(rs.getString("ESTADO"));
                   
                   
                   listaDao.add(listaEndereco);
               }
           }
            }
       
        
        
       return listaDao;
   }
    
}

    

