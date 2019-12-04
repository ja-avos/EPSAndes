package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public class Horario implements VOHorario{

	private long id_Horario;
	
	private long IPS;
	
	private long servicio;
	
	private long capacidad;
	
	private long dia;
	
	private Timestamp hora_Inicio;
	
	private Timestamp hora_Fin;
	
	private long deshabilitado;
	
	public Horario() {
		this.id_Horario = 0;
		this.IPS = 0;
		this.servicio = 0;
		this.capacidad = 0;
		this.dia = 1;
		this.hora_Inicio = new Timestamp(0);
		this.hora_Fin = new Timestamp(0);
		this.deshabilitado = 0;
	}
	
	public Horario(long idHorario, long IPS, long servicio, long capacidad,
			long dia, Timestamp horaInicio, Timestamp horaFin, long deshabilitado) {
		this.id_Horario = idHorario;
		this.IPS = IPS;
		this.servicio = servicio;
		this.capacidad = capacidad;
		this.dia = dia;
		this.hora_Inicio = horaInicio;
		this.hora_Fin = horaFin;
		this.deshabilitado = deshabilitado;
	}

	public long getIPS() {
		return IPS;
	}

	public void setIPS(long iPS) {
		IPS = iPS;
	}

	public long getServicio() {
		return servicio;
	}

	public void setServicio(long servicio) {
		this.servicio = servicio;
	}

	public long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(long capacidad) {
		this.capacidad = capacidad;
	}

	public long getDia() {
		return dia;
	}

	public void setDia(long dia) {
		this.dia = dia;
	}
	
	public long getId_Horario() {
		return id_Horario;
	}

	public void setId_Horario(long id_Horario) {
		this.id_Horario = id_Horario;
	}

	public Timestamp getHora_Inicio() {
		return hora_Inicio;
	}

	public void setHora_Inicio(Timestamp hora_Inicio) {
		this.hora_Inicio = hora_Inicio;
	}

	public Timestamp getHora_Fin() {
		return hora_Fin;
	}

	public void setHora_Fin(Timestamp hora_Fin) {
		this.hora_Fin = hora_Fin;
	}

	public long getDeshabilitado() {
		return deshabilitado;
	}

	public void setDeshabilitado(long deshabilitado) {
		this.deshabilitado = deshabilitado;
	}

	public String toString() {
		return "Horario [idHorario=" + id_Horario + ", IPS=" + IPS +
				", servicio=" + servicio + ", capacidad" + capacidad +
				", dia=" + dia + ", horaInicio" + hora_Inicio.toString() + 
				", horaFin=" + hora_Fin.toString() + "]";
	}
}
