package Server;

/*
 * Son los nodos de un grafo, la data es el destino
 * que contiene el nodo
 */
public class NodoG<T> {
	
	/*
	 * @param id: es el nombre del nodo, para facilitar
	 * localizar el nodo
	 * @param name: nombre del nodo, para buscar equals
	 * @param data: es la ciudad que contiene el nodo
	 */
    final private String id;
    final private String name;
    final public Destino destino;


	public NodoG(String id, String name, Destino destino) {
        this.id = id;
        this.name = name;
        this.destino = destino;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
  
    public Destino getDestino() {
		return destino;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coneccion other = (Coneccion) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
