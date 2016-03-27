package peteral.test.build.platformwar.entities;

import java.io.Serializable;

public class JournalParameterId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Long parameterId;
	int paramNo;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + paramNo;
		result = prime * result + ((parameterId == null) ? 0 : parameterId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JournalParameterId other = (JournalParameterId) obj;
		if (paramNo != other.paramNo)
			return false;
		if (parameterId == null) {
			if (other.parameterId != null)
				return false;
		} else if (!parameterId.equals(other.parameterId))
			return false;
		return true;
	}
	
	
}
