package Server;

import java.util.List;


/*
 * Clase que contiene todas las conecciones y los nodos 
 *para poder utilizar el algoritmo de Dijkstra
 */

public class Grafo<T> {
	
	/*
	 * @param nodos: es la lista de nodos del grafo
	 * @param conecciones: es la lista de conecciones del grafo
	 */
	private final List<NodoG<T>> nodos;
    private final List<Coneccion<T>> conecciones;

    public Grafo(List<Coneccion<T>> conecciones, List<NodoG<T>> nodos) {
        this.conecciones = conecciones;
        this.nodos = nodos;
    }

    public List<NodoG<T>> getNodos() {
        return nodos;
    }

    public List<Coneccion<T>> getConecciones() {
        return conecciones;
    }


	
	
}
