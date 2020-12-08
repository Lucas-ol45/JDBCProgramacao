	package main;

	import java.sql.Connection;
	import javax.swing.JOptionPane;
	import connection.ConectionFactory;

	public class MainTeste {
		
		public static void main(String[] args) {
			
			Connection con = null;
			con = ConectionFactory.getConnection();
			if(con!=null) {
				JOptionPane.showMessageDialog(null, "Sucesso", "Conectado", 1);
			}
		}
	}

