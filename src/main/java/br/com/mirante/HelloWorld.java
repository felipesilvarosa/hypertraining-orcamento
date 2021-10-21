package br.com.mirante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloWorld {

	public static void main(String[] args) throws SQLException {

		Integer maiorId = null;

		try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/orcamento", "root", "fel3003");
				Statement statement = conexao.createStatement()) {

			ResultSet result = statement.executeQuery("SELECT MAX(ID) AS ID FROM ORCAMENTO");
			result.next();
			maiorId = result.getInt("ID");

		} catch (SQLException exception) {
			System.out.println("Erro ao conectar ao servidor");
			exception.printStackTrace();
		}

		System.out.println(maiorId);

	}

	static void imprimirResultado(ResultSet result) throws SQLException {
		while (result.next()) {
			Integer id = result.getInt("ID");
			String nome = result.getString("NOME");

			System.out.println(id + " " + nome);
		}
	}
}
