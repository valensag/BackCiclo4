package co.hackaton.proyectoODS.dao;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import co.hackaton.proyectoODS.dto.BeneficiariosDto;

public class BeneficiariosDao {

	MongoClient conexion;
	MongoDatabase baseDatos;
	MongoCollection<org.bson.Document> beneficiarios;
	
	public BeneficiariosDao() {
		try {
			
			conexion = MongoClients.create("mongodb+srv://hackaton:qTIXhEk91x3DGOV0@cluster0.ya7ac.mongodb.net/test");
			baseDatos = conexion.getDatabase("proyecto");
			beneficiarios = baseDatos.getCollection("beneficiarios");
			
		} catch (Exception e) {
		
			System.out.println("Error al conectar");
			
		}
	}
	
	private void cerrar() {
		try {
			
			conexion.close();
			System.out.println("Conexión cerrada");
			
		} catch (Exception e) {
			
			System.out.println("Error al conectar");
			
		}
	}
	
	public boolean crear(BeneficiariosDto beneficiariosDto) {
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("codigoBeneficiario", beneficiariosDto.getCodigoBeneficiario())
				.append("nombreBeneficiario", beneficiariosDto.getNombreBeneficiario())
				.append("personas", beneficiariosDto.getPersonas())
				.append("edades", beneficiariosDto.getEdades())
				.append("requisitosNutricionales", beneficiariosDto.getRequisitosNutricionales())
				.append("motivoNecesidad", beneficiariosDto.getMotivoNecesidad())
				.append("tiempoUsoServicio", beneficiariosDto.getTiempoUsoServicio());
			beneficiarios.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
	}
	
	public ArrayList<BeneficiariosDto> listar() {
		ArrayList<BeneficiariosDto> listado = new ArrayList<BeneficiariosDto>();
		try {
			ArrayList<Document> documentos = beneficiarios.find().into(new ArrayList<>());
			for(Document doc: documentos) {
				BeneficiariosDto nuevo = new BeneficiariosDto();
				nuevo.setCodigoBeneficiario(doc.getString("codigoBeneficiario"));
				nuevo.setNombreBeneficiario(doc.getString("nombreBeneficiario"));
				nuevo.setPersonas(doc.getString("personas"));
				nuevo.setEdades(doc.getString("edades"));
				nuevo.setRequisitosNutricionales(doc.getString("requisitosNutricionales"));
				nuevo.setMotivoNecesidad(doc.getString("motivoNecesidad"));
				nuevo.setTiempoUsoServicio(doc.getString("tiempoUsoServicio"));
			listado.add(nuevo);
			}
			System.out.println("Listado generado");
		} catch (Exception e) {
			System.out.println("No se pudo listar los documentos");
		}
		return listado;
	}

	public boolean eliminar(String codigoBeneficiario) {
		boolean rta=false;
		try {
			DeleteResult estado = beneficiarios.deleteOne(new Document("codigoBeneficiario", codigoBeneficiario));
			System.out.println("Se eliminó el documento");
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el documento");
		}
		return rta;
	}

	public ArrayList<BeneficiariosDto> buscar(String codigoBeneficiario) {
		ArrayList<BeneficiariosDto> listado = new ArrayList<BeneficiariosDto>();
		try {
			ArrayList<Document> documentos = beneficiarios.find(new Document("codigoBeneficiario", codigoBeneficiario)).into(new ArrayList<>());
			for(Document doc: documentos) {
				BeneficiariosDto nuevo = new BeneficiariosDto();
				nuevo.setCodigoBeneficiario(doc.getString("codigoBeneficiario"));
				nuevo.setNombreBeneficiario(doc.getString("nombreBeneficiario"));
				nuevo.setPersonas(doc.getString("personas"));
				nuevo.setEdades(doc.getString("edades"));
				nuevo.setRequisitosNutricionales(doc.getString("requisitosNutricionales"));
				nuevo.setMotivoNecesidad(doc.getString("motivoNecesidad"));
				nuevo.setTiempoUsoServicio(doc.getString("tiempoUsoServicio"));
				
				listado.add(nuevo);
			}
			System.out.println("Documento encontrado");
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
		}
		this.cerrar();
		return listado;
		
	}

	public boolean actualizar(BeneficiariosDto beneficiariosDto) {
		boolean rta = false;
		try {
			
			Document documento = new Document();
			documento.append("codigoBeneficiario", beneficiariosDto.getCodigoBeneficiario());
			documento.append("nombreBeneficiario", beneficiariosDto.getNombreBeneficiario());
			documento.append("personas", beneficiariosDto.getPersonas());
			documento.append("edades", beneficiariosDto.getEdades());
			documento.append("requisitosNutricionales", beneficiariosDto.getRequisitosNutricionales());
			documento.append("motivoNecesidad", beneficiariosDto.getMotivoNecesidad());
			documento.append("tiempoUsoServicio", beneficiariosDto.getTiempoUsoServicio());
			
			Document filtro = new Document("codigoBeneficiario", beneficiariosDto.getCodigoBeneficiario());
			
			UpdateResult estado = beneficiarios.replaceOne(filtro, documento);
			System.out.println("Documento actualizado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el documento");
		}
		return rta;
	}
}
