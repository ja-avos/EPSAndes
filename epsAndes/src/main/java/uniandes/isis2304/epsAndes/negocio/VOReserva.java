package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public interface VOReserva {

	public long getCodigo();
	
	public boolean isServicioPrestado();
	
	public Timestamp getFecha();
	
	public long getHorario();
	
	public long getAfiliado();
	
	public long getOrden();
	
	public String toString();
}
