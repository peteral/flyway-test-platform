package peteral.test.build.platformwar;

import java.util.logging.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import peteral.test.build.platformapi.Journal;

@Stateless
@Remote(Journal.class)
public class JournalBean implements Journal {

	@Override
	public void log(String message) {
		Logger.getLogger("platform").info(message);
	}

}
