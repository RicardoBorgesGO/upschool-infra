package br.com.infra.tenant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ "classpath:demo.properties" })
public class MultiTenancyUtils {
	
    private String defaultSchema = null;

    public String getDefaultSchema() {
        return defaultSchema;
    }

    @Value("${DEFAULT_DATASOURCE}")
    public void setDefaultSchema(String defaultSchema) {
        this.defaultSchema = defaultSchema;
    }
}
