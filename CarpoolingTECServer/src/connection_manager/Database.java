package connection_manager;

import Server.Server;
import Server.Usuario;
import Utils.List;

public class Database {
	
	private static List<Usuario> drivers = new List<Usuario>();
	private static List<Usuario> students = new List<Usuario>();
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
	
	public Usuario isDriver(String driver) {
		int index = 0;
		while(index<drivers.length()) {
			Usuario result = drivers.getData(index);
			System.out.println("Comparing " + driver + " to " + result.getNombre());
			if(driver.equals(result.nombre)) {
				return result;
			}index++;
		}return null;
	}
	
	public Usuario isStudent(String student) {
		int index = 0;
		while(index<students.length()) {
			Usuario result = students.getData(index);
			System.out.println("Comparing " + student + " to " + result.getNombre());
			if(student.equals(result.nombre)) {
				return result;
			}index++;
		}return null;
	}

}
