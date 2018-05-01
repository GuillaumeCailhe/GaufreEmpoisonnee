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
    private ModeDeJeu modeDeJeu;
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
        this.modeDeJeu = modeDeJeu;
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

    /**
     * Joue le coup d'un joueur humain
     *
     * @param idJoueur le numéro du joueur (1 ou 2)
     * @param x première coordonnée
     * @param y deuxième coordonnée
     * @return vrai si le coup a pu être joué, faux sinon
     */
    public boolean jouerCoup(int idJoueur, int x, int y) {
        Joueur joueur = joueur1;
        if (idJoueur == 2) {
            joueur = joueur2;
        }
        joueur.jouerCoupPrecis(x, y);
        // GROS CODE DEGUEULASSE J'AI HONTE D'ECRIRE CA MAIS PAS LE TEMPS DE FAIRE CA PROPRE
        // Que Dieu me pardonne.
        // Calcul du coup de l'IA
        switch(modeDeJeu){
            case JOUEUR_CONTRE_IA_FACILE:
                ((JoueurIAFacile) joueur2).ajouterCoup(y,x);
                ((JoueurIAFacile) joueur2).jouerCoup();
                break;
            case JOUEUR_CONTRE_IA_INTERMEDIAIRE:
                ((JoueurIAIntermediaire) joueur2).ajouterCoup(y,x);
                ((JoueurIAIntermediaire) joueur2).jouerCoup();
                break;
            case JOUEUR_CONTRE_IA_DIFFICILE:
                ((JoueurIADifficile) joueur2).ajouterCoup(y,x);
                ((JoueurIADifficile) joueur2).jouerCoup();
                break;
        }

        return false;
    }

    /**
     * Renvoie vraie si la partie est terminée, c'est à dire que la case
     * empoisonnée a été mangée.
     *
     * @return vrai si la partie est terminée, faux sinon.
     */
    public boolean estUnePartieTerminee() {
        return this.plateau.getPlateau()[0][0] == Case.VIDE;
    }
}
