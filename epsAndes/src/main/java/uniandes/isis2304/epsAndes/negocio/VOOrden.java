package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

public interface VOOrden {

	public long getCodigo();
	
	public Date getFecha();
	
	public boolean isValido();
	
	public long getMedicoRemitente();
	
	public long getServicio();
	
	public long getAfiliado();
	
	public String toString();
}
