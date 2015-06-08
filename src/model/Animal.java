package model;

import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author Mayana
 */
public class Animal {
    private int id_Animal;
    private Date nascimento;
    private String tipo;
    private String raca;
    private String nome;

    public int getId_Animal() {
        return id_Animal;
    }

    public void setId_Animal(int id_Animal) {
        this.id_Animal = id_Animal;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
