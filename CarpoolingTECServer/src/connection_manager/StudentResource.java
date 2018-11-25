package connection_manager;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import Server.Usuario;
import Utils.List;

@Path("/student")
public class StudentResource {
	
	
private Database server = new Database();
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String addStudent(String id) {
		String[] metadata = id.split(",");
		String param1 = metadata[0];
		String param2 = metadata[1];
		String param3 = metadata[2];
		String param4 = metadata[3];
		Usuario data = new Usuario(param1, Integer.parseInt(param2), Integer.parseInt(param3), Integer.parseInt(param4));
		server.addStudent(data);
		return "Log in successfully";
	}
	
	// Save data
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getStudents() {
		String drivers = new Gson().toJson(server.getStudents());
		return drivers;
	}
	
	@GET
	@Path("/{lookup}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getStudent(@PathParam("lookup") String lookup) {
		Usuario result = server.isStudent(lookup);
		if(result == (null)) {
			return "Student not found";
		}
		return new Gson().toJson(result);
	}
	
	@GET
	@Path("/carnet/{lookup}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCarne(@PathParam("lookup") String lookup) {
		Usuario result = server.searchByCarne(Integer.parseInt(lookup));
		if(result == (null)) {
			return "User not found";
		}
		return new Gson().toJson(result);
	}
	
	@GET
	@Path("/findDriver")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String findDriver(String id) {
		return server.assignDriver(id);
	}
	
	@GET
	@Path("/map")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMap() {
		return new Gson().toJson(server.getServer().mapa);
	}
	
}
