package uniandes.isis2304.epsAndes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Reserva;
import uniandes.isis2304.epsAndes.negocio.Rol;

public class SQLReserva {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLReserva (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addReserva (PersistenceManager pm, long codigo, int servicioPrestado,
			Timestamp fecha, long horario, long afiliado, long orden, long campana) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableReserva() + 
        		"(codigo, servicio_prestado, fecha, horario, afiliado, orden, campana) "
        		+ "values (?,?,?,?,?,?,?)");
        q.setParameters(codigo, servicioPrestado, fecha, horario, afiliado, orden, campana);
        return (long) q.executeUnique();
	}
	
	public long prestarServicio (PersistenceManager pm, long codigo)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + pe.getTableReserva() + 
        		" SET servicio_prestado = 1 WHERE codigo = ?");
        q.setParameters(codigo);
        return (long) q.executeUnique();
	}
	
	public List<Reserva> getReservaByServicioPrestado (PersistenceManager pm, 
			int servicioPrestado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableReserva() + 
				" WHERE servicio_Prestado = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(servicioPrestado);
		return (List<Reserva>) q.executeList();
	}
	
	public long getCantidadReservas (PersistenceManager pm, Timestamp fecha,
			long idHorario)
	{
		String sql = "";
		sql += "SELECT COUNT (codigo)";
		sql += " FROM " + pe.getTableReserva();
		sql += " WHERE fecha = ? AND horario = ?";
		Query q = pm.newQuery(SQL, sql);
		q.setParameters(fecha, idHorario);
		return ((BigDecimal) q.executeUnique()).longValue ();
	}
	
	public long setOrden (PersistenceManager pm, long codigo, long orden)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pe.getTableReserva() + " SET orden = ? WHERE codigo = ?");
	     q.setParameters(orden, codigo);
	     return (long) q.executeUnique();
	}
	
	public long deleteReservaCamapana (PersistenceManager pm, long campana, long servicio) {
		String sql = "";
		sql += "DELETE " + pe.getTableReserva() ;
		sql += " FROM " + pe.getTableReserva();
		sql += " INNER JOIN " + pe.getTableHorario();
		sql += " ON horario = id_horario";
		sql += " WHERE servicio = ? AND campana = ?";
		Query q = pm.newQuery(SQL, sql);
        q.setParameters(servicio, campana);
        return (long) q.executeUnique();
	}
	
	public long deleteReservasCamapana (PersistenceManager pm, long campana) {
		String sql = "";
		sql += "DELETE " + pe.getTableReserva() ;
		sql += " FROM " + pe.getTableReserva();
		sql += " INNER JOIN " + pe.getTableHorario();
		sql += " ON horario = id_horario";
		sql += " WHERE campana = ?";
		Query q = pm.newQuery(SQL, sql);
        q.setParameters(campana);
        return (long) q.executeUnique();
	}
	
	public long deleteReservasFechas (PersistenceManager pm, Timestamp fecha_inicio,
			Timestamp fecha_fin, long servicio, long ips) {
		String sql = "";
		sql += "DELETE " + pe.getTableReserva() ;
		sql += " FROM " + pe.getTableReserva();
		sql += " INNER JOIN " + pe.getTableHorario();
		sql += " ON horario = id_horario";
		sql += " WHERE servicio = ? AND ips = ? AND fecha BETWEEN ? AND ?";
		Query q = pm.newQuery(SQL, sql);
        q.setParameters(servicio, ips, fecha_inicio, fecha_fin);
        return (long) q.executeUnique();
	}
	
	public List<Reserva> getReservasFechas (PersistenceManager pm, Timestamp fecha_inicio,
			Timestamp fecha_fin, long servicio, long ips) {
		String sql = "";
		sql += "SELECT " + pe.getTableReserva() + ".*";
		sql += " FROM " + pe.getTableReserva();
		sql += " INNER JOIN " + pe.getTableHorario();
		sql += " ON horario = id_horario";
		sql += " WHERE servicio = ? AND ips = ? AND fecha BETWEEN ? AND ?";
		Query q = pm.newQuery(SQL, sql);
        q.setParameters(servicio, ips, fecha_inicio, fecha_fin);
        q.setResultClass(Reserva.class);
        return (List<Reserva>) q.executeList();
	}
	
	public long setAfiliado (PersistenceManager pm, long codigo, long afiliado)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pe.getTableReserva() + " SET afiliado = ? WHERE codigo = ?");
	     q.setParameters(afiliado, codigo);
	     return (long) q.executeUnique();
	}
	
	public Reserva getReservaById (PersistenceManager pm, long codigo) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableReserva() + 
				" WHERE codigo = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(codigo);
		return (Reserva) q.executeUnique();
	}
}
