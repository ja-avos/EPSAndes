package uniandes.isis2304.epsAndes.negocio;

public class TipoID implements VOTipoID{

	private long id_Tipo;
	
	private String nombre;
	
	public TipoID() {
		this.id_Tipo = 0;
		this.nombre = "";
	}
	
	public TipoID(long idTipo, String nombre) {
		this.id_Tipo = idTipo;
		this.nombre = nombre;
	}

	public long getIdTipo() {
		return id_Tipo;
	}

	public void setIdServicio(long idServicio) {
		this.id_Tipo = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "TipoServicio [idServicio=" + id_Tipo + ", nombre= " + nombre + "]";
	}
}
