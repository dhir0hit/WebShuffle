package com.example.webapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable {

    @FXML
    private TextArea textField;

    @FXML
    private WebView webView;

    @FXML
    void loadFile(ActionEvent event) {
        String text = "";
        try {
            File cssFile = new File("src/main/resources/com/example/webapp/stylesheet/colors.css");
            Scanner readFile = new Scanner(cssFile);
            while(readFile.hasNextLine()) {
                text += "\n" + readFile.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        textField.setText(text);
    }

    @FXML
    void getColor(ActionEvent event) {
        String output = "", lineString;
        try {
            File cssFile = new File("src/main/resources/com/example/webapp/stylesheet/colors.css");
            Scanner readFile = new Scanner(cssFile);
            while(readFile.hasNextLine()) {
                lineString = readFile.nextLine().trim();
                 if (lineString.contains("background-color")) {
                     lineString = lineString.replace(";", "");
                     output += "\n" + lineString.replace("background-color: ", "");
                 }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        textField.setText(output);
    }

    @FXML
    void changeColor(ActionEvent event) {
        String output;
        try {
            File cssFile = new File("src/main/resources/com/example/webapp/stylesheet/colors.css");
            Scanner readFile = new Scanner(cssFile);
            while(readFile.hasNextLine()) {
                readFile.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        WebEngine engine = webView.getEngine();
        engine.load(Objects.requireNonNull(getClass().getResource("navigationBar.html")).toString() );

    }

}