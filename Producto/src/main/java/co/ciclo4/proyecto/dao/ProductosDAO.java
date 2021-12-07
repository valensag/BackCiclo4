package co.ciclo4.proyecto.dao;



import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import co.ciclo4.proyecto.dto.ProductosDTO;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

public class ProductosDAO {
	MongoClient conexion;
	MongoDatabase baseDatos;
	MongoCollection<org.bson.Document> Productos;
	
	public ProductosDAO() {
		try {
			
			conexion = MongoClients.create("mongodb://localhost");
			baseDatos = conexion.getDatabase("proyecto");
			Productos = baseDatos.getCollection("Productos");
			
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
	
	public boolean crear(ProductosDTO ProductosDTO) {
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("codigoProducto", ProductosDTO.getCodigoProducto())
					 .append("nombreProducto", ProductosDTO.getNombreProducto())
					 .append("nitProveedor", ProductosDTO.getNitProveedor())
					 .append("precioCompra", ProductosDTO.getPrecioCompra())
					 .append("ivaCompra", ProductosDTO.getIvaCompra())
					 .append("precioVenta", ProductosDTO.getPrecioVenta());
					 
			Productos.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
	}
	
	public ArrayList<ProductosDTO> listar() {
		ArrayList<ProductosDTO> listado = new ArrayList<ProductosDTO>();
		try {
			ArrayList<Document> documentos = Productos.find().into(new ArrayList<>());
			for(Document doc: documentos) {
				ProductosDTO nuevo = new ProductosDTO();
				nuevo.setCodigoProducto(doc.getLong("codigoProducto"));
				nuevo.setNombreProducto(doc.getString("nombreProducto"));
				nuevo.setNitProveedor(doc.getLong("nitProveedor"));
				nuevo.setPrecioCompra(doc.getDouble("precioCompra"));
				nuevo.setIvaCompra(doc.getDouble("ivaCompra"));
				nuevo.setPrecioVenta(doc.getDouble("precioVenta"));
				
			
				
			listado.add(nuevo);
			}
			System.out.println("Listado generado");
		} catch (Exception e) {
			System.out.println("No se pudo listar los documentos");
		}
		return listado;
	}
	
	public boolean eliminar(Long codigoProducto) {
		boolean rta=false;
		try {
			DeleteResult estado = Productos.deleteOne(new Document("codigoProdcuto", codigoProducto));
			System.out.println("Se eliminó el documento");
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el documento");
		}
		return rta;
	}
	
	/*public int login(LoginDTO nombreProducto) {
		ArrayList<ProductosDTO> listado = new ArrayList<ProductosDTO>();
		try {
			ArrayList<Document> documentos = Productos.find(new Document("Producto", nombreProducto)).into(new ArrayList<>());
			System.out.println("Voy acá 11");
			
		}
		catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
			
		}
		
		return 1;
		
	}*/
	
	public ArrayList<ProductosDTO> buscar(Long codigoProducto) {
		ArrayList<ProductosDTO> listado = new ArrayList<ProductosDTO>();
		try {
			ArrayList<Document> documentos = Productos.find(new Document("codigoProducto", codigoProducto)).into(new ArrayList<>());
			for(Document doc: documentos) {
				ProductosDTO nuevo = new ProductosDTO();
				nuevo.setCodigoProducto(doc.getLong("codigoProducto"));
				nuevo.setNombreProducto(doc.getString("nombreProducto"));
				nuevo.setNitProveedor(doc.getLong("nitProveedor"));
				nuevo.setPrecioCompra(doc.getDouble("precioCompra"));
				nuevo.setIvaCompra(doc.getDouble("ivaCompra"));
				nuevo.setPrecioVenta(doc.getDouble("precioVenta"));
				
				listado.add(nuevo);
			}
			System.out.println("Documento encontrado");
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
		}
		this.cerrar();
		return listado;
		
	}
	
	
	
	
	public boolean actualizar(ProductosDTO ProductosDTO) {
		boolean rta = false;
		try {
			
			Document documento = new Document();
			documento.append("codigoProducto", ProductosDTO.getCodigoProducto());
			documento.append("nombreProducto", ProductosDTO.getNombreProducto());
			documento.append("nitProveedor", ProductosDTO.getNitProveedor());
			documento.append("precioCompra", ProductosDTO.getPrecioCompra());
			documento.append("ivaCompra", ProductosDTO.getIvaCompra());
			documento.append("precioVenta", ProductosDTO.getPrecioVenta());
			
			
			Document filtro = new Document("codigoProducto", ProductosDTO.getCodigoProducto());
			
			UpdateResult estado = Productos.replaceOne(filtro, documento);
			System.out.println("Documento actualizado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el documento");
		}
		return rta;
	}
}
