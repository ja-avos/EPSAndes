package uniandes.isis2304.epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLExamenDiagnostico {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLExamenDiagnostico (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addExamenDiagnostico (PersistenceManager pm, long reserva, String diagnostico) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableExamenDiagnostico() + 
        		"(reserva, diagnostico) "
        		+ "values (?,?)");
        q.setParameters(reserva, diagnostico);
        return (long) q.executeUnique();
	}
}
