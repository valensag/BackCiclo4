package co.hackaton.proyectoODS.dto;

public class AlimentosDto {
	
	private String codigoAlimento;
	private String nombreAlimento;
	private String caducidadAlimento;
	private String tipoAlimento;
	
	public AlimentosDto() {
		
	}

	public AlimentosDto(String codigoAlimento, String nombreAlimento, String caducidadAlimento, String tipoAlimento) {
		this.codigoAlimento = codigoAlimento;
		this.nombreAlimento = nombreAlimento;
		this.caducidadAlimento = caducidadAlimento;
		this.tipoAlimento = tipoAlimento;
	}

	public String getCodigoAlimento() {
		return codigoAlimento;
	}

	public void setCodigoAlimento(String codigoAlimento) {
		this.codigoAlimento = codigoAlimento;
	}

	public String getNombreAlimento() {
		return nombreAlimento;
	}

	public void setNombreAlimento(String nombreAlimento) {
		this.nombreAlimento = nombreAlimento;
	}

	public String getCaducidadAlimento() {
		return caducidadAlimento;
	}

	public void setCaducidadAlimento(String caducidadAlimento) {
		this.caducidadAlimento = caducidadAlimento;
	}

	public String getTipoAlimento() {
		return tipoAlimento;
	}

	public void setTipoAlimento(String tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}
	
	
}
