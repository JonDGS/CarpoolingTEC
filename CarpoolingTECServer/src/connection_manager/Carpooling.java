package connection_manager;

import java.util.HashSet;
import java.util.Set;

//Local imports
import Utils.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@ApplicationPath("connect")
public class Carpooling extends Application {
	
	private static List drivers = new List();
	private static List students = new List();
	
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(DriverResource.class);
		classes.add(StudentResource.class);
		return classes;
	}
}
