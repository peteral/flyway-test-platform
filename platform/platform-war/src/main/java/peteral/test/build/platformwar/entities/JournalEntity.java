package peteral.test.build.platformwar.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOURNAL")
public class JournalEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;
	
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
