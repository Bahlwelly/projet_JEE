package Classes;
import java.util.HashMap;
import java.util.Map;

public class DepartmentDAO {
	private static Map<String, Departement> departements = new HashMap<>();
	
	public void addDepart (Departement dep) {
		departements.put(dep.getId(), dep);
	}
	
	public Map<String, Departement> getAllDepart () {
		return departements;
	}
	
	public Departement getDepartById (String id) {
		return departements.get(id);
	}
	
	public void updateDepart (Departement dep) {
		departements.put(dep.getId(), dep);
	}
	
	public void deleteDepart (String id) {
		departements.remove(id);
	}
}
