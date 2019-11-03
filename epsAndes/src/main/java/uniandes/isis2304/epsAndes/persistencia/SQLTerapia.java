package uniandes.isis2304.epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLTerapia {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLTerapia (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addTerapia (PersistenceManager pm, long reserva, int numeroSesiones) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableTerapia() + 
        		"(reserva, numero_sesiones) "
        		+ "values (?,?)");
        q.setParameters(reserva, numeroSesiones);
        return (long) q.executeUnique();
	}
}
