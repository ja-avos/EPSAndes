package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public interface VOHospitalizacion {

	public long getReserva();
	
	public Timestamp getFechaSalida();
	
	public String getObservacion();
	
	public String toString();
}
