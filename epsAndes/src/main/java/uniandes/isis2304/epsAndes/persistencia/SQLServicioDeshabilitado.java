package uniandes.isis2304.epsAndes.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.IPS;
import uniandes.isis2304.epsAndes.negocio.ServicioDeshabilitado;

public class SQLServicioDeshabilitado {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLServicioDeshabilitado (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addServicioDeshabilitado (PersistenceManager pm, Timestamp fecha_inicio,
			Timestamp fecha_fin, long id) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableServicioDeshabilitado() + 
        		"(id, fecha_inicio, fecha_fin) "
        		+ "values (?,?,?)");
        q.setParameters(id, fecha_inicio, fecha_fin);
        return (long) q.executeUnique();
	}
	
	public ServicioDeshabilitado findServicioDeshabilitado (PersistenceManager pm,
			Timestamp fecha_inicio, Timestamp fecha_fin) {
		String sql = "SELECT *";
		sql += " FROM " + pe.getTableServicioDeshabilitado();
		sql += " WHERE fecha_inicio = ? AND fecha_fin = ?";
		Query q = pm.newQuery(SQL, sql);
		q.setParameters(fecha_inicio, fecha_fin);
		q.setResultClass(ServicioDeshabilitado.class);
		return (ServicioDeshabilitado) q.executeUnique();
	}
}
