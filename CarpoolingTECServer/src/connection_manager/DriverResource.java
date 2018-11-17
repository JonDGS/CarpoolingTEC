package connection_manager;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;

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
		Usuario data = new Usuario(param1, Integer.parseInt(param2), Integer.parseInt(param3));
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
	@Path("/carnet/{lookup}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCarne(@PathParam("lookup") String lookup) {
		Usuario result = server.searchByCarne(Integer.parseInt(lookup));
		if(result == (null)) {
			return "Driver not found";
		}
		return new Gson().toJson(result);
	}
	

}
