package peteral.test.build.platformwar.entities;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="JOURNAL")
@Cacheable(false)
public class JournalEntity {
	@Id
	@SequenceGenerator(sequenceName="JOURNAL_SEQUENCE", name="JournalEntitySeq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="JournalEntitySeq")
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private Timestamp ts;
	private String message;
	
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
