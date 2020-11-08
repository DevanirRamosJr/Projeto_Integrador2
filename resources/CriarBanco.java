package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		

		final String url = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
		final String usuario = "root";
		final String senha = "123456789";

		
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

}
