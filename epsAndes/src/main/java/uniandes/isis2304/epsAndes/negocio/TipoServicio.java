package uniandes.isis2304.epsAndes.negocio;

public class TipoServicio implements VOTipoServicio{

	private long id_Servicio;
	
	private String nombre;
	
	public TipoServicio() {
		this.id_Servicio = 0;
		this.nombre = "";
	}
	
	public TipoServicio(long idServicio, String nombre) {
		this.id_Servicio = idServicio;
		this.nombre = nombre;
	}

	public long getIdServicio() {
		return id_Servicio;
	}

	public void setIdServicio(long idServicio) {
		this.id_Servicio = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "TipoServicio [idServicio=" + id_Servicio + ", nombre= " + nombre + "]";
	}
}
