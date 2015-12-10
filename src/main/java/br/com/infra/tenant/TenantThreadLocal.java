package br.com.infra.tenant;

public class TenantThreadLocal {
	public static final ThreadLocal<String> tenantThreadLocal = new ThreadLocal<String>();
}
