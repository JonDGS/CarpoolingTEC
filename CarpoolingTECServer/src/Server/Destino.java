package Server;
/*
 * Clase que contiene los datos necesarios
 * para hacer destinos y que los nodos del grafo
 * tenga la informacion 
 */
public class Destino {
	
	/*
	 * @param nombre: es el nombre del destino
	 * @param posiblesConecciones: son las posibles conecciones,
	 * para despues elegir aleatoriamente las conecciones 
	 * que se deseen
	 * @param id: es un numero especifico para identificar
	 * a las ciudades
	 * 
	 */
	
	public String nombre;
	public int id;
	public List<Destino> posiblesConecciones;
	
	
	public Destino(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}
}
