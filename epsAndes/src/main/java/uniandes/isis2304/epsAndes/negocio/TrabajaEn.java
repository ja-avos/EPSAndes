package uniandes.isis2304.epsAndes.negocio;

public class TrabajaEn implements VOTrabajaEn{

	private long IPS;
	
	private long medico;
	
	public TrabajaEn() {
		this.IPS = 0;
		this.medico = 0;
	}
	
	public TrabajaEn(long IPS, long medico) {
		this.IPS = IPS;
		this.medico = medico;
	}

	public long getIPS() {
		return IPS;
	}

	public void setIPS(long iPS) {
		IPS = iPS;
	}

	public long getMedico() {
		return medico;
	}

	public void setMedico(long medico) {
		this.medico = medico;
	}
	
	public String toString() {
		return "TrabajaEn [IPS=" + IPS + ", medico=" + medico + "]";
	}
}
