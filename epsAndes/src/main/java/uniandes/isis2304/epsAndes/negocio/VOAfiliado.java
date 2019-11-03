package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;
import java.sql.Timestamp;

public interface VOAfiliado {

	public long getId_Afiliado();
	
	public Timestamp getFecha_Nacimiento();
	
	public long getUsuario();
	
	public String toString();
}
