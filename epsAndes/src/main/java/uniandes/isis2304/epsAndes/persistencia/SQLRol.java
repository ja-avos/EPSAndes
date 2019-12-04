package uniandes.isis2304.epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Rol;
import uniandes.isis2304.epsAndes.negocio.VORol;

class SQLRol {
	
	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLRol (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addRol (PersistenceManager pm, long idRol, String rol) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableRol () + 
        		"(id_Rol, rol) values (?,?)");
        q.setParameters(idRol, rol);
        return (long) q.executeUnique();
	}
	
	public List<Rol> getRoles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableRol());
		q.setResultClass(Rol.class);
		return (List<Rol>) q.executeList();
	}
	
	public Rol getRolByID(PersistenceManager pm, Long id)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableRol() + " WHERE ID_ROL = ?");
		q.setResultClass(Rol.class);
		q.setParameters(id);
		return (Rol) q.executeUnique();
	}
	
	public List<Rol> getRolesByName (PersistenceManager pm, String rol) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableRol() + 
				" WHERE rol = ?");
		q.setResultClass(Rol.class);
		q.setParameters(rol);
		return (List<Rol>) q.executeList();
	}
	
	public long eliminarPorId(PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pe.getTableRol() + 
				" WHERE ID_ROL = ?");
		q.setParameters(id);
		return (long) q.executeUnique();
	}
}
