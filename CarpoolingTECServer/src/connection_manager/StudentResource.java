package connection_manager;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import Utils.List;

@Path("/student")
public class StudentResource {
	
	
	private Database server = new Database();
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String addDriver(String id) {
		server.addStudent(id);
		return "Log in successfully";
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getDrivers() {
		String drivers = new Gson().toJson(server.getStudents());
		return drivers;
	}
	
	@GET
	@Path("/{lookup}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getStudent(@PathParam("lookup") String lookup) {
		String result = (String) server.getStudentList().searchData(lookup);
		return result;
	}
	
}
