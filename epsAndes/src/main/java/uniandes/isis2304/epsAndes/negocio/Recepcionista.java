package uniandes.isis2304.epsAndes.negocio;

public class Recepcionista implements VORecepcionista{
	
	private long idRecepcionista;
	
	private long usuario;
	
	private long IPS;
	
	public Recepcionista() {
		this.idRecepcionista = 0;
		this.usuario = 0;
		this.IPS = 0;
	}
	
	public Recepcionista(long idRecepcionista, long usuario, long IPS) {
		this.idRecepcionista = idRecepcionista;
		this.usuario = usuario;
		this.IPS = IPS;
	}

	public long getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(long idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

	public long getIPS() {
		return IPS;
	}

	public void setIPS(long iPS) {
		IPS = iPS;
	}

	public String toString() {
		return "Recepcionista [idRecepcionista=" + idRecepcionista + 
				", usuario=" + usuario + ", IPS=" + IPS + "]";
	}
}
