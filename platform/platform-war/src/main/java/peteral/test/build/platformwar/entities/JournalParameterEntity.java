package peteral.test.build.platformwar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="JOURNAL_PARAMETER")
@IdClass(JournalParameterId.class)
public class JournalParameterEntity {
	@Id
	@Column(name="PARAMETER_ID")
	private Long parameterId;
	@Id
	@Column(name="PARAM_NO")
	private int paramNo;
	
	@Column(name="PARAM_VALUE")
	private String paramValue;

	public Long getParameterId() {
		return parameterId;
	}

	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}

	public int getParamNo() {
		return paramNo;
	}

	public void setParamNo(int paramNo) {
		this.paramNo = paramNo;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
}
