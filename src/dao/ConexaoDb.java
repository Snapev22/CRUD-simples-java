package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por fornecer conexões com o banco de dados.
 * <p>
 * Neste projeto é utilizado o {@link DriverManager} pela simplicidade didática.
 * Em ambientes de produção, recomenda-se o uso de um pool de conexões, como o
 * {@link HikariDataSource}, por ser mais performático.
 */
public class ConexaoDb {

	/**
	 * Estabelece e retorna uma nova conexão com o banco de dados.
	 *
	 * @return uma conexão ativa com o banco de dados.
	 * @throws RuntimeException se a conexão falhar.
	 */
	public Connection recuperaConexao() {
		try {
			String password = "****";
			String user = "root";
			String database = "agenda_db";

			String url = "jdbc:mysql://localhost:3306/" + database;
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
	}

	/**
	 * Pool de conexões 
	 
	 	A pool torna viável que mais de um usuário acessem o sistema ao mesmo tempo.
	 	Torna possivel um cojunto de conexões.
	 * @return
	 */
	public HikariDataSource createDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/agenda_db");
		config.setUsername("root");
		config.setPassword("Sn@pev22");
		config.setMaximumPoolSize(10);
		
		return new HikariDataSource(config);
	}
}
