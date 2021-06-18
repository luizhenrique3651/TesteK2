/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luiz.view.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConectaBanco {
    
    
     public static Connection conector(){
   java.sql.Connection conexao = null;
   //abaixo, chamada do driver
   String driver = "com.mysql.cj.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/bancoJogos?useSSL=true";
   String user = "luiz";
   String password = "luiz123";
   //atrapalhar a conexao com banco agora
   //try catch para tentar realizar a conexao e se nao for possivel, retornar exceção
       try {
           Class.forName(driver);
           conexao = DriverManager.getConnection(url, user, password);
           return conexao;
       } catch (Exception e) {
           String mensagemErro = "Caro usuário, houve um erro na execução da"
                   + " ferramenta, copie e cole o codigo abaixo e mande para o"
                   + " desenvolvedor. \n \n" +e+ " \n \n email do desenvolvedor:"
                   + " uizhenrique@gmail.com"; 
           
           JOptionPane.showMessageDialog(null, mensagemErro);

           return null;
       }
       
   }
     public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://192.168.0.59:3306/db_cafe?useSSL=true", "luiz", "luiz123");
	}
    
}
