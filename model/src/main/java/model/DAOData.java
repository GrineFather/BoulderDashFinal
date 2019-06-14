package model;

import java.sql.Connection;
import java.sql.SQLException;

import entity.Data;
import entity.Level;

public abstract class DAOData<C extends Data> {

	/** The connection. */
	private final Connection connection;

	/**
	 * Instantiates a new DAO entity.
	 *
	 * @param connection the connection
	 * @throws SQLException the SQL exception
	 */
	public DAOData(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}

	/**
	 * Creates the.
	 *
	 * @param Data the entity
	 * @return true, if successful
	 */
	public abstract boolean create(C Data);

	/**
	 * Delete.
	 *
	 * @param Data the entity
	 * @return true, if successful
	 */
	public abstract boolean delete(C Data);

	/**
	 * Update.
	 *
	 * @param Data the entity
	 * @return true, if successful
	 */
	public abstract boolean update(C Data);

	/**
	 * Find.
	 *
	 * @param id the id
	 * @return the e
	 */
	public abstract Level find(int id);

}
