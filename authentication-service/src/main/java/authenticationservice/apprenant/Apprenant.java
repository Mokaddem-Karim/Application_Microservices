package authenticationservice.apprenant;

import jakarta.persistence.*;

@Entity
@Table(name="Apprenant")
public class Apprenant  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cin;
    private String nom;
    private String prenom;
    private String dateN;
    private String adresse;
    private int tel;
   // private String email;
   // private String password;




    public Apprenant() {
    }


    public Apprenant(int id, int cin, String nom, String prenom, String dateN, String adresse, int tel/*, String email, String password*/) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateN = dateN;
        this.adresse = adresse;
        this.tel = tel;
      //  this.email = email;
       // this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
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

    public String getDateN() {
        return dateN;
    }

    public void setDateN(String dateN) {
        this.dateN = dateN;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
/*
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }*/


    @Override
    public String toString() {
        return "apprenant{" +
                "id=" + id +
                ", cin=" + cin +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateN=" + dateN +
                ", adresse='" + adresse + '\'' +
                ", tel=" + tel +

                '}';
    }
}
