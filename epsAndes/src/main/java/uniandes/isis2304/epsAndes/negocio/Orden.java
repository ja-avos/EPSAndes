package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public class Orden implements VOOrden{

	private long codigo;
	
	private Timestamp fecha;
	
	private boolean valido;
	
	private long medico_Remit;
	
	private long servicio;
	
	private long afiliado;
	
	public Orden() {
		this.codigo = 0;
		this.fecha = new Timestamp(0);
		this.valido = false;
		this.medico_Remit = 0;
		this.servicio = 0;
		this.afiliado = 0;
	}
	
	public Orden(long codigo, Timestamp fecha, boolean valido, long medicoRemitente,
			long servicio, long afiliado) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.valido = valido;
		this.medico_Remit = medicoRemitente;
		this.servicio = servicio;
		this.afiliado = afiliado;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public long getMedico_Remit() {
		return medico_Remit;
	}

	public void setMedico_Remit(long medico_Remit) {
		this.medico_Remit = medico_Remit;
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
