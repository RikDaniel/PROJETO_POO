/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.dao.DaoFuncionario;

/**
 *
 * @author Mayana
 */
public class ControllerFuncionario {
    
    
    public void negocioDoFuncionario(Funcionario func) throws SQLException{
        // aqui vem as regras de negocio do seu programa 
        /**
         * informando como o funcionario deve ser mandado para o DAO
         *  por exemplo vamos fazer uma verificação para saber se a salário dele é
         * menor que o mínimo
         */
         int erro=0;
         if(func.getSalario()< 788.00){
             erro++;
             System.out.println("salario menor que o minimo");
         }
         	if(func.getCpf().equals("")){
			erro++;
			//joga excecao
		}
		if (func.getNome().equals("")){
			 erro++;
		 }
		 if (func.getEndereco().equals("")){
			 erro++;
		 }
		 if (func.getFuncao().equals("")){
			 erro++;
		 }
		 if (func.getHorario()== 0){
			 erro++;
		 }
		 if (func.getSalario() == 0){
			 erro++;
                 }
                 if (func.getTelefone() .equals("")){
                         erro++;
                 }
                          
         
         if( erro == 0){
             DaoFuncionario dFunc = new DaoFuncionario();
             dFunc.cadastroDeFuncionario(func);
         }
                     if (erro == 0){
                     salvar(func);
                     System.out.println("Funcionario Salvo!!!");
                     {JOptionPane.showMessageDialog(null, "Funcionario Cadastrado!!!");}
                 }
                if(func.getCpf() != ""){
                    try{
                      
                    }catch(Exception e){
                        
                    }
                }     
                 System.out.println(erro);
                 
	}
        

                public void salvar(Funcionario funcionario) throws
                    SQLException {
                    
                    DaoFuncionario fun = new DaoFuncionario();
                    fun.cadastroDeFuncionario(funcionario);
}
        
        }

