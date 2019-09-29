package uniandes.isis2304.epsAndes.negocio;

public class Usuario implements VOUsuario{
	
	private long idUsuario;
	
	private String nombre;
	
	private String correo;
	
	private long id;
	
	private long tipoID;
	
	private long rol;
	
	public Usuario() {
		this.idUsuario = 0;
		this.nombre = "";
		this.correo = "";
		this.id = 0;
		this.tipoID = 0;
		this.rol = 0;
	}
	
	public Usuario(long idUsuario, String nombre, String correo, long id,
			long tipoID, long rol) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.correo = correo;
		this.id = id;
		this.tipoID = tipoID;
		this.rol = rol;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTipoID() {
		return tipoID;
	}

	public void setTipoID(long tipoID) {
		this.tipoID = tipoID;
	}

	public long getRol() {
		return rol;
	}

	public void setRol(long rol) {
		this.rol = rol;
	}
	
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre +
				", correo=" + correo + ", id=" + id + ", tipoID=" + tipoID +
				", rol=" + rol + "]";
	}
}
