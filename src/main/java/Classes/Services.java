package Classes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
public class Services {
    private static Map<String, Employee> employees = new HashMap<>();
    private static Map<String, Evaluation> evaluations = new HashMap<>();
    private static int evaluationIdCounter = 1;

    // Existing methods for employees...

    // METHODE AFFICHER LES EMPLOYEES
    @GET
    @Path("/employees")
    public Map<String, Employee> getEmployees() {
        return employees;
    }

    // METHODE AJOUTER UN EMPLOYEE
    @POST
    @Path("/employees")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ajouter(Employee employee) {
        if (employee.getId() != null && !employee.getId().isEmpty()) {
            if (employees.containsKey(employee.getId())) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Employee already exists")
                        .build();
            } else {
                employees.put(employee.getId(), employee);
                return Response.status(Response.Status.CREATED)
                        .entity("Employee added")
                        .build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("ID cannot be null or empty")
                    .build();
        }
    }

    // METHODE SUPPRIMER UN EMPLOYEE
    @DELETE
    @Path("/employees")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response supprimer(Employee employee) {
        if (employee.getId() != null && !employee.getId().isEmpty()) {
            if (employees.containsKey(employee.getId())) {
                employees.remove(employee.getId());
                return Response.status(Response.Status.OK)
                        .entity("Employee deleted")
                        .build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Employee not found")
                        .build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("ID cannot be null or empty")
                    .build();
        }
    }

    // METHODE MODIFIER UN EMPLOYEE
    @PUT
    @Path("/employees")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifier(Employee employee) {
        if (employee.getId() != null && !employee.getId().isEmpty()) {
            if (employees.containsKey(employee.getId())) {
                employees.put(employee.getId(), employee);
                return Response.status(Response.Status.OK)
                        .entity("Employee updated")
                        .build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Employee not found")
                        .build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("ID cannot be null or empty")
                    .build();
        }
    }

    // METHODE AJOUTER UNE EVALUATION
    @POST
    @Path("/evaluations")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ajouterEvaluation(Evaluation evaluation) {
        // Check if the evaluator is a RESPONSABLE_DEPARTEMENT
        Employee evaluator = employees.get(evaluation.getEvaluatorId());
        if (evaluator == null || evaluator.getRole() != Roles.RESPONSABLE_DEPARTEMENT) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("seulement les responsables de depatements peuvent evaluer les employees")
                    .build();
        }

        // Check if the employee exists
        if (!employees.containsKey(evaluation.getEmployeeId())) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Employee non trouvee")
                    .build();
        }

        // Generate a unique ID for the evaluation
        evaluation.setId("eval-" + evaluationIdCounter++);
        evaluation.setEvaluationDate(new Date());

        // Add the evaluation to the map
        evaluations.put(evaluation.getId(), evaluation);

        return Response.status(Response.Status.CREATED)
                .entity("Evaluation ajoutee avec succes")
                .build();
    }

    // METHODE AFFICHER LES EVALUATIONS D'UN EMPLOYEE
    @GET
    @Path("/evaluations/{employeeId}")
    public Response getEvaluationsForEmployee(@PathParam("employeeId") String employeeId) {
        if (!employees.containsKey(employeeId)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Employee non trouvee")
                    .build();
        }

        Map<String, Evaluation> employeeEvaluations = new HashMap<>();
        for (Evaluation eval : evaluations.values()) {
            if (eval.getEmployeeId().equals(employeeId)) {
                employeeEvaluations.put(eval.getId(), eval);
            }
        }

        return Response.status(Response.Status.OK)
                .entity(employeeEvaluations)
                .build();
    }
}