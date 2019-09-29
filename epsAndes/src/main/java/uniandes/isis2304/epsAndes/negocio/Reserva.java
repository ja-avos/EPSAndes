package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

public class Reserva implements VOReserva{

	private long codigo;
	
	private boolean servicioPrestado;
	
	private Date fecha;
	
	private long horario;
	
	private long afiliado;
	
	private long orden;
	
	public Reserva() {
		this.codigo = 0;
		this.servicioPrestado = false;
		this.fecha = null;
		this.horario = 0;
		this.afiliado = 0;
		this.orden = 0;
	}
	
	public Reserva(long codigo, boolean servicioPrestado, Date fecha, 
			long horario, long afiliado, long orden) {
		this.codigo = codigo;
		this.servicioPrestado = servicioPrestado;
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

	public boolean isServicioPrestado() {
		return servicioPrestado;
	}

	public void setServicioPrestado(boolean servicioPrestado) {
		this.servicioPrestado = servicioPrestado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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

	public String toString() {
		return "Reserva [codigo=" + codigo + ", servicioPrestado=" + String.valueOf(servicioPrestado) +
				", fecha=" + fecha.toString() + ", horario=" + horario +
				", afiliado=" + afiliado + ", orden=" + orden + "]";
	}
}
