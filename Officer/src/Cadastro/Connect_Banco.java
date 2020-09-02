package Cadastro;

import java.sql.*;



public class Connect_Banco {

	private static final String nome = "root";
	
	private static final String senha = "root";
	
	private static final String caminho = "jdbc:mysql://localhost:3306/cadastro?useSSL=false";
	
		static Connection con;
		static Statement st;
		static PreparedStatement prest;
		static ResultSet result;
//Conexão com o banco	
	static Connection conexao () throws SQLException {
		
		
		con = DriverManager.getConnection(caminho, nome, senha);
		
		
		
		return con;
	}		
	

}
