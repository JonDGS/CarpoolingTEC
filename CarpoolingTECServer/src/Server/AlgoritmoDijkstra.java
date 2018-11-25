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
    	System.out.println("---------------AlgoritmoDijkstra---------------");
    	System.out.println("----El inicio del recorrido sera: "+source.getName()+"-----");
    	System.out.println("Estableciendo lo necesario para conseguir la menor distancia");
        settledNodes = new HashSet<NodoG>();
        unSettledNodes = new HashSet<NodoG>();
        distance = new HashMap<NodoG, Integer>();
        predecessors = new HashMap<NodoG, NodoG>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
        	System.out.println("Se Buscara Nueva distancia...");
        	NodoG node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
        System.out.println("--Se ejecuto el algoritmo, se tiene todas las distancias--");
        System.out.println("---------------AlgoritmoDijkstra---------------");
    }

    private void findMinimalDistances(NodoG node) {
        List<NodoG> adjacentNodes = getNeighbors(node);
        int n = adjacentNodes.length();
        for(int i = 0; i < n; i++) {
            if (getShortestDistance(adjacentNodes.getData(i)) > getShortestDistance(node)
                    + getDistance(node, adjacentNodes.getData(i))) {
                distance.put(adjacentNodes.getData(i), getShortestDistance(node)
                        + getDistance(node, adjacentNodes.getData(i)));
                predecessors.put(adjacentNodes.getData(i), node);
                unSettledNodes.add(adjacentNodes.getData(i));
            }
        }
    }

    public int getDistance(NodoG nodo, NodoG objetivo) {
    	int n = conecciones.length();
    	for(int i = 0; i < n; i++) {
            if (conecciones.getData(i).getFuente().equals(nodo)
                    && conecciones.getData(i).getDestino().equals(objetivo)) {
                return conecciones.getData(i).getPeso();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<NodoG> getNeighbors(NodoG node) {
        List<NodoG> neighbors = new List<NodoG>();
        int n = conecciones.length();
        for(int i = 0; i < n; i++) {
            if (conecciones.getData(i).getFuente().equals(node)
                    && !isSettled(conecciones.getData(i).getDestino())) {
                neighbors.addLast(conecciones.getData(i).getDestino());
            }
        }
        return neighbors;
    }

	private NodoG getMinimum(Set<NodoG> nodos) {
		System.out.print("Buscando minima distancia");
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
        System.out.print(".....Se encontró: "+ minimum.getName()+".");
        System.out.println("");
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
    	System.out.println("Buscando Menor distancia a: "+objetivo.getName());
        List<NodoG> path = new List<NodoG>();
        //NodoG step = new NodoG(objetivo.getId(),objetivo.getName(),objetivo.getDestino());
        NodoG step = objetivo;
        if (predecessors.get(step) == null) {
            return null;
        }
        path.addLast(step);
        System.out.println("Buscando en: "+step.getName());
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            System.out.println("Buscando en: "+step.getName());
            path.addLast(step);
        }
        path = path.reverse(path);
        return path;
    }
}
