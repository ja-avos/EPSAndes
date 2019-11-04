package uniandes.isis2304.epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLParticipan {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLParticipan (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addParticipan (PersistenceManager pm, long id_afiliado, long id_campana) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableParticipan() + 
        		"(id_afiliado, id_campana) values (?,?)");
        q.setParameters(id_afiliado, id_campana);
        return (long) q.executeUnique();
	}
}
