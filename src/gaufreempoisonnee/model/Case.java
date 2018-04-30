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
public enum Case {
    VIDE(0),
    GAUFRE(1),
    POISON(2);
    
    int contenu;

    Case(int contenu){
        this.contenu = contenu;
    }

    /**
     * @return le contenu de la case
     */
    public int getContenu() {
        return contenu;
    }
}
