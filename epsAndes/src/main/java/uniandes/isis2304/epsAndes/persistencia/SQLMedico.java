package uniandes.isis2304.epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLMedico {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLMedico (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addMedico (PersistenceManager pm, long idMedico, long registroMedico,
			String especialidad, long usuario) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableMedico() + 
        		"(id_Medico, registro_Medico, especialidad, usuario) "
        		+ "values (?,?,?,?)");
        q.setParameters(idMedico, registroMedico, especialidad, usuario);
        return (long) q.executeUnique();
	}
}
