package uniandes.isis2304.epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLUtil {

	private final static String SQL = PersistenciaEPSAndes.SQL;
	
	private PersistenciaEPSAndes pe;
	
	public SQLUtil (PersistenciaEPSAndes pe)
	{
		this.pe = pe;
	}
	
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pe.getSeqEPSAndes() + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}
	
	public long [] limpiarEPSAndes (PersistenceManager pm)
	{
        Query qAfiliado = pm.newQuery(SQL, "DELETE FROM " + pe.getTableAfiliado());          
        Query qSirven = pm.newQuery(SQL, "DELETE FROM " + pe.getTableConsulta() );
        Query qVisitan = pm.newQuery(SQL, "DELETE FROM " + pe.getTableExamenDiagnostico ());
        Query qBebida = pm.newQuery(SQL, "DELETE FROM " + pe.getTableHorario() );
        Query qTipoBebida = pm.newQuery(SQL, "DELETE FROM " + pe.getTableHospitalizacion());
        Query qBebedor = pm.newQuery(SQL, "DELETE FROM " + pe.getTableIPS());
        Query qBar = pm.newQuery(SQL, "DELETE FROM " + pe.getTableMedico());
        Query qOrden = pm.newQuery(SQL, "DELETE FROM " + pe.getTableOrden());
        Query qProcedimiento = pm.newQuery(SQL, "DELETE FROM " + pe.getTableProcedimiento());
        Query qRecepcionista= pm.newQuery(SQL, "DELETE FROM " + pe.getTableRecepcionista());
        Query qReserva= pm.newQuery(SQL, "DELETE FROM " + pe.getTableReserva());
        Query qRol = pm.newQuery(SQL, "DELETE FROM " + pe.getTableRol());
        Query qServicioSalud = pm.newQuery(SQL, "DELETE FROM " + pe.getTableServicioSalud());
        Query qTerapia= pm.newQuery(SQL, "DELETE FROM " + pe.getTableTerapia());
        Query qTipoConsulta= pm.newQuery(SQL, "DELETE FROM " + pe.getTableTipoConsulta());
        Query qTipoID= pm.newQuery(SQL, "DELETE FROM " + pe.getTableTipoID());
        Query qtipoServicio= pm.newQuery(SQL, "DELETE FROM " + pe.getTableTipoServicio());
        Query qTrabajaEn= pm.newQuery(SQL, "DELETE FROM " + pe.getTableTrabajaEn());
        Query qUsuario= pm.newQuery(SQL, "DELETE FROM " + pe.getTableUsuario());

        long gustanEliminados = (long) qAfiliado.executeUnique ();
        long sirvenEliminados = (long) qSirven.executeUnique ();
        long visitanEliminadas = (long) qVisitan.executeUnique ();
        long bebidasEliminadas = (long) qBebida.executeUnique ();
        long tiposBebidaEliminados = (long) qTipoBebida.executeUnique ();
        long bebedoresEliminados = (long) qBebedor.executeUnique ();
        long baresEliminados = (long) qBar.executeUnique ();
        long orden = (long) qOrden.executeUnique ();
        long procedimiento = (long) qProcedimiento.executeUnique();
        long recepcionista = (long) qRecepcionista.executeUnique();
        long reserva = (long) qReserva.executeUnique();
        long rol = (long) qRol.executeUnique();
        long servicioSalud = (long) qServicioSalud.executeUnique();
        long terapia = (long) qTerapia.executeUnique();
        long tipoConsulta = (long) qTipoConsulta.executeUnique();
        long tipoId = (long) qTipoID.executeUnique();
        long tipoServicio = (long) qtipoServicio.executeUnique();
        long trabajaEn = (long) qTrabajaEn.executeUnique();
        long usuario = (long) qUsuario.executeUnique();
        return new long[] {gustanEliminados, sirvenEliminados, visitanEliminadas, bebidasEliminadas, 
        		tiposBebidaEliminados, bebedoresEliminados, baresEliminados,
        		orden, procedimiento, recepcionista, reserva, rol, servicioSalud,
        		terapia, tipoConsulta, tipoId, tipoServicio, trabajaEn, usuario};
	}
}
