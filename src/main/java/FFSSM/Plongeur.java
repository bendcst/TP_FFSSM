package FFSSM;

import java.time.LocalDate;

public class Plongeur extends Personne {
	private int niveau;
        public Licence licence;

    public Plongeur(int niveau, String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }
        
     public void ajouteLicence(String numero, LocalDate delivrance, Club club){
         Licence lic = new Licence(this, numero, delivrance, niveau, club);
         this.licence = lic;
     }   
}
