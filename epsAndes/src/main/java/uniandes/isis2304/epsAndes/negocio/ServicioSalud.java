package uniandes.isis2304.epsAndes.negocio;

public class ServicioSalud implements VOServicioSalud{
	
	private long idServicio;
	
	private String nombre;
	
	private long tipo;
	
	public ServicioSalud() {
		this.idServicio = 0;
		this.nombre = "";
		this.tipo = 0;
	}
	
	public ServicioSalud(long id, String nombre, long tipo) {
		this.idServicio = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setId(long id) {
		this.idServicio = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTipo() {
		return tipo;
	}

	public void setTipo(long tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return "ServicioSalud [id=" + idServicio + ", nombre=" + nombre + 
				", tipo de servicio=" + tipo + "]";

	}
}
