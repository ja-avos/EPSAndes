package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

public interface VOOrden {

	public long getCodigo();
	
	public Date getFecha();
	
	public boolean isValido();
	
	public String toString();
}
