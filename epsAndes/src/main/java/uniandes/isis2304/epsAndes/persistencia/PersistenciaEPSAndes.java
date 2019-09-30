package uniandes.isis2304.epsAndes.persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


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
	

	
	
	private PersistenciaEPSAndes()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("EPSAndes");		
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
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////
	////////////////////MANEJO USUARIOS/////////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	
	
	////////////////////////////////////////////////////////////////////////
	////////////////////////MANEJO MEDICO///////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	
	
	///////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO AFILIADOS///////////////////////////////
	////////////////////////////////////////////////////////////////////////





	////////////////////////////////////////////////////////////////////////
	//////////////////////////MANEJO RECEPCIONISTA//////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO IPSs////////////////////////////////////
	////////////////////////////////////////////////////////////////////////

	
	
	
	
	////////////////////////////////////////////////////////////////////////
	////////////////////////MANEJO TRABAJA_EN///////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO TIPO_ID/////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO TIPO_SERVICIO///////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	
	
	////////////////////////////////////////////////////////////////////////
	////////////////////////MANEJO SERVICIO_SALUD///////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	
	
	////////////////////////////////////////////////////////////////////////
	////////////////////////MANEJO HORARIO//////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO ORDEN///////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////
	/////////////////////////MANEJO RESERVA/////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	
	
	
}
