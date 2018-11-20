package Server;

/*
 * Clase que tiene los algoritmos necesarios
 * para buscar el camino más corto
 * de un nodoG A a uno B
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlgoritmoDijkstra {
	

	private final List<NodoG> nodes;
    private final List<Coneccion> conecciones;
    private Set<NodoG> settledNodes;
    private Set<NodoG> unSettledNodes;
    private Map<NodoG, NodoG> predecessors;
    private Map<NodoG, Integer> distance;

    public AlgoritmoDijkstra(Grafo mapa) {
        this.nodes = mapa.getNodos();
        this.conecciones = mapa.getConecciones();
    }

    public void execute(NodoG source) {
        settledNodes = new HashSet<NodoG>();
        unSettledNodes = new HashSet<NodoG>();
        distance = new HashMap<NodoG, Integer>();
        predecessors = new HashMap<NodoG, NodoG>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
        	NodoG node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(NodoG node) {
        List<NodoG> adjacentNodes = getNeighbors(node);
        int n = adjacentNodes.length();
        for(int i = 0; i < (n-1); i++) {
            if (getShortestDistance(adjacentNodes.getData(i)) > getShortestDistance(node)
                    + getDistance(node, adjacentNodes.getData(i))) {
                distance.put(adjacentNodes.getData(i), getShortestDistance(node)
                        + getDistance(node, adjacentNodes.getData(i)));
                predecessors.put(adjacentNodes.getData(i), node);
                unSettledNodes.add(adjacentNodes.getData(i));
            }
        }

    }

    private int getDistance(NodoG nodo, NodoG objetivo) {
    	int n = conecciones.length();
    	for(int i = 0; i < (n-1); i++) {
            if (conecciones.getData(i).getFuente().equals(nodo)
                    && conecciones.getData(i).getDestino().equals(objetivo)) {
                return conecciones.getData(i).getPeso();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<NodoG> getNeighbors(NodoG node) {
        List<NodoG> neighbors = new List<NodoG>();
        int n = neighbors.length();
        for(int i = 0; i < (n-1); i++) {
            if (conecciones.getData(i).getFuente().equals(node)
                    && !isSettled(conecciones.getData(i).getDestino())) {
                neighbors.addLast(conecciones.getData(i).getDestino());
            }
        }
        return neighbors;
    }

	private NodoG getMinimum(Set<NodoG> nodos) {
    	NodoG minimum = null;
        for (NodoG vertex : nodos) {
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

    private boolean isSettled(NodoG nodo) {
        return settledNodes.contains(nodo);
    }

    private int getShortestDistance(NodoG destino) {
        Integer d = distance.get(destino);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    public List<NodoG> getPath(NodoG objetivo) {
        List<NodoG> path = new List<NodoG>();
        NodoG step = objetivo;
        if (predecessors.get(step) == null) {
            return null;
        }
        path.addLast(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.addLast(step);
        }
        path = path.reverse(path);
        return path;
    }
}
