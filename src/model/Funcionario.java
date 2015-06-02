/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.GregorianCalendar;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 *
 * @author Mayana
 */
public class Funcionario extends Pessoa{
    private double salario;
    private java.sql.Date horario;
    private String funcao;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public java.sql.Date getHorario() {
        
        return horario;
    }

    public void setHorario(java.sql.Date horario ) {
        this.horario = horario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setHorario(java.util.Date h) {
        
    }
    
}
