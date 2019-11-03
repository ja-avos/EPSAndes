package uniandes.isis2304.epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLConsulta {
	
	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLConsulta (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addConsulta (PersistenceManager pm, long reserva, String observacion, int prioridad,
			String receta, long tipo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableConsulta() + 
        		"(reserva, observacion, prioridad, receta, tipo) "
        		+ "values (?,?,?,?,?)");
        q.setParameters(reserva, observacion, prioridad, receta, tipo);
        return (long) q.executeUnique();
	}
}
