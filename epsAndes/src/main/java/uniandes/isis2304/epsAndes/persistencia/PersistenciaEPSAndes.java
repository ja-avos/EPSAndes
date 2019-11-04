package uniandes.isis2304.epsAndes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.epsAndes.negocio.Afiliado;
import uniandes.isis2304.epsAndes.negocio.Campana;
import uniandes.isis2304.epsAndes.negocio.Consulta;
import uniandes.isis2304.epsAndes.negocio.ExamenDiagnostico;
import uniandes.isis2304.epsAndes.negocio.Horario;
import uniandes.isis2304.epsAndes.negocio.Hospitalizacion;
import uniandes.isis2304.epsAndes.negocio.IPS;
import uniandes.isis2304.epsAndes.negocio.Medico;
import uniandes.isis2304.epsAndes.negocio.Orden;
import uniandes.isis2304.epsAndes.negocio.Participan;
import uniandes.isis2304.epsAndes.negocio.Procedimiento;
import uniandes.isis2304.epsAndes.negocio.Recepcionista;
import uniandes.isis2304.epsAndes.negocio.Reserva;
import uniandes.isis2304.epsAndes.negocio.Rol;
import uniandes.isis2304.epsAndes.negocio.ServicioDeshabilitado;
import uniandes.isis2304.epsAndes.negocio.ServicioSalud;
import uniandes.isis2304.epsAndes.negocio.Terapia;
import uniandes.isis2304.epsAndes.negocio.TipoConsulta;
import uniandes.isis2304.epsAndes.negocio.TipoID;
import uniandes.isis2304.epsAndes.negocio.TipoServicio;
import uniandes.isis2304.epsAndes.negocio.TrabajaEn;
import uniandes.isis2304.epsAndes.negocio.Usuario;
import uniandes.isis2304.epsAndes.negocio.VORol;


public class PersistenciaEPSAndes {

	private static Logger log = Logger.getLogger(PersistenciaEPSAndes.class.getName());
	
	public final static String SQL = "javax.jdo.query.SQL";
	
	private static PersistenciaEPSAndes instance;
	
	private PersistenceManagerFactory pmf;
	
	private List <String> tablas;
	
	private SQLUtil sqlUtil;
	
	private SQLRol sqlRol;
	
	private SQLUsuario sqlUsuario;
	
	private SQLIps sqlIPS;
	
	private SQLAfiliado sqlAfiliado;
	
	private SQLMedico sqlMedico;
	
	private SQLRecepcionista sqlRecepcionista;
	
	private SQLTrabajaEn sqlTrabajaEn;
	
	private SQLTipoId sqlTipoId;
	
	private SQLHorario sqlHorario;
	
	private SQLOrden sqlOrden;
	
	private SQLReserva sqlReserva;
	
	private SQLServicioSalud sqlServicioSalud;
	
	private SQLTipoServicio sqlTipoServicio;
	
	private SQLExamenDiagnostico sqlExamenDiagnostico;
	
	private SQLTerapia sqlTerapia;
	
	private SQLProcedimiento sqlProcedimiento;
	
	private SQLHospitalizacion sqlHospitalizacion;
	
	private SQLTipoConsulta sqlTipoConsulta;
	
	private SQLConsulta sqlConsulta;
	
	private SQLCampana sqlCampana;
	
	private SQLParticipan sqlParticipan;
	
	private SQLServicioDeshabilitado sqlServicioDeshabilitado;
	
	private PersistenciaEPSAndes()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("EPSAndes");
		System.out.println(pmf.getConnectionUserName());
		System.out.println(pmf.getConnectionURL());
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("epsandes_sequence");
		tablas.add("AFILIADO");
		tablas.add("CAMPANA");
		tablas.add("CONSULTA");
		tablas.add("EXAMEN_DIAGNOSTICO");
		tablas.add("HORARIO");
		tablas.add("HOSPITALIZACION");
		tablas.add("IPS");
		tablas.add("MEDICO");
		tablas.add("ORDEN");
		tablas.add("PARTICIPAN");
		tablas.add("PROCEDIMIENTO");
		tablas.add("RECEPCIONISTA");
		tablas.add("RESERVA");
		tablas.add("ROL");
		tablas.add("SERVICIO_DESHABILITADO");
		tablas.add("SERVICIO_SALUD");
		tablas.add("TERAPIA");
		tablas.add("TIPO_CONSULTA");
		tablas.add("TIPO_ID");
		tablas.add("TIPO_SERVICIO");
		tablas.add("TRABAJA_EN");
		tablas.add("USUARIO");
	}
	
	private PersistenciaEPSAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}
	
	public static PersistenciaEPSAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaEPSAndes ();
		}
		return instance;
	}
	
	public static PersistenciaEPSAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaEPSAndes (tableConfig);
		}
		return instance;
	}
	
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	private void crearClasesSQL ()
	{
		// TODO
		sqlRol = new SQLRol(this);
		sqlUsuario = new SQLUsuario(this);
		sqlIPS = new SQLIps(this);
		sqlAfiliado = new SQLAfiliado(this);
		sqlMedico = new SQLMedico(this);
		sqlRecepcionista = new SQLRecepcionista(this);
		sqlTrabajaEn = new SQLTrabajaEn(this);
		sqlTipoId = new SQLTipoId(this);
		sqlHorario = new SQLHorario(this);
		sqlOrden = new SQLOrden(this);
		sqlReserva = new SQLReserva(this);
		sqlServicioSalud = new SQLServicioSalud(this);
		sqlTipoServicio = new SQLTipoServicio(this);
		sqlExamenDiagnostico = new SQLExamenDiagnostico(this);
		sqlTerapia = new SQLTerapia(this);
		sqlProcedimiento = new SQLProcedimiento(this);
		sqlHospitalizacion = new SQLHospitalizacion(this);
		sqlTipoConsulta = new SQLTipoConsulta(this);
		sqlConsulta = new SQLConsulta(this);
		sqlCampana = new SQLCampana(this);
		sqlParticipan = new SQLParticipan(this);
		sqlServicioDeshabilitado = new SQLServicioDeshabilitado(this);
		sqlUtil = new SQLUtil(this);
	}
	
	public String getSeqEPSAndes ()
	{
		return tablas.get (0);
	}
	
	public String getTableAfiliado() {
		return tablas.get(1);
	}
	
	public String getTableConsulta() {
		return tablas.get(3);
	}
	
	public String getTableExamenDiagnostico() {
		return tablas.get(4);
	}
	
	public String getTableHorario() {
		return tablas.get(5);
	}
	
	public String getTableHospitalizacion() {
		return tablas.get(6);
	}
	
	public String getTableIPS() {
		return tablas.get(7);
	}
	
	public String getTableMedico() {
		return tablas.get(8);
	}
	
	public String getTableOrden() {
		return tablas.get(9);
	}
	
	public String getTableProcedimiento() {
		return tablas.get(11);
	}
	
	public String getTableRecepcionista() {
		return tablas.get(12);
	}
	
	public String getTableReserva() {
		return tablas.get(13);
	}
	
	public String getTableRol() {
		return tablas.get(14);
	}
	
	public String getTableServicioSalud() {
		return tablas.get(16);
	}
	
	public String getTableTerapia() {
		return tablas.get(17);
	}
	
	public String getTableTipoConsulta() {
		return tablas.get(18);
	}
	
	public String getTableTipoID() {
		return tablas.get(19);
	}
	
	public String getTableTipoServicio() {
		return tablas.get(20);
	}
	
	public String getTableTrabajaEn() {
		return tablas.get(21);
	}
	
	public String getTableUsuario() {
		return tablas.get(22);
	}
	
	public String getTableCampana() {
		return tablas.get(2);
	}
	
	public String getTableParticipan() {
		return tablas.get(10);
	}
	
	public String getTableServicioDeshabilitado() {
		return tablas.get(15);
	}
	
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	////////////////////////////////////////////////////////////////////////
	////////////////////MANEJO ROLES DE USUARIO/////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	public Rol addRol(String rol)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idRol = nextval ();
            long tuplasInsertadas = sqlRol.addRol(pm, idRol, rol);
            tx.commit();
            
            log.trace ("Inserción de rol: " + rol + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Rol (idRol, rol);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	public List<Rol> getRoles ()
	{
		return sqlRol.getRoles(pmf.getPersistenceManager());
	}
	
	public long eliminarRolPorId(long id)
	{
		return sqlRol.eliminarPorId(pmf.getPersistenceManager(), id);
	}
	
	public Rol getRolByNombre(String rol)
	{
		return sqlRol.getRolesByName(pmf.getPersistenceManager(), rol).isEmpty() ? null : sqlRol.getRolesByName(pmf.getPersistenceManager(), rol).get(0);
	}
	
	
	////////////////////////////////////////////////////////////////////////
	////////////////////MANEJO USUARIOS/////////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	public Usuario addUsuario(String nombre, String correo, long id,
			long tipoID, long rol) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idUsuario = nextval ();
            long tuplasInsertadas = sqlUsuario.addUsuario(pm, idUsuario, nombre, correo, idUsuario, tipoID, rol);
            tx.commit();

            log.trace ("Inserción de usuario: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Usuario(idUsuario, nombre, correo, id, tipoID, rol);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Usuario getUserByID(Long id)
	{
		return sqlUsuario.getUsuarioByID(pmf.getPersistenceManager(), id);
	}
	
	public List<Usuario> getUsers()
	{
		return sqlUsuario.getUsers(pmf.getPersistenceManager());
	}

	public Usuario getUserByEmail (String correo) 
	{
		return sqlUsuario.getUserByEmail(pmf.getPersistenceManager(), correo);
	}
	
	
	////////////////////////////////////////////////////////////////////////
	////////////////////////MANEJO MEDICO///////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	public Medico addMedico(long registroMedico, String especialidad, long usuario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idMedico = nextval ();
            long tuplasInsertadas = sqlMedico.addMedico(pm, idMedico, registroMedico, especialidad, usuario);
            tx.commit();

            log.trace ("Inserción de medico: " + usuario + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Medico(idMedico, registroMedico, especialidad, usuario);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	
	///////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO AFILIADOS///////////////////////////////
	////////////////////////////////////////////////////////////////////////

	public Afiliado addAfiliado(Timestamp fechaNacimiento, long usuario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idAfiliado = nextval ();
            long tuplasInsertadas = sqlAfiliado.addAfiliado(pm, idAfiliado, fechaNacimiento, usuario);
            tx.commit();

            log.trace ("Inserción de afiliado: " + usuario + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Afiliado(idAfiliado, fechaNacimiento, usuario);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}



	////////////////////////////////////////////////////////////////////////
	//////////////////////////MANEJO RECEPCIONISTA//////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	public Recepcionista addRecepcionista(long usuario, long IPS) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idRecepcionista = nextval ();
            long tuplasInsertadas = sqlRecepcionista.addRecepcionista(pm, idRecepcionista, usuario, IPS);
            tx.commit();

            log.trace ("Inserción de recepcionista: " + usuario + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Recepcionista(idRecepcionista, usuario, IPS);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	
	////////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO IPSs////////////////////////////////////
	////////////////////////////////////////////////////////////////////////

	
	public IPS addIPS(String localizacion, String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlIPS.addIps(pm, id, localizacion, nombre);
            tx.commit();

            log.trace ("Inserción de IPS: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new IPS(id, localizacion, nombre);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public IPS getIPSById(long id) {
		return sqlIPS.getIPSById(pmf.getPersistenceManager(), id);
	}
	
	////////////////////////////////////////////////////////////////////////
	////////////////////////MANEJO TRABAJA_EN///////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	public TrabajaEn addTrabajaEn(long ips, long medico) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlTrabajaEn.addTrabajaEn(pm, ips, medico);
    		tx.commit();

            log.trace ("Inserción de trabajaEn: [" + ips + ", " + medico + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new TrabajaEn(ips, medico);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	
	////////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO TIPO_ID/////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	public TipoID addTipoID(String nombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idTipo = nextval ();
            long tuplasInsertadas = sqlTipoId.addTipoId(pm, idTipo, nombre);
            tx.commit();
            
            log.trace ("Inserción de tipoId: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new TipoID(idTipo, nombre);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public TipoID getTipoIDByNombre(String nombre)
	{
		return sqlTipoId.getTiposIdByName(pmf.getPersistenceManager(), nombre).isEmpty() ? null : sqlTipoId.getTiposIdByName(pmf.getPersistenceManager(), nombre).get(0);
	}
	
	public List<TipoID> getTiposID()
	{
		return sqlTipoId.getTiposId(pmf.getPersistenceManager());
	}
	
	public long eliminarTipoIDPorId(long id)
	{
		return sqlTipoId.eliminarTipoIdPorId(pmf.getPersistenceManager(), id);
	}
	
	////////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO TIPO_SERVICIO///////////////////////
	////////////////////////////////////////////////////////////////////////
	
	public TipoServicio addTipoServicio(String nombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idServicio = nextval ();
            long tuplasInsertadas = sqlTipoServicio.addTipoServicio(pm, idServicio, nombre);
            tx.commit();
            
            log.trace ("Inserción de tipoId: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new TipoServicio(idServicio, nombre);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public TipoServicio getTipoServicioByNombre(String servicio)
	{
		return sqlTipoServicio.getTipoServicioByName(pmf.getPersistenceManager(), servicio).isEmpty() ? null : sqlTipoServicio.getTipoServicioByName(pmf.getPersistenceManager(), servicio).get(0);
	}
	
	public List<TipoServicio> getTiposServicio()
	{
		return sqlTipoServicio.getTiposServicio(pmf.getPersistenceManager());
	}
	
	public long eliminarTipoServicioPorId(long id)
	{
		return sqlTipoServicio.eliminarPorId(pmf.getPersistenceManager(), id);
	}
	
	////////////////////////////////////////////////////////////////////////
	////////////////////////MANEJO SERVICIO_SALUD///////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	public ServicioSalud addServicioSalud(String nombre, long tipo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idServicio = nextval ();
            long tuplasInsertadas = sqlServicioSalud.addServicioSalud(pm, idServicio, nombre, tipo);
            tx.commit();

            log.trace ("Inserción de ServicioSalud: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new ServicioSalud(idServicio, nombre, tipo);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public ServicioSalud getServicioSaludByID(long id) {
		return sqlServicioSalud.getServicioSaludById(pmf.getPersistenceManager(), id);
	}
	
	////////////////////////////////////////////////////////////////////////
	////////////////////////MANEJO HORARIO//////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	public Horario addHorario(long IPS, long servicio, int capacidad, int dia,
			Timestamp horaInicio, Timestamp horaFin) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idHorario = nextval ();
            long tuplasInsertadas = sqlHorario.addHorario(pm, idHorario, IPS, 
            		servicio, capacidad, dia, horaInicio, horaFin);
            tx.commit();

            log.trace ("Inserción de horario: [" + IPS + ", " + servicio + "]. " + tuplasInsertadas + " tuplas insertadas");
            
            return new Horario(idHorario, IPS, servicio, capacidad, dia, horaInicio, horaFin, 0);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<Object[]> getDisponibilidadDeHorario (Timestamp fecha, long servicio)
	{
		int dia = fecha.getDay() + 1;
		List<Object []> respuesta = new LinkedList <Object []> ();
		List<Horario> tuplas = sqlHorario.getHorarios(pmf.getPersistenceManager(), dia, servicio);
        for ( Horario horario : tuplas)
        {
			long disponibilidad = getDisponibilidad(horario.getId_Horario(), fecha);

			Object [] resp = new Object [2];
			resp [0] = horario;
			resp [1] = disponibilidad;	
			
			if (disponibilidad != 0) respuesta.add(resp);
        }

		return respuesta;
	}
	
	public List<Horario> getHorariosByIPS(long ips) 
	{
		return sqlHorario.getHorariosByIPS(pmf.getPersistenceManager(), ips);
	}
	
	public long habilitarServicio(long servicio, long ips) {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp2 = sqlHorario.habilitar(pmf.getPersistenceManager(), servicio, ips);
            tx.commit();
            return resp2;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
     }
        
    public String[] deshabilitarServicio(long servicio, long ips, Timestamp fecha_inicio,
    		Timestamp fecha_fin) {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
        	String[] resp = new String[4];
        	
            tx.begin();
            long deshabilitado = 0;
            ServicioDeshabilitado findServicioDeshabilitado = sqlServicioDeshabilitado.findServicioDeshabilitado(pmf.getPersistenceManager(),
            		fecha_inicio, fecha_fin);
			if (findServicioDeshabilitado != null) {
            	deshabilitado = findServicioDeshabilitado.getId();
            } else {
            	deshabilitado = nextval ();
            	sqlServicioDeshabilitado.addServicioDeshabilitado(pmf.getPersistenceManager(), fecha_inicio, fecha_fin, deshabilitado);
            }
			
			List<Reserva> porReasignar = sqlReserva.getReservasFechas(pmf.getPersistenceManager(), fecha_inicio, fecha_fin, servicio, ips);
			
			long deshabilitados = sqlHorario.deshabilitar(pmf.getPersistenceManager(),
            		servicio, ips, deshabilitado);
			resp[0] = "servicios deshabilitados: " + deshabilitados;
			
			long eliminados = sqlReserva.deleteReservasFechas(pmf.getPersistenceManager(), fecha_inicio, fecha_fin, servicio, ips);
            resp[1] = "reservas eliminadas: " + eliminados;
            
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//            	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	String[] resp = new String[4];
            return resp;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	////////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO ORDEN///////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	public Orden addOrden(Timestamp fecha, boolean validoBool, long medicoRemitente,
			long servicio, long afiliado) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long codigo = nextval ();
            int valido = validoBool? 1:0;
            long tuplasInsertadas = sqlOrden.addOrden(pm, codigo, fecha, valido,
            		medicoRemitente, servicio, afiliado);
            tx.commit();

            log.trace ("Inserción de orden: [" + medicoRemitente + ", " + afiliado + "]. " + tuplasInsertadas + " tuplas insertadas");
            
            return new Orden(codigo, fecha, validoBool, medicoRemitente, servicio, afiliado);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Orden getOrdenDeAfiliadoPara (long afiliado, long servicio)
	{
		return sqlOrden.getOrden(pmf.getPersistenceManager(), afiliado, servicio);
	}
	
	public long useOrden (long codigoOrden) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp2 = sqlOrden.invalidarOrden(pmf.getPersistenceManager(), codigoOrden);
            tx.commit();
            return resp2;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	////////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO RESERVA/////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	public Reserva addReserva(boolean servicioPrestadoBool, Timestamp fecha,
			long horario, long afiliado, long orden, long campana) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            
            long codigo = nextval ();
            int servicioPrestado = servicioPrestadoBool? 1:0;
            long tuplasInsertadas = sqlReserva.addReserva(pm, codigo, 
            		servicioPrestado, fecha, horario, afiliado, orden, campana);
            tx.commit();

            log.trace ("Inserción de orden: [" + horario + ", " + afiliado + "]. " + tuplasInsertadas + " tuplas insertadas");
            
            return new Reserva(codigo, servicioPrestadoBool, fecha, horario, afiliado, orden);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public long registrarPrestacionServicio (long codigo)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.prestarServicio(pm, codigo);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////MANEJO EXAMEN_DIAGNOSTICO///////////////////////
	///////////////////////////////////////////////////////////////////////
	
	public ExamenDiagnostico addExamenDiagnostico(long reserva, String diagnostico) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlExamenDiagnostico.addExamenDiagnostico(pm, reserva, diagnostico);
            tx.commit();

            log.trace ("Inserción de exámen diagnóstico: " + reserva + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new ExamenDiagnostico(reserva, diagnostico);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////MANEJO TERAPIAS/////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	
	public Terapia addTerapia(long reserva, int numeroSesiones) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlTerapia.addTerapia(pm, reserva, numeroSesiones);
            tx.commit();

            log.trace ("Inserción de terapia: " + reserva + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Terapia(reserva, numeroSesiones);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////MANEJO PROCEDIMIENTO////////////////////////////
	///////////////////////////////////////////////////////////////////////
	
	public Procedimiento addProcedimiento(long reserva, String descripcion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlProcedimiento.addProcedimiento(pm, reserva, descripcion);
            tx.commit();

            log.trace ("Inserción de procedimiento: " + reserva + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Procedimiento(reserva, descripcion);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////MANEJO HOSPITALIZACIÓN//////////////////////////
	///////////////////////////////////////////////////////////////////////
	
	public Hospitalizacion addHospitalizacion(long reserva, Timestamp fechaSalida, String observacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlHospitalizacion.addHospitalizacion(pm, reserva, fechaSalida, observacion);
            tx.commit();

            log.trace ("Inserción de hospitalizacion: " + reserva + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Hospitalizacion(reserva, fechaSalida, observacion);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////MANEJO TIPO CONSULTA////////////////////////////
	///////////////////////////////////////////////////////////////////////
	
	public TipoConsulta addTipoConsulta(String nombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idTipo = nextval ();
            long tuplasInsertadas = sqlTipoConsulta.addTipoConsulta(pm, idTipo, nombre);
            tx.commit();
            
            log.trace ("Inserción de tipoConsulta: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new TipoConsulta(idTipo, nombre);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public TipoConsulta getTipoConsultaByNombre(String nombre)
	{
		return sqlTipoConsulta.getTipoConsultaByName(pmf.getPersistenceManager(), nombre).isEmpty() ? null : sqlTipoConsulta.getTipoConsultaByName(pmf.getPersistenceManager(), nombre).get(0);
	}
	
	public List<TipoConsulta> getTiposConsulta()
	{
		return sqlTipoConsulta.getTiposConsulta(pmf.getPersistenceManager());
	}
	
	public long eliminarTipoConsultaPorId(long id)
	{
		return sqlTipoConsulta.eliminarPorId(pmf.getPersistenceManager(), id);
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////MANEJO CONSULTA/////////////////////////////////
	///////////////////////////////////////////////////////////////////////

	public Consulta addConsulta(long reserva, String observacion, int prioridad, String receta, 
			long tipo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlConsulta.addConsulta(pm, reserva, observacion, prioridad, 
			receta, tipo); 
			tx.commit();
			
			log.trace ("Inserción de consulta: " + reserva + ": " + tuplasInsertadas + " tuplas insertadas");
			
			return new Consulta(reserva, observacion, prioridad, receta, tipo);
		}
		catch (Exception e)
		{
		//e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	
	///////////////////////////////////////////////////////////////////////
	///////////////////////MANEJO REQS DE CONSULTA/////////////////////////
	///////////////////////////////////////////////////////////////////////
	
	public List<Object []> darCantidadServiciosPrestadosPorIPS (Timestamp fechaInicio,
			Timestamp fechaFin)
	{
		List<Object []> respuesta = new LinkedList <Object []> ();
		List<Object> tuplas = sqlIPS.darCantidadServiciosPrestadosPorIPS(pmf.getPersistenceManager(), 
				fechaInicio, fechaFin);
        for ( Object tupla : tuplas)
        {
			Object [] datos = (Object []) tupla;
			long id = ((BigDecimal) datos [0]).longValue ();
			String localizacion = (String) datos [1];
			String nombre = (String) datos [2];
			int cantServicios = ((BigDecimal) datos [3]).intValue ();

			Object [] resp = new Object [2];
			resp [0] = new IPS(id, localizacion, nombre);
			resp [1] = cantServicios;	
			
			respuesta.add(resp);
        }

		return respuesta;
	}
	
	public List<ServicioSalud> dar20ServiciosMasSolicitados (Timestamp fechaInicio,
			Timestamp fechaFin)
	{
		return sqlServicioSalud.dar20MasSolicitados(pmf.getPersistenceManager(), fechaInicio, fechaFin);
	}
	
	public long utilizacionServicios (long afiliado, Timestamp fechaInicio,
			Timestamp fechaFin) {
		return sqlReserva.utilizacionDeServicios(pmf.getPersistenceManager(), afiliado, fechaInicio, fechaFin);
	}
	
	public List<Horario> getHorarios(int dia, long idServicio)
	{
		return sqlHorario.getHorarios(pmf.getPersistenceManager(), dia, idServicio);
	}
	
	public long getDisponibilidad (long horario, Timestamp fecha)
	{
		return sqlHorario.getCapacidad(pmf.getPersistenceManager(), horario) -
				sqlReserva.getCantidadReservas(pmf.getPersistenceManager(), fecha, horario);
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////MANEJO CAMPANA//////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	
	public Campana addCampana(Timestamp fecha_inicio, Timestamp fecha_fin, 
			TipoServicio[] servicios, long[] cantidades, boolean cancelada) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id_Campana = nextval ();
            long tuplasInsertadas = sqlCampana.addCampana(pmf.getPersistenceManager(), 
            		id_Campana, fecha_inicio, fecha_fin);
            Calendar calendarInicio = Calendar.getInstance();
            calendarInicio.set(Calendar.DAY_OF_MONTH, fecha_inicio.getDate());
            calendarInicio.set(Calendar.MONTH, fecha_inicio.getMonth());
            calendarInicio.set(Calendar.YEAR, fecha_inicio.getYear());
            
            Calendar calendarFin = Calendar.getInstance();
            calendarFin.set(Calendar.DAY_OF_MONTH, fecha_fin.getDate());
            calendarFin.set(Calendar.MONTH, fecha_fin.getMonth());
            calendarFin.set(Calendar.YEAR, fecha_fin.getYear());
            
            addReservaCampana(servicios, cantidades, calendarInicio, calendarFin);
            tx.commit();

            log.trace ("Inserción de campana: " + id_Campana + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Campana(id_Campana, fecha_inicio, fecha_fin, cancelada);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	private void addReservaCampana(TipoServicio[] tipos, long[] cantidades,
			Calendar fecha_inicio, Calendar fecha_fin) 
	{
		for (int i = 0; i < tipos.length; i ++) {
			TipoServicio tipo = tipos[i];
			long cantidadRequerida = cantidades[i];
			List<Horario> horarios = sqlHorario.getHorariosPorTipoServicio
					(pmf.getPersistenceManager(), tipo.getId_Servicio());
			for (Calendar actual = fecha_inicio; actual.equals(fecha_fin);
					actual.add(Calendar.DAY_OF_YEAR, 1)) {
				
			}
				
		}
	}
	
	public long cancelarServicioCampana(long campana, long servicio) {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.deleteReservaCamapana(pmf.getPersistenceManager(), campana, servicio);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public long[] cancelarCampana(long campana) {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp1 = sqlCampana.cancelCampana(pmf.getPersistenceManager(), campana);
            long resp2 = sqlReserva.deleteReservasCamapana(pmf.getPersistenceManager(), campana);
            tx.commit();
            long[] resp = new long[2];
            resp[0] = resp1;
            resp[1] = resp2;
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////MANEJO PARTICIPAN///////////////////////////////
	///////////////////////////////////////////////////////////////////////
	
	public Participan addParticipan(long id_afiliado, long id_campana) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlParticipan.addParticipan(pmf.getPersistenceManager(), id_afiliado, id_campana);
    		tx.commit();

            log.trace ("Inserción de Participan: [" + id_afiliado + ", " + id_campana + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new Participan(id_afiliado, id_campana);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////CNSULTAS IT2	///////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	
	public List<ServicioSalud> serviciosSinDemanda(int n) {
		LocalDate hoy = LocalDate.now();
		Timestamp hoyt = new Timestamp(hoy.getYear(), hoy.getMonthValue(), hoy.getDayOfMonth(), 0, 0, 0, 0);
		LocalDate inicioAño = LocalDate.of(hoy.getYear(), Month.JANUARY, 1);
		Timestamp inicioAñot = new Timestamp(hoy.getYear(), 1, 1, 0, 0, 0, 0);
		long weeks = ChronoUnit.WEEKS.between(inicioAño, hoy);
		return sqlServicioSalud.getServiciosSinDemanda(pmf.getPersistenceManager(), 
				inicioAñot, hoyt, weeks, n);
	}
	
	public List<Object[]> afiliadosExigentes() {
		LocalDate hoy = LocalDate.now();
		Timestamp fechaFin = new Timestamp(hoy.getYear(), hoy.getMonthValue(), hoy.getDayOfMonth(), 0, 0, 0, 0);
		LocalDate inicioAño = LocalDate.of(hoy.getYear(), Month.JANUARY, 1);
		Timestamp fechaInicio = new Timestamp(hoy.getYear(), 1, 1, 0, 0, 0, 0);
		return sqlAfiliado.afiliadosExigentes(pmf.getPersistenceManager(), fechaInicio, fechaFin);
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////LIMPIAR EPS////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	
	public long [] limpiarEPS ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarEPSAndes(pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
}
