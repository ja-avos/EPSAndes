package uniandes.isis2304.epsAndes.negocio;

public class ExamenDiagnostico implements VOExamenDiagnostico{
	
	private long reserva;
	
	private String diagnostico;
	
	public ExamenDiagnostico() {
		this.reserva = 0;
		this.diagnostico = "";
	}
	
	public ExamenDiagnostico(long reserva, String diagnostico) {
		this.reserva = reserva;
		this.diagnostico = diagnostico;
	}

	public long getReserva() {
		return reserva;
	}

	public void setReserva(long reserva) {
		this.reserva = reserva;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public String toString() {
		return "ExamenDiagnostico [reserva=" + reserva + ", diagnostico =" +
				diagnostico +"]";
	}
}
