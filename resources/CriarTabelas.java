package source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {
	
	public static void main() throws SQLException {
		cliente();
		local();
		conta_agua();
		ref_agua();
		conta_luz();
		ref_luz();
		login();
		}
	
	public static void cliente() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS cliente ("
				+ "id_cli int PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "cnpj_cli CHAR(11) NOT NULL,"
				+ "telefone_cli VARCHAR(20) NOT NULL"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Cliente criada com sucesso!!!");
		conexao.close();
	}
	
	public static void local() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS local ("
				+ "id_loc int PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "id_cli int NOT NULL,"
				+ "endereco VARCHAR(70) NOT NULL,"
				+ "complemento VARCHAR(100) NOT NULL,"
				+ "cep VARCHAR(20) NOT NULL,"
				+ "cidade VARCHAR(40) NOT NULL,"
				+ "uf CHAR(2) NOT NULL,"
				+ "pais VARCHAR (40) NOT NULL,"
				+ "FOREIGN KEY (id_cli) REFERENCES cliente(id_cli)"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Local criada com sucesso!!!");
		conexao.close();
	}
	
	public static void ref_agua() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS ref_agua ("
				+ "mes VARCHAR(19) PRIMARY KEY NOT NULL,"
				+ "rgi VARCHAR(15) NOT NULL,"
				+ "numero_conta VARCHAR(15) NOT NULL,"
				+ "consumo VARCHAR(15) NOT NULL,"
				+ "total_pagar VARCHAR(10) NOT NULL,"
				+ "vencimento VARCHAR(15) NOT NULL,"
				+ "digitador VARCHAR(20) NOT NULL"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Ref_agua criada com sucesso!!!");
		conexao.close();
	}
	
	public static void conta_agua() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS conta_agua ("
				+ "rgi VARCHAR(15) PRIMARY KEY NOT NULL,"
				+ "id_local int NOT NULL,"
				+ "FOREIGN KEY (id_local) REFERENCES local(id_loc)"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Conta_agua criada com sucesso!!!");
		conexao.close();
	}
	
	public static void ref_luz() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS ref_luz ("
				+ "mes VARCHAR(9) PRIMARY KEY NOT NULL,"
				+ "instalacao VARCHAR(15) NOT NULL,"
				+ "vencimento CHAR(10) NOT NULL,"
				+ "consumo VARCHAR(15) NOT NULL,"
				+ "tarifa VARCHAR(15) NOT NULL,"
				+ "pis VARCHAR(15) NOT NULL,"
				+ "confins VARCHAR(15) NOT NULL,"
				+ "icms VARCHAR(15) NOT NULL,"
				+ "total_pagar VARCHAR(10) NOT NULL,"
				+ "digitador VARCHAR(20) NOT NULL"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Ref_luz criada com sucesso!!!");
		conexao.close();
	}
	
	public static void conta_luz() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS conta_luz ("
				+ "instalacao VARCHAR(15) PRIMARY KEY NOT NULL,"
				+ "id_local int NOT NULL,"
				+ "FOREIGN KEY (id_local) REFERENCES local(id_loc)"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Conta_luz criada com sucesso!!!");
		conexao.close();
	}
	
	public static void login() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS login ("
				+ "nome VARCHAR(20) PRIMARY KEY NOT NULL,"
				+ "senha VARCHAR(20) NOT NULL"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela 'login' criada com sucesso!!!");
		
		//já adiciona alguns logins
		PreparedStatement posted = conexao.prepareStatement("INSERT IGNORE INTO login VALUES("
				+ "'admin', 'password'),"
				+ "('devanir', 'abcd1234')");
		posted.executeUpdate();

		System.out.println("Dados inseridos.");
		conexao.close();
		
	}
	
	public static void criarlogin(String nome, String senha) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		PreparedStatement posted = conexao.prepareStatement("INSERT INTO login VALUES('" + nome + "', '" + senha +"')");
		posted.executeUpdate();
		
	}
	
}
