package controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.Animal;
import model.Cliente;
import model.dao.DaoAnimal;

/**
 *
 * @author Pc do Rik
 */

public class ControllerAnimal {
    private int id_Animal;
    
    public void salvar(int id_Animal, Date nascimento, String tipo, String raca, String nome)
            throws SQLException{
        Animal animal = new Animal();
        DaoAnimal emp = new DaoAnimal();
        
        animal.setId_Animal(id_Animal);
        animal.setNascimento(nascimento);
        animal.setTipo(tipo);
        animal.setRaca(raca);
        animal.setNome(nome);
        
        emp.cadastroDeAnimal(animal);      
    }
    
    public List<Animal> ListaAnimais() throws SQLException{
        
       DaoAnimal emp = new DaoAnimal();
       return emp.selecionarAnimal(id_Animal);  
    }
    
    
    public void atualizar(int id_Animal, String tipo, 
            String raca, String nome) throws SQLException {
        Animal animal = new Animal();
        DaoAnimal emp = new DaoAnimal();
        
        animal.setId_Animal(id_Animal);
        animal.setTipo(tipo);
        animal.setRaca(raca);
        animal.setNome(nome);
        
        emp.atualizarAnimal(animal, id_Animal);
    }
    
    
    public void apagar(int id_Animal) throws SQLException{
        
        Animal animal = new Animal();
        DaoAnimal emp = new DaoAnimal();
        
        animal.setId_Animal(id_Animal);
        
        emp.removerAnimal(animal);
        
    }
    
}
