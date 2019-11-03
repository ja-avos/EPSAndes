package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public interface VOOrden {

	public long getCodigo();
	
	public Timestamp getFecha();
	
	public boolean isValido();
	
	public long getMedicoRemitente();
	
	public long getServicio();
	
	public long getAfiliado();
	
	public String toString();
}
