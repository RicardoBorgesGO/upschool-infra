//package br.com.infra.config;
//
//import javax.sql.DataSource;
//
//import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
//
//public class SimpleMultiTenantConnectionProvider extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -406960773801059739L;
//	
//	private DataSource dataSource;
//
//	@Override
//	protected DataSource selectAnyDataSource() {
//		return dataSource;
//	}
//
//	@Override
//	protected DataSource selectDataSource(String tenantIdentifier) {
//		return dataSource;
//	}
//
//	public DataSource getDataSourceMap() {
//		return dataSource;
//	}
//
//	public void setDataSourceMap(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
//
//}
