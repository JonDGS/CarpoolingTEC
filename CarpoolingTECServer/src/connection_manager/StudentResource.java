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
		Usuario data = new Gson().fromJson(id, Usuario.class);
		server.addStudent(data);
		return "Log in successfully";
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getStudents() {
		String students = new Gson().toJson(server.getStudents());
		return students;
	}
	
	@GET
	@Path("/{lookup}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getDriver(@PathParam("lookup") String lookup) {
		Usuario lookup_aux = new Gson().fromJson(lookup, Usuario.class);
		Usuario result = server.getDriverList().searchData(lookup_aux);
		if(result == (null)) {
			return "Driver not found";
		}
		return new Gson().toJson(result);
	}
	
}
