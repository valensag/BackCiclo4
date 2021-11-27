package co.hackaton.proyectoODS.dto;

public class BeneficiariosDto {
	
	private String codigoBeneficiario;
	private String nombreBeneficiario;
	private String personas;
	private String edades;
	private String requisitosNutricionales;
	private String motivoNecesidad;
	private String tiempoUsoServicio;
	
	public BeneficiariosDto() {
		
	}

	public BeneficiariosDto(String codigoBeneficiario, String nombreBeneficiario, String personas, String edades,
			String requisitosNutricionales, String motivoNecesidad, String tiempoUsoServicio) {
		super();
		this.codigoBeneficiario = codigoBeneficiario;
		this.nombreBeneficiario = nombreBeneficiario;
		this.personas = personas;
		this.edades = edades;
		this.requisitosNutricionales = requisitosNutricionales;
		this.motivoNecesidad = motivoNecesidad;
		this.tiempoUsoServicio = tiempoUsoServicio;
	}

	public String getCodigoBeneficiario() {
		return codigoBeneficiario;
	}

	public void setCodigoBeneficiario(String codigoBeneficiario) {
		this.codigoBeneficiario = codigoBeneficiario;
	}

	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}

	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}

	public String getPersonas() {
		return personas;
	}

	public void setPersonas(String personas) {
		this.personas = personas;
	}

	public String getEdades() {
		return edades;
	}

	public void setEdades(String edades) {
		this.edades = edades;
	}

	public String getRequisitosNutricionales() {
		return requisitosNutricionales;
	}

	public void setRequisitosNutricionales(String requisitosNutricionales) {
		this.requisitosNutricionales = requisitosNutricionales;
	}

	public String getMotivoNecesidad() {
		return motivoNecesidad;
	}

	public void setMotivoNecesidad(String motivoNecesidad) {
		this.motivoNecesidad = motivoNecesidad;
	}

	public String getTiempoUsoServicio() {
		return tiempoUsoServicio;
	}

	public void setTiempoUsoServicio(String tiempoUsoServicio) {
		this.tiempoUsoServicio = tiempoUsoServicio;
	}

	
}
