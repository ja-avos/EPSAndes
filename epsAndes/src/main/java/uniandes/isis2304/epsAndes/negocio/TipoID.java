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

	public long getId_Tipo() {
		return id_Tipo;
	}

	public void setId_Tipo(long id_Tipo) {
		this.id_Tipo = id_Tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "TipoID [idTipo=" + id_Tipo + ", nombre= " + nombre + "]";
	}
}
