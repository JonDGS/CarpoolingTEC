package Tests;

import com.google.gson.Gson;

import Server.Usuario;
import connection_manager.Database;

public class DatabaseTest {
	
	public static void main(String[] args) {
		Database a = new Database();
		Usuario A = new Usuario("Jonathan", 2018118336, 1, 6);
		a.addDriver(A);
		Usuario B = new Usuario("Adrian", 2018111111, 1, 4);
		a.addDriver(B);
		Usuario C = new Usuario("David", 2018222222, 1, 6);
		a.addDriver(C);
		Usuario D = a.isDriver("David");
		System.out.println(new Gson().toJson(D));
	}

}
