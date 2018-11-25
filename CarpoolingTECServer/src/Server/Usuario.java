package Server;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/*
 * Clase que sirve para hacer una base de datos de las
 * personas que esten usando el app
 */
public class Usuario {
	
	/*
	 * @param nombre: nombre del Usuario
	 * @param carne: carne del usuario
	 * @param tipo: se ususara un 1 cuando se quiera ser un estudiante
	 * que no posee auto, y un 2 cuando es un estudiante que quiere
	 * trasportar otros estudiates
	 * @param cantEspacios: cuando el tipo es 2, es necesario colocar la 
	 * cantidad de espacios en el auto.
	 * @param cantidadViajes: sirve para hacer el top 5 de estudiantes
	 * con más viajes
	 * @param viajes: un historial de los viajes realizados
	 * @param busy: boolean que dicta si un usuario esta ocupado o no
	 */
	public String nombre;
	public int carne;
	public int tipo;
	public int cantEspacios;
	public int cantidadViajes;
	public List<Viaje> viajes;
	private List<Usuario> passangers = new List<Usuario>();
	private boolean busy = false;
	private String uniqueID;
	private static int connection = 0;
	
	public Usuario(String nombre, int carne, int tipo, int cantEspacios) {
		this.nombre = nombre;
		this.carne = carne;
		this.tipo = tipo;
		this.cantEspacios = cantEspacios;
		String identifier = "connection " + String.valueOf(connection);
		try {
			this.uniqueID = DatatypeConverter.printHexBinary( 
			           MessageDigest.getInstance("SHA-256").digest(identifier.getBytes("UTF-8")));
			connection++;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		
	}
	
	public List<Usuario> getPassangers(){
		return this.passangers;
	}
	
	public String getUniqueID() {
		return this.uniqueID;
	}
	
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	
	public boolean isBusy() {
		return busy;
	}
	
	public void addStudent(Usuario user) {
		passangers.addLast(user);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCarne() {
		return carne;
	}

	public void setCarne(int carne) {
		this.carne = carne;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCantidadViajes() {
		return cantidadViajes;
	}

	public void setCantidadViajes(int cantidadViajes) {
		this.cantidadViajes = cantidadViajes;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}
	
	public int getCantEspacios() {
		return cantEspacios;
	}
	public void setCantEspacios(int cantEspacios ) {
		this.cantEspacios = cantEspacios;
	}
	
}
