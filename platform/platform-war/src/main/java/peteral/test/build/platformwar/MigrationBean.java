package peteral.test.build.platformwar;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;

import peteral.test.build.platformapi.DatabaseMigration;

@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class MigrationBean {
	@Resource(lookup = "java:/jdbc/oracle")
	private DataSource dataSource;

	@PostConstruct
	public void migrate() {
		new DatabaseMigration().migrate(dataSource, "PLATFORM_METADATA");
	}
}
