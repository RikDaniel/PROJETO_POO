/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerFuncionario;
import java.sql.SQLException;
import model.Funcionario;

/**
 *
 * @author Mayana
 */
public class MainTeste {
    
    
    public static void main(String[] args) throws SQLException{
        
        //modelo
        Funcionario f = new Funcionario();
        f.setSalario(600);
        //controller
        ControllerFuncionario cf = new ControllerFuncionario();
        //DAO
        cf.negocioDoFuncionario(f);
                
    }
}
