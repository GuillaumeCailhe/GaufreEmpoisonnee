/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gaufreempoisonnee.model;
import java.util.Random;
/**
 *
 * @author helgr
 */
public class JoueurIAFacile extends Joueur{
    
    
    private Plateau plateau;
    private int idJoueur;

    public JoueurIAFacile(int id, Plateau p) {
        super(id, p);
        plateau = p;
        idJoueur = id;
    }
    
    public boolean jouerCoup() {
        Random r = new Random();
        int x, y;
        if(!(plateau.getCase(1, 0) == Case.GAUFRE || plateau.getCase(0, 1) == Case.GAUFRE))
        {
            x = 0;
            y = 0;
        } else {
            do {
                x = r.nextInt(plateau.getHauteur());
                y = r.nextInt(plateau.getLargeur());
            }while(!(plateau.getCase(x, y) == Case.GAUFRE));
        }
        return jouerCoupPrecis(x,y);
    }

    
    
}
