package br.com.infra.tenant;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import br.com.infra.service.ITenantService;
import br.com.infra.service.impl.TenantServiceImpl;
import br.com.infra.util.SpringUtils;

@Component
public class SchemaResolver {
	
	protected String resolveTenant() {
		//TODO Verificar a necessidade deste trecho
		String tenant = TenantThreadLocal.tenantThreadLocal.get();

		if (tenant != null)
			return tenant;
		//
		
		final ApplicationContext applicationContext = SpringUtils.getSpringContext();
		
		String tenantSchema = null;
		ITenantService tenantService = null;
		MultiTenancyUtils multiTenancyUtils = null;
		
		if (null == applicationContext) {
			throw new IllegalStateException("Spring application context is null");
		}
		
		tenantService = applicationContext.getBean(TenantServiceImpl.class);
		multiTenancyUtils = applicationContext.getBean(MultiTenancyUtils.class);
		
		tenantSchema = tenantService.getTenantSchemaName();
		if (tenantSchema == null) {
			tenantSchema = multiTenancyUtils.getDefaultSchema();
		}
		
		return tenantSchema;
	}

}
