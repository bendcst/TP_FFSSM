/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Benjamin
 */
public class TestFFSSM {

    Club club;
    Licence licence;
    Moniteur moniteur;
    Plongee plongee;
    Plongeur plongeur;
    Site site;

    @BeforeEach
    public void setUp() {
        club = new Club(moniteur, "PopArt", "0606060606");
        licence = new Licence(plongeur, "65345", LocalDate.of(2020, 5, 3), 1, club);
        moniteur = new Moniteur(11652, 4, "00978", "Jugnot", "Gerard", "2 rue du Loup", "0605040302", LocalDate.of(1951, 5, 4));
        plongee = new Plongee(site, moniteur, LocalDate.of(2020, 11, 30), 10, 2);
        plongeur = new Plongeur(2, "01635", "Letexier", "Yvick", "45 rue des Platanes", "0606050504", LocalDate.of(1993, 8, 14));
        site = new Site("Marseille", "Les details");
    }

    
    
    @Test
    public void testAjouteLicence(){
        plongeur.ajouteLicence("65345", LocalDate.of(2020, 5, 3), club);
        assertEquals(plongeur.licence.getDelivrance(), LocalDate.of(2020, 5, 3), "La licence n'est pas attribuee");
    }
    
    @Test
    public void testEstValide() {
        assertTrue(licence.estValide(LocalDate.now()), "La licence n'est plus valide");
    }
    
    @Test
    public void testNouvelleEmbauche(){
        moniteur.nouvelleEmbauche(club, LocalDate.of(2018,3,26));
        assertTrue(moniteur.emplois().contains(moniteur.embauche));
    }
        
    @Test
    public void testOrganisePlongee() {
        club.organisePlongee(plongee);
        assertEquals(plongee, club.plongeeOrganisee.get(0), "La plongee n'est pas ajoutee");

    }
    
    @Test
    public void testEstConforme(){
        plongeur.ajouteLicence("65345", LocalDate.of(2020, 5, 3), club);
        plongee.ajouteParticipant(plongeur);
        assertTrue(plongee.estConforme(),"La plongee n'est pas conforme");
    }
    
    @Test
    public void testPlongeesNonConformes(){
        plongeur.ajouteLicence("65345", LocalDate.of(2020, 5, 3), club);
        plongee.ajouteParticipant(plongeur);
        club.organisePlongee(plongee);
        
        assertFalse(club.plongeesNonConformes().contains(plongee), "La plongee n'est pas conforme");
        
    }
    
    
}
