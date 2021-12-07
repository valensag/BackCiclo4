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


import co.ciclo4.proyecto.dao.ClientesDAO;

import co.ciclo4.proyecto.dto.ClientesDTO;




@CrossOrigin(origins = "http://localhost:8092")
@RestController
public class Clientes {
	
	
	/*@PostMapping("/loginclient")
	public int login(@PathVariable("nombreCliente") String nombreCliente) {
		ClientesDAO Clientes = new ClientesDAO();
		int responseLogin = Clientes.login(nombreCliente);
		return responseLogin;
	}*/
	
		
	@PostMapping("/crearCliente")
	public boolean crearCliente(@RequestBody ClientesDTO ClientesDTO) {
		boolean estado = false;
		ClientesDAO Clientes = new ClientesDAO();
		estado = Clientes.crear(ClientesDTO);
		return estado;
	}
	
	@GetMapping("/listarClientes")
	public ArrayList<ClientesDTO> listarClientes() {
		ArrayList<ClientesDTO> listado;
		ClientesDAO Clientes = new ClientesDAO();
		listado = Clientes.listar();
		return listado;
	}
	
	@DeleteMapping("/eliminarCliente/{cedulaCliente}")
	public boolean eliminarCliente(@PathVariable("cedulaCliente") Long cedulaCliente) {
		boolean rta = false;
		ClientesDAO Clientes = new ClientesDAO();
		rta = Clientes.eliminar(cedulaCliente);
		return rta;
	}
	
	@GetMapping("/buscarCliente/{cedulaCliente}")
	public ArrayList<ClientesDTO> buscarCliente(@PathVariable("cedulaCliente")Long cedulaCliente) {
		ArrayList<ClientesDTO> listado;
		ClientesDAO Clientes = new ClientesDAO();
		listado = Clientes.buscar(cedulaCliente);
		return listado;
	}
	
	@PutMapping("/actualizarCliente")
	public boolean actualizarCliente(@RequestBody ClientesDTO ClientesDTO) {
		boolean estado = false;
		ClientesDAO Clientes = new ClientesDAO();
		estado = Clientes.actualizar(ClientesDTO);
		return estado;
	}
}


