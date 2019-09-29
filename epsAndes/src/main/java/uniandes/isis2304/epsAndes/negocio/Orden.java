package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;

public class Orden implements VOOrden{

	private long codigo;
	
	private Date fecha;
	
	private boolean valido;
	
	public Orden() {
		this.codigo = 0;
		this.fecha = null;
		this.valido = false;
	}
	
	public Orden(long codigo, Date fecha, boolean valido) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.valido = valido;
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
	
	public String toString() {
		return "Orden [codigo=" + codigo + ", fecha=" + fecha.toString() + ", valido=" + String.valueOf(valido) + "]";

	}
}
