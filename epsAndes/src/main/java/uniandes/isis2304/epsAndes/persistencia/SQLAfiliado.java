package uniandes.isis2304.epsAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Afiliado;

class SQLAfiliado {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLAfiliado (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addAfiliado (PersistenceManager pm, long idAfiliado, Timestamp fechaNacimiento,
			long usuario) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableAfiliado() + 
        		"(id_Afiliado, fecha_Nacimiento, usuario) values (?,?,?)");
        q.setParameters(idAfiliado, fechaNacimiento, usuario);
        return (long) q.executeUnique();
	}
	
	public void deleteAfiliado(PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pe.getTableAfiliado() +
				" WHERE ID_AFILIADO = ?");
		q.setParameters(id);
		q.executeUnique();
	}
	
	public List<Object[]> afiliadosExigentes (PersistenceManager pm, Timestamp fechaInicio,
			Timestamp fechaFin) {
		String sql = "SELECT afiliado, COUNT(*), COUNT (DISTINCT tipo)";
		sql += " FROM " + pe.getTableReserva();
		sql += "   INNER JOIN " + pe.getTableHorario();
		sql += "   ON horario = id_horario";
		sql += "   INNER JOIN" + pe.getTableServicioSalud();
		sql += "   ON servicio = id_servicio";
		sql += " WHERE fecha BETWEEN ? AND ?";
		sql += " GROUP BY afiliado";
		sql += " HAVING COUNT(*) > 12 AND COUNT (DISNTINCT tipo) > 3";
		
		Query q = pm.newQuery(SQL, sql);
		q.setParameters(fechaInicio, fechaFin);
		return q.executeList();
	}
	
	public List<Afiliado> getAfiliados(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableAfiliado());
		q.setResultClass(Afiliado.class);
		return (List<Afiliado>) q.executeList();
	}
}
