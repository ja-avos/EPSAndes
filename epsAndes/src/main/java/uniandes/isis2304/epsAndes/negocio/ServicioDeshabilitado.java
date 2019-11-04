package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public class ServicioDeshabilitado {

	private long id;
	
	private Timestamp fecha_inicio;
	
	private Timestamp fecha_fin;
	
	public ServicioDeshabilitado() {
		this.id = 0;
		this.fecha_inicio = new Timestamp(0);
		this.fecha_fin = new Timestamp(0);
	}
	
	public ServicioDeshabilitado(long id, Timestamp fecha_inicio, Timestamp fecha_fin) {
		this.id = id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
}
