package peteral.test.build.platformwar;

import java.sql.Timestamp;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import peteral.test.build.platformapi.Journal;
import peteral.test.build.platformwar.entities.JournalEntity;

@Stateless
@Remote(Journal.class)
public class JournalBean implements Journal {
	@PersistenceContext(unitName="PU")
	private EntityManager em;
	
	@Override
	public void log(String message) {
		JournalEntity entry = new JournalEntity();
		entry.setTs(new Timestamp(System.currentTimeMillis()));
		entry.setMessage(message);
		
		em.persist(entry);
		
		em.flush();
	}

}
