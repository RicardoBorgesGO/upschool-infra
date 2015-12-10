package br.com.infra.tenant;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;

import br.com.infra.config.ConnectionProviderBuilder;

public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3244227375145759307L;
	
	private final ConnectionProvider connectionProvider = ConnectionProviderBuilder.buildConnectionProvider("sgo", true);

	@Override
	public boolean isUnwrappableAs(Class class1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getAnyConnection() throws SQLException {
		return connectionProvider.getConnection();
	}

	@Override
	public Connection getConnection(String tenantIdentifier) throws SQLException {
		final Connection connection = getAnyConnection();
		
		try {
			//TODO Melhorar, esta especifico para o POSTGRES
			connection.createStatement().execute("SET search_path = " + tenantIdentifier);
		} catch (Exception e) {
			throw new HibernateException("Não pode alterar a conexão para o esquema especificado [" + tenantIdentifier + "]", e);
		}
		
		return connection;
	}

	@Override
	public void releaseAnyConnection(Connection connection) throws SQLException {
		connectionProvider.closeConnection(connection);
	}

	@Override
	public void releaseConnection(String tenantIdentifier, Connection connection)
			throws SQLException {
		try {
			//TODO Melhorar, esta especifico para o POSTGRES
			connection.createStatement().execute("SET search_path = " + tenantIdentifier);
		} catch (Exception e) {
			throw new HibernateException("Não pode alterar a conexão para o esquema especificado [" + tenantIdentifier + "]", e);
		}
		connectionProvider.closeConnection(connection);
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
