package uniandes.isis2304.epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Rol;
import uniandes.isis2304.epsAndes.negocio.TipoServicio;

public class SQLTipoServicio {
	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLTipoServicio (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addTipoServicio (PersistenceManager pm, long idServicio, String nombre) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableTipoServicio() + 
        		"(id_Servicio, nombre) values (?,?)");
        q.setParameters(idServicio, nombre);
        return (long) q.executeUnique();
	}
	
	public List<TipoServicio> getTipoServicioByName (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableTipoServicio () 
		+ " WHERE nombre = ?");
		q.setResultClass(TipoServicio.class);
		q.setParameters(nombre);
		return (List<TipoServicio>) q.executeList();
	}
	
	public List<TipoServicio> getTiposServicio (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableTipoServicio());
		q.setResultClass(TipoServicio.class);
		return (List<TipoServicio>) q.executeList();
	}
}
