package br.inatel.dm110.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.inatel.dm110.impl.AuditService_Impl;
import br.inatel.dm110.impl.ProductService_Impl;

@ApplicationPath("/api")
public class RestApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(ProductService_Impl.class);
		classes.add(AuditService_Impl.class);
		return classes;
	}
}
