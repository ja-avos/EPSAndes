package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;
import java.sql.Timestamp;

public interface VOAfiliado {

	public long getIdAfiliado();
	
	public Timestamp getFechaNacimiento();
	
	public long getUsuario();
	
	public String toString();
}
