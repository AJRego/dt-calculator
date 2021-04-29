package org.ajrego.ui.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.ajrego.util.Calculator;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {

    @FXML private TextField txtSize;
    @FXML private TextField txtSpeed;
    @FXML private Button btnMB;
    @FXML private Button btnGB;
    @FXML private Button btnTB;
    @FXML private Button btnKbps;
    @FXML private Button btnMbps;
    @FXML private Label lbDownloadTime;

    Calculator calculator = null;
    private String sizeUnit = "";
    private String speedUnit = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calculator = new Calculator();
        sizeUnit = "MB";
        speedUnit = "Mbps";
        txtSize.setText("10");
        txtSpeed.setText("1");

        lbDownloadTime.setText("" + calculator.getDownloadTime(
                getSizeUnit(),
                Double.parseDouble(txtSize.getText()),
                getSpeedUnit(),
                Double.parseDouble(txtSpeed.getText())));
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public String getSpeedUnit() {
        return speedUnit;
    }

    public void setSpeedUnit(String speedUnit) {
        this.speedUnit = speedUnit;
    }

    @FXML
    void buttonsDownloadTime(MouseEvent event) {
        if(event.getSource() == btnMB){
            setSizeUnit("MB");
        }

        if(event.getSource() == btnGB){
            setSizeUnit("GB");
        }

        if(event.getSource() == btnTB){
            setSizeUnit("TB");
        }

        if(event.getSource() == btnKbps){
            setSpeedUnit("Kbps");
        }

        if(event.getSource() == btnMbps){
            setSpeedUnit("Mbps");
        }
    }

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void fieldsDownloadTime(KeyEvent event) {
        if(event.getSource() == txtSize){
            lbDownloadTime.setText("" + calculator.getDownloadTime(
                    getSizeUnit(),
                    Double.parseDouble(txtSize.getText()),
                    getSpeedUnit(),
                    !txtSpeed.getText().equals("") ? Double.parseDouble(txtSpeed.getText()) : 0));
        }

        if(event.getSource() == txtSpeed){
            lbDownloadTime.setText("" + calculator.getDownloadTime(
                    getSizeUnit(),
                    !txtSize.getText().equals("") ? Double.parseDouble(txtSize.getText()) : 0,
                    getSpeedUnit(),
                    Double.parseDouble(txtSpeed.getText())));
        }
    }
}
