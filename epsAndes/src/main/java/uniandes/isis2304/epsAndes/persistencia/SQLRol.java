package uniandes.isis2304.epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Rol;

class SQLRol {
	
	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLRol (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addRol (PersistenceManager pm, String rol) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableRol () + "(rol) values (?)");
        q.setParameters(rol);
        return (long) q.executeUnique();
	}
	
	public List<Rol> getRoles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableRol());
		q.setResultClass(Rol.class);
		return (List<Rol>) q.executeList();
	}
}
