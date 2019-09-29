package uniandes.isis2304.epsAndes.negocio;

public class Procedimiento implements VOProcedimiento{
	
	private long reserva;
	
	private String descripcion;
	
	public Procedimiento() {
		this.reserva = 0;
		this.descripcion = "";
	}
	
	public Procedimiento(long reserva, String descripcion) {
		this.reserva = reserva;
		this.descripcion = descripcion;
	}

	public long getReserva() {
		return reserva;
	}

	public void setReserva(long reserva) {
		this.reserva = reserva;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString() {
		return "Procedimiento [reserva=" + reserva + ", descripcion=" + descripcion + "]";
	}
}
