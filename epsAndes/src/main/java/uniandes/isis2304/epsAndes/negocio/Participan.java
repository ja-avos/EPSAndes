package uniandes.isis2304.epsAndes.negocio;

public class Participan implements VOParticipan{

	private long id_afiliado;
	
	private long id_campana;
	
	public Participan(){
		this.id_afiliado = 0;
		this.id_campana = 0;
	}
	
	public Participan (long id_afiliado, long id_campana) {
		this.id_afiliado = id_afiliado;
		this.id_campana = id_campana;
	}

	public long getId_afiliado() {
		return id_afiliado;
	}

	public void setId_afiliado(long id_afiliado) {
		this.id_afiliado = id_afiliado;
	}

	public long getId_campana() {
		return id_campana;
	}

	public void setId_campana(long id_campana) {
		this.id_campana = id_campana;
	}
}
