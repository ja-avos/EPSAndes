package uniandes.isis2304.epsAndes.negocio;

public class IPS implements VOIps{

	private long id_IPS;
	
	private String localizacion;
	
	private String nombre;
	
	public IPS() {
		this.id_IPS = 0;
		this.localizacion = "";
		this.nombre = "";
	}
	
	public IPS(long id, String localizacion, String nombre) {
		this.id_IPS = id;
		this.localizacion = localizacion;
		this.nombre = nombre;
	}

	public long getId() {
		return id_IPS;
	}

	public void setId(long id) {
		this.id_IPS = id;
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
		return "IPS [id=" + id_IPS + ", nombre=" + nombre + ", localizacion=" + localizacion + "]";
	}
}
