package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

public interface VOHospitalizacion {

	public long getReserva();
	
	public Date getFechaSalida();
	
	public String getObservacion();
	
	public String toString();
}
