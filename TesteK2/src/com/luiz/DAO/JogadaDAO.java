/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luiz.DAO;

import com.luiz.model.Jogada;
import com.luiz.view.connection.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luiz
 */
public class JogadaDAO {
    
    
    
    public void adicionaVencedorJogada(Jogada jogadaResult) throws SQLException{
        Connection conexao = ConectaBanco.conector();

		String sql = "INSERT INTO jogada(vencedorJogada) VALUES(?)";

		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, jogadaResult.getVencedorJogada());
		statement.execute();
		
		ResultSet rs = statement.getGeneratedKeys();
		if (rs.next()) {
		}
		
	
    
    
    }
}
