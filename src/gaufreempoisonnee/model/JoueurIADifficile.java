/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaufreempoisonnee.model;

/**
 *
 * @author lefebfab
 */
public class JoueurIADifficile extends Joueur{

    public JoueurIADifficile(int idJoueur, Plateau plateau) {
        super(idJoueur, plateau);
    }

    public boolean jouerCoup() {
        return jouerCoupPrecis(0,0);
    }
    
}
