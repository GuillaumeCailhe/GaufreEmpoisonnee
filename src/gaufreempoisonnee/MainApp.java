/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaufreempoisonnee;

import gaufreempoisonnee.model.Plateau;

/**
 *
 * @author helgr
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Plateau plateau = new Plateau(3, 5);
        System.out.println(plateau.toString());
        
        System.out.println("On mange la case 1/3");
        boolean estMangee = plateau.mangerMorceauDeGauffre(1, 3);
        if(estMangee){
            System.out.println(plateau.toString());
        }
    }
    
}
