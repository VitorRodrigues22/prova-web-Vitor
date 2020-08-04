package br.com.moduloweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySqlDAO {
	private String url = "jdbc:mysql://dev.crurmnllvgn6.us-east-2.rds.amazonaws.com/avaliacao";
	private String usuario = "java";
	private String senha = "1234";

	public Connection obterConexao() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, usuario, senha);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Connection buscarPorId(Integer codigo) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, usuario, senha);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}


}

