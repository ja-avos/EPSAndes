package uniandes.isis2304.epsAndes.negocio;

public class Usuario implements VOUsuario{
	
	private long id_Usuario;
	
	private String nombre;
	
	private String correo;
	
	private long id;
	
	private long tipo_ID;
	
	private long rol;
	
	public Usuario() {
		this.id_Usuario = 0;
		this.nombre = "";
		this.correo = "";
		this.id = 0;
		this.tipo_ID = 0;
		this.rol = 0;
	}
	
	public Usuario(long idUsuario, String nombre, String correo, long id,
			long tipoID, long rol) {
		this.id_Usuario = idUsuario;
		this.nombre = nombre;
		this.correo = correo;
		this.id = id;
		this.tipo_ID = tipoID;
		this.rol = rol;
	}

	public long getIdUsuario() {
		return id_Usuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.id_Usuario = idUsuario;
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
		return tipo_ID;
	}

	public void setTipoID(long tipoID) {
		this.tipo_ID = tipoID;
	}

	public long getRol() {
		return rol;
	}

	public void setRol(long rol) {
		this.rol = rol;
	}
	
	public String toString() {
		return "Usuario [idUsuario=" + id_Usuario + ", nombre=" + nombre +
				", correo=" + correo + ", id=" + id + ", tipoID=" + tipo_ID +
				", rol=" + rol + "]";
	}
}
