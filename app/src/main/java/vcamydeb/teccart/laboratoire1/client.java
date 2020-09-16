package vcamydeb.teccart.laboratoire1;
import java.io.Serializable;


public class client  {
    private String nom;
    private String prenom;
    private String adresse;
    private String username;
    private String password;
    private Double solde;
    private Double credit;

    public client(String nom, String prenom, String adresse, String username, String password, Double solde, Double credit) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.username = username;
        this.password = password;
        this.solde = solde;
        this.credit = credit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }
}
