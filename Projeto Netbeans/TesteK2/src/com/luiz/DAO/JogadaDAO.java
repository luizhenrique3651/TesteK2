/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luiz.DAO;

import com.luiz.model.Jogada;
import com.luiz.connection.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
      public List<Jogada> read() {

        Connection conexao = ConectaBanco.conector();
        
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Jogada> jogadaDaVez = new ArrayList();

        try {
            pst = conexao.prepareStatement("SELECT * FROM jogada");
            rs = pst.executeQuery();

            while (rs.next()) {

                Jogada Jogos = new Jogada();

                Jogos.setVencedorJogada(rs.getInt("vencedorJogada"));
                
                
                
                
              jogadaDaVez.add(Jogos);
            }
 
        } catch (SQLException ex) {
            Logger.getLogger(JogadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           //ModuloConexao.closeConnection(conexao, pst, rs);
        }

       return jogadaDaVez;

}
    
}
