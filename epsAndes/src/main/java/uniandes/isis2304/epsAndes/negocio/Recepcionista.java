package uniandes.isis2304.epsAndes.negocio;

public class Recepcionista implements VORecepcionista{
	
	private long id_Recepcionista;
	
	private long usuario;
	
	private long IPS;
	
	public Recepcionista() {
		this.id_Recepcionista = 0;
		this.usuario = 0;
		this.IPS = 0;
	}
	
	public Recepcionista(long idRecepcionista, long usuario, long IPS) {
		this.id_Recepcionista = idRecepcionista;
		this.usuario = usuario;
		this.IPS = IPS;
	}

	public long getIdRecepcionista() {
		return id_Recepcionista;
	}

	public void setIdRecepcionista(long idRecepcionista) {
		this.id_Recepcionista = idRecepcionista;
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
		return "Recepcionista [idRecepcionista=" + id_Recepcionista + 
				", usuario=" + usuario + ", IPS=" + IPS + "]";
	}
}
