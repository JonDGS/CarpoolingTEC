package Server;


/*
 * Clase que contiene todas las conecciones y los nodos 
 *para poder utilizar el algoritmo de Dijkstra
 */

public class Grafo {
	
	/*
	 * @param nodos: es la lista de nodos del grafo
	 * @param conecciones: es la lista de conecciones del grafo
	 */
	public List<NodoG> nodos;
    public List<Coneccion> conecciones;

    public Grafo(List<NodoG> nodos, List<Coneccion> conecciones) {
        this.conecciones = conecciones;
        this.nodos = nodos;
    }

    public List<NodoG> getNodos() {
        return nodos;
    }

    public List<Coneccion> getConecciones() {
        return conecciones;
    }
    

	
	
}
