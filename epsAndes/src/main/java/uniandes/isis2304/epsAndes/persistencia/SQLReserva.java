package uniandes.isis2304.epsAndes.persistencia;

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
			Timestamp fecha, long horario, long afiliado, long orden) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableReserva() + 
        		"(codigo, servicio_prestado, fecha, horario, afiliado, orden) "
        		+ "values (?,?,?,?,?,?)");
        q.setParameters(codigo, servicioPrestado, fecha, horario, afiliado, orden);
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
}
