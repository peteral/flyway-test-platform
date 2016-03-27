package peteral.test.build.platformwar.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy="parameterId", cascade=CascadeType.ALL)
	private List<JournalParameterEntity> parameter;
	
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
	public List<JournalParameterEntity> getParameter() {
		return parameter;
	}
	public void setParameter(List<JournalParameterEntity> parameter) {
		this.parameter = parameter;
	}
}
