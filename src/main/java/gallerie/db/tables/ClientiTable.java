package gallerie.db.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import gallerie.db.Table;
import gallerie.model.*;

public class ClientiTable implements Table<Cliente, String> {
	
	public static final String TABLE_NAME = "clienti";
	
	private final Connection connection;
	
	public ClientiTable(final Connection connection) {
		this.connection = Objects.requireNonNull(connection);
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public boolean dropTable() {
		try (final Statement statement = this.connection.createStatement()) {
			statement.executeUpdate("DROP TABLE " + TABLE_NAME);
			return true;
		} catch (final SQLException e) {
			System.out.println("Cannot drop table " + TABLE_NAME);
			return false;
		}
	}

	@Override
	public Optional<Cliente> findByPrimaryKey(String primaryKey) {
		final String query = "SELECT * FROM " + TABLE_NAME + " WHERE codFiscale = ?";
		try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
			statement.setString(1, primaryKey);
			final ResultSet resultSet = statement.executeQuery();
			return readClientiFromResultSet(resultSet).stream().findFirst();
		} catch (SQLException e) {
			throw new IllegalStateException();
		}
	}

	@Override
	public List<Cliente> findAll() {
		try (final Statement statement = this.connection.createStatement()) {
			final ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME);
			return readClientiFromResultSet(resultSet);
		} catch (SQLException e) {
			throw new IllegalStateException();
		}
	}

	@Override
	public boolean save(Cliente value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Cliente updatedValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<Cliente> readClientiFromResultSet(final ResultSet resultSet) {
		final List<Cliente> list = new ArrayList<>();
		try {
			while (resultSet.next()) {
				final String codFiscale = resultSet.getString("codFiscale");
				final String nome = resultSet.getString("nome");
				final String cognome = resultSet.getString("cognome");
				final Long telefono = resultSet.getLong("telefono");
				final String mail = resultSet.getString("mail");
				final Cliente cliente = new Cliente(codFiscale, nome, cognome, telefono, mail);
				list.add(cliente);
			}
			return list;
		} catch (final SQLException e) {
			return list;
		}
	}

}
