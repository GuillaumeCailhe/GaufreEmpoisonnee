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
        if(!(plateau.getCase(plateau.getHauteur()-2, 0) == Case.GAUFRE || plateau.getCase(plateau.getHauteur()-1, 1) == Case.GAUFRE))
        {
            x = plateau.getHauteur()-1;
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
