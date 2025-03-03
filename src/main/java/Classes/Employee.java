package Classes;
import org.mindrot.jbcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Employee {
	private String id;
	private String nom;
	private String prenom;
	private String nss;
	private String email;
	private String tele;
	@JsonProperty("motpasshash")
	private String motpasshash;
	private Roles role;
	private String adress;
	@JsonProperty("iddepartement")
	private String iddepartement;
	public Employee() {
		
	}
	public Employee (String id, String nom, String prenom, String NSS, String email, String tele, String motPassHash, Roles role, String adress, String idDepartement) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nss = NSS;
		this.email = email;
		this.tele = tele;
		this.adress = adress;
		this.role = role;
		this.iddepartement = idDepartement;
		this.motpasshash = HashMotPass(motPassHash);
				
	}
	
	private String HashMotPass (String motPass) {
		return BCrypt.hashpw(motPass, BCrypt.gensalt());
	}
	
	public boolean verifierMotDePasse(String motDePasse) {
        return BCrypt.checkpw(motDePasse, this.motpasshash);
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
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setNSS(String nSS) {
		nss = nSS;
	}
	
	public String getNSS() {
		return nss;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setTele(String tele) {
		this.tele = tele;
	}
	
	public String getTele() {
		return tele;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setiDdepartement(String iDdepartement) {
		this.iddepartement = iDdepartement;
	}
	
	public String getiDdepartement() {
		return iddepartement;
	}
	
	public void setRole(Roles role) {
		this.role = role;
	}
	
	public Roles getRole() {
		return role;
	}
	
	
}
