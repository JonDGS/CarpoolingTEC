package Server;

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
	 */
	public String nombre;
	public int carne;
	public int tipo;
	public int cantEspacios;
	public int cantidadViajes;
	public List<Viaje> viajes;
	
	public Usuario(String nombre, int carne, int tipo) {
		this.nombre = nombre;
		this.carne = carne;
		this.tipo = tipo;
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
