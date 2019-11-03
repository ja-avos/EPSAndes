package uniandes.isis2304.epsAndes.negocio;

public class Rol implements VORol{
	
	private long id_Rol;
	
	private String rol;
	
	public Rol() {
		this.id_Rol = 0;
		this.rol = "";
	}
	
	public Rol(long idRol, String rol) {
		this.id_Rol = idRol;
		this.rol = rol;
	}

	public long getId_Rol() {
		return id_Rol;
	}

	public void setId_Rol(long id_Rol) {
		this.id_Rol = id_Rol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public String toString() {
		return "Rol [idRol=" + id_Rol + ", rol=" + rol + "]";
	}
}
