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
	
	public Usuario(long id_Usuario, String nombre, String correo, long id,
			long tipo_ID, long rol) {
		this.id_Usuario = id_Usuario;
		this.nombre = nombre;
		this.correo = correo;
		this.id = id;
		this.tipo_ID = tipo_ID;
		this.rol = rol;
	}

	public long getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(long id_Usuario) {
		this.id_Usuario = id_Usuario;
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

	public long getTipo_ID() {
		return tipo_ID;
	}

	public void setTipo_ID(long tipo_ID) {
		this.tipo_ID = tipo_ID;
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
