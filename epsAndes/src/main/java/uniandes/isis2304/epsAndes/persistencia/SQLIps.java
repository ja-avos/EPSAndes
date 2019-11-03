package uniandes.isis2304.epsAndes.persistencia;

import java.sql.Timestamp;
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
		q.setResultClass(IPS.class);
		return (List<IPS>) q.executeList();
	}
	
	public IPS getIPSById (PersistenceManager pm, long id)
	{
		String sql = "SELECT * ";
		sql += "FROM " + pe.getTableIPS();
		sql += "WHERE id_ips = ?";
		Query q = pm.newQuery(SQL, sql);
		q.setParameters(id);
		q.setResultClass(IPS.class);
		return (IPS) q.executeList();
	}
	
	public List<Object> darCantidadServiciosPrestadosPorIPS (PersistenceManager pm,
			Timestamp fechaInicio, Timestamp fechaFin)
	{
	    String sql = "SELECT id, localizacion, nombre, count (distinct servicio) as servicios_Prestados";
	    sql += " FROM " + pe.getTableReserva();
	    sql += " INNER JOIN " + pe.getTableHorario() + " ON horario = id_horario";
	    sql += " RIGHT OUTER JOIN " + pe.getTableIPS() + " ON ips = id_IPS";
	    sql += " WHERE fecha BETWEEN ? AND ?";
	    sql	+= " GROUP BY id, localizacion, nombre";
		
	    Query q = pm.newQuery(SQL, sql);
	    q.setParameters(fechaInicio, fechaFin);
		return q.executeList();
	}
}
