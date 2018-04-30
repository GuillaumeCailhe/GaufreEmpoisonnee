/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaufreempoisonnee.model;

import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 *
 * @author lefebfab
 */
public class NoeudArbre{
    
    private int yJoue;
    private int xJoue;
           
    // EVALUATION DU NOEUD
    private boolean valeur;
    
    private NoeudArbre pere;
    private ArrayList<NoeudArbre> fils;
    
    public NoeudArbre(int y, int x, NoeudArbre p){
        yJoue = y;
        xJoue = x;
        valeur = false;
        fils = new ArrayList<NoeudArbre>();
        pere = p;
    }

    public int getyJoue() {
        return yJoue;
    }

    public int getxJoue() {
        return xJoue;
    }

    public NoeudArbre getPere() {
        return pere;
    }

    public boolean getValeur() {
        return valeur;
    }

    public void setValeur(boolean valeur) {
        this.valeur = valeur;
    }

    public void ajouterFils(NoeudArbre f){
        fils.add(f);
    }

    public ArrayList<NoeudArbre> getFils() {
        return fils;
    }

    @Override
    public String toString() {

        StringBuilder sj = new StringBuilder();{
            NoeudArbre pere = this.getPere();
            while(pere != null){
                sj.append("-");
                pere = pere.getPere();
            }
            
            sj.append("Coup: " + yJoue + ";" + xJoue + "; valeur: " + valeur + "\n");

            for (NoeudArbre f : fils) {
                sj.append(f.toString());
            }

            return sj.toString();
        }
    }
    
}
