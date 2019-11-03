package uniandes.isis2304.epsAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Horario;
import uniandes.isis2304.epsAndes.negocio.Rol;

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
}
