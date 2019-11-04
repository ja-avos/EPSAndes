package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public class Campana implements VOCampana{

	private long id_campana;
	
	private Timestamp fecha_inicio;
	
	private Timestamp fecha_fin;
	
	private boolean cancelada;
	
	public Campana(){
		this.id_campana = 0;
		this.fecha_inicio = new Timestamp(0);
		this.fecha_fin = new Timestamp(0);
		this.cancelada = false;
	}
	
	public Campana (long id_campana, Timestamp fecha_inicio, Timestamp fecha_fin, 
			boolean cancelada) {
		this.id_campana = id_campana;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.cancelada = cancelada;
	}

	public long getId_campana() {
		return id_campana;
	}

	public void setId_campana(long id_campana) {
		this.id_campana = id_campana;
	}

	public Timestamp getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Timestamp fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Timestamp getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Timestamp fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}
	
}
