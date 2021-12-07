package co.ciclo4.proyecto.dao;



import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import co.ciclo4.proyecto.dto.ClientesDTO;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

public class ClientesDAO {
	MongoClient conexion;
	MongoDatabase baseDatos;
	MongoCollection<org.bson.Document> Clientes;
	
	public ClientesDAO() {
		try {
			
			conexion = MongoClients.create("mongodb://localhost");
			baseDatos = conexion.getDatabase("proyecto");
			Clientes = baseDatos.getCollection("Clientes");
			
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
	
	public boolean crear(ClientesDTO ClientesDTO) {
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("cedulaCliente", ClientesDTO.getCedulaCliente())
					 .append("direccionCliente", ClientesDTO.getDireccionCliente())
					 .append("emailCliente", ClientesDTO.getEmailCliente())
					 .append("nombreCliente", ClientesDTO.getNombreCliente())
					 .append("telefonoCliente", ClientesDTO.getTelefonoCliente());
					 
			Clientes.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
	}
	
	public ArrayList<ClientesDTO> listar() {
		ArrayList<ClientesDTO> listado = new ArrayList<ClientesDTO>();
		try {
			ArrayList<Document> documentos = Clientes.find().into(new ArrayList<>());
			for(Document doc: documentos) {
				ClientesDTO nuevo = new ClientesDTO();
				nuevo.setCedulaCliente(doc.getLong("cedulaCliente"));
				nuevo.setDireccionCliente(doc.getString("direccionCliente"));
				nuevo.setEmailCliente(doc.getString("emailCliente"));
				nuevo.setNombreCliente(doc.getString("nombreCliente"));
				nuevo.setTelefonoCliente(doc.getString("telefonoCliente"));
			
				
			listado.add(nuevo);
			}
			System.out.println("Listado generado");
		} catch (Exception e) {
			System.out.println("No se pudo listar los documentos");
		}
		return listado;
	}
	
	public boolean eliminar(Long cedulaCliente) {
		boolean rta=false;
		try {
			DeleteResult estado = Clientes.deleteOne(new Document("cedulaCliente", cedulaCliente));
			System.out.println("Se eliminó el documento");
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el documento");
		}
		return rta;
	}
	
	/*public int login(LoginDTO nombreCliente) {
		ArrayList<ClientesDTO> listado = new ArrayList<ClientesDTO>();
		try {
			ArrayList<Document> documentos = Clientes.find(new Document("Cliente", nombreCliente)).into(new ArrayList<>());
			System.out.println("Voy acá 11");
			
		}
		catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
			
		}
		
		return 1;
		
	}*/
	
	public ArrayList<ClientesDTO> buscar(Long cedulaCliente) {
		ArrayList<ClientesDTO> listado = new ArrayList<ClientesDTO>();
		try {
			ArrayList<Document> documentos = Clientes.find(new Document("cedulaCliente", cedulaCliente)).into(new ArrayList<>());
			for(Document doc: documentos) {
				ClientesDTO nuevo = new ClientesDTO();
				nuevo.setCedulaCliente(doc.getLong("cedulaCliente"));
				nuevo.setDireccionCliente(doc.getString("direccionCliente"));
				nuevo.setEmailCliente(doc.getString("emailCliente"));
				nuevo.setNombreCliente(doc.getString("nombreCliente"));
				nuevo.setTelefonoCliente(doc.getString("telefonoCliente"));
				listado.add(nuevo);
			}
			System.out.println("Documento encontrado");
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
		}
		this.cerrar();
		return listado;
		
	}
	
	
	
	
	public boolean actualizar(ClientesDTO ClientesDTO) {
		boolean rta = false;
		try {
			
			Document documento = new Document();
			documento.append("cedulaCliente", ClientesDTO.getCedulaCliente());
			documento.append("direccionCliente", ClientesDTO.getDireccionCliente());
			documento.append("emailCliente", ClientesDTO.getEmailCliente());
			documento.append("nombreCliente", ClientesDTO.getNombreCliente());
			documento.append("telefonoCliente", ClientesDTO.getTelefonoCliente());
			
			
			
			Document filtro = new Document("cedulaCliente", ClientesDTO.getCedulaCliente());
			
			UpdateResult estado = Clientes.replaceOne(filtro, documento);
			System.out.println("Documento actualizado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el documento");
		}
		return rta;
	}
}
