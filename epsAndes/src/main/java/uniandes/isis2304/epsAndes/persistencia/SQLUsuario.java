package uniandes.isis2304.epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.epsAndes.negocio.Usuario;

public class SQLUsuario {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLUsuario (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long addUsuario (PersistenceManager pm, long idUsuario, String nombre, String correo,
			long id, long tipoId, long rol)
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pe.getTableUsuario() + 
        		"(id_Usuario, nombre, correo,"
        		+ "id, tipo_Id, rol) values (?,?,?,?,?,?)");
        q.setParameters(idUsuario, nombre, correo, id, tipoId, rol);
        return (long) q.executeUnique();
	}
	
	public List<Usuario> findUsuarioByRol (PersistenceManager pm, long rol) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableUsuario() + " WHERE rol = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(rol);
		return (List<Usuario>) q.executeList();
	}
	
	public Usuario getUsuarioByID (PersistenceManager pm, long idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pe.getTableUsuario() + 
				" WHERE idUsuario = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(idUsuario);
		return (Usuario) q.executeUnique();
	}
}
