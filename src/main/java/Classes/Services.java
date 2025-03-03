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
//import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
public class Services {
	private static Map<String,Employee> employees = new HashMap<>();
//METHODE aFFICHER DEMPLOYEES 
	@GET
	public Map<String, Employee>getValue() {
		return employees;
	}

//METHODE AJOUTER DEMPLOYEES 
	 @POST
	    @Consumes(MediaType.APPLICATION_JSON)  // Cette annotation permet de consommer un JSON
	    public Response ajouter(Employee employee) {
	        if (employee.getId() != null && !employee.getId().isEmpty()) { 
	        	if (employees.containsKey(employee.getId())) {
	        		return Response.status(Response.Status.BAD_REQUEST)
	                           .entity("dejas ajouter")
	                           .build();
	        	}else {
	            employees.put(employee.getId(), employee);
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
	 
	 
//METHODE SUPPRIMER DEMPLOYEES 
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response supprimer(Employee employee) {
		
		 if (employee.getId() != null && !employee.getId().isEmpty()) {
			    if (employees.containsKey(employee.getId())) {
		            employees.remove(employee.getId());
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
	
//METHODE MODIFIER DEMPLOYEES 	
	 @PUT 
		@Consumes(MediaType.APPLICATION_JSON)
		public Response modifier(Employee employee) {
			 if (employee.getId() != null && !employee.getId().isEmpty()) {
			        if (employees.containsKey(employee.getId())) {
			            employees.put(employee.getId(), employee);
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
		}

}
	 
	 
	 
	 
 
}
