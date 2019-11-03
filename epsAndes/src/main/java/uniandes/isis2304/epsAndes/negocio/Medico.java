package uniandes.isis2304.epsAndes.negocio;

public class Medico implements VOMedico{

	private long id_Medico;
	
	private long registro_Medico;
	
	private String especialidad;
	
	private long usuario;
	
	public Medico() {
		this.id_Medico = 0;
		this.registro_Medico = 0;
		this.especialidad = "";
		this.usuario = 0;
	}
	
	public Medico(long idMedico, long registroMedico, String especialidad, long usuario) {
		this.id_Medico = idMedico;
		this.registro_Medico = registroMedico;
		this.especialidad = especialidad;
		this.usuario = usuario;
	}

	public long getId_Medico() {
		return id_Medico;
	}

	public void setId_Medico(long id_Medico) {
		this.id_Medico = id_Medico;
	}

	public long getRegistro_Medico() {
		return registro_Medico;
	}

	public void setRegistro_Medico(long registro_Medico) {
		this.registro_Medico = registro_Medico;
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
		return "Medico [idMedico=" + id_Medico + ", registroMedico=" + registro_Medico +
				", especialidad=" + especialidad + ", usuario=" + usuario + "]";
	}
}
