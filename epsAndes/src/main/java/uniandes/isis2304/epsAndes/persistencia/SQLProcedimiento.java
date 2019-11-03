package uniandes.isis2304.epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLProcedimiento {
	
private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLProcedimiento (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addProcedimiento (PersistenceManager pm, long reserva, String descripcion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableProcedimiento() + 
        		"(reserva, descripcion) "
        		+ "values (?,?)");
        q.setParameters(reserva, descripcion);
        return (long) q.executeUnique();
	}

}
