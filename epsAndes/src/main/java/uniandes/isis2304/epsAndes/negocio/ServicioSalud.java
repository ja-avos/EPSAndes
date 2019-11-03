package uniandes.isis2304.epsAndes.negocio;

public class ServicioSalud implements VOServicioSalud{
	
	private long id_Servicio;
	
	private String nombre;
	
	private long tipo;
	
	public ServicioSalud() {
		this.id_Servicio = 0;
		this.nombre = "";
		this.tipo = 0;
	}
	
	public ServicioSalud(long id, String nombre, long tipo) {
		this.id_Servicio = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public long getIdServicio() {
		return id_Servicio;
	}

	public void setId(long id) {
		this.id_Servicio = id;
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
		return "ServicioSalud [id=" + id_Servicio + ", nombre=" + nombre + 
				", tipo de servicio=" + tipo + "]";

	}
}
