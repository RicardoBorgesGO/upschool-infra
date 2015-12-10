package br.com.infra.service.impl;

import org.springframework.stereotype.Service;

import br.com.infra.service.ITenantService;

@Service
public class TenantServiceImpl implements ITenantService {
	
	private String tenantName = null;

	@Override
	public String getTenantSchemaName() {
		return tenantName;
	}

	@Override
    public void setTenantSchemaName(final String tenant) {
        tenantName = tenant;
    }
}
