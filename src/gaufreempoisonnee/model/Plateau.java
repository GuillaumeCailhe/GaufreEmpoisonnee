/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaufreempoisonnee.model;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.StringJoiner;

/**
 *
 * @author helgr
 */
public class Plateau {

   
    private int largeur, hauteur;
    private Case[][] plateau;

    private Hashtable<Integer, Configuration> hashConfigurations;
    

    /**
     * Constructeur, initialise le plateau avec des cases de gaufre et une case
     * empoisonnée
     *
     * @param largeur la largeur du plateau
     * @param hauteur la hauteau du plateau
     */
    public Plateau(int hauteur, int largeur) {
        this.largeur = largeur;
        this.hauteur = hauteur;

        this.plateau = new Case[hauteur][largeur];

        // On remplit le plateau de cases gaufrées.
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                plateau[i][j] = Case.GAUFRE;
            }
        }

        // On empoisonne la case dans le coin inférieur gauche.
        plateau[hauteur - 1][0] = Case.POISON;
        
        hashConfigurations = new Hashtable<Integer, Configuration>();
    }

    /**
     * @return la largeur du plateau
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * @return la hauteur du plateau
     */
    public int getHauteur() {
        return hauteur;
    }
    
    /**
     * @param x
     * @param y
     * @return la case de coordonnées (x,y)
     */
    public Case getCase(int x, int y){
        return this.plateau[x][y];
    }
    
    /**
     * Met la case de coordonnées (x,y) à  
     * @param x
     * @param y
     * @param c 
     */
    public void setCase(int x, int y, Case c){
        this.plateau[x][y] = c;
    }
    
    /**
     * Met vide la case dévorée de coordonnées (x,y) et les cases à droite et en
     * haut de celle-ci.
     *
     * @param x
     * @param y
     * @return true si la gaufre a pu être mangée, faux sinon
     */
    public boolean mangerMorceauDeGauffre(int x, int y) {
        if (this.plateau[x][y] != Case.VIDE) { // On vérifie que la case est bien un morceau de gaufre
            // On supprime les cases à droite et au dessus de cette case.
            for (int i = x; i >= 0; i--) {
                for (int j = y; j < this.getLargeur(); j++) {
                    this.plateau[i][j] = Case.VIDE;
                }
            }
            
            return true;
        } else {
            return false;
        }
    }

    /**
     * Renvoie le plateau sous forme de string pour un affichage ultérieur
     *
     * @return
     */
    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("Plateau de taille : [" + this.getHauteur() + "][" + this.getLargeur() + "]");
        for (Case[] ligne : plateau) {
            sj.add(Arrays.toString(ligne));
        }

        return sj.toString();
    }
    

    private NoeudArbre arbreConfiguration(Configuration c){
        if(!hashConfigurations.contains(c.hashCode())){
            hashConfigurations.put(c.hashCode(),c);
        }
        
        
        
        
        return null;
    }
    
    
    
}
