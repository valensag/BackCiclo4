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


import co.ciclo4.proyecto.dao.ProveedoresDAO;

import co.ciclo4.proyecto.dto.ProveedoresDTO;




@CrossOrigin(origins = "http://localhost:8092")
@RestController
public class Proveedores {
	
	
	/*@PostMapping("/loginclient")
	public int login(@PathVariable("nombreProveedor") String nombreProveedor) {
		ProveedoresDAO Proveedores = new ProveedoresDAO();
		int responseLogin = Proveedores.login(nombreProveedor);
		return responseLogin;
	}*/
	
		
	@PostMapping("/crearProveedor")
	public boolean crearProveedor(@RequestBody ProveedoresDTO ProveedoresDTO) {
		boolean estado = false;
		ProveedoresDAO Proveedores = new ProveedoresDAO();
		estado = Proveedores.crear(ProveedoresDTO);
		return estado;
	}
	
	@GetMapping("/listarProveedores")
	public ArrayList<ProveedoresDTO> listarProveedores() {
		ArrayList<ProveedoresDTO> listado;
		ProveedoresDAO Proveedores = new ProveedoresDAO();
		listado = Proveedores.listar();
		return listado;
	}
	
	@DeleteMapping("/eliminarProveedor/{cedulaProveedor}")
	public boolean eliminarProveedor(@PathVariable("cedulaProveedor") Long cedulaProveedor) {
		boolean rta = false;
		ProveedoresDAO Proveedores = new ProveedoresDAO();
		rta = Proveedores.eliminar(cedulaProveedor);
		return rta;
	}
	
	@GetMapping("/buscarProveedor/{cedulaProveedor}")
	public ArrayList<ProveedoresDTO> buscarProveedor(@PathVariable("cedulaProveedor")Long cedulaProveedor) {
		ArrayList<ProveedoresDTO> listado;
		ProveedoresDAO Proveedores = new ProveedoresDAO();
		listado = Proveedores.buscar(cedulaProveedor);
		return listado;
	}
	
	@PutMapping("/actualizarProveedor")
	public boolean actualizarProveedor(@RequestBody ProveedoresDTO ProveedoresDTO) {
		boolean estado = false;
		ProveedoresDAO Proveedores = new ProveedoresDAO();
		estado = Proveedores.actualizar(ProveedoresDTO);
		return estado;
	}
}


