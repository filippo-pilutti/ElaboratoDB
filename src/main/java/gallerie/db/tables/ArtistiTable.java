package gallerie.db.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import gallerie.db.Table;
import gallerie.model.Artista;
import gallerie.utils.Utils;

public class ArtistiTable implements Table<Artista, Integer> {
	
	public static final String TABLE_NAME = "artisti";
	
	private final Connection connection;
	
	public ArtistiTable(final Connection connection) {
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
	public Optional<Artista> findByPrimaryKey(final Integer primaryKey) {
		final String query = "SELECT * FROM " + TABLE_NAME + " WHERE codArtista = ?";
		try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
			statement.setInt(1, primaryKey);
			final ResultSet resultSet = statement.executeQuery();
			return readArtistiFromResultSet(resultSet).stream().findFirst();
		} catch (SQLException e) {
			throw new IllegalStateException();
		}
	}

	@Override
	public List<Artista> findAll() {
		try (final Statement statement = this.connection.createStatement()) {
			final ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME);
			return readArtistiFromResultSet(resultSet);
		} catch (SQLException e) {
			throw new IllegalStateException();
		}
	}

	@Override
	public boolean save(final Artista artista) {
		final String query = "INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
			statement.setString(1, artista.getNome().orElse(null));
			statement.setString(2, artista.getCognome().orElse(null));
			statement.setString(3, artista.getNomeArte().orElse(null));
			statement.setLong(4, artista.getTelefono().orElse(0L));
			statement.setString(5, artista.getMail().orElse(null));
			statement.setDate(6, artista.getDataMorte().map(Utils::dateToSqlDate).orElse(null));
			statement.setInt(7, artista.getCodArtista());
			statement.executeUpdate();
			return true;
		} catch (final SQLIntegrityConstraintViolationException e) {
			return false;
		} catch (final SQLException e) {
			throw new IllegalStateException();
		}
	}

	@Override
	public boolean update(final Artista artista) {
		final String query = "UPDATE " + TABLE_NAME + " SET nome = ?, cognome = ?, "
								+ "nomeArte = ?, telefono = ?, mail = ?, dataMorte = ?"
								+ "WHERE codArtista = ?";
		try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
			statement.setString(1, artista.getNome().orElse(null));
			statement.setString(2, artista.getCognome().orElse(null));
			statement.setString(3, artista.getNomeArte().orElse(null));
			statement.setLong(4, artista.getTelefono().orElse(null));
			statement.setString(5, artista.getMail().orElse(null));
			statement.setDate(6, artista.getDataMorte().map(Utils::dateToSqlDate).orElse(null));
			statement.setInt(7, artista.getCodArtista());
			statement.executeUpdate();
			return true;
		} catch (final SQLException e) {
			throw new IllegalStateException();
		}
	}

	@Override
	public boolean delete(final Integer primaryKey) {
		final String query = "DELETE FROM " + TABLE_NAME + "WHERE codArtista = ?";
		try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
			statement.setInt(1, primaryKey);
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new IllegalStateException();
		}
	}
	
	private List<Artista> readArtistiFromResultSet(final ResultSet resultSet) {
		final List<Artista> list = new ArrayList<>();
		try {
			while(resultSet.next()) {
				final Optional<String> nome = Optional.ofNullable(resultSet.getString("nome"));
				final Optional<String> cognome = Optional.ofNullable(resultSet.getString("cognome"));
				final Optional<String> nomeArte = Optional.ofNullable(resultSet.getString("nomeArte"));
				final Optional<Long> telefono = Optional.ofNullable(resultSet.getLong("telefono"));
				final Optional<String> mail = Optional.ofNullable(resultSet.getString("mail"));
				final Optional<Date> dataMorte = Optional.ofNullable(Utils.sqlDateToDate(resultSet.getDate("dataMorte")));
				final int codArtista = resultSet.getInt("codArtista");
				final Artista artista = new Artista(nome, cognome, nomeArte, telefono, mail, dataMorte, codArtista);
				list.add(artista);
			}
			return list;
		} catch (SQLException e) {
			return list;
		}
	}

	
}
