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
public enum ModeDeJeu {
    JOUEUR_CONTRE_JOUEUR(0),
    JOUEUR_CONTRE_IA_FACILE(1),
    JOUEUR_CONTRE_IA_INTERMEDIAIRE(2),
    JOUEUR_CONTRE_IA_DIFFICILE(3);
    
    int contenu;

    ModeDeJeu(int contenu){
        this.contenu = contenu;
    }

    /**
     * @return le contenu de la case
     */
    public int getContenu() {
        return contenu;
    }
}
