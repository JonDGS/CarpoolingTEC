package connection_manager;

import com.google.gson.Gson;

import Server.Server;
import Server.AlgoritmoDijkstra;
import Server.NodoG;
import Server.Destino;
import Server.ListDestinosConecciones;
import Server.Usuario;
import Server.List;

//String converter import

public class Database {
	
	private static List<Usuario> drivers = new List<Usuario>();
	private static List<Usuario> students = new List<Usuario>();
	private static List<Usuario> queue = new List<Usuario>();
	private static Server server = new Server();
	
	public static List<Usuario> getDriverList() {
		return drivers;
	}
	
	public static List<Usuario> getStudentList() {
		return students;
	}
	
	public  void addDriver(Usuario data) {
		drivers.addLast(data);
		
	}
	
	public List<Usuario> getDrivers() {
		return drivers;
	}
	
	public  void addStudent(Usuario data) {
		students.addLast(data);
		
	}
	
	public List<Usuario> getStudents() {
		return students;
	}
	
	public String setDriverStatus(String carnet, String newStatus) {
		int index = 0;
		while(index<drivers.length()) {
			Usuario result = drivers.getData(index);
			if(Integer.parseInt(carnet) == result.carne) {
				drivers.getData(index).setBusy(Boolean.parseBoolean(newStatus));
				return "Changed successfully";
			}
		}return "Driver not found";
	}
	
	public Usuario isDriverFree() {
		int index = 0;
		while(index<drivers.length()) {
			if(!drivers.getData(index).isBusy()) {
				return drivers.getData(index);
			}index++;
		}return null;
	}
	
	public String findDriver(String id){
		Usuario passanger = new Gson().fromJson(id, Usuario.class);
		Usuario assignedDriver = isDriverFree();
		if(assignedDriver == null) {
			return "No driver is free as of now";
		}assignedDriver.addStudent(passanger);
		return "Assigned to driver " + assignedDriver.getNombre();
		
	}
	
	public Usuario searchByCarne(int carne) {
		int index = 0;
		while(index<drivers.length()) {
			Usuario result = drivers.getData(index);
			if(carne == result.carne) {
				return result;
			}index++;
		}index = 0;
		while(index<students.length()) {
			Usuario result = students.getData(index);
			if(carne == result.carne) {
				return result;
			}index++;
		}return null;
	}
	
	public String assignDriver(String id) {
		Usuario passanger = isStudent(id);
		Usuario driver = isDriverFree();
		if(driver == null) {
			return "No driver is available";
		}driver.addStudent(passanger);
		return "Your assigned driver is " + driver.getNombre();
	}
	
	public Usuario isDriver(String driver) {
		int index = 0;
		while(index<drivers.length()) {
			Usuario result = drivers.getData(index);
			if(driver.equals(result.nombre)) {
				return result;
			}index++;
		}return null;
	}
	
	public Usuario isStudent(String student) {
		int index = 0;
		while(index<students.length()) {
			Usuario result = students.getData(index);
			if(student.equals(result.nombre)) {
				return result;
			}index++;
		}return null;
	}
	
	public Server getServer() {
		return this.server;
	}
	
	public NodoG searchLocationByName(String name) {
		int index = 0;
		NodoG result = null;
		while(index < server.mapa.getNodos().length()) {
			if(server.mapa.getNodos().getData(index).getName().equals(name)) {
				result = server.mapa.getNodos().getData(index);
				return result;
			}index++;
		}return null;
	}
	
	public List<NodoG> getPath(String start, String finish){
		AlgoritmoDijkstra manager = new AlgoritmoDijkstra(server.mapa);
		NodoG source = searchLocationByName(start);
		if(source == null) {
			return null;
		}
		manager.execute(source);
		List<NodoG> path = manager.getPath(searchLocationByName(finish));
		if(path == null) {
			return null;
		}return path;
	}
	
	public List<Usuario> getMyPassangers(String myName){
		List<Usuario> passangers = isDriver(myName).getPassangers();
		if(passangers == null) {
			return null;
		}return passangers;
	}
	
	public String getJsonPath(String start, String finish) {
		List<NodoG> path = getPath(start, finish);
		if(path == null) {
			return "Error al calcular ruta";
		}
		return new Gson().toJson(path);
	}
	
	public int getTime(String start, String finish) {
		AlgoritmoDijkstra manager = new AlgoritmoDijkstra(server.mapa);
		NodoG source = searchLocationByName(start);
		NodoG destination = searchLocationByName(finish);
		if((source == null) || (destination == null)) {
			return 0;
		}
		manager.execute(source);
		return manager.getDistance(source, destination);
	}

}
