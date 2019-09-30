package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.epsAndes.persistencia.PersistenciaEPSAndes;

public class EPSAndes {

	private static Logger log = Logger.getLogger(EPSAndes.class.getName());
	
	private PersistenciaEPSAndes pp;
	
	public EPSAndes ()
	{
		pp = PersistenciaEPSAndes.getInstance ();
	}
	
	public EPSAndes (JsonObject tableConfig)
	{
		pp = PersistenciaEPSAndes.getInstance (tableConfig);
	}
	
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	public Rol addRol (String rol)
	{
        log.info ("Adicionando Rol: " + rol);
        Rol nuevoRol = pp.addRol (rol);		
        log.info ("Adicionando Rol: " + nuevoRol);
        return nuevoRol;
	}
	
	public Usuario addUsuario (String nombre, String correo, long id,
			long tipoID, long rol)
	{
		log.info("Adicionando usuario: " + nombre);
		Usuario nuevoUsuario = pp.addUsuario(nombre, correo, id, tipoID, rol);
		log.info("Adicionando usuario: " + nuevoUsuario);
		return nuevoUsuario;
	}
	
	public Medico addMedico (long registroMedico, String especialidad, long usuario)
	{
		log.info("Adicionando medico: " + usuario);
		Medico nuevoMedico = pp.addMedico(registroMedico, especialidad, usuario);
		log.info("Adicionando medico: " + nuevoMedico);
		return nuevoMedico;
	}
	
	public Afiliado addAfiliado (Date fechaNacimiento, long usuario)
	{
		log.info("Adicionando afiliado: " + usuario);
		Afiliado nuevoAfiliado = pp.addAfiliado(fechaNacimiento, usuario);
		log.info("Adicionando afiliado: " + nuevoAfiliado);
		return nuevoAfiliado;
	}
	
	public Recepcionista addRecepcionista (long usuario, long IPS)
	{
		log.info("Adicionando recepcionista: " + usuario);
		Recepcionista nuevoRecepcionista = pp.addRecepcionista(usuario, IPS);
		log.info("Adicionando afiliado: " + nuevoRecepcionista);
		return nuevoRecepcionista;
	}
	
	public long [] limpiarEPS ()
	{
        log.info ("Limpiando la BD de EPSAndes");
        long [] muertos = pp.limpiarEPS();	
        log.info ("Limpiando la BD de EPSAndes: Listo!");
        return muertos;
	}
}
