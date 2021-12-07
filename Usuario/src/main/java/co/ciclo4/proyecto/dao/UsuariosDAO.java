package co.ciclo4.proyecto.dao;



import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import co.ciclo4.proyecto.dto.LoginDTO;
import co.ciclo4.proyecto.dto.UsuariosDTO;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

public class UsuariosDAO {
	MongoClient conexion;
	MongoDatabase baseDatos;
	MongoCollection<org.bson.Document> Usuarios;
	
	public UsuariosDAO() {
		try {
			
			conexion = MongoClients.create("mongodb://localhost");
			baseDatos = conexion.getDatabase("proyecto");
			Usuarios = baseDatos.getCollection("Usuarios");
			
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
	
	public boolean crear(UsuariosDTO UsuariosDTO) {
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("ID", UsuariosDTO.getId())
					 .append("cedulaUsuario", UsuariosDTO.getCedulaUsuario())
					 .append("emailUsuario", UsuariosDTO.getEmailUsuario())
					 .append("nombreUsuario", UsuariosDTO.getNombreUsuario())
					 .append("password", UsuariosDTO.getPassword())
					 .append("Usuario", UsuariosDTO.getUsuario());
			Usuarios.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
	}
	
	public ArrayList<UsuariosDTO> listar() {
		ArrayList<UsuariosDTO> listado = new ArrayList<UsuariosDTO>();
		try {
			ArrayList<Document> documentos = Usuarios.find().into(new ArrayList<>());
			for(Document doc: documentos) {
				UsuariosDTO nuevo = new UsuariosDTO();
				nuevo.setId(doc.getLong("ID"));
				nuevo.setCedulaUsuario(doc.getLong("cedulaUsuario"));
				nuevo.setEmailUsuario(doc.getString("emailUsuario"));
				nuevo.setNombreUsuario(doc.getString("nombreUsuario"));
				nuevo.setPassword(doc.getString("password"));
				nuevo.setUsuario(doc.getString("Usuario"));
				
			listado.add(nuevo);
			}
			System.out.println("Listado generado");
		} catch (Exception e) {
			System.out.println("No se pudo listar los documentos");
		}
		return listado;
	}
	
	public boolean eliminar(Long cedulaUsuario) {
		boolean rta=false;
		try {
			DeleteResult estado = Usuarios.deleteOne(new Document("cedulaUsuario", cedulaUsuario));
			System.out.println("Se eliminó el documento");
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el documento");
		}
		return rta;
	}
	
	/*public int login(LoginDTO nombreUsuario) {
		ArrayList<UsuariosDTO> listado = new ArrayList<UsuariosDTO>();
		try {
			ArrayList<Document> documentos = Usuarios.find(new Document("Usuario", nombreUsuario)).into(new ArrayList<>());
			System.out.println("Voy acá 11");
			
		}
		catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
			
		}
		
		return 1;
		
	}*/
	
	public ArrayList<UsuariosDTO> buscar(Long cedulaUsuario) {
		ArrayList<UsuariosDTO> listado = new ArrayList<UsuariosDTO>();
		try {
			ArrayList<Document> documentos = Usuarios.find(new Document("cedulaUsuario", cedulaUsuario)).into(new ArrayList<>());
			for(Document doc: documentos) {
				UsuariosDTO nuevo = new UsuariosDTO();
				nuevo.setId(doc.getLong("ID"));
				nuevo.setCedulaUsuario(doc.getLong("cedulaUsuario"));
				nuevo.setEmailUsuario(doc.getString("emailUsuario"));
				nuevo.setNombreUsuario(doc.getString("nombreUsuario"));
				nuevo.setPassword(doc.getString("password"));
				nuevo.setUsuario(doc.getString("Usuario"));
				listado.add(nuevo);
			}
			System.out.println("Documento encontrado");
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
		}
		this.cerrar();
		return listado;
		
	}
	
	
	
	
	public boolean actualizar(UsuariosDTO UsuariosDTO) {
		boolean rta = false;
		try {
			
			Document documento = new Document();
			documento.append("ID", UsuariosDTO.getId());
			documento.append("cedulaUsuario", UsuariosDTO.getCedulaUsuario());
			documento.append("emailUsuario", UsuariosDTO.getEmailUsuario());
			documento.append("nombreUsuario", UsuariosDTO.getNombreUsuario());
			documento.append("password", UsuariosDTO.getPassword());
			documento.append("Usuario", UsuariosDTO.getUsuario());
			
			
			Document filtro = new Document("cedulaUsuario", UsuariosDTO.getCedulaUsuario());
			
			UpdateResult estado = Usuarios.replaceOne(filtro, documento);
			System.out.println("Documento actualizado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el documento");
		}
		return rta;
	}
}
