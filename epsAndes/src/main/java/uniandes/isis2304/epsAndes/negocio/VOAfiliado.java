package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

public interface VOAfiliado {

	public long getIdAfiliado();
	
	public Date getFechaNacimiento();
	
	public long getUsuario();
	
	public String toString();
}
