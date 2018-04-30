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

    private Joueur joueur1, joueur2;
    private Plateau plateau;

    /**
     * Constructeur détaillé avec choix de la taille du plateau
     *
     * @param modeDeJeu
     * @param hauteurPlateau
     * @param largeurPlateau
     */
    public Moteur(ModeDeJeu modeDeJeu, int hauteurPlateau, int largeurPlateau) {
        this.plateau = new Plateau(hauteurPlateau, largeurPlateau);
        this.joueur1 = FabriqueJoueur.creerJoueur(1, modeDeJeu, plateau);
        this.joueur2 = FabriqueJoueur.creerJoueur(2, modeDeJeu, plateau);
    }

    /**
     * Constructeur par défaut
     *
     * @param modeDeJeu
     */
    public Moteur(ModeDeJeu modeDeJeu) {
        this(modeDeJeu, 5, 10);
    }

    /**
     * @return le joueur 1
     */
    public Joueur getJoueur1() {
        return joueur1;
    }

    /**
     * @return le joueur 2
     */
    public Joueur getJoueur2() {
        return joueur2;
    }

    /**
     * @return le plateau
     */
    public Plateau getPlateau() {
        return plateau;
    }

    public boolean estUnePartieGagnee() {
        /* A IMPLEMENTER */
        return true;
    }
}
