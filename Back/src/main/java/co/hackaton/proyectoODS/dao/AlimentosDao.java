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

import co.hackaton.proyectoODS.dto.AlimentosDto;
import co.hackaton.proyectoODS.dto.BeneficiariosDto;

public class AlimentosDao {
	MongoClient conexion;
	MongoDatabase baseDatos;
	MongoCollection<org.bson.Document> alimentos;
	
	public AlimentosDao() {
		try {
			
			conexion = MongoClients.create("mongodb+srv://hackaton:qTIXhEk91x3DGOV0@cluster0.ya7ac.mongodb.net/test");
			baseDatos = conexion.getDatabase("proyecto");
			alimentos = baseDatos.getCollection("alimentos");
			
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
	
	public boolean crear(AlimentosDto alimentosDto) {
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("codigoAlimento", alimentosDto.getCodigoAlimento())
					 .append("nombreAlimento", alimentosDto.getNombreAlimento())
					 .append("caducidadAlimento", alimentosDto.getCaducidadAlimento())
					 .append("tipoAlimento", alimentosDto.getTipoAlimento());
			alimentos.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
	}
	
	public ArrayList<AlimentosDto> listar() {
		ArrayList<AlimentosDto> listado = new ArrayList<AlimentosDto>();
		try {
			ArrayList<Document> documentos = alimentos.find().into(new ArrayList<>());
			for(Document doc: documentos) {
				AlimentosDto nuevo = new AlimentosDto();
				nuevo.setCodigoAlimento(doc.getString("codigoAlimento"));
				nuevo.setNombreAlimento(doc.getString("nombreAlimento"));
				nuevo.setCaducidadAlimento(doc.getString("caducidadAlimento"));
				nuevo.setTipoAlimento(doc.getString("tipoAlimento"));
			listado.add(nuevo);
			}
			System.out.println("Listado generado");
		} catch (Exception e) {
			System.out.println("No se pudo listar los documentos");
		}
		return listado;
	}
	
	public boolean eliminar(String codigoAlimento) {
		boolean rta=false;
		try {
			DeleteResult estado = alimentos.deleteOne(new Document("codigoAlimento", codigoAlimento));
			System.out.println("Se eliminó el documento");
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el documento");
		}
		return rta;
	}
	
	public ArrayList<AlimentosDto> buscar(String codigoAlimento) {
		ArrayList<AlimentosDto> listado = new ArrayList<AlimentosDto>();
		try {
			ArrayList<Document> documentos = alimentos.find(new Document("codigoAlimento", codigoAlimento)).into(new ArrayList<>());
			for(Document doc: documentos) {
				AlimentosDto nuevo = new AlimentosDto();
				nuevo.setCodigoAlimento(doc.getString("codigoAlimento"));
				nuevo.setNombreAlimento(doc.getString("nombreAlimento"));
				nuevo.setCaducidadAlimento(doc.getString("caducidadAlimento"));
				nuevo.setTipoAlimento(doc.getString("tipoAlimento"));
				listado.add(nuevo);
			}
			System.out.println("Documento encontrado");
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
		}
		this.cerrar();
		return listado;
		
	}
	
	public boolean actualizar(AlimentosDto alimentosDto) {
		boolean rta = false;
		try {
			
			Document documento = new Document();
			documento.append("codigoAlimento", alimentosDto.getCodigoAlimento());
			documento.append("nombreAlimento", alimentosDto.getNombreAlimento());
			documento.append("caducidadAlimento", alimentosDto.getCaducidadAlimento());
			documento.append("tipoAlimento", alimentosDto.getTipoAlimento());
			
			Document filtro = new Document("codigoAlimento", alimentosDto.getCodigoAlimento());
			
			UpdateResult estado = alimentos.replaceOne(filtro, documento);
			System.out.println("Documento actualizado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el documento");
		}
		return rta;
	}
}
