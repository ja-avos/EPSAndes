package uniandes.isis2304.epsAndes.negocio;

import java.sql.Date;
import java.sql.Timestamp;

public class Afiliado implements VOAfiliado{
	
	private long id_Afiliado;
	
	private Timestamp fechaNacimiento;
	
	private long usuario;
	
	public Afiliado() {
		this.id_Afiliado = 0;
		this.fechaNacimiento = new Timestamp(0);
		this.usuario = 0;
	}
	
	public Afiliado(long idAfiliado, Timestamp fechaNacimiento, long usuario) {
		this.id_Afiliado = idAfiliado;
		this.fechaNacimiento = fechaNacimiento;
		this.usuario = usuario;
	}

	public long getIdAfiliado() {
		return id_Afiliado;
	}

	public void setIdAfiliado(long idAfiliado) {
		this.id_Afiliado = idAfiliado;
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
		return "Afiliado [idAfiliado=" + id_Afiliado + ", fechaNacimiento=" +
				fechaNacimiento + ", usuario=" + usuario + "]";
	}
}
