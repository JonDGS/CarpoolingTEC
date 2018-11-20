package Server;

public class ServerMainL {

	public static void main(String[] args) {
		Server s = new Server();
		AlgoritmoDijkstra t = new AlgoritmoDijkstra(s.mapa);
		t.getClass();
		//t.getPath(s.mapa.nodos.getData(10)); 
		
		System.out.println(s.mapa.nodos.getData(11).getId());
		
		System.out.print(s.mapa.conecciones.getData(5).getFuente()+" a ");
		System.out.print(s.mapa.conecciones.getData(5).getDestino());
	}

}
