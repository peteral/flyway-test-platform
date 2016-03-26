package peteral.test.build.platformwar;

import java.util.logging.Logger;

import javax.ejb.EJBException;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;

public class FlywayInvocation {
	private final Logger log = Logger.getLogger(FlywayInvocation.class.getName());

	public void migrate(DataSource dataSource, String tableName) {
		if (dataSource == null) {
			log.severe("no datasource found to execute the db migrations!");
			throw new EJBException("no datasource found to execute the db migrations!");
		}

		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setDataSource(dataSource);
		flyway.setLocations("/db/migration/standard",
				"/db/migration/" + System.getProperty("test.databasetype", "oracle"));
		flyway.setTable(tableName);

		for (MigrationInfo i : flyway.info().all()) {
			log.info("Database validation: " + i.getState() + ": " + i.getVersion() + " : " + i.getDescription()
					+ " from file: " + i.getScript());
		}
		flyway.migrate();
	}
}
