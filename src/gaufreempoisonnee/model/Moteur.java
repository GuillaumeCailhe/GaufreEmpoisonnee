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
     * Constructeur dÃ©taillÃ© avec choix de la taille du plateau
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
     * Constructeur par dÃ©faut
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
     * @param idJoueur le numÃ©ro du joueur (1 ou 2)
     * @param x premiÃ¨re coordonnÃ©e
     * @param y deuxiÃ¨me coordonnÃ©e
     * @return vrai si le coup a pu Ãªtre jouÃ©, faux sinon
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
     * Renvoie vraie si la partie est terminÃ©e, c'est Ã  dire que la case
     * empoisonnÃ©e a Ã©tÃ© mangÃ©e.
     *
     * @return vrai si la partie est terminÃ©e, faux sinon.
     */
    public boolean estUnePartieTerminee() {
        return this.plateau.getPlateau()[0][0] == Case.VIDE;
    }
}
