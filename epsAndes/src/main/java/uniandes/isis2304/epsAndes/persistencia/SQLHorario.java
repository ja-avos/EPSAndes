package uniandes.isis2304.epsAndes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Horario;
import uniandes.isis2304.epsAndes.negocio.Rol;
import uniandes.isis2304.epsAndes.negocio.Usuario;

public class SQLHorario {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLHorario (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addHorario (PersistenceManager pm, long idHorario, long IPS,
			long servicio, int capacidad, int dia, Timestamp horaInicio,
			Timestamp horaFin) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableHorario() + 
        		"(id_Horario, ips, servicio, capacidad, dia, hora_inicio, hora_fin) "
        		+ "values (?,?,?,?,?,?,?)");
        q.setParameters(idHorario, IPS, servicio, capacidad, dia, horaInicio, horaFin);
        return (long) q.executeUnique();
	}
	
	public List<Horario> getHorarioByServicio (PersistenceManager pm, long servicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableHorario() + 
				" WHERE servicio = ?");
		q.setResultClass(Horario.class);
		q.setParameters(servicio);
		return (List<Horario>) q.executeList();
	}
	
	public List<Horario> getHorariosByIPS (PersistenceManager pm, long ips)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableHorario() + 
				" WHERE ips = ?");
		q.setResultClass(Horario.class);
		q.setParameters(ips);
		return (List<Horario>) q.executeList();
	}
	
	public List<Horario> getHorarios (PersistenceManager pm, int dia,
			long idServicio) 
	{
		String sql = "";
		sql += "SELECT *";
		sql += " FROM " + pe.getTableHorario();
		sql += " WHERE dia = ? AND servicio = ? AND deshabilitado IS NULL";
		Query q = pm.newQuery(SQL, sql);
		q.setParameters(dia, idServicio);
		q.setResultClass(Horario.class);
		return (List<Horario>) q.executeList();
	}
	
	public long getCapacidad (PersistenceManager pm, long idHorario) 
	{
		String sql = "";
		sql += "SELECT capacidad";
		sql += " FROM " + pe.getTableHorario();
		sql += " WHERE id_horario = ?";
		Query q = pm.newQuery(SQL, sql);
		q.setParameters(idHorario);
		return ((BigDecimal) q.executeUnique()).longValue ();
	}
	
	public List<Horario> getHorariosPorTipoServicio(PersistenceManager pm, long tipo_servicio)
	{
		String sql = "";
		sql += " SELECT id_horario, ips, servicio, capacidad, dia, hora_inicio, hora_fin, deshabilitado";
		sql += " FROM " + pe.getTableHorario();
		sql += " INNER JOIN " + pe.getTableServicioSalud();
		sql += " ON servicio = id_servicio";
		sql += " WHERE tipo = ?";
		Query q = pm.newQuery(SQL, sql);
		q.setParameters(tipo_servicio);
		q.setResultClass(Horario.class);
		return (List<Horario>) q.executeList();
	}
	
	public long habilitar(PersistenceManager pm, long servicio, long ips) {
		Query q = pm.newQuery(SQL, "UPDATE " + pe.getTableHorario() + " SET deshabilitado = null WHERE servicio = ?");
	     q.setParameters(servicio);
	     return (long) q.executeUnique();
	}
	
	public long deshabilitar(PersistenceManager pm, long servicio, long ips, long deshabilitado) {
		Query q = pm.newQuery(SQL, "UPDATE " + pe.getTableHorario() + " SET deshabilitado = ? WHERE servicio = ?");
	     q.setParameters(deshabilitado, servicio);
	     return (long) q.executeUnique();
	}
	
	public long isDeshabilitado(PersistenceManager pm, long servicio, long ips) {
		String sql = "";
		sql += "SELECT deshabilitado";
		sql += " FROM " + pe.getTableHorario();
		sql += " WHERE servicio = ? AND ips = ?";
		Query q = pm.newQuery(SQL, sql);
		q.setParameters(servicio, ips);
		return ((BigDecimal) q.executeUnique()).longValue ();
	}
}
