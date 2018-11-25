package connection_manager;

import com.google.gson.Gson;

import Server.Server;
import Server.Usuario;
import Utils.List;

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
		driver.setBusy(true);
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

}
