package Server;

/*
 * Clase que contine la infirmacion de las conecciones
 * en el mapa de grafos con peso y dirigidos
 */
public class Coneccion<T> {
	
	/*
	 * @param id: es el nombre de la coneccion
	 * para facilitar la distincion
	 * @param fuente: es el inicio de la coneccion
	 * @param destino: es adonde apunta el nodo
	 * @param peso: es la cantidad en segundos
	 * que se dura de fuente a destino
	 */
	
	public final String id;
    private final NodoG<T> fuente;
    private final NodoG<T> destino;
    private final int peso;

    public Coneccion(String id, NodoG<T> fuente, NodoG<T> destino, int peso) {
        this.id = id;
        this.fuente = fuente;
        this.destino = destino;
        this.peso = peso;
    }

    public String getId() {
        return id;
    }
    public NodoG<T> getDestino() {
        return destino;
    }

    public NodoG<T> getFuente() {
        return fuente;
    }
    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return fuente + " " + destino;
    }
	
	
}
