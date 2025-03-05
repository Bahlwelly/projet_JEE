package Classes;

public class Departement {
	private String id;
	private String nom;
	private Integer nombre_employees;
	private String id_responsable;
	
	public Departement () {
		
	}
	public  Departement( String id, String nom, Integer nombre_employee, String id_responsable ) {
		this.id = id;
		this.nom = nom;
		this.nombre_employees = nombre_employee;
		this.id_responsable = id_responsable;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNombre_employees(Integer nombre_employees) {
		this.nombre_employees = nombre_employees;
	}
	
	public Integer getNombre_employees() {
		return nombre_employees;
	}
	
	public void setId_responsable(String id_responsable) {
		this.id_responsable = id_responsable;
	}
	
	public String getId_responsable() {
		return id_responsable;
	}
}
