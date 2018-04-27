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
public class FabriqueJoueur {
    /**
     * Fabrique permettant de créer un joueur.
     * 
     * @param idJoueur
     * @param modeDeJeu
     * @param plateau
     * @return le joueur créé selon son mode de jeu et son id.
     */
    public static Joueur creerJoueur(int idJoueur, ModeDeJeu modeDeJeu, Plateau plateau){
        if (idJoueur == 1) {
            return new JoueurHumain(idJoueur, plateau);
        } else {
            switch (modeDeJeu) {
                case JOUEUR_CONTRE_JOUEUR:
                    return new JoueurHumain(idJoueur, plateau);
                case JOUEUR_CONTRE_IA_FACILE:
                    return new JoueurIAFacile(idJoueur, plateau);
                case JOUEUR_CONTRE_IA_INTERMEDIAIRE:
                    return new JoueurIAIntermediaire(idJoueur, plateau);
                case JOUEUR_CONTRE_IA_DIFFICILE:
                    return new JoueurIADifficile(idJoueur, plateau);
                default:
                    return null;
            }
        }
    }
}
