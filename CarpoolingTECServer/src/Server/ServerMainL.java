package Server;

public class ServerMainL {

	public static void main(String[] args) {
		Server s = new Server();
		AlgoritmoDijkstra t = new AlgoritmoDijkstra(s.mapa);
		t.getClass();
		t.execute(s.mapa.nodos.getData(10));
		List<NodoG> path = t.getPath(s.mapa.nodos.getData(20));
		System.out.println(path.getData(0).getName());
		
		System.out.println(s.mapa.nodos.getData(11).getId());
		
		System.out.print(s.mapa.conecciones.getData(5).getFuente()+" a ");
		System.out.print(s.mapa.conecciones.getData(5).getDestino());
		System.out.print("Distancia total: "+t.getDistTotal(path));
	}

}
