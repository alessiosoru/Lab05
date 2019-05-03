package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Parola;

public class ParolaDAO {

	public boolean verificaEsistenza(String parziale) {
		
//		Parola parola = null;
		int esistenza =-1;
		
		final String sql = "SELECT count(*) FROM parola WHERE nome = ? ";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parziale);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				esistenza = rs.getInt("count(*)");
//				System.out.println(rs.getString("nome"));
//				System.out.println(rs.toString());
//				System.out.println(esistenza);
//				esistenza = rs.getInt(1);
//				int id = rs.getInt("id");
//				String nome = rs.getString("nome");
//				
//				parola = new Parola(id, nome);
			}
			conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		if(esistenza>0)
			return true;
		else
			return false;
		
//		if(parola.getNome()!=null)
//			return true;
//		else
//			return false;
	}

}
