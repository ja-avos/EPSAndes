package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public class Hospitalizacion implements VOHospitalizacion{

	private long reserva;
	
	private Timestamp fecha_Salida;
	
	private String observacion;
	
	public Hospitalizacion() {
		this.reserva = 0;
		this.fecha_Salida = new Timestamp(0);
		this.observacion = "";
	}
	
	public Hospitalizacion(long reserva, Timestamp fechaSalida, String observacion) {
		this.reserva = reserva;
		this.fecha_Salida = fechaSalida;
		this.observacion = observacion;
	}

	public long getReserva() {
		return reserva;
	}

	public void setReserva(long reserva) {
		this.reserva = reserva;
	}

	public Timestamp getFecha_Salida() {
		return fecha_Salida;
	}

	public void setFecha_Salida(Timestamp fecha_Salida) {
		this.fecha_Salida = fecha_Salida;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public String toString() {
		return "Hospitalizacion [reserva=" + reserva + ", fechaSalida=" +
				fecha_Salida.toString() + ", observacion=" + observacion + "]";
	}
}
