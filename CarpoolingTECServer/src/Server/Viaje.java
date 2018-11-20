package Server;

/*
 * Clase necesaria para poder hacer un historial de los
 * viajes realizados
 */
public class Viaje {
	/*
	 * @param conductor: es el usuario que hace el viaje
	 * @param inicio: es el inicio del viaje
	 * @param objetivo: es el final del viaje
	 * @param listPasajeros: son todos los pasajeros 
	 * abordo durante el viaje.
	 */
	public Usuario Conductor;
	public NodoG inicio;
	public NodoG objetivo;
	public List<Usuario> listPasajeros;
	
	
	public Usuario getConductor() {
		return Conductor;
	}
	public void setConductor(Usuario conductor) {
		Conductor = conductor;
	}
	public NodoG getInicio() {
		return inicio;
	}
	public void setInicio(NodoG inicio) {
		this.inicio = inicio;
	}
	public NodoG getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(NodoG objetivo) {
		this.objetivo = objetivo;
	}
	public List<Usuario> getListPasajeros() {
		return listPasajeros;
	}
	
	
	
}
