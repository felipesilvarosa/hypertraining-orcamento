package br.com.mirante;

import java.sql.SQLException;

public class HelloWorld {

	public static void main(String[] args) throws SQLException {

		System.out.println(System.getenv("SISTEMA_ORCAMENTO_PASSWORD"));
	}
}
