package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public interface VOCampana {

	public long getId_campana();
	
	public Timestamp getFecha_inicio();
	
	public Timestamp getFecha_fin();
	
	public boolean isCancelada();
}
