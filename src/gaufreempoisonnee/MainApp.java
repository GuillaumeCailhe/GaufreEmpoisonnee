/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaufreempoisonnee;

import gaufreempoisonnee.controller.ChoixDuModeController;
import gaufreempoisonnee.controller.MenuController;
import gaufreempoisonnee.controller.PlateauController;
import gaufreempoisonnee.model.ModeDeJeu;
import gaufreempoisonnee.model.Moteur;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author helgr
 */
public class MainApp extends Application {

    private Moteur moteur;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gaufre empoisonnée");

        afficherMenu();
    }

    /**
     * Affiche la fenêtre du menu principal.
     */
    public void afficherMenu() {
        try {
            // lecture du FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Menu.fxml"));
            AnchorPane menu = (AnchorPane) loader.load();

            // On charge la scène
            Scene scene = new Scene(menu);
            primaryStage.setScene(scene);

            MenuController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Affiche la fenêtre du choix du mode de jeu.
     */
    public void afficherChoixDuMode() {
        try {
            // lecture du FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ChoixDuMode.fxml"));
            AnchorPane menu = (AnchorPane) loader.load();

            // On charge la scène
            Scene scene = new Scene(menu);
            primaryStage.setScene(scene);

            ChoixDuModeController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Affiche la fenêtre du plateau.
     */
    public void afficherPlateau(){
        try {
            // lecture du FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Plateau.fxml"));
            AnchorPane menu = (AnchorPane) loader.load();

            // On charge la scène
            Scene scene = new Scene(menu);
            primaryStage.setScene(scene);

            PlateauController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Met le moteur à jour
     * @param modeDeJeu le mode de jeu
     */
    public void lancerPartie(ModeDeJeu modeDeJeu) {
        this.moteur = new Moteur(modeDeJeu);
        afficherPlateau();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
