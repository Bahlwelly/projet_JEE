package Classes;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
@AdminAnnotion
public class AdminFilter implements ContainerRequestFilter {
    private Services service = new Services();

    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        // Récupérer l'ID de l'utilisateur connecté depuis un en-tête HTTP
        String userId = crc.getHeaderString("UserId");

        // Vérifier si l'ID est valide et récupérer l'employé associé
        Employee employee = service.getEmployeeById(userId);
        if (employee == null || !"ADMIN".equalsIgnoreCase( String.valueOf(employee.getRole()))) {
            // Bloquer l'accès si l'employé n'existe pas ou n'est pas admin
            crc.abortWith(Response
                .status(Response.Status.FORBIDDEN)
                .entity("Accès refusé : Réservé aux administrateurs.")
                .build());
        }
    }
}