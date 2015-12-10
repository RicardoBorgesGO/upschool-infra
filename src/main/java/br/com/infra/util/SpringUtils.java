package br.com.infra.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtils implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext = null;

	public static ApplicationContext getSpringContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext appContext)
			throws BeansException {
		SpringUtils.applicationContext = appContext;
	}
}
