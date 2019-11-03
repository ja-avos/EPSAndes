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
	
	public List<Horario> getHorarios (PersistenceManager pm, int dia,
			long idServicio) 
	{
		String sql = "";
		sql += "SELECT *";
		sql += " FROM " + pe.getTableHorario();
		sql += " WHERE dia = ? AND servicio = ?";
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
}
