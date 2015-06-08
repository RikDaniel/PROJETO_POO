package model.dao;

import model.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


/**
 *
 * @author Mayana
 */
public class DaoAnimal {
    
            private Connection conexao;
    
    public DaoAnimal() throws SQLException {
        this.conexao = CriaConexao.fazerConexao();
    }
    
    
            public void cadastroDeAnimal(Animal animal) throws SQLException{
        String sql = "INSERT INTO ANIMAL (ID_ANIMAL, NASCIMENTO, TIPO, RACA, NOME) VALUES (?,?,?,?,?)"; // aqui teremos a query de inserção no banco de dados
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, animal.getId_Animal());
                psmt.setDate(2, (java.sql.Date) animal.getNascimento());
                psmt.setString(3, animal.getTipo());
                psmt.setString(4, animal.getRaca());
                psmt.setString(5, animal.getNome());
                /*DaoFicha f = new DaoFicha();
                f.cadastroDeFicha (animal.getFicha());*/
                
                psmt.execute();
            }
        
    }   
   public void removerAnimal(Animal animal) throws SQLException{
       String sql = "DELETE FROM ANIMAL WHERE  ID_ANIMAL LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, animal.getId_Animal());
                psmt.execute();
            }
       
   }
   public void atualizarAnimal(Animal animal, int id_Animal) throws SQLException{
       String sql = " UPDATE ANIMAL SET ID_ANIMAL = ?, NASCIMENTO = ?, TIPO = ?, RACA = ?, NOME = ? WHERE COD LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, animal.getId_Animal());
                psmt.setDate(2, (java.sql.Date) animal.getNascimento());
                psmt.setString(3, animal.getTipo());
                psmt.setString(4, animal.getRaca());
                psmt.setString(5, animal.getNome());
               
               psmt.setInt(6, animal.getId_Animal());
               
               psmt.execute();
            } 
   }
   
   public List<Animal> selecionarAnimal(int id_Animal) throws SQLException{
       List<Animal> listaDao = new ArrayList<>();
       
       String sql = "SELECT * FROM ANIMAL WHERE ID_ANIMAL LIKE ?";
            try (PreparedStatement psmt = this.conexao.prepareStatement(sql)) {
                psmt.setInt(1, id_Animal);
            try (ResultSet rs = psmt.executeQuery()) {
               while(rs.next()){
                   Animal listaAnimal = new Animal();
                   
                   listaAnimal.setId_Animal(rs.getInt("ID_ANIMAL"));
                   listaAnimal.setNascimento(rs.getDate("NASCIMENTO"));
                   listaAnimal.setTipo(rs.getString("TIPO"));
                   listaAnimal.setRaca(rs.getString("RACA"));
                   listaAnimal.setNome(rs.getString("NOME"));
                   listaDao.add(listaAnimal);
               }
           }
            }
       
        
        
       return listaDao;
   }
    
}
