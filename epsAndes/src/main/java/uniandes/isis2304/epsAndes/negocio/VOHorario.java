package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

public interface VOHorario {

	public long getIdHorario();
	
	public long getIPS();
	
	public long getServicio();
	
	public int getCapacidad();
	
	public int getDia();
	
	public Date getHoraInicio();
	
	public Date getHoraFin();
	
	public String toString();
}
