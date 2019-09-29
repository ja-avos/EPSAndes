package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

public class Orden implements VOOrden{

	private long codigo;
	
	private Date fecha;
	
	private boolean valido;
	
	private long medicoRemitente;
	
	private long servicio;
	
	private long afiliado;
	
	public Orden() {
		this.codigo = 0;
		this.fecha = new Date(0);
		this.valido = false;
		this.medicoRemitente = 0;
		this.servicio = 0;
		this.afiliado = 0;
	}
	
	public Orden(long codigo, Date fecha, boolean valido, long medicoRemitente,
			long servicio, long afiliado) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.valido = valido;
		this.medicoRemitente = medicoRemitente;
		this.servicio = servicio;
		this.afiliado = afiliado;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}
	
	public long getMedicoRemitente() {
		return medicoRemitente;
	}

	public void setMedicoRemitente(long medicoRemitente) {
		this.medicoRemitente = medicoRemitente;
	}

	public long getServicio() {
		return servicio;
	}

	public void setServicio(long servicio) {
		this.servicio = servicio;
	}

	public long getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(long afiliado) {
		this.afiliado = afiliado;
	}

	public String toString() {
		return "Orden [codigo=" + codigo + ", fecha=" + fecha.toString() + ", valido=" + String.valueOf(valido) + "]";

	}
}
