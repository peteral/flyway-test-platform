package peteral.test.build.platformwar.entities;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;

@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class Migration {
	private final Logger log = Logger.getLogger(Migration.class.getName());
	
	@Resource(lookup = "java:jboss/datasources/test")
	private DataSource dataSource;
	
	@PostConstruct
	public void migrate() {
		if (dataSource == null) {
			log.severe("no datasource found to execute the db migrations!");
			throw new EJBException(
					"no datasource found to execute the db migrations!");
		}
 
		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setDataSource(dataSource);
		flyway.setLocations("/db/migration/" + System.getProperty("test.databasetype", "mssql"));
		flyway.setTable("PLATFORM_METADATA");
		
		for (MigrationInfo i : flyway.info().all()) {
			log.info("Database validation: " + i.getState() + ": " + i.getVersion() + " : "
					+ i.getDescription() + " from file: " + i.getScript());
		}
		flyway.migrate();
	}
}
