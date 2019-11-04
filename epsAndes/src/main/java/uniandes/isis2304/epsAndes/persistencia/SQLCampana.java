package uniandes.isis2304.epsAndes.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLCampana {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLCampana (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addCampana (PersistenceManager pm, long id_Campana, Timestamp fecha_inicio,
			Timestamp fecha_Fin) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableCampana() + 
        		"(id_Campana, fecha_inicio, fecha_fin, cancelada) values (?,?,?,?)");
        q.setParameters(id_Campana, fecha_inicio, fecha_Fin, 0);
        return (long) q.executeUnique();
	}
	
	public long cancelCampana (PersistenceManager pm, long id_campana) {
		Query q = pm.newQuery(SQL, "UPDATE " + pe.getTableCampana() + 
				" SET cancelada = 1 WHERE id_campana = ?");
	     q.setParameters(id_campana);
	     return (long) q.executeUnique();
	}
}
