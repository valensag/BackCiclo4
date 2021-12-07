package co.ciclo4.proyecto.dto;

public class UsuariosDTO{
	
	private Long id;
	
	private Long cedulaUsuario;
	
	private String emailUsuario;

	private String nombreUsuario;

	private String password;

	private String usuario;
	
	

	public UsuariosDTO(Long id, Long cedulaUsuario, String emailUsuario, String nombreUsuario, String password,
			String usuario) {
		super();
		this.id = id;
		this.cedulaUsuario = cedulaUsuario;
		this.emailUsuario = emailUsuario;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.usuario = usuario;
	}
	
	

	public UsuariosDTO() {
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(Long cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
