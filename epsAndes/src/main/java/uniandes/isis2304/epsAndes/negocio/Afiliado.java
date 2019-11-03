package uniandes.isis2304.epsAndes.negocio;

import java.sql.Timestamp;

public class Afiliado implements VOAfiliado{
	
	private long id_Afiliado;
	
	private Timestamp fecha_Nacimiento;
	
	private long usuario;
	
	public Afiliado() {
		this.id_Afiliado = 0;
		this.fecha_Nacimiento = new Timestamp(0);
		this.usuario = 0;
	}
	
	public Afiliado(long idAfiliado, Timestamp fechaNacimiento, long usuario) {
		this.id_Afiliado = idAfiliado;
		this.fecha_Nacimiento = fechaNacimiento;
		this.usuario = usuario;
	}

	public long getId_Afiliado() {
		return id_Afiliado;
	}

	public void setId_Afiliado(long id_Afiliado) {
		this.id_Afiliado = id_Afiliado;
	}

	public Timestamp getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(Timestamp fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}
	
	public String toString() {
		return "Afiliado [idAfiliado=" + id_Afiliado + ", fechaNacimiento=" +
				fecha_Nacimiento + ", usuario=" + usuario + "]";
	}
}
