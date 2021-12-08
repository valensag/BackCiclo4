package co.ciclo4.proyecto.dao;



import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import co.ciclo4.proyecto.dto.ProveedoresDTO;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

public class ProveedoresDAO {
	MongoClient conexion;
	MongoDatabase baseDatos;
	MongoCollection<org.bson.Document> Proveedores;
	
	public ProveedoresDAO() {
		try {
			
			conexion = MongoClients.create("mongodb://localhost");
			baseDatos = conexion.getDatabase("proyecto");
			Proveedores = baseDatos.getCollection("Proveedores");
			
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
	
	public boolean crear(ProveedoresDTO ProveedoresDTO) {
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("nitProveedor", ProveedoresDTO.getNitProveedor())
					 .append("ciudadProveedor", ProveedoresDTO.getCiudadProveedor())
					 .append("direccionProveedor", ProveedoresDTO.getDireccionProveedor())
					 .append("nombreProveedor", ProveedoresDTO.getNombreProveedor())
					 .append("telefonoProveedor", ProveedoresDTO.getTelefonoProveedor());
					 
			Proveedores.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
	}
	
	public ArrayList<ProveedoresDTO> listar() {
		ArrayList<ProveedoresDTO> listado = new ArrayList<ProveedoresDTO>();
		try {
			ArrayList<Document> documentos = Proveedores.find().into(new ArrayList<>());
			for(Document doc: documentos) {
				ProveedoresDTO nuevo = new ProveedoresDTO();
				nuevo.setNitProveedor(doc.getLong("nitProveedor"));
				nuevo.setCiudadProveedor(doc.getString("ciudadProveedor"));
				nuevo.setDireccionProveedor(doc.getString("direccionProveedor"));
				nuevo.setNombreProveedor(doc.getString("nombreProveedor"));
				nuevo.setTelefonoProveedor(doc.getString("telefonoProveedor"));
			
				
			listado.add(nuevo);
			}
			System.out.println("Listado generado");
		} catch (Exception e) {
			System.out.println("No se pudo listar los documentos");
		}
		return listado;
	}
	
	public boolean eliminar(Long cedulaProveedor) {
		boolean rta=false;
		try {
			DeleteResult estado = Proveedores.deleteOne(new Document("cedulaProveedor", cedulaProveedor));
			System.out.println("Se eliminó el documento");
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el documento");
		}
		return rta;
	}
	
	/*public int login(LoginDTO nombreProveedor) {
		ArrayList<ProveedoresDTO> listado = new ArrayList<ProveedoresDTO>();
		try {
			ArrayList<Document> documentos = Proveedores.find(new Document("Proveedor", nombreProveedor)).into(new ArrayList<>());
			System.out.println("Voy acá 11");
			
		}
		catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
			
		}
		
		return 1;
		
	}*/
	
	public ArrayList<ProveedoresDTO> buscar(Long NitProveedor) {
		ArrayList<ProveedoresDTO> listado = new ArrayList<ProveedoresDTO>();
		try {
			ArrayList<Document> documentos = Proveedores.find(new Document("nitProveedor", NitProveedor)).into(new ArrayList<>());
			for(Document doc: documentos) {
				ProveedoresDTO nuevo = new ProveedoresDTO();
				nuevo.setNitProveedor(doc.getLong("nitProveedor"));
				nuevo.setCiudadProveedor(doc.getString("ciudadProveedor"));
				nuevo.setDireccionProveedor(doc.getString("direccionProveedor"));
				nuevo.setNombreProveedor(doc.getString("nombreProveedor"));
				nuevo.setTelefonoProveedor(doc.getString("telefonoProveedor"));
				listado.add(nuevo);
			}
			System.out.println("Documento encontrado");
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
		}
		this.cerrar();
		return listado;
		
	}
	
	
	
	
	public boolean actualizar(ProveedoresDTO ProveedoresDTO) {
		boolean rta = false;
		try {
			
			Document documento = new Document();
			documento.append("nitProveedor", ProveedoresDTO.getNitProveedor());
			documento.append("ciudadProveedor", ProveedoresDTO.getCiudadProveedor());
			documento.append("direccionProveedor", ProveedoresDTO.getDireccionProveedor());
			documento.append("nombreProveedor", ProveedoresDTO.getNombreProveedor());
			documento.append("telefonoProveedor", ProveedoresDTO.getTelefonoProveedor());
			
			
			
			Document filtro = new Document("nitProveedor", ProveedoresDTO.getNitProveedor());
			
			UpdateResult estado = Proveedores.replaceOne(filtro, documento);
			System.out.println("Documento actualizado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el documento");
		}
		return rta;
	}
}
