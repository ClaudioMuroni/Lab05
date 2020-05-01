package it.polito.tdp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DizionarioDAO {

	public boolean parolaCorretta(String s) {
		// TODO Auto-generated method stub
		
		final String sql = "SELECT p.nome FROM parola AS p WHERE p.nome=?";
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				conn.close();
				return true;
			}
			else {
				conn.close();
				return false;
			}
		}catch(SQLException e) {
			
			throw new RuntimeException("Errore DB", e);
		}
	}

	
}
