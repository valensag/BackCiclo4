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


import co.ciclo4.proyecto.dao.UsuariosDAO;
import co.ciclo4.proyecto.dto.LoginDTO;
import co.ciclo4.proyecto.dto.UsuariosDTO;




@CrossOrigin(origins = "http://localhost:8090")
@RestController
public class Usuarios {
	
	
	/*@PostMapping("/loginclient")
	public int login(@PathVariable("nombreUsuario") String nombreUsuario) {
		UsuariosDAO Usuarios = new UsuariosDAO();
		int responseLogin = Usuarios.login(nombreUsuario);
		return responseLogin;
	}*/
	
		
	@PostMapping("/crearUsuario")
	public boolean crearUsuario(@RequestBody UsuariosDTO UsuariosDTO) {
		boolean estado = false;
		UsuariosDAO Usuarios = new UsuariosDAO();
		estado = Usuarios.crear(UsuariosDTO);
		return estado;
	}
	
	@GetMapping("/listarUsuarios")
	public ArrayList<UsuariosDTO> listarUsuarios() {
		ArrayList<UsuariosDTO> listado;
		UsuariosDAO Usuarios = new UsuariosDAO();
		listado = Usuarios.listar();
		return listado;
	}
	
	@DeleteMapping("/eliminarUsuario/{cedulaUsuario}")
	public boolean eliminarUsuario(@PathVariable("cedulaUsuario") Long cedulaUsuario) {
		boolean rta = false;
		UsuariosDAO Usuarios = new UsuariosDAO();
		rta = Usuarios.eliminar(cedulaUsuario);
		return rta;
	}
	
	@GetMapping("/buscarUsuario/{cedulaUsuario}")
	public ArrayList<UsuariosDTO> buscarUsuario(@PathVariable("cedulaUsuario")Long cedulaUsuario) {
		ArrayList<UsuariosDTO> listado;
		UsuariosDAO Usuarios = new UsuariosDAO();
		listado = Usuarios.buscar(cedulaUsuario);
		return listado;
	}
	
	@PutMapping("/actualizarUsuario")
	public boolean actualizarUsuario(@RequestBody UsuariosDTO UsuariosDTO) {
		boolean estado = false;
		UsuariosDAO Usuarios = new UsuariosDAO();
		estado = Usuarios.actualizar(UsuariosDTO);
		return estado;
	}
}


