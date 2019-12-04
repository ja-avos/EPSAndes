package uniandes.isis2304.epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Medico;
import uniandes.isis2304.epsAndes.negocio.Usuario;

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
	
	public void deleteMedico(PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pe.getTableMedico() +
				" WHERE ID_MEDICO = ?");
		q.setParameters(id);
		q.executeUnique();
	}
	
	public List<Medico> getMedicos(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableMedico());
		q.setResultClass(Medico.class);
		return (List<Medico>) q.executeList();
	}
}
