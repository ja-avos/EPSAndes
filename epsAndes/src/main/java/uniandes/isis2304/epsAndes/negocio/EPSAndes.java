package uniandes.isis2304.epsAndes.negocio;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.epsAndes.persistencia.PersistenciaEPSAndes;
import uniandes.isis2304.parranderos.negocio.TipoBebida;

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
        log.info ("Adicionando Tipo de bebida: " + rol);
        Rol nuevoRol = pp.addRol (rol);		
        log.info ("Adicionando Tipo de bebida: " + nuevoRol);
        return nuevoRol;
	}
	
	public long [] limpiarEPS ()
	{
        log.info ("Limpiando la BD de EPSAndes");
        long [] muertos = pp.limpiarEPS();	
        log.info ("Limpiando la BD de EPSAndes: Listo!");
        return muertos;
	}
}
