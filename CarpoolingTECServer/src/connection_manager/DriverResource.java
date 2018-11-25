package connection_manager;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;

import Server.AlgoritmoDijkstra;
import Server.NodoG;
import Server.Usuario;
//Local import
import Utils.List;

@Path("/driver")
public class DriverResource {
	
	private Database server = new Database();
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String addDriver(String id) {
		String[] metadata = id.split(",");
		String param1 = metadata[0];
		String param2 = metadata[1];
		String param3 = metadata[2];
		String param4 = metadata[3];
		Usuario data = new Usuario(param1, Integer.parseInt(param2), Integer.parseInt(param3), Integer.parseInt(param4));
		server.addDriver(data);
		return "Log in successfully";
	}
	
	// Save data
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getDrivers() {
		String drivers = new Gson().toJson(server.getDrivers());
		return drivers;
	}
	
	@GET
	@Path("/{lookup}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getDriver(@PathParam("lookup") String lookup) {
		Usuario result = server.isDriver(lookup);
		if(result == (null)) {
			return "Driver not found";
		}
		return new Gson().toJson(result);
	}
	
	@GET
	@Path("/{lookup}/passangers")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMyPassengers(@PathParam("lookup") String lookup) {
		Usuario result = server.isDriver(lookup);
		if(result == (null)) {
			return "Driver not found";
		}
		return new Gson().toJson(result.getPassangers());
	}
	
	@GET
	@Path("/carnet/{lookup}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCarne(@PathParam("lookup") String lookup) {
		Usuario result = server.searchByCarne(Integer.parseInt(lookup));
		if(result == (null)) {
			return "Driver not found";
		}
		return new Gson().toJson(result);
	}
	
	@GET
	@Path("/map")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMap() {
		return new Gson().toJson(server.getServer().mapa.nodos);
	}
	
	@GET
	@Path("/map/{lookup}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMap(@PathParam("lookup") String place) {
		NodoG location = server.searchLocationByName(place);
		if(location == null) {
			return "Place not found";
		}return new Gson().toJson(location);
	}
	
	@GET
	@Path("/{lookup}/passangers")
	@Produces(MediaType.TEXT_PLAIN)
	public String getPassangers(@PathParam("lookup") String driver) {
		Usuario user = server.isDriver(driver);
		if(user == null) {
			return "Error";
		}
		Server.List<Usuario> passangers = user.getPassangers();
		if(passangers == null) {
			return "User has no passangers";
		}return new Gson().toJson(passangers);
	}
	
	@GET
	@Path("/timeToDestination")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getTime(String locations) {
		String[] list = locations.split(",");
		int timeTo = server.getTime(list[0], list[1]);
		if(timeTo == 0) {
			return "Error";
		}return String.valueOf(timeTo);
	}
	
	@GET
	@Path("/map/path")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getPath(String data) {
		String[] places = data.split(",");
		NodoG origin = server.searchLocationByName(places[0]);
		NodoG destination = server.searchLocationByName(places[1]);
		if((origin == null) || (destination == null)) {
			return "Error";
		}
		AlgoritmoDijkstra manager = new AlgoritmoDijkstra(server.getServer().mapa);
		manager.execute(origin);
		Server.List<NodoG> list = manager.getPath(destination);
		if(list == null) {
			return "No path";
		}return new Gson().toJson(list);
	}
	

}
