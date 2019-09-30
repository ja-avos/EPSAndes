package uniandes.isis2304.epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.IPS;
import uniandes.isis2304.epsAndes.negocio.Rol;

public class SQLIps {
	
	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLIps (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addIps (PersistenceManager pm, long id, String localizacion, String nombre) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableIPS() + "(id, localizacion, nombre) "
        		+ "values (?, ?,?)");
        q.setParameters(id, localizacion, nombre);
        return (long) q.executeUnique();
	}
	
	public List<IPS> getIpss (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableIPS());
		q.setResultClass(Rol.class);
		return (List<IPS>) q.executeList();
	}
}
