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
public class JoueurIAFacile extends Joueur{

    public JoueurIAFacile(int idJoueur, Plateau plateau) {
        super(idJoueur, plateau);
    }

    @Override
    public boolean jouerCoup(int x, int y) {
        /* A IMPLEMENTER */
        return false;
    }
    
}
