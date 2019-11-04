package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public interface VOReserva {

	public long getCodigo();
	
	public boolean isServicio_Prestado();
	
	public Timestamp getFecha();
	
	public long getHorario();
	
	public long getAfiliado();
	
	public long getOrden();
	
	public long getCampana();
	
	public String toString();
}
