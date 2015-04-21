/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mayana
 */
public class CriaConexao {
    public static Connection fazerConexao() throws SQLException {
		Connection conexao = null;
		try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    System.out.println("Conectado ao banco");
                    return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",  "CLINICA_VETERINARIA", "123456");
		}catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                }return conexao;
	}
    
}
