package br.com.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@ComponentScan({ "br.com.infra" })
@ImportResource({ "classpath:spring-security.xml" })
public class SecurityConfigXml {

}
