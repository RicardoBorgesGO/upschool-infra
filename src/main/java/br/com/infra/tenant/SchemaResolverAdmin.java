package br.com.infra.tenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.infra.service.IUsuarioService;

public class SchemaResolverAdmin extends SchemaResolver implements CurrentTenantIdentifierResolver {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SchemaResolverAdmin.class);

    @Autowired
	private IUsuarioService usuarioService;
    
    @Override
    public String resolveCurrentTenantIdentifier() {
        
        String tenantResoloved = resolveTenant();
        
        LOGGER.debug("Tenant Schema resolved by SchemaResolverAdmin " + tenantResoloved);

        return tenantResoloved;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }
}