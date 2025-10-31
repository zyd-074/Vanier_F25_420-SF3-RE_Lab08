/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 2480549
 */
public class MainFXMLController implements Initializable {

    @FXML
    private RadioButton black;
    @FXML
    private ToggleGroup colorGroup;
    @FXML
    private RadioButton red;
    @FXML
    private RadioButton green;
    @FXML
    private RadioButton blue;
    @FXML
    private RadioButton small;
    @FXML
    private ToggleGroup sizeGroup;
    @FXML
    private RadioButton medium;
    @FXML
    private RadioButton large;
    @FXML
    private Button undoBtn;
    @FXML
    private Button redoBtn;
    @FXML
    private Pane drawingAreaPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void colorRadioButtonSelected(ActionEvent event) {
    }

    @FXML
    private void sizeRadioButtonSelected(ActionEvent event) {
    }

    @FXML
    private void undoClicked(ActionEvent event) {
    }

    @FXML
    private void redoClicked(ActionEvent event) {
    }

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
    }
    
}
