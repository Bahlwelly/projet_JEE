package Classes;
import org.mindrot.jbcrypt.BCrypt;
public class Employee {
	private String id;
	private String nom;
	private String prenom;
	private String NSS;
	private String email;
	private String tele;
	private String motPassHash;
	private Roles role;
	private String adress;
	private String iDdepartement;
	
	public Employee (String id, String nom, String prenom, String NSS, String email, String tele, String motPassHash, Roles role, String adress, String idDepartement) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.NSS = NSS;
		this.email = email;
		this.tele = tele;
		this.adress = adress;
		this.role = role;
		this.iDdepartement = idDepartement;
		this.motPassHash = HashMotPass(motPassHash);
				
	}
	
	private String HashMotPass (String motPass) {
		return BCrypt.hashpw(motPass, BCrypt.gensalt());
	}
	
	public boolean verifierMotDePasse(String motDePasse) {
        return BCrypt.checkpw(motDePasse, this.motPassHash);
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
		NSS = nSS;
	}
	
	public String getNSS() {
		return NSS;
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
		this.iDdepartement = iDdepartement;
	}
	
	public String getiDdepartement() {
		return iDdepartement;
	}
	
	public void setRole(Roles role) {
		this.role = role;
	}
	
	public Roles getRole() {
		return role;
	}
	
	
}
