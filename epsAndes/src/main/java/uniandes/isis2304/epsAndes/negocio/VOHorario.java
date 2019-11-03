package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public interface VOHorario {

	public long getIdHorario();
	
	public long getIPS();
	
	public long getServicio();
	
	public int getCapacidad();
	
	public int getDia();
	
	public Timestamp getHoraInicio();
	
	public Timestamp getHoraFin();
	
	public String toString();
}
