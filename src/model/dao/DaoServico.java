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
import model.Servico;

/**
 *
 * @author Mayana
 */
public class DaoServico {
    
          private Connection conexao;
    
    public DaoServico() throws SQLException {
        this.conexao = CriaConexao.fazerConexao();
    }
                public void cadastroDeServico( Servico servico) throws SQLException{
        String sql = "INSERT INTO SERVICO (ID_SERVICO, TIPO, PRECO) VALUES (?,?,?)"; // aqui teremos a query de inserção no banco de dados
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, servico.getId_servico());
                psmt.setString(2, servico.getTipo());
                psmt.setDouble(3, servico.getPreco());                
                DaoFicha serv = new DaoFicha();
                serv.cadastroDeFicha (servico.getFicha());
                                
                psmt.execute();
            }
        
    }   
   public void removerServico(Servico servico) throws SQLException{
       String sql = "DELETE FROM SERVICO WHERE  ID_SERVICO LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, servico.getId_servico());
                psmt.execute();
            }
       
   }
   public void atualizarServico(Servico servico, int id_servico) throws SQLException{
       String sql = " UPDATE SERVICO SET ID_SERVICO = ?, TIPO = ?, PRECO = ? WHERE COD LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, servico.getId_servico());
                psmt.setString(2, servico.getTipo());                
                psmt.setDouble(3, servico.getPreco());
               
               psmt.setInt(4, servico.getId_servico());
               
               psmt.execute();
            } 
   }
   
   public List<Servico> selecionarServico(int id_servico) throws SQLException{
       List<Servico> listaDao = new ArrayList<>();
       
       String sql = "SELECT * FROM SERVICO WHERE ID_SERVICO LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, id_servico);
            try (ResultSet rs = psmt.executeQuery()) {
               while(rs.next()){
                   Servico listaServico = new Servico();
                   
                   listaServico.setId_servico(rs.getInt("ID_SERVICO"));
                   listaServico.setTipo(rs.getString("TIPO"));                   
                   listaServico.setPreco(rs.getDouble("PRECO"));
                   listaDao.add(listaServico);
               }
           }
            }
       
        
        
       return listaDao;
   }
    
}
