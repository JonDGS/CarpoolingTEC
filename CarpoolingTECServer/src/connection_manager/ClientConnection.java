package connection_manager;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;

import com.google.gson.*;

public class ClientConnection {
	private static String urlDefault = "http://jongsrx480:9080/CarpoolingTEC/connect";
	
	public static String requestServerUpdate(String path) throws IOException {
		URL url = new URL(urlDefault + path);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		int status = connection.getResponseCode();
		InputStreamReader reader = new InputStreamReader((connection.getInputStream()));
		char[] buffer = new char[1024];
		int readChars = 0;
		StringBuilder builder = new StringBuilder();
		while((readChars = reader.read(buffer))>0) {
			builder.append(new String(buffer, 0, readChars));
		}
		return builder.toString();
	}
	
	public static String requestListDrivers() throws IOException {
		URL url = new URL(urlDefault + "/driver");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		int status = connection.getResponseCode();
		InputStreamReader reader = new InputStreamReader((connection.getInputStream()));
		char[] buffer = new char[1024];
		int readChars = 0;
		StringBuilder builder = new StringBuilder();
		while((readChars = reader.read(buffer))>0) {
			builder.append(new String(buffer, 0, readChars));
		}
		return builder.toString();
	}
	
	public static String sendInfo(String name, String carnet, String tipo, String cantEspacios) {
		try {
	        URL url = null;
	        if(tipo == "1") {
	        	url = new URL(urlDefault + "/driver");
	        }else {
	        	new URL(urlDefault + "/student");
	        }
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "text/plain");
	        String info = name + ',' + carnet + ',' + tipo + ',' + cantEspacios;
	        String input = info;
	        OutputStream os = conn.getOutputStream();
	        os.write(input.getBytes());
	        os.flush();
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));
	        String output = br.readLine();
	        conn.disconnect();
	        return output;
	    } catch (MalformedURLException e) {
	    	System.out.println("Error de URL malformado");
	    } catch (IOException e) {
	    	System.out.println("Error de IO");
	    }
	 return null;
	}
	
	/*public static List<Dragon> postServerUpdate(List<Dragon> json) throws IOException {
		 try {
		        URL url = new URL(urlDefault + "/");
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setDoOutput(true);
		        conn.setRequestMethod("POST");
		        conn.setRequestProperty("Content-Type", "application/json");
		        String input = ListSerializer.toJsonString(json);
		        OutputStream os = conn.getOutputStream();
		        os.write(input.getBytes());
		        os.flush();
		        BufferedReader br = new BufferedReader(new InputStreamReader(
		                (conn.getInputStream())));
		        String output = br.readLine();
		        conn.disconnect();
		        return ListSerializer.fromJsonString(output);
		    } catch (MalformedURLException e) {
		    	System.out.println("Error de URL malformado");
		    } catch (IOException e) {
		    	System.out.println("Error de IO");
		    }
		 return null;
		}*/
		
	}
