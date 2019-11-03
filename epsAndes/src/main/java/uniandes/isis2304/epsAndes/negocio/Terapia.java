package uniandes.isis2304.epsAndes.negocio;

public class Terapia implements VOTerapia{
	
	private long reserva;
	
	private int numero_Sesiones;
	
	public Terapia() {
		this.reserva = 0;
		this.numero_Sesiones = 0;
	}
	
	public Terapia(long reserva, int numeroSesiones) {
		this.reserva = reserva;
		this.numero_Sesiones = numeroSesiones;
	}

	public long getReserva() {
		return reserva;
	}

	public void setReserva(long reserva) {
		this.reserva = reserva;
	}
	
	public int getNumero_Sesiones() {
		return numero_Sesiones;
	}

	public void setNumero_Sesiones(int numero_Sesiones) {
		this.numero_Sesiones = numero_Sesiones;
	}

	public String toString() {
		return "Terapia [reserva=" + reserva + ", numeroSesiones=" + numero_Sesiones + "]";
	}
}
