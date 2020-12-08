package candidatoDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.Connection;

import connection.ConectionFactory;
import model.candidato;

public class candidatoDao {
	public int create (candidato dao) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		String sqlInsert = "INSERT INTO candidato (nome, cpf, cargo) VALUES (?,?,?)";
		
		con = ConectionFactory.getConnection();
		try {
			stmt = con.prepareStatement(sqlInsert);
			stmt.setString(1, dao.getNome());
			stmt.setString(2, dao.getCpf());
			stmt.setString(3, dao.getCargo());
			stmt.execute();
			
			return 1;
		} 
		
		catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro no cadastro! "+e.getMessage(), "Erro", 2, null);
return 0;
		}
		
		finally {
			
			ConectionFactory.closeConnection(con, stmt);
		}
	}
}
