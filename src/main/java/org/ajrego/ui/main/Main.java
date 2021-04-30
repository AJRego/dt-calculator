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

    @FXML
    private TextField txtSize;
    @FXML
    private TextField txtSpeed;
    @FXML
    private Button btnMB;
    @FXML
    private Button btnGB;
    @FXML
    private Button btnTB;
    @FXML
    private Button btnKbps;
    @FXML
    private Button btnMbps;
    @FXML
    private Label lbDownloadTime;
    @FXML
    private Label lbMoreInfo;

    private String sizeUnit = "";
    private String speedUnit = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sizeUnit = "MB";
        speedUnit = "Mbps";
        txtSize.setText("10");
        txtSpeed.setText("1");

        getDownloadTime();
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
        if (event.getSource() == btnMB) {
            setSizeUnit("MB");
            getDownloadTime();
        }

        if (event.getSource() == btnGB) {
            setSizeUnit("GB");
            getDownloadTime();
        }

        if (event.getSource() == btnTB) {
            setSizeUnit("TB");
            getDownloadTime();
        }

        if (event.getSource() == btnKbps) {
            setSpeedUnit("Kbps");
            getDownloadTime();
        }

        if (event.getSource() == btnMbps) {
            setSpeedUnit("Mbps");
            getDownloadTime();
        }
    }

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void fieldsDownloadTime(KeyEvent event) {
        if (event.getSource() == txtSize) {
            getDownloadTime();
        }

        if (event.getSource() == txtSpeed) {
            getDownloadTime();
        }
    }

    private void getDownloadTime() {
        double result = Calculator.getDownloadTime(
                getSizeUnit(),
                !txtSize.getText().isEmpty() ? Double.parseDouble(txtSize.getText()) : 0,
                getSpeedUnit(),
                !txtSpeed.getText().isEmpty() ? Double.parseDouble(txtSpeed.getText()) : 0);
        lbDownloadTime.setText(Calculator.getMinutes(result) + " Minutos " + Calculator.getSeconds(result) + " Segundos");
        lbMoreInfo.setText("en descargar " + txtSize.getText() + " " + getSizeUnit()
                + " con " + (Calculator.getDownloadSpeed(getSpeedUnit(),
                Double.parseDouble(txtSpeed.getText())))
                + " Kbps de bajada.");
    }
}
