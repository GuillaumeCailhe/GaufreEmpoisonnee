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
        // Le plateau doit être positif et pas excessivement grand
        if (hauteur < 1 || largeur < 1 || hauteur > 20 || largeur > 20) {
            largeur = 5;
            hauteur = 10;
        }

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
        plateau[0][0] = Case.POISON;

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
     * @return un tableau bidimensionnel de cases contenant le plateau
     */
    public Case[][] getPlateau() {
        return plateau;
    }

    /**
     * @param x
     * @param y
     * @return la case de coordonnées (x,y)
     */
    public Case getCase(int y, int x) {
        return this.plateau[y][x];
    }

    /**
     * Met la case de coordonnées (x,y) à
     *
     * @param x
     * @param y
     * @param c
     */
    public void setCase(int y, int x, Case c) {
        this.plateau[y][x] = c;
    }

    /**
     * Met vide la case dévorée de coordonnées (x,y) et les cases à droite et en
     * haut de celle-ci.
     *
     * @param x
     * @param y
     * @return true si la gaufre a pu être mangée, faux sinon
     */
    public boolean mangerMorceauDeGauffre(int y, int x) {
        if (y >= 0 && x >= 0 && y < this.hauteur && x < this.largeur && this.plateau[y][x] != Case.VIDE) { // On vérifie que la case est bien un morceau de gaufre
            // On supprime les cases à droite et au dessus de cette case.
            for (int i = y; i < this.hauteur; i++) {
                for (int j = x; j < this.largeur; j++) {
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

    private NoeudArbre arbreConfiguration(Configuration c) {
        if (!hashConfigurations.contains(c.hashCode())) {
            hashConfigurations.put(c.hashCode(), c);
        }

        return null;
    }

    /**
     * 
     * @param noeud
     */
    public void arbreMinMax1(NoeudArbre noeud) {
        if(noeud.getxJoue() == 0 && noeud.getyJoue() == 0){ // Terminal, le joueur précédent a mangé le poison
            noeud.setValeur(true);
        } else {            
            for (int i = this.hauteur-1; i >= 0; i--) {
                for (int j = this.largeur-1; j>=0; j--) {
                    boolean ok = true;
                    if(i == 0 && j == 0 && noeud.getFils().size() > 0){
                        ok = false;
                    }
                    NoeudArbre pere = noeud;
                    while(ok && pere != null){
                        if(i >= pere.getyJoue() && j >= pere.getxJoue()){
                            ok = false;
                        }
                        pere = pere.getPere();
                    }
                    if(ok){
                        NoeudArbre fils = new NoeudArbre(i,j,noeud);
                        noeud.ajouterFils(fils);
                        arbreMinMax2(fils);
                        noeud.setValeur(noeud.getValeur() || fils.getValeur());
                    }
                }
            }
        }
    }
    
        /**
     * 
     * @param noeud
     */
    public void arbreMinMax2(NoeudArbre noeud) {
        if(noeud.getxJoue() == 0 && noeud.getyJoue() == 0){ // Terminal, le joueur précédent a mangé le poison
            noeud.setValeur(false);
        } else {   
            noeud.setValeur(true);
            for (int i = this.hauteur-1; i >= 0; i--) {
                for (int j = this.largeur-1; j>=0; j--) {
                    boolean ok = true;
                    if(i == 0 && j == 0 && noeud.getFils().size() > 0){
                        ok = false;
                    }
                    NoeudArbre pere = noeud;
                    while(ok && pere != null){
                        if(i >= pere.getyJoue() && j >= pere.getxJoue()){
                            ok = false;
                        }
                        pere = pere.getPere();
                    }
                    if(ok){
                        NoeudArbre fils = new NoeudArbre(i,j,noeud);
                        noeud.ajouterFils(fils);
                        arbreMinMax1(fils);
                        noeud.setValeur(noeud.getValeur() && fils.getValeur());
                    } 
                }
            }
        }
    }


}
