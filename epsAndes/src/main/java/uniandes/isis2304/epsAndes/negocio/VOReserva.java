package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

public interface VOReserva {

	public long getCodigo();
	
	public boolean isServicioPrestado();
	
	public Date getFecha();
	
	public long getHorario();
	
	public long getAfiliado();
	
	public long getOrden();
	
	public String toString();
}
