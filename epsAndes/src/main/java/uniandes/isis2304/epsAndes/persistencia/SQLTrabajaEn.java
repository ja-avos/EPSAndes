package uniandes.isis2304.epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLTrabajaEn {
	
	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLTrabajaEn (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addRol (PersistenceManager pm, long ips, String medico) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableTrabajaEn() + 
        		"(ips, medico) values (?,?)");
        q.setParameters(ips, medico);
        return (long) q.executeUnique();
	}
}
