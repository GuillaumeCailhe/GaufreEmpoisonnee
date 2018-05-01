/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaufreempoisonnee.controller;

import gaufreempoisonnee.MainApp;
import gaufreempoisonnee.model.ModeDeJeu;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author helgr
 */
public class ChoixDuModeController implements Initializable {

    @FXML
    private Pane paneDifficulteIA;
    @FXML
    private RadioButton boutonMode1joueur;
    @FXML
    private RadioButton boutonMode2joueurs;
    @FXML
    private RadioButton boutonIAFacile;
    @FXML
    private RadioButton boutonIAIntermediaire;
    @FXML
    private RadioButton boutonIADifficile;
    @FXML
    private ToggleGroup toggleGroupNombreJoueurs;
    @FXML
    private ToggleGroup toggleGroupDifficulte;
    

    private MainApp mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleGroupNombreJoueurs.selectToggle(boutonMode1joueur);
        toggleGroupDifficulte.selectToggle(boutonIAFacile);
    }

    /**
     * Est appelée par le contrôleur principal pour envoyer une référence vers
     * lui-même.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Ramène au menu. Est appellée lors du clic sur le bouton retour.
     */
    @FXML
    private void traiterRetour() {
        this.mainApp.afficherMenu();
    }

    /**
     * Initialise le moteur selon les paramètres choisis sur les radiobuttons.
     */
    @FXML
    private void traiterCommencer() {
        Toggle nombreJoueursSelectionne = toggleGroupNombreJoueurs.getSelectedToggle();
        if(nombreJoueursSelectionne.equals(boutonMode1joueur)){
            Toggle difficulteSelectionnee = toggleGroupDifficulte.getSelectedToggle();
            if(difficulteSelectionnee.equals(boutonIAFacile)){
                this.mainApp.lancerPartie(ModeDeJeu.JOUEUR_CONTRE_IA_FACILE);
            }else if(difficulteSelectionnee.equals(boutonIAIntermediaire)){
                this.mainApp.lancerPartie(ModeDeJeu.JOUEUR_CONTRE_IA_INTERMEDIAIRE);
            }else if(difficulteSelectionnee.equals(boutonIADifficile)){
                this.mainApp.lancerPartie(ModeDeJeu.JOUEUR_CONTRE_IA_DIFFICILE);
            }
        }else if(nombreJoueursSelectionne.equals(boutonMode2joueurs)){
            this.mainApp.lancerPartie(ModeDeJeu.JOUEUR_CONTRE_JOUEUR);
        }
    }

    /**
     * Cache les choix de difficulté relatifs à l'IA.
     */
    @FXML
    private void cacherChoixDifficulte() {
        paneDifficulteIA.setVisible(false);
    }

    /**
     * Affiche les choix de difficulté relatifs à l'IA.
     */
    @FXML
    private void afficherChoixDifficulte() {
        paneDifficulteIA.setVisible(true);
    }
}
