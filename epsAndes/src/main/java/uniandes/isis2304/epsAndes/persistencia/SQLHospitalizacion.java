package uniandes.isis2304.epsAndes.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLHospitalizacion {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLHospitalizacion (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addHospitalizacion (PersistenceManager pm, long reserva, Timestamp fechaSalida,
			String observacion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableHospitalizacion() + 
        		"(reserva, fecha_salida, observacion) "
        		+ "values (?,?,?)");
        q.setParameters(reserva, fechaSalida, observacion);
        return (long) q.executeUnique();
	}
}
