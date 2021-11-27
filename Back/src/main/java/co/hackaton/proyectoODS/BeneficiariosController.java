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

import co.hackaton.proyectoODS.dao.BeneficiariosDao;
import co.hackaton.proyectoODS.dto.BeneficiariosDto;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class BeneficiariosController {
	
	@PostMapping("/crearBeneficiario")
	public boolean crearBeneficiario(@RequestBody BeneficiariosDto beneficiariosDto) {
		boolean estado = false;
		BeneficiariosDao beneficiarios = new BeneficiariosDao();
		estado = beneficiarios.crear(beneficiariosDto);
		return estado;
	}
	
	@GetMapping("/listarBeneficiarios")
	public ArrayList<BeneficiariosDto> listarBeneficiarios() {
		ArrayList<BeneficiariosDto> listado;
		BeneficiariosDao beneficiarios = new BeneficiariosDao();
		listado = beneficiarios.listar();
		return listado;
	}
	
	@DeleteMapping("/eliminarBeneficiario/{codigoBeneficiario}")
	public boolean eliminarBeneficiario(@PathVariable("codigoBeneficiario") String codigoBeneficiario) {
		boolean rta = false;
		BeneficiariosDao beneficiarios = new BeneficiariosDao();
		rta = beneficiarios.eliminar(codigoBeneficiario);
		return rta;
	}
	
	@GetMapping("/buscarBeneficiario/{codigoBeneficiario}")
	public ArrayList<BeneficiariosDto> buscarBeneficiario(@PathVariable("codigoBeneficiario")String codigoBeneficiario) {
		ArrayList<BeneficiariosDto> listado;
		BeneficiariosDao beneficiarios = new BeneficiariosDao();
		listado = beneficiarios.buscar(codigoBeneficiario);
		return listado;
	}
	
	@PutMapping("/actualizarBeneficiario")
	public boolean actualizarBeneficiario(@RequestBody BeneficiariosDto beneficiariosDto) {
		boolean estado = false;
		BeneficiariosDao beneficiarios = new BeneficiariosDao();
		estado = beneficiarios.actualizar(beneficiariosDto);
		return estado;
	}
}
