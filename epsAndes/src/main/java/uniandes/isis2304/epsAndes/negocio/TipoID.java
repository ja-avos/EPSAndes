package uniandes.isis2304.epsAndes.negocio;

public class TipoID implements VOTipoID{

	private long idTipo;
	
	private String nombre;
	
	public TipoID() {
		this.idTipo = 0;
		this.nombre = "";
	}
	
	public TipoID(long idTipo, String nombre) {
		this.idTipo = idTipo;
		this.nombre = nombre;
	}

	public long getIdTipo() {
		return idTipo;
	}

	public void setIdServicio(long idServicio) {
		this.idTipo = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "TipoServicio [idServicio=" + idTipo + ", nombre= " + nombre + "]";
	}
}
