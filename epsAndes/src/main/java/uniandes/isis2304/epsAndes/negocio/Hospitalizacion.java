package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

public class Hospitalizacion implements VOHospitalizacion{

	private long reserva;
	
	private Date fechaSalida;
	
	private String observacion;
	
	public Hospitalizacion() {
		this.reserva = 0;
		this.fechaSalida = new Date(0);
		this.observacion = "";
	}
	
	public Hospitalizacion(long reserva, Date fechaSalida, String observacion) {
		this.reserva = reserva;
		this.fechaSalida = fechaSalida;
		this.observacion = observacion;
	}

	public long getReserva() {
		return reserva;
	}

	public void setReserva(long reserva) {
		this.reserva = reserva;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public String toString() {
		return "Hospitalizacion [reserva=" + reserva + ", fechaSalida=" +
				fechaSalida.toString() + ", observacion=" + observacion + "]";
	}
}
