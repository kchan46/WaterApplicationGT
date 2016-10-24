package model;

import fxapp.Main;

import java.time.LocalDateTime;

/**
 * Created by PT3 on 10/10/2016.
 */
public class WaterSourceReport {
    private LocalDateTime dateTime;
    private int reportNumber;
    private String reporterName;
    private String waterLocation;
    private String waterType;
    private String waterCondition;

    // private Main mainApplication;

    public WaterSourceReport(String waterLocation, int reportNumber, String reporterName, String waterType, String waterCondition) {
        this.dateTime = LocalDateTime.now();
        // this.reportNumber = mainApplication.getReportNumber();
        // this.reporterName = mainApplication.getDatabase().get(mainApplication.getUser()).getName();
        this.reportNumber = reportNumber;
        this.reporterName = reporterName;
        this.waterLocation = waterLocation;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getReportNumber() {
        return reportNumber;
    }

    public String getReporterName() {
        return reporterName;
    }

    public String getWaterLocation() {
        return waterLocation;
    }

    public String getWaterType() {
        return waterType;
    }

    public String getWaterCondition() {
        return waterCondition;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setReportNumber(int reportNumber) {
        this.reportNumber = reportNumber;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public void setWaterLocation(String waterLocation) {
        this.waterLocation = waterLocation;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    public void setWaterCondition(String waterCondition) {
        this.waterCondition = waterCondition;
    }

    @Override
    public String toString() {
        return reportNumber + " - " + waterLocation + " - " + reporterName;
    }
}
