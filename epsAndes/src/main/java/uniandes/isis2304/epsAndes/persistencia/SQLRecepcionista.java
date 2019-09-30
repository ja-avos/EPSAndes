package uniandes.isis2304.epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Recepcionista;

public class SQLRecepcionista {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLRecepcionista (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addRecepcionista (PersistenceManager pm, long idRecepcionista,
			long usuario, long IPS) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableRecepcionista() +
        		"(id_Recepcionista, usuario, ips) values (?,?,?)");
        q.setParameters(idRecepcionista, usuario, IPS);
        return (long) q.executeUnique();
	}
	
	public Recepcionista getRecepcionistaByID (PersistenceManager pm, long idRecepcionista) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableRecepcionista() +
				" WHERE idRecepcionista = ?");
		q.setResultClass(Recepcionista.class);
		q.setParameters(idRecepcionista);
		return (Recepcionista) q.executeUnique();
	}
}
