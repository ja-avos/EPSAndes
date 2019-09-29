package uniandes.isis2304.epsAndes.negocio;

public class TipoServicio implements VOTipoServicio{

	private long idServicio;
	
	private String nombre;
	
	public TipoServicio() {
		this.idServicio = 0;
		this.nombre = "";
	}
	
	public TipoServicio(long idServicio, String nombre) {
		this.idServicio = idServicio;
		this.nombre = nombre;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "TipoServicio [idServicio=" + idServicio + ", nombre= " + nombre + "]";
	}
}
