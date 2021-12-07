package co.ciclo4.proyecto;


import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.ciclo4.proyecto.dao.ProductosDAO;

import co.ciclo4.proyecto.dto.ProductosDTO;




@CrossOrigin(origins = "http://localhost:8093")
@RestController
public class Productos {
	
	
	/*@PostMapping("/loginclient")
	public int login(@PathVariable("nombreProducto") String nombreProducto) {
		ProductosDAO Productos = new ProductosDAO();
		int responseLogin = Productos.login(nombreProducto);
		return responseLogin;
	}*/
	
		
	@PostMapping("/crearProducto")
	public boolean crearProducto(@RequestBody ProductosDTO ProductosDTO) {
		boolean estado = false;
		ProductosDAO Productos = new ProductosDAO();
		estado = Productos.crear(ProductosDTO);
		return estado;
	}
	
	@GetMapping("/listarProductos")
	public ArrayList<ProductosDTO> listarProductos() {
		ArrayList<ProductosDTO> listado;
		ProductosDAO Productos = new ProductosDAO();
		listado = Productos.listar();
		return listado;
	}
	
	@DeleteMapping("/eliminarProducto/{codigoProducto}")
	public boolean eliminarProducto(@PathVariable("codigoProducto") Long codigoProducto) {
		boolean rta = false;
		ProductosDAO Productos = new ProductosDAO();
		rta = Productos.eliminar(codigoProducto);
		return rta;
	}
	
	@GetMapping("/buscarProducto/{codigoProducto}")
	public ArrayList<ProductosDTO> buscarProducto(@PathVariable("codigoProducto")Long codigoProducto) {
		ArrayList<ProductosDTO> listado;
		ProductosDAO Productos = new ProductosDAO();
		listado = Productos.buscar(codigoProducto);
		return listado;
	}
	
	@PutMapping("/actualizarProducto")
	public boolean actualizarProducto(@RequestBody ProductosDTO ProductosDTO) {
		boolean estado = false;
		ProductosDAO Productos = new ProductosDAO();
		estado = Productos.actualizar(ProductosDTO);
		return estado;
	}
}


