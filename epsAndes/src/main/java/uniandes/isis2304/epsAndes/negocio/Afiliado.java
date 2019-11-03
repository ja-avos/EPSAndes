package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;
import java.sql.Timestamp;

public class Afiliado implements VOAfiliado{
	
	private long idAfiliado;
	
	private Timestamp fechaNacimiento;
	
	private long usuario;
	
	public Afiliado() {
		this.idAfiliado = 0;
		this.fechaNacimiento = new Timestamp(0);
		this.usuario = 0;
	}
	
	public Afiliado(long idAfiliado, Timestamp fechaNacimiento, long usuario) {
		this.idAfiliado = idAfiliado;
		this.fechaNacimiento = fechaNacimiento;
		this.usuario = usuario;
	}

	public long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public Timestamp getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}
	
	public String toString() {
		return "Afiliado [idAfiliado=" + idAfiliado + ", fechaNacimiento=" +
				fechaNacimiento + ", usuario=" + usuario + "]";
	}
}
