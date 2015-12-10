package br.com.infra.config;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;

public class ConnectionProviderBuilder {
	
	private static final String URL_FILE = "/persistence-postgres.properties";
	
	private static Properties getConnectionProviderProperties(String dbName) {
		Properties properties = getFileConfigProperties();
		
		Properties propertiesConnection = new Properties(null);
		propertiesConnection.put(Environment.DRIVER, properties.get("jdbc.driverClassName"));
		propertiesConnection.put(Environment.URL, String.format(properties.get("jdbc.url").toString(), dbName));
		propertiesConnection.put(Environment.USER, properties.get("jdbc.user"));
		propertiesConnection.put(Environment.PASS, properties.get("jdbc.pass"));
		propertiesConnection.put(Environment.DIALECT, properties.get("hibernate.dialect"));
		
		return propertiesConnection;
	}
	
	public static DriverManagerConnectionProviderImpl buildConnectionProvider(String dbName, final boolean allowAggressiveRelease) {
		DriverManagerConnectionProviderImpl connectionProvider = new DriverManagerConnectionProviderImpl() {
			@Override
			public boolean supportsAggressiveRelease() {
				return allowAggressiveRelease;
			}
		};
		
		connectionProvider.configure(getConnectionProviderProperties(dbName));
		return connectionProvider;
	}
	
	public static Properties getFileConfigProperties() {
		Properties properties = new Properties();
		
		try {
			properties.load(ConnectionProviderBuilder.class.getResourceAsStream(URL_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
