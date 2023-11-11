package org.example.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class FXCopierController {
    @FXML
    private RadioButton copyRadioButton;

    @FXML
    private RadioButton deleteRadioButton;

    @FXML
    private Button destinationChooserButton;

    @FXML
    private TextField destinationTextField;

    @FXML
    private RadioButton migrateRadioButton;

    @FXML
    private BorderPane rootPane;

    @FXML
    private Button runButton;

    @FXML
    private Button sourceChooserButton;

    @FXML
    public void initialize() {
        System.out.println("Controller is running");
        runButton.setOnAction((e) -> System.out.println("Run Button pressed"));
    }
}
