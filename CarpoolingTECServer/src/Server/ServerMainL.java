package Server;

public class ServerMainL {

	public static void main(String[] args) {
		Server s = new Server();
		AlgoritmoDijkstra t = new AlgoritmoDijkstra(s.mapa);
		t.getClass();
		t.execute(s.mapa.nodos.getData(9));
		List<NodoG> path = t.getPath(s.mapa.nodos.getData(20));		
		System.out.println("Tamaño del mapa: "+s.mapa.nodos.length());
		System.out.print("Distancia total: "+t.getDistTotal(path));
	}

}
