package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public interface VOHorario {

	public long getId_Horario();
	
	public long getIPS();
	
	public long getServicio();
	
	public long getCapacidad();
	
	public long getDia();
	
	public Timestamp getHora_Inicio();
	
	public Timestamp getHora_Fin();
	
	public long getDeshabilitado();
	
	public String toString();
}
