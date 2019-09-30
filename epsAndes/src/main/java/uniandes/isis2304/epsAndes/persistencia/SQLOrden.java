package uniandes.isis2304.epsAndes.persistencia;

import java.sql.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLOrden {
	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLOrden(PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addOrden (PersistenceManager pm, long codigo, Date fecha, int valido,
			long medicoRemitente, long servicio, long afiliado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableOrden() + 
        		"(codigo, fecha, valido, medicoRemitente, servicio, afiliado)"
        		+ " values (?,?,?,?,?,?)");
        q.setParameters(codigo, fecha, valido, medicoRemitente, servicio, afiliado);
        return (long) q.executeUnique();
	}
	
	public long invalidarOrden (PersistenceManager pm, long codigo)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + pe.getTableOrden() + 
        		" SET valido = 0 WHERE codigo = ?");
        q.setParameters(codigo);
        return (long) q.executeUnique();
	}
}
