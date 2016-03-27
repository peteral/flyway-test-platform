package peteral.test.build.platformwar.entities;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
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
	
	private Timestamp ts;
	private String message;
	@Column(name="param1")
	private String parameter;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
