/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaufreempoisonnee.controller;

import gaufreempoisonnee.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author helgr
 */
public class MenuController implements Initializable {

    private MainApp mainApp;

    /**
     * Initialise la classe du contrÃ´leur.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Lance la fenÃªtre de choix du mode de jeu. AppelÃ© lors du clic sur le
     * bouton "Jouer".
     */
    @FXML
    private void traiterJouer() {
        mainApp.afficherChoixDuMode();
    }

    /**
     * Quitte l'application. AppelÃ© lors du clic sur le bouton "Quitter".
     */
    @FXML
    private void traiterQuitter() {
        Platform.exit();
    }

    /**
     * Est appelÃ©e par le contrÃ´leur principal pour envoyer une rÃ©fÃ©rence vers
     * lui-mÃªme.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
