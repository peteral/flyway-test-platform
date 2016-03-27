package peteral.test.build.platformwar;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import peteral.test.build.platformapi.Journal;
import peteral.test.build.platformwar.entities.JournalEntity;
import peteral.test.build.platformwar.entities.JournalParameterEntity;

@Stateless
@Remote(Journal.class)
public class JournalBean implements Journal {
	@PersistenceContext(unitName = "PU")
	private EntityManager em;

	@Override
	public void log(String message, String... parameter) {
		JournalEntity entry = new JournalEntity();
		entry.setTs(new Timestamp(System.currentTimeMillis()));
		entry.setMessage(message);

		em.persist(entry);
		
		if (parameter.length > 0) {
			List<JournalParameterEntity> parameters = new ArrayList<>();
			for (int i = 0; i < parameter.length; i++) {
				JournalParameterEntity param = new JournalParameterEntity();
				param.setParameterId(entry.getId());
				param.setParamNo(i + 1);
				param.setParamValue(parameter[i]);
				em.persist(param);
			}
			entry.setParameter(parameters);
		}
	}

}
