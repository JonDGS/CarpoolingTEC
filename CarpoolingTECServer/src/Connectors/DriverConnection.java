package Connectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverConnection {
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
	
	public static String sendInfo(String name, String carnet, String tipo, String cantEspacios) throws IOException {
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
	    	throw new IOException("Error");
	    }
	 return null;
	}
	
	public static String getPassangers(String id) throws IOException {
		URL url = new URL(urlDefault + "/driver/"+id+"passangers");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "text/plain");
        String input = id;
        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());
        os.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        String output = br.readLine();
        conn.disconnect();
        return output;
    }
	
	public static String getTimeToLocation(String start, String finish) throws IOException {
		URL url = new URL(urlDefault + "/driver/timeToDestination");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "text/plain");
        String input = start + ',' + finish;
        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());
        os.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        String output = br.readLine();
        conn.disconnect();
        return output;
	}
	
	public static String getPath(String start, String finish) throws IOException {
		URL url = new URL(urlDefault + "/driver/map/path");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "text/plain");
        String input = start + ',' + finish;
        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());
        os.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        String output = br.readLine();
        conn.disconnect();
        return output;
	}
}
