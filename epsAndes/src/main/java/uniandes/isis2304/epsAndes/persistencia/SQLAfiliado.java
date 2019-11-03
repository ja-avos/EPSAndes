package uniandes.isis2304.epsAndes.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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
}
