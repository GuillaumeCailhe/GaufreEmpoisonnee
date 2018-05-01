/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaufreempoisonnee.controller;

import gaufreempoisonnee.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author helgr
 */
public class PlateauController implements Initializable {

    @FXML
    private GridPane gaufre;
    private MainApp mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Node source = (Node) e.getSource();
                Integer colIndex = GridPane.getColumnIndex(source);
                Integer rowIndex = GridPane.getRowIndex(source);
                mainApp.gererCoup(colIndex,rowIndex);
            }
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                Button button = new Button();
                button.setMinWidth(137);
                button.setMinHeight(88);
                button.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
                
                gaufre.add(button, j, i);
            }
        }

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
