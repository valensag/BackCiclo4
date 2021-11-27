package co.hackaton.proyectoODS;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.hackaton.proyectoODS.dao.AlimentosDao;
import co.hackaton.proyectoODS.dao.BeneficiariosDao;
import co.hackaton.proyectoODS.dto.AlimentosDto;
import co.hackaton.proyectoODS.dto.BeneficiariosDto;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AlimentosController {
	
	@PostMapping("/crearAlimento")
	public boolean crearAlimento(@RequestBody AlimentosDto alimentosDto) {
		boolean estado = false;
		AlimentosDao alimentos = new AlimentosDao();
		estado = alimentos.crear(alimentosDto);
		return estado;
	}
	
	@GetMapping("/listarAlimentos")
	public ArrayList<AlimentosDto> listarAlimentos() {
		ArrayList<AlimentosDto> listado;
		AlimentosDao alimentos = new AlimentosDao();
		listado = alimentos.listar();
		return listado;
	}
	
	@DeleteMapping("/eliminarAlimento/{codigoAlimento}")
	public boolean eliminarAlimento(@PathVariable("codigoAlimento") String codigoAlimento) {
		boolean rta = false;
		AlimentosDao alimentos = new AlimentosDao();
		rta = alimentos.eliminar(codigoAlimento);
		return rta;
	}
	
	@GetMapping("/buscarAlimento/{codigoAlimento}")
	public ArrayList<AlimentosDto> buscarAlimento(@PathVariable("codigoAlimento")String codigoAlimento) {
		ArrayList<AlimentosDto> listado;
		AlimentosDao alimentos = new AlimentosDao();
		listado = alimentos.buscar(codigoAlimento);
		return listado;
	}
	
	@PutMapping("/actualizarAlimento")
	public boolean actualizarAlimento(@RequestBody AlimentosDto alimentosDto) {
		boolean estado = false;
		AlimentosDao alimentos = new AlimentosDao();
		estado = alimentos.actualizar(alimentosDto);
		return estado;
	}
}
