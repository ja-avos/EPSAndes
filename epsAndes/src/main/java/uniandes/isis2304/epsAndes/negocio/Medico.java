package uniandes.isis2304.epsAndes.negocio;

public class Medico implements VOMedico{

	private long idMedico;
	
	private long registroMedico;
	
	private String especialidad;
	
	private long usuario;
	
	public Medico() {
		this.idMedico = 0;
		this.registroMedico = 0;
		this.especialidad = "";
		this.usuario = 0;
	}
	
	public Medico(long idMedico, long registroMedico, String especialidad, long usuario) {
		this.idMedico = idMedico;
		this.registroMedico = registroMedico;
		this.especialidad = especialidad;
		this.usuario = usuario;
	}

	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {
		this.idMedico = idMedico;
	}

	public long getRegistroMedico() {
		return registroMedico;
	}

	public void setRegistroMedico(long registroMedico) {
		this.registroMedico = registroMedico;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}
	
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", registroMedico=" + registroMedico +
				", especialidad=" + especialidad + ", usuario=" + usuario + "]";
	}
}
