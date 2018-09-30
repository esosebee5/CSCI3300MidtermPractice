package ung.mccb.csis.csci3300.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Car {

    private String LNo, VIN, model, make, year;

    public String getLNo() {
        return LNo;
    }

    public void setLNo(String LNo) {
        this.LNo = LNo;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int saveRecord() {
        saveUserIntoDatabase();
        return 1;
    }

    // This method  implements PreparedStatement properly.
    public int saveUserIntoDatabase() {
        int affectedRow=0;
        String query = "insert into car" + "(lno, vin, make, model, year)"
                + "values(?,?,?,?,?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement sqlStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
            sqlStatement.setString(1, getLNo());
            sqlStatement.setString(2, getVIN());
            sqlStatement.setString(3, getMake());
            sqlStatement.setString(4, getModel());
            sqlStatement.setString(5, getYear());

            // get the number of return rows
            affectedRow = sqlStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Status: operation failed due to " + e);

        }
        return affectedRow;

    }

}
