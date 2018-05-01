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
public abstract class Joueur {
    private int idJoueur;
    Plateau plateau;
    
    /**
     * @param idJoueur : le numéro permettant d'identifier le joueur
     * @param plateau : le plateau de jeu
     */
    public Joueur(int idJoueur, Plateau plateau) {
        this.idJoueur = idJoueur;
        this.plateau = plateau;
    }

    /**
     * @return l'id du joueur
     */
    public int getIdJoueur() {
        return idJoueur;
    }
    
    
    /**
     * Cette fonction gère le coup du joueur en mangeant la pièce de coordonnées (x, y)
     * Effet de bord : met à jour le plateau.
     * @param x
     * @param y
     * @return vrai si le coup est valable, faux sinon
     */
    public boolean jouerCoupPrecis(int y, int x){
        return plateau.mangerMorceauDeGauffre(y,x);
    }
}
