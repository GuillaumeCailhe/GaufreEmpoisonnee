/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaufreempoisonnee.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lefebfab
 */
public class NoeudArbre {
    private Configuration configuration; 
    private List<NoeudArbre> fils;
    
    public NoeudArbre(Configuration c){
        configuration = c;
        fils = new ArrayList<NoeudArbre>();
    }
    
    public void AjouterFils(NoeudArbre f){
        fils.add(f);
    }
}
