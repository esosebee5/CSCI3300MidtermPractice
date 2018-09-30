package ung.mccb.csis.csci3300.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ung.mccb.csis.csci3300.model.Car;

public class Controller {
    @FXML
    TextField txtLNo, txtVIN, txtModel, txtMake, txtYear;

    public void submitRecord(ActionEvent actionEvent) {
        String LNo, VIN, model, make, year;
        LNo = txtLNo.getText();
        VIN = txtVIN.getText();
        model = txtModel.getText();
        make = txtMake.getText();
        year = txtYear.getText();

        Car car = new Car();
        car.setLNo(LNo);
        car.setVIN(VIN);
        car.setMake(make);
        car.setModel(model);
        car.setYear(year);

        int result = car.saveRecord();
    }
}
