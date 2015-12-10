package br.com.infra.service;

public interface ITenantService {
	
	String getTenantSchemaName();

    void setTenantSchemaName(String username);
}
