package Tests;

import connection_manager.Database;

public class DatabaseTest {
	
	public static void main(String[] args) {
		Database a = new Database();
		a.addDriver("Antonio");
		String b = (String) a.getDriverList().searchData("David");
		if(b == null) {
			System.out.println("Not found");
		}else {
			System.out.println(b);
		}
	}

}
