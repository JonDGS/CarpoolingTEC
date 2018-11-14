package connection_manager;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;

//Local import
import Utils.List;

@Path("/driver")
public class DriverResource {
	
	private Database server = new Database();
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String addDriver(String id) {
		server.addDriver(id);
		return "Log in successfully";
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getDrivers() {
		String drivers = new Gson().toJson(server.getDrivers());
		return drivers;
	}
	
	@GET
	@Path("/{lookup}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getDriver(@PathParam("lookup") String lookup) {
		String result = (String) server.getDriverList().searchData(lookup);
		return result;
	}
	

}
