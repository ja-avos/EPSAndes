package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;
import java.util.List;

import javax.swing.JOptionPane;

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
	
	public List<Rol> darRoles ()
	{
        log.info ("Listando Roles");
        List<Rol> roles = pp.getRoles();
        log.info ("Listando Roles: " + roles.size() + " roles existentes");
        return roles;
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
	
	public Usuario getUserByEmail(String correo) throws Exception {
		String msg = "";
		for(Rol u : pp.getRoles())
		{
			msg+= "\n" + u.getRol();
		}
		pp.addRol2("");
		System.out.println("Usuarios: " + msg);
		log.info("Dar información de usuario por correo: " + correo);
		Usuario usuario = pp.getUserByEmail(correo);
		log.info ("Buscando usuario por correo: " + usuario != null ? usuario : "NO EXISTE");
		if (usuario == null ) throw new Exception("Correo no registrado en el sistema");
		return usuario;
	}
	
	public Medico addMedico (long registroMedico, String especialidad, long usuario)
	{
		log.info("Adicionando medico: " + usuario);
		Medico nuevoMedico = pp.addMedico(registroMedico, especialidad, usuario);
		log.info("Adicionando medico: " + nuevoMedico);
		return nuevoMedico;
	}
	
	public Afiliado addAfiliado (Timestamp fechaNacimiento, long usuario)
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
	
	public Orden addOrden (Timestamp fecha, boolean valido, long medicoRemitente,
			long servicio, long afiliado)
	{
		log.info ("Adicionando Orden [" + medicoRemitente + ", " + afiliado + "]");
        Orden resp = pp.addOrden(fecha, valido, medicoRemitente, servicio, 
        		afiliado);
        log.info ("Adicionando Orden: " + resp + " tuplas insertadas");
        return resp;
	}
	
	public Horario addHorario (long IPS, long servicio, int capacidad, int dia,
			Timestamp horaInicio, Timestamp horaFin)
	{
		log.info ("Adicionando Horario [" + IPS + ", " + servicio + "]");
        Horario resp = pp.addHorario(IPS, servicio, capacidad, dia, horaInicio,
        		horaFin);
        log.info ("Adicionando Horario: " + resp + " tuplas insertadas");
        return resp;
	}
	
	public Reserva addReserva (boolean servicioPrestado, Timestamp fecha, long horario,
			long afiliado, long orden)
	{
		log.info ("Adicionando Reserva [" + horario + ", " + afiliado + "]");
        Reserva resp = pp.addReserva(servicioPrestado, fecha, horario, 
        		afiliado, orden);
        log.info ("Adicionando Reserva: " + resp + " tuplas insertadas");
        return resp;
	}
	
	public TipoConsulta addTipoConsulta(String nombre)
	{
		log.info ("Adicionando tipoConsulta: " + nombre);
        TipoConsulta nuevoTipo = pp.addTipoConsulta(nombre);
        log.info ("Adicionando tipoConsulta: " + nuevoTipo);
        return nuevoTipo;
	}
	
	public Consulta addConsulta(long reserva, String observacion, int prioridad, String receta, 
			long tipo)
	{
		log.info ("Adicionando Consulta [" + reserva + ", " + observacion + ", " + prioridad +
				", " + receta + ", " + tipo + "]");
        Consulta resp = pp.addConsulta(reserva, observacion, prioridad, receta, tipo);
        log.info ("Adicionando Consulta: " + resp + " tuplas insertadas");
        return resp;
	}
	
	public ExamenDiagnostico addExamenDiagnostico(long reserva, String diagnostico)
	{
		log.info ("Adicionando examenDiagnostico [" + reserva + ", " + diagnostico + "]");
        ExamenDiagnostico resp = pp.addExamenDiagnostico(reserva, diagnostico);
        log.info ("Adicionando examenDiagnostico: " + resp + " tuplas insertadas");
        return resp;
	}
	
	public Terapia addTerapia(long reserva, int numeroSesiones)
	{
		log.info ("Adicionando terapia [" + reserva + ", " + numeroSesiones + "]");
        Terapia resp = pp.addTerapia(reserva, numeroSesiones);
        log.info ("Adicionando terapia: " + resp + " tuplas insertadas");
        return resp;
	}
	
	public Procedimiento addProcedimiento(long reserva, String descripcion)
	{
		log.info ("Adicionando procedimiento [" + reserva + ", " + descripcion + "]");
        Procedimiento resp = pp.addProcedimiento(reserva, descripcion);
        log.info ("Adicionando procedimiento: " + resp + " tuplas insertadas");
        return resp;
	}
	
	public Hospitalizacion addHospitalizacion(long reserva, Timestamp fechaSalida, String observacion)
	{
		log.info ("Adicionando Hospitalizacion [" + reserva + ", " + fechaSalida + ", " +
				observacion + "]");
		Hospitalizacion resp = pp.addHospitalizacion(reserva, fechaSalida, observacion);
        log.info ("Adicionando Hospitalizacion: " + resp + " tuplas insertadas");
        return resp;
	}
	
	public long registrarPrestacionServicio (long codigo)
	{
        log.info ("Registrando la prestación del servicio: " + codigo);
        long resp = pp.registrarPrestacionServicio(codigo);
        log.info ("Registrando la prestación del servicio: " + resp + " tuplas actualizadas");
        return resp;
	}
	
	public List<Object []> darCantidadServiciosPrestadosPorIPS (Timestamp fechaInicio,
			Timestamp fechaFin)
	{
        log.info ("Listando IPS y cuántos servicios ha prestado entre: " + fechaInicio +
        		" y " + fechaFin);
        List<Object []> tuplas = pp.darCantidadServiciosPrestadosPorIPS(fechaInicio, fechaFin);
        log.info ("Listando IPS y cuántos servicios ha prestado entre: " + fechaInicio +
        		" y " + fechaFin + "Listo!");
        return tuplas;
	}
	
	public long [] limpiarEPS ()
	{
        log.info ("Limpiando la BD de EPSAndes");
        long [] muertos = pp.limpiarEPS();	
        log.info ("Limpiando la BD de EPSAndes: Listo!");
        return muertos;
	}
}
