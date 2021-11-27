package co.hackaton.proyectoODS.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "proveedores")
public class ProveedoresDto {
	
	private String codigoProveedor;
	private String nombreProveedor;
	private String ubicacionProveedor;
	private Boolean envioProveedor;
	private String aperturaProveedor;
	private String cierreProveedor;
	
	public ProveedoresDto() {
		
	}

	public ProveedoresDto(String codigoProveedor, String nombreProveedor, String ubicacionProveedor,
			Boolean envioProveedor, String aperturaProveedor, String cierreProveedor) {
		
		this.codigoProveedor = codigoProveedor;
		this.nombreProveedor = nombreProveedor;
		this.ubicacionProveedor = ubicacionProveedor;
		this.envioProveedor = envioProveedor;
		this.aperturaProveedor = aperturaProveedor;
		this.cierreProveedor = cierreProveedor;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getUbicacionProveedor() {
		return ubicacionProveedor;
	}

	public void setUbicacionProveedor(String ubicacionProveedor) {
		this.ubicacionProveedor = ubicacionProveedor;
	}

	public Boolean getEnvioProveedor() {
		return envioProveedor;
	}

	public void setEnvioProveedor(Boolean envioProveedor) {
		this.envioProveedor = envioProveedor;
	}

	public String getAperturaProveedor() {
		return aperturaProveedor;
	}

	public void setAperturaProveedor(String aperturaProveedor) {
		this.aperturaProveedor = aperturaProveedor;
	}

	public String getCierreProveedor() {
		return cierreProveedor;
	}

	public void setCierreProveedor(String cierreProveedor) {
		this.cierreProveedor = cierreProveedor;
	}
	

}
