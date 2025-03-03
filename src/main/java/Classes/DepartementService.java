package Classes;

import java.util.Map;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("/departements")
public class DepartementService {
	private DepartmentDAO depDao = new DepartmentDAO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addDepart (Departement dep) {
		depDao.addDepart(dep);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Departement> getAllDepart () {
		return depDao.getAllDepart();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Departement getDepartById (String id) {
		return depDao.getDepartById(id);
	}
	
	
	@PUT 
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateDepart (Departement dep) {
		depDao.updateDepart(dep);
	}
	
	
	
}
