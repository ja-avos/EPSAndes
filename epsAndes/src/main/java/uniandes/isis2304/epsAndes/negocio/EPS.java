package uniandes.isis2304.epsAndes.negocio;

public class EPS implements VOEps{
	
	private long id;
	
	private String nombre;
	
	public EPS() {
		this.id = 0;
		this.nombre = "";
	}
	
	public EPS(long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "EPS [id=" + id + ", nombre=" + nombre + "]";
	}
}
