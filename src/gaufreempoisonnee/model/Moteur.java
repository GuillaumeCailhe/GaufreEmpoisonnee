/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaufreempoisonnee.model;

/**
 *
 * @author helgr
 */
public class Moteur {

    private Joueur Joueur1, Joueur2;
    private Plateau plateau;
    private ModeDeJeu modeDeJeu;

    /**
     * Constructeur détaillé avec choix de la taille du plateau
     *
     * @param modeDeJeu
     * @param hauteurPlateau
     * @param largeurPlateau
     */
    public void Moteur(ModeDeJeu modeDeJeu, int hauteurPlateau, int largeurPlateau) {
        this.modeDeJeu = modeDeJeu;
        this.plateau = new Plateau(hauteurPlateau, largeurPlateau);
    }

    /**
     * Constructeur par défaut
     *
     * @param modeDeJeu
     */
    public void Moteur(ModeDeJeu modeDeJeu) {
        Moteur(modeDeJeu, 5, 10);
    }

    public boolean estUnePartieGagnee() {
        /* A IMPLEMENTER */
        return true;
    }
}
