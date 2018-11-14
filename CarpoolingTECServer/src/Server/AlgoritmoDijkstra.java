package Server;

/*
 * Clase que tiene los algoritmos necesarios
 * para buscar el camino más corto
 * de un nodoG A a uno B
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlgoritmoDijkstra<T> {
	

	private final List<NodoG<T>> nodes;
    private final List<Coneccion<T>> conecciones;
    private Set<NodoG<T>> settledNodes;
    private Set<NodoG<T>> unSettledNodes;
    private Map<NodoG<T>, NodoG<T>> predecessors;
    private Map<NodoG<T>, Integer> distance;

    public AlgoritmoDijkstra(Grafo<T> graph) {
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<NodoG<T>>(graph.getNodos());
        this.conecciones = new ArrayList<Coneccion<T>>(graph.getConecciones());
    }

    public void execute(NodoG<T> source) {
        settledNodes = new HashSet<NodoG<T>>();
        unSettledNodes = new HashSet<NodoG<T>>();
        distance = new HashMap<NodoG<T>, Integer>();
        predecessors = new HashMap<NodoG<T>, NodoG<T>>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
        	NodoG<T> node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(NodoG<T> node) {
        List<NodoG<T>> adjacentNodes = getNeighbors(node);
        for (NodoG<T> target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }

    }

    private int getDistance(NodoG<T> nodo, NodoG<T> objetivo) {
        for (Coneccion conec : conecciones) {
            if (conec.getFuente().equals(nodo)
                    && conec.getDestino().equals(objetivo)) {
                return conec.getPeso();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<NodoG<T>> getNeighbors(NodoG<T> node) {
        List<NodoG<T>> neighbors = new ArrayList<NodoG<T>>();
        for (Coneccion<T> edge : conecciones) {
            if (edge.getFuente().equals(node)
                    && !isSettled(edge.getDestino())) {
                neighbors.add(edge.getDestino());
            }
        }
        return neighbors;
    }

    private NodoG<T> getMinimum(Set<NodoG<T>> nodos) {
    	NodoG<T> minimum = null;
        for (NodoG<T> vertex : nodos) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(NodoG<T> nodo) {
        return settledNodes.contains(nodo);
    }

    private int getShortestDistance(NodoG<T> destino) {
        Integer d = distance.get(destino);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public LinkedList<NodoG<T>> getPath(NodoG<T> objetivo) {
        LinkedList<NodoG<T>> path = new LinkedList<NodoG<T>>();
        NodoG<T> step = objetivo;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
}
