package br.com.mirante.orcamento.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemRepositoryJdbc implements ItemRepository {

	private static final String URL = "jdbc:mysql://localhost/orcamento";
	private static final String USER = "root";
	private static final String PASSWORD = System.getenv("SISTEMA_ORCAMENTO_PASSWORD");

	@Override
	public void excluir(Integer idItem) {

		String comando = "DELETE FROM ITEM_ORCAMENTO WHERE ID = ?";

		try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conexao.prepareStatement(comando)) {

			statement.setInt(1, idItem);
			statement.executeUpdate();

		} catch (SQLException exception) {
			System.out.println("Erro ao conectar ao servidor");
			exception.printStackTrace();
		}
	}

}
