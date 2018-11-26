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
    	//Cerrar Rutas
    	CerrarRuta(15);
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
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            System.out.println("Pasar por: "+step.getName());
            path.addLast(step);
        }
        return path;
    }
    
    public int getDistTotal(List<NodoG> list) {
    	list = list.reverse(list);
    	list.print(list);
    	int n = list.length()-1;
    	int tot = 0;
    	for(int i = 0; i < n; i++) {
    		tot = tot + getDistance(list.getData(i), list.getData(i+1));
    	}
    	return tot;
    }

    private void CerrarRuta(int port) {
    	int ranNum = (int) (Math.random() * 100) + 1;
		if (ranNum < port) {
			System.out.println("---------------RUTA CERRADA-----------------");
			int RR = rutaRandom();
			System.out.println("---Se Cerró Ruta de "+conecciones.getData(RR).getFuente()+ " a "+ conecciones.getData(RR).getDestino()+ "--");
			System.out.println("-----Favor Tomar Ruatas Alternas------------");
			System.out.println("--------------------------------------------");
			conecciones.deleteData(RR);
		}
	}

	private int rutaRandom() {
		List<Integer> i = new List<Integer>();
		i.addLast(2);i.addLast(34);i.addLast(39);i.addLast(40);
		i.addLast(41);i.addLast(42);i.addLast(43);i.addLast(44);
		int n = i.length()-1;
		int ranNum = (int) (Math.random() * n);
		return i.getData(ranNum);
	}

}
