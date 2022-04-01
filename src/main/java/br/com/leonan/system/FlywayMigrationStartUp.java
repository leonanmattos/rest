package br.com.leonan.system;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.BEAN)
public class FlywayMigrationStartUp {

	@Resource(lookup = "java:jboss/datasources/restDS")
	private DataSource dataSource;

	@PostConstruct
	public void postConstruct() {
		Flyway flyway = Flyway.configure()
				.schemas("sa_rest")
				.dataSource(dataSource)
				.group(true)
				.load();
		flyway.migrate();
	}
}
