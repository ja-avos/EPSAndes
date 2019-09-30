package uniandes.isis2304.epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Rol;
import uniandes.isis2304.epsAndes.negocio.ServicioSalud;

public class SQLServicioSalud {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLServicioSalud (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addServicioSalud (PersistenceManager pm, long idServicio, String nombre,
			long tipo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableServicioSalud() + 
        		"(id_Servicio, nombre, tipo) values (?,?)");
        q.setParameters(idServicio, nombre, tipo);
        return (long) q.executeUnique();
	}
	
	public List<ServicioSalud> getServiciosSalud (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableServicioSalud());
		q.setResultClass(ServicioSalud.class);
		return (List<ServicioSalud>) q.executeList();
	}
}
