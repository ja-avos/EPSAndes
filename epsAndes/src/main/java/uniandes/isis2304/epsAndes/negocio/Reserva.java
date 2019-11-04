package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public class Reserva implements VOReserva{

	private long codigo;
	
	private boolean servicio_Prestado;
	
	private Timestamp fecha;
	
	private long horario;
	
	private long afiliado;
	
	private long orden;
	
	private long campana;
	
	public Reserva() {
		this.codigo = 0;
		this.servicio_Prestado = false;
		this.fecha = new Timestamp(0);
		this.horario = 0;
		this.afiliado = 0;
		this.orden = 0;
	}
	
	public Reserva(long codigo, boolean servicioPrestado, Timestamp fecha, 
			long horario, long afiliado, long orden) {
		this.codigo = codigo;
		this.servicio_Prestado = servicioPrestado;
		this.fecha = fecha;
		this.horario = horario;
		this.afiliado = afiliado;
		this.orden = 0;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public boolean isServicio_Prestado() {
		return servicio_Prestado;
	}

	public void setServicio_Prestado(boolean servicio_Prestado) {
		this.servicio_Prestado = servicio_Prestado;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public long getHorario() {
		return horario;
	}

	public void setHorario(long horario) {
		this.horario = horario;
	}

	public long getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(long afiliado) {
		this.afiliado = afiliado;
	}

	public long getOrden() {
		return orden;
	}

	public void setOrden(long orden) {
		this.orden = orden;
	}
	

	public long getCampana() {
		return campana;
	}

	public void setCampana(long campana) {
		this.campana = campana;
	}

	public String toString() {
		return "Reserva [codigo=" + codigo + ", servicioPrestado=" + String.valueOf(servicio_Prestado) +
				", fecha=" + fecha.toString() + ", horario=" + horario +
				", afiliado=" + afiliado + ", orden=" + orden + "]";
	}
}
