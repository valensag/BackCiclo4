package co.ciclo4.proyecto.dto;

public class ProductosDTO{
	
	private Long codigoProducto;
	
	private String nombreProducto;
	
	private Long nitProveedor;
	
	private Double precioCompra;
	
	private Double ivaCompra;
	
	private Double precioVenta;
	
	

	public ProductosDTO() {
		
	}

	public ProductosDTO(Long codigoProducto, String nombreProducto, Long nitProveedor, Double precioCompra,
			Double ivaCompra, Double precioVenta) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.nitProveedor = nitProveedor;
		this.precioCompra = precioCompra;
		this.ivaCompra = ivaCompra;
		this.precioVenta = precioVenta;
	}

	public Long getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Long getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(Long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public Double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Double getIvaCompra() {
		return ivaCompra;
	}

	public void setIvaCompra(Double ivaCompra) {
		this.ivaCompra = ivaCompra;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}
	
		
	
	
	
}
