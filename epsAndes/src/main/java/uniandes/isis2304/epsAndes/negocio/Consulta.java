package uniandes.isis2304.epsAndes.negocio;

public class Consulta implements VOConsulta{
	
	private long reserva;
	
	private String observacion;
	
	private int prioridad;
	
	private String receta;
	
	private long tipo;
	
	public Consulta() {
		this.reserva = 0;
		this.observacion = "";
		this.prioridad = 0;
		this.receta = "";
		this.tipo = 0;
	}
	
	public Consulta(long reserva, String observacion, int prioridad, 
			String receta, long tipo) {
		this.reserva = reserva;
		this.observacion = observacion;
		this.prioridad = prioridad;
		this.receta = receta;
		this.tipo = tipo;
	}

	public long getReserva() {
		return reserva;
	}

	public void setReserva(long reserva) {
		this.reserva = reserva;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public long getTipo() {
		return tipo;
	}

	public void setTipo(long tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return "Consulta [reserva=" + reserva + ", observacion=" + observacion +
				", prioridad=" + prioridad + ", receta=" + receta + 
				", tipo=" + tipo + "]";
	}
}
