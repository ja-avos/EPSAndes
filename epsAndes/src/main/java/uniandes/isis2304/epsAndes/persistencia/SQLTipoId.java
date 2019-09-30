package uniandes.isis2304.epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Rol;
import uniandes.isis2304.epsAndes.negocio.TipoID;

public class SQLTipoId {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLTipoId (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addTipoId (PersistenceManager pm, long idTipo, String nombre) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableTipoID() + 
        		"(id_Tipo, nombre) values (?,?)");
        q.setParameters(idTipo, nombre);
        return (long) q.executeUnique();
	}
	
	public List<TipoID> getTipoId (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableTipoID());
		q.setResultClass(Rol.class);
		return (List<TipoID>) q.executeList();
	}
}
