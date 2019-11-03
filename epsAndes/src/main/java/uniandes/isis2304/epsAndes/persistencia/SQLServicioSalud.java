package uniandes.isis2304.epsAndes.persistencia;

import java.sql.Timestamp;
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
	
	public List<Object> dar20MasSolicitados (PersistenceManager pm,
			Timestamp fechaInicio, Timestamp fechaFin)
	{
		String sql = "SELECT * FROM (";
		sql += "	SELECT id_servicio, nombre, tipo";
	    sql += " 		FROM " + pe.getTableReserva();
	    sql += " 		INNER JOIN " + pe.getTableHorario() + " ON horario = id_horario";
	    sql += " 		RIGHT OUTER JOIN " + pe.getTableServicioSalud() + " ON servicio = id_servicio";
	    sql += " 	WHERE fecha BETWEEN ? AND ?";
	    sql	+= " 	GROUP BY id_servicio, nombre, tipo";
	    sql	+= " 	ORDER BY COUNT(*))";
	    sql	+= " WHERE ROWNUM < 21;";
		
	    Query q = pm.newQuery(SQL, sql);
	    q.setParameters(fechaInicio, fechaFin);
		return q.executeList();
	}
	
	public ServicioSalud getServicioSaludById (PersistenceManager pm, long id)
	{
		String sql = "SELECT *";
		sql += " FROM " + pe.getTableServicioSalud();
		sql += " WHERE id_servicio = ?";
		Query q = pm.newQuery(SQL, sql);
	    q.setParameters(id);
	    return (ServicioSalud) q.executeUnique(); 
	}
}
