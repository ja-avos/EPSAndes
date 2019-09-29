package uniandes.isis2304.epsAndes.negocio;

public class Terapia implements VOTerapia{
	
	private long reserva;
	
	private int numeroSesiones;
	
	public Terapia() {
		this.reserva = 0;
		this.numeroSesiones = 0;
	}
	
	public Terapia(long reserva, int numeroSesiones) {
		this.reserva = reserva;
		this.numeroSesiones = numeroSesiones;
	}

	public long getReserva() {
		return reserva;
	}

	public void setReserva(long reserva) {
		this.reserva = reserva;
	}

	public int getNumeroSesiones() {
		return numeroSesiones;
	}

	public void setNumeroSesiones(int numeroSesiones) {
		this.numeroSesiones = numeroSesiones;
	}
	
	public String toString() {
		return "Terapia [reserva=" + reserva + ", numeroSesiones=" + numeroSesiones + "]";
	}
}
