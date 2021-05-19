
public class NPC {
	private String jmeno;

	//-----------------------------------------

	public String getJmeno() {
		return jmeno;
	}

	public void setJmeno(String jmeno) {
		jmeno = jmeno;
	}

	public NPC(String jmeno) {
		super();
		this.jmeno = jmeno;
	}
	//-----------------------------------------
	@Override
	public String toString() {
		return jmeno;
	}

	//-----------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jmeno == null) ? 0 : jmeno.hashCode());
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
		NPC other = (NPC) obj;
		if (jmeno == null) {
			if (other.jmeno != null)
				return false;
		} else if (!jmeno.equals(other.jmeno))
			return false;
		return true;
	}


	//-----------------------------------------


}
