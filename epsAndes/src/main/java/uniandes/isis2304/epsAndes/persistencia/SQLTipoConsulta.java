package uniandes.isis2304.epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Rol;
import uniandes.isis2304.epsAndes.negocio.TipoConsulta;
import uniandes.isis2304.epsAndes.negocio.TipoID;

public class SQLTipoConsulta {

private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLTipoConsulta (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addTipoConsulta (PersistenceManager pm, long idTipo, String nombre) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableTipoConsulta() + 
        		"(id_Tipo, nombre) values (?,?)");
        q.setParameters(idTipo, nombre);
        return (long) q.executeUnique();
	}
	
	public List<TipoConsulta> getTiposConsulta (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableTipoConsulta());
		q.setResultClass(TipoConsulta.class);
		return (List<TipoConsulta>) q.executeList();
	}
	
	public List<TipoConsulta> getTipoConsultaByName(PersistenceManager pm, String name)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableTipoConsulta() +
				" WHERE NOMBRE = ?");
		q.setParameters(name);
		q.setResultClass(TipoConsulta.class);
		return (List<TipoConsulta>) q.executeList();
	}
	
	public long eliminarPorId(PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pe.getTableTipoConsulta() + 
				" WHERE ID_TIPO = ?");
		q.setParameters(id);
		return (long) q.executeUnique();
	}
}
