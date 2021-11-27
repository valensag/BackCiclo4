package co.hackaton.proyectoODS.dao;


import com.mongodb.client.MongoClients;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import co.hackaton.proyectoODS.dto.ProveedoresDto;

public class ProveedoresDao {
	
	MongoClient conexion;
	MongoDatabase baseDatos;
	MongoCollection<org.bson.Document> proveedores;
	
	public ProveedoresDao() {
		try {
			
			conexion = MongoClients.create("mongodb+srv://hackaton:qTIXhEk91x3DGOV0@cluster0.ya7ac.mongodb.net/test");
			baseDatos = conexion.getDatabase("proyecto");
			proveedores = baseDatos.getCollection("proveedores");
			
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
	
	/**
	 * 
	 * @param proveedoresDto
	 * @return
	 */
	public boolean crear(ProveedoresDto proveedoresDto) {
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("codigoProveedor", proveedoresDto.getCodigoProveedor())
				.append("nombreProveedor", proveedoresDto.getNombreProveedor())
				.append("ubicacionProveedor", proveedoresDto.getUbicacionProveedor())
				.append("envioProveedor", proveedoresDto.getEnvioProveedor())
				.append("apperturaProveedor", proveedoresDto.getAperturaProveedor())
				.append("cierreProveedor", proveedoresDto.getCierreProveedor());
			proveedores.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
	}
	
	public ArrayList<ProveedoresDto> listar() {
		ArrayList<ProveedoresDto> listado = new ArrayList<ProveedoresDto>();
		try {
			ArrayList<Document> documentos = proveedores.find().into(new ArrayList<>());
			for(Document documento: documentos) {
				ProveedoresDto nuevo = new ProveedoresDto();
				nuevo.setCodigoProveedor(documento.getString("codigoProveedor"));
				nuevo.setNombreProveedor(documento.getString("nombreProveedor"));
				nuevo.setUbicacionProveedor(documento.getString("ubicacionProveedor"));
				nuevo.setEnvioProveedor(documento.getBoolean("envioProveedor"));
				nuevo.setAperturaProveedor(documento.getString("aperturaProveedor"));
				nuevo.setCierreProveedor(documento.getString("cierreProveedor"));
			listado.add(nuevo);
			}
			System.out.println("Listado generado");
		} catch (Exception e) {
			System.out.println("No se pudo listar los documentos");
		}
		return listado;
	}

	public boolean eliminar(String codigoProveedor) {
		boolean rta=false;
		try {
			DeleteResult estado = proveedores.deleteOne(new Document("codigoProveedor", codigoProveedor));
			System.out.println("Se eliminó el documento");
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el documento");
		}
		return rta;
	}

	public ArrayList<ProveedoresDto> buscar(String codigoProveedor) {
		ArrayList<ProveedoresDto> listado = new ArrayList<ProveedoresDto>();
		try {
			ArrayList<Document> documentos = proveedores.find(new Document("codigoProveedor", codigoProveedor)).into(new ArrayList<>());
			for(Document doc: documentos) {
				ProveedoresDto nuevo = new ProveedoresDto();
				nuevo.setCodigoProveedor(doc.getString("codigoProveedor"));
				nuevo.setNombreProveedor(doc.getString("nombreProveedor"));
				nuevo.setUbicacionProveedor(doc.getString("ubicacionProveedor"));
				nuevo.setEnvioProveedor(doc.getBoolean("envioProveedor"));
				nuevo.setAperturaProveedor(doc.getString("aperturaProveedor"));
				nuevo.setCierreProveedor(doc.getString("cierreProveedor"));
				
				listado.add(nuevo);
			}
			System.out.println("Documento encontrado");
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
		}
		this.cerrar();
		return listado;
		
	}

	public boolean actualizar(ProveedoresDto proveedoresDto) {
		boolean rta = false;
		try {
			
			Document documento = new Document();
			documento.append("codigoProveedor", proveedoresDto.getCodigoProveedor());
			documento.append("nombreProveedor", proveedoresDto.getNombreProveedor());
			documento.append("ubicacionProveedor", proveedoresDto.getUbicacionProveedor());
			documento.append("envioProveedor", proveedoresDto.getEnvioProveedor());
			documento.append("aperturaProveedor", proveedoresDto.getAperturaProveedor());
			documento.append("cierreProveedor", proveedoresDto.getCierreProveedor());
			
			Document filtro = new Document("codigoProveedor", proveedoresDto.getCodigoProveedor());
			
			UpdateResult estado = proveedores.replaceOne(filtro, documento);
			System.out.println("Documento actualizado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el documento");
		}
		return rta;
	}
}
