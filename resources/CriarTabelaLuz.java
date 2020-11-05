package source;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaLuz {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS conta_luz ("
				+ "numero_instalacao VARCHAR(15) PRIMARY KEY NOT NULL,"
				+ "cliente VARCHAR(80) NOT NULL,"
				+ "vencimento DATE NOT NULL,"
				+ "conta_mes VARCHAR(15) NOT NULL,"
				+ "consumo DECIMAL(15,2) NOT NULL,"
				+ "tarifa DECIMAL(15,10) NOT NULL,"
				+ "pis DECIMAL(15,2) NOT NULL,"
				+ "confins DECIMAL(15,2) NOT NULL,"
				+ "icms DECIMAL(15,2) NOT NULL,"
				+ "total_pagar DECIMAL(15,2) NOT NULL"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada com sucesso!!!");
		conexao.close();
	}

}
