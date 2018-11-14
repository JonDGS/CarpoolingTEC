package connection_manager;

import Utils.List;

public class Database<T> {
	
	private static List drivers = new List();
	private static List students = new List();
	
	public static List getDriverList() {
		return drivers;
	}
	
	public static List getStudentList() {
		return drivers;
	}
	
	public  void addDriver(T data) {
		drivers.addLast(data);
		
	}
	
	public List getDrivers() {
		return drivers;
	}
	
	public  void addStudent(T data) {
		students.addLast(data);
		
	}
	
	public List getStudents() {
		return students;
	}
	
	public T isDriver(T driver) {
		T result = (T) drivers.searchData(driver);
		return result;
	}
	
	public T isStudent(T student) {
		T result = (T) drivers.searchData(student);
		return result;
	}

}
