package Server;

public class ServerMainL {

	public static void main(String[] args) {
		Server s = new Server();
		AlgoritmoDijkstra t = new AlgoritmoDijkstra(s.mapa);
		//t.getPath(s.mapa.nodos.getData(10)); 
	}

}
