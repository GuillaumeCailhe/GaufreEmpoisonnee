/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaufreempoisonnee.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 *
 * @author lefebfab
 */
public class JoueurIADifficile extends Joueur{

    private NoeudArbre minMax;
    private boolean modeMinMax;
    
    public JoueurIADifficile(int idJoueur, Plateau plateau) {
        super(idJoueur, plateau);
        minMax = new NoeudArbre(plateau.getHauteur(), plateau.getLargeur(), null);
        modeMinMax = false;
    }

    public boolean jouerCoup() {
        int y, x;
        Random r = new Random();
        
        if(plateau.getCase(3,3) == Case.VIDE){ // Si le terrain est suffisament petit pour le min max
            if(!modeMinMax){
                modeMinMax = true;
                plateau.arbreMinMax1(minMax);
            } 
            Hashtable<Boolean, ArrayList<NoeudArbre>> m = minMax.getFilsVictorieux();
            if(m.get(true).size() > 0 || m.get(false).size() > 0){
                if(m.get(true).size() > 0) { // On peut entrer dans une configuration gagnante ! Victoire :D
                    System.out.println("je gagne !");
                    int i = r.nextInt(m.get(true).size());
                    y = m.get(true).get(i).getyJoue();
                    x = m.get(true).get(i).getxJoue();
                } else { // meh. pas gagnant mais pas perdant non plus
                    System.out.println("Je peut gagner !");
                    int i = r.nextInt(m.get(false).size());
                    y = m.get(false).get(i).getyJoue();
                    x = m.get(false).get(i).getxJoue();
                }

            } else { // OH MON DIEU JE VAIS MOURIR, JE VAIS DEVOIR MANGER DU POISON :'(
                System.out.println("Je vais perdre :c");
                System.out.println(minMax);
                int i = r.nextInt(minMax.getFils().size());
                y = minMax.getFils().get(i).getyJoue();
                x = minMax.getFils().get(i).getxJoue();
            }    
        } else { // terrain enc1ore trop grand, l'IA va chercher à le réduire
            do {
                y = r.nextInt(plateau.getHauteur()-3)+3;
                x = r.nextInt(plateau.getLargeur()-3)+3;
            } while(plateau.getCase(y,x) == Case.VIDE);
        }
        
        System.out.println("Je joue en : " + y + "-" + x);
        ajouterCoup(y,x);
        
        NoeudArbre fils = new NoeudArbre(y,x,minMax);
        minMax.ajouterFils(fils);
        return jouerCoupPrecis(y,x);
    }
    
    public void ajouterCoup(int y, int x){
        if(modeMinMax){
            for(NoeudArbre f : minMax.getFils()){
                if(f.getyJoue() == y && f.getxJoue() == x){
                    minMax = f;
                }
            }
        } else {
            NoeudArbre f = new NoeudArbre(y,x,minMax);
            minMax.ajouterFils(f);
            minMax = f;
        }        
    }
}
