package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	private static String user;
	private static String password;
	
	public static void main() throws SQLException {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true&useTimezone=true&serverTimezone=UTC";
		String usuario = user;
		String senha = password;
		
		// CRIANDO CONEXAO
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		Statement stmt = conexao.createStatement();
		
		// CRIANDO BANCO DE DADOS SE ELE NÃO EXISTIR
		stmt.execute("CREATE DATABASE IF NOT EXISTS projeto_integrador");
		
		// DELETANDO O BANCO CASO ELE EXISTA
		//stmt.execute("DROP DATABASE IF EXISTS curso_java");
		
		System.out.println("Banco criado com sucesso!!!");
		
		conexao.close();
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setUser(String user) {
		CriarBanco.user = user;
	}

	public static void setPassword(String password) {
		CriarBanco.password = password;
	}

}
