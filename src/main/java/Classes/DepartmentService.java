package Classes;
import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

@Path("/departement")
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentService {
	private static Map<String, Departement> departements = new HashMap<>();
	@POST
	@Produces(MediaType.APPLICATION_JSON)  
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDepart (Departement dep) {
		  if (dep.getId() != null && !dep.getId().isEmpty()) { 
	        	if (departements.containsKey(dep.getId())) {
	        		return Response.status(Response.Status.BAD_REQUEST)
	                           .entity("dejas ajouter")
	                           .build();
	        	}else {
	            departements.put(dep.getId(), dep);
	            return Response.status(Response.Status.CREATED)
	            		.entity("Ajouter")
	            		.build();
	        	}
	        } else {
	            // Si l'ID est null, on renvoie une réponse 400 (Bad Request).
	            return Response.status(Response.Status.BAD_REQUEST)
	                           .entity("L'id ne peut pas être null ou vide")
	                           .build();
	        }
	}
	
	@GET
	public Map<String, Departement> getAllDepart () {
		return departements;
	}
//une seule departement	
	@GET
	@Path("une")
	@Produces(MediaType.APPLICATION_JSON)  
	@Consumes(MediaType.APPLICATION_JSON) 
	public Departement getDepartById (@QueryParam("id") String id) {
		return departements.get(id);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)  
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDepart (Departement dep) {
		if (dep.getId() != null && !dep.getId().isEmpty()) {
	        if (departements.containsKey(dep.getId())) {
	            departements.put(dep.getId(), dep);
	            return Response.status(Response.Status.OK) 
	                    .entity("modifier")
	                    .build();
	        } else {
	            return Response.status(Response.Status.NOT_FOUND)
	                    .entity("lid nest pas retrouvem")
	                    .build();
	                }
	 }else {
		 return Response.status(Response.Status.BAD_REQUEST)
                 .entity("L'id ne peut pas être null ou videm")
                 .build();
	 }}
	
	@DELETE
	public Response deleteDepart (Departement dep) {
		 if (dep.getId() != null && !dep.getId().isEmpty()) {
			    if (departements.containsKey(dep.getId())) {
		            departements.remove(dep.getId());
		            return Response.status(Response.Status.OK) 
		                    .entity("supprimer")
		                    .build();
		        } else {
		            return Response.status(Response.Status.NOT_FOUND)
		                    .entity("lid nest pas retrouve")
		                    .build();
		                }
		 }else {
			 return Response.status(Response.Status.BAD_REQUEST)
                    .entity("L'id ne peut pas être null ou vide")
                    .build();	
	}
	}
}

