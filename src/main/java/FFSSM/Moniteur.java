/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public Embauche embauche;

    public Moniteur(int numeroDiplome, int niveau, String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        super(niveau, numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
    }

    

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        if (!this.numeroINSEE.equals(embauche.employe.numeroINSEE) || this.embauche.estTerminee()) {
            return Optional.empty();     
    }
    return Optional.of(this.embauche.employeur);
}
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
         Embauche emb = new Embauche(debutNouvelle, this, employeur);
             }

    /*public List<Embauche> emplois() {
         return this.emplois().add(this.nouvelleEmbauche(embauche.employeur, embauche.debut));
         
         

}*/
}