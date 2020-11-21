package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	private static String user;
	private static String password;
	
	public static Connection getConexao() {
			
			try {
				String url = "jdbc:mysql://localhost/projeto_integrador?verifyServerCertificate=false&useSSL=true&useTimezone=true&serverTimezone=UTC";
				String usuario = "root";
				String senha = "password";
				
				// CRIANDO CONEXAO
				return DriverManager.getConnection(url, usuario, senha);
			} catch(SQLException e) {	
				throw new RuntimeException(e);
			}
		}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setUser(String user) {
		FabricaConexao.user = user;
	}

	public static void setPassword(String password) {
		FabricaConexao.password = password;
	}

}
