/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo;

import java.util.Date;
import model.Funcionario;

/**
 *
 * @author Mayana
 */
public class Projeto_POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here]
        Funcionario f = new Funcionario();
        //20:00
        String horainicio = "20:00";
        
        Date h = new Date();
        
        h.setHours(Integer.parseInt(horainicio.substring(0, 2)));
        f.setHorario(h);
        
        System.out.println(h.getHours());
    }
    
}