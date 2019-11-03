package uniandes.isis2304.epsAndes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
import uniandes.isis2304.epsAndes.negocio.Consulta;
import uniandes.isis2304.epsAndes.negocio.ExamenDiagnostico;
import uniandes.isis2304.epsAndes.negocio.Horario;
import uniandes.isis2304.epsAndes.negocio.Hospitalizacion;
import uniandes.isis2304.epsAndes.negocio.IPS;
import uniandes.isis2304.epsAndes.negocio.Medico;
import uniandes.isis2304.epsAndes.negocio.Orden;
import uniandes.isis2304.epsAndes.negocio.Procedimiento;
import uniandes.isis2304.epsAndes.negocio.Recepcionista;
import uniandes.isis2304.epsAndes.negocio.Reserva;
import uniandes.isis2304.epsAndes.negocio.Rol;
import uniandes.isis2304.epsAndes.negocio.ServicioSalud;
import uniandes.isis2304.epsAndes.negocio.Terapia;
import uniandes.isis2304.epsAndes.negocio.TipoConsulta;
import uniandes.isis2304.epsAndes.negocio.TipoID;
import uniandes.isis2304.epsAndes.negocio.TipoServicio;
import uniandes.isis2304.epsAndes.negocio.TrabajaEn;
import uniandes.isis2304.epsAndes.negocio.Usuario;


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
		tablas.add("CONSULTA");
		tablas.add("EXAMEN_DIAGNOSTICO");
		tablas.add("HORARIO");
		tablas.add("HOSPITALIZACION");
		tablas.add("IPS");
		tablas.add("MEDICO");
		tablas.add("ORDEN");
		tablas.add("PROCEDIMIENTO");
		tablas.add("RECEPCIONISTA");
		tablas.add("RESERVA");
		tablas.add("ROL");
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
		return tablas.get(2);
	}
	
	public String getTableExamenDiagnostico() {
		return tablas.get(3);
	}
	
	public String getTableHorario() {
		return tablas.get(4);
	}
	
	public String getTableHospitalizacion() {
		return tablas.get(5);
	}
	
	public String getTableIPS() {
		return tablas.get(6);
	}
	
	public String getTableMedico() {
		return tablas.get(7);
	}
	
	public String getTableOrden() {
		return tablas.get(8);
	}
	
	public String getTableProcedimiento() {
		return tablas.get(9);
	}
	
	public String getTableRecepcionista() {
		return tablas.get(10);
	}
	
	public String getTableReserva() {
		return tablas.get(11);
	}
	
	public String getTableRol() {
		return tablas.get(12);
	}
	
	public String getTableServicioSalud() {
		return tablas.get(13);
	}
	
	public String getTableTerapia() {
		return tablas.get(14);
	}
	
	public String getTableTipoConsulta() {
		return tablas.get(15);
	}
	
	public String getTableTipoID() {
		return tablas.get(16);
	}
	
	public String getTableTipoServicio() {
		return tablas.get(17);
	}
	
	public String getTableTrabajaEn() {
		return tablas.get(18);
	}
	
	public String getTableUsuario() {
		return tablas.get(19);
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
	
	public void addRol2(String rol)
	{
		sqlRol.addRol(pmf.getPersistenceManager(), 10, "Hola");
	}

	public List<Rol> getRoles ()
	{
		return sqlRol.getRoles(pmf.getPersistenceManager());
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
            
            return new Horario(idHorario, IPS, servicio, capacidad, dia, horaInicio, horaFin);
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
	
	
	
	////////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO RESERVA/////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	public Reserva addReserva(boolean servicioPrestadoBool, Timestamp fecha,
			long horario, long afiliado, long orden) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long codigo = nextval ();
            int servicioPrestado = servicioPrestadoBool? 1:0;
            long tuplasInsertadas = sqlReserva.addReserva(pm, codigo, 
            		servicioPrestado, fecha, horario, afiliado, orden);
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
