package Tests;

import com.google.gson.Gson;

import Server.Usuario;
import connection_manager.Database;

public class DatabaseTest {
	
	public static void main(String[] args) {
		Database a = new Database();
		Usuario A = new Usuario("Jonathan", 2018118336, 1);
		a.addDriver(A);
		Usuario B = new Usuario("Adrian", 2018111111, 1);
		a.addDriver(B);
		Usuario C = new Usuario("David", 2018222222, 1);
		a.addDriver(C);
		System.out.println(new Gson().toJson(a.searchByCarne(2018111111)));
		String test = "Antonio,2018111111,1";
		String[] test2 = test.split(",");
		for(int i = 0; i<test2.length; i++) {
			System.out.println(test2[i]);
		}
		String id = "Antonio,2018111111,1";
		String[] metadata = id.split(",");
		String param1 = metadata[0];
		String param2 = metadata[1];
		String param3 = metadata[2];
		Usuario data = new Usuario(param1, Integer.parseInt(param2), Integer.parseInt(param3));
	}

}
