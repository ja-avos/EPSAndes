package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

public class Horario implements VOHorario{

	private long idHorario;
	
	private long IPS;
	
	private long servicio;
	
	private int capacidad;
	
	private int dia;
	
	private Date horaInicio;
	
	private Date horaFin;
	
	public Horario() {
		this.idHorario = 0;
		this.IPS = 0;
		this.servicio = 0;
		this.capacidad = 0;
		this.dia = 1;
		this.horaInicio = new Date(0);
		this.horaFin = new Date(0);
	}
	
	public Horario(long idHorario, long IPS, long servicio, int capacidad,
			int dia, Date horaInicio, Date horaFin) {
		this.idHorario = idHorario;
		this.IPS = IPS;
		this.servicio = servicio;
		this.capacidad = capacidad;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
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

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}
	
	public String toString() {
		return "Horario [idHorario=" + idHorario + ", IPS=" + IPS +
				", servicio=" + servicio + ", capacidad" + capacidad +
				", dia=" + dia + ", horaInicio" + horaInicio.toString() + 
				", horaFin=" + horaFin.toString() + "]";
	}
}
