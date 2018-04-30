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

    NoeudArbre minMax;
    
    public JoueurIADifficile(int idJoueur, Plateau plateau) {
        super(idJoueur, plateau);
       
    }

    public boolean jouerCoup() {
        int y, x;
        
        if(plateau.getCase(2,0) == Case.VIDE && plateau.getCase(0, 2) == Case.VIDE){ // Si le terrain est suffisament petit pour le min max
            if(minMax == null){
                minMax = new NoeudArbre(plateau.getHauteur(), plateau.getLargeur(), null);
                plateau.arbreMinMax1(minMax);
            } 
            y = 0;
            x = 0;
        } else { // terrain encore trop grand, l'IA va chercher à le réduire
            y = 0;
            x = 0;
        }

        
        
        return jouerCoupPrecis(y,x);
    }
    
}
