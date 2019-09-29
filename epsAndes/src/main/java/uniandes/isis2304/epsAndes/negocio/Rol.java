package uniandes.isis2304.epsAndes.negocio;

public class Rol implements VORol{
	
	private long idRol;
	
	private String rol;
	
	public Rol() {
		this.idRol = 0;
		this.rol = "";
	}
	
	public Rol(long idRol, String rol) {
		this.idRol = idRol;
		this.rol = rol;
	}

	public long getIdRol() {
		return idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public String toString() {
		return "Rol [idRol=" + idRol + ", rol=" + rol + "]";
	}
}
