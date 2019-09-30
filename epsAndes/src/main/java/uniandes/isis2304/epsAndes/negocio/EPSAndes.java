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
	
	public TipoID addTipoID (String nombre)
	{
        log.info ("Adicionando tipoID: " + nombre);
        TipoID nuevoTipo = pp.addTipoID(nombre);	
        log.info ("Adicionando tipoID: " + nuevoTipo);
        return nuevoTipo;
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
	
	public IPS addIPS (String localizacion, String nombre)
	{
		log.info("Adicionando la IPS: " + nombre);
		IPS nuevaIPS = pp.addIPS(localizacion, nombre);
		log.info("Adicionando afiliado: " + nuevaIPS);
		return nuevaIPS;
	}
	
	public TrabajaEn addTrabajaEn (long ips, long medico)
	{
		log.info ("Adicionando trabajaEn [" + ips + ", " + medico + "]");
        TrabajaEn resp = pp.addTrabajaEn(ips, medico);
        log.info ("Adicionando trabaEn: " + resp + " tuplas insertadas");
        return resp;
	}
	
	public TipoServicio addTipoServicio(String nombre)
	{
        log.info ("Adicionando tipoServicio: " + nombre);
        TipoServicio nuevoTipo = pp.addTipoServicio(nombre);
        log.info ("Adicionando tipoServicio: " + nuevoTipo);
        return nuevoTipo;
	}
	
	public ServicioSalud addServicioSalud (String nombre, long tipo)
	{
		log.info("Adicionando el ServicioSalud: " + nombre);
		ServicioSalud nuevoServicio = pp.addServicioSalud(nombre, tipo);
		log.info("Adicionando afiliado: " + nuevoServicio);
		return nuevoServicio;
	}
	
	public Orden addOrden (Date fecha, boolean valido, long medicoRemitente,
			long servicio, long afiliado)
	{
		log.info ("Adicionando Orden [" + medicoRemitente + ", " + afiliado + "]");
        Orden resp = pp.addOrden(fecha, valido, medicoRemitente, servicio, 
        		afiliado);
        log.info ("Adicionando Orden: " + resp + " tuplas insertadas");
        return resp;
	}
	
	public long [] limpiarEPS ()
	{
        log.info ("Limpiando la BD de EPSAndes");
        long [] muertos = pp.limpiarEPS();	
        log.info ("Limpiando la BD de EPSAndes: Listo!");
        return muertos;
	}
}
