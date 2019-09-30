package uniandes.isis2304.epsAndes.negocio;

public class IPS implements VOIps{

	private long id;
	
	private String localizacion;
	
	private String nombre;
	
	public IPS() {
		this.id = 0;
		this.localizacion = "";
		this.nombre = "";
	}
	
	public IPS(long id, String localizacion, String nombre) {
		this.id = id;
		this.localizacion = localizacion;
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return "IPS [id=" + id + ", nombre=" + nombre + ", localizacion=" + localizacion + "]";
	}
}
