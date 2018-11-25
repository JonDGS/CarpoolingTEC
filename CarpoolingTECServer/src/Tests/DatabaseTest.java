package Tests;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import Server.Server;
import Server.Usuario;
import connection_manager.Database;

public class DatabaseTest {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Server a = new Server();
		String json = new Gson().toJson(a.mapa);
		System.out.println(json);
		
	}

}
