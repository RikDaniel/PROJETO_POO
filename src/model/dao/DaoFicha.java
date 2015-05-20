/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Ficha;


/**
 *
 * @author Mayana
 */
public class DaoFicha {
    
      private Connection conexao;
    
    public DaoFicha() throws SQLException {
        this.conexao = CriaConexao.fazerConexao();
    }
                public void cadastroDeFicha( Ficha ficha) throws SQLException{
        String sql = "INSERT INTO FICHA (ID_FICHA, AGENDAMENTO, DIAGNOSTICO) VALUES (?,?,?)"; // aqui teremos a query de inserção no banco de dados
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, ficha.getId_ficha());
                psmt.setDate(2, (Date) ficha.getAgendamento());
                psmt.setString(3, ficha.getDiagnostico());                
                DaoCliente fic = new DaoCliente();
                fic.cadastroDeCliente (ficha.getCliente());
                DaoAnimal au = new DaoAnimal();
                au.cadastroDeAnimal (ficha.getAnimal());
                
                psmt.execute();
            }
        
    }   
   public void removerFicha(Ficha ficha) throws SQLException{
       String sql = "DELETE FROM FICHA WHERE  ID_FICHA LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, ficha.getId_ficha());
                psmt.execute();
            }
       
   }
   public void atualizarFicha(Ficha ficha, int id_ficha) throws SQLException{
       String sql = " UPDATE FICHA SET ID_FICHA = ?, AGENDAMENTO = ?, DIAGNOSTICO = ? WHERE COD LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, ficha.getId_ficha());
                psmt.setDate(2, (Date) ficha.getAgendamento());                
                psmt.setString(3, ficha.getDiagnostico());
               
               psmt.setInt(4, ficha.getId_ficha());
               
               psmt.execute();
            } 
   }
   
   public List<Ficha> selecionarFicha(int id_ficha) throws SQLException{
       List<Ficha> listaDao = new ArrayList<>();
       
       String sql = "SELECT * FROM FICHA WHERE ID_FICHA LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, id_ficha);
            try (ResultSet rs = psmt.executeQuery()) {
               while(rs.next()){
                   Ficha listaFicha = new Ficha();
                   
                   listaFicha.setId_ficha(rs.getInt("ID_FICHA"));
                   listaFicha.setAgendamento(rs.getDate("AGENDAMENTO"));                   
                   listaFicha.setDiagnostico(rs.getString("DIAGNOSTICO"));
                   listaDao.add(listaFicha);
               }
           }
            }
       
        
        
       return listaDao;
   }
}

    

