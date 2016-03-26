package peteral.test.build.platformwar;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import peteral.test.build.platformapi.Journal;

@Singleton
@Startup
@DependsOn("Migration")
public class StartupBean {
	@EJB(lookup=Journal.LOOKUP)
	private Journal journal;
	
	@PostConstruct
	public void startup() {
		journal.log("Application start");
	}
}
