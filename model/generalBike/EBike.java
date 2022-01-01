package model.generalBike;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class EBike extends GeneralBike{
    private Double batteryPercent;
    private Integer loadCycle;
    private Time estimatedTimeLeft;
    @Override
    public Map<String, String> encapsulate() {
        Map<String,String> container = new HashMap<>();
        container.put("Name",name);
        container.put("Weight (kg)",weight.toString());
        container.put("License Plate",licensePlate);
        container.put("Manufactured Date",manufacturedDate.toString());
        container.put("Cost/Deposit (VND)",cost.toString());
        container.put("Type","EBike");
        container.put("Image",image);
        container.put("Battery (%)",batteryPercent.toString());
        container.put("Load Cycle",loadCycle.toString());
        container.put("Estimated Time Left",estimatedTimeLeft.toString());
        return container;
    }

    public Double getBatteryPercent() {
        return batteryPercent;
    }

    public void setBatteryPercent(Double batteryPercent) {
        this.batteryPercent = batteryPercent;
    }

    public Integer getLoadCycle() {
        return loadCycle;
    }

    public void setLoadCycle(Integer loadCycle) {
        this.loadCycle = loadCycle;
    }

    public Time getEstimatedTimeLeft() {
        return estimatedTimeLeft;
    }

    public void setEstimatedTimeLeft(Time estimatedTimeLeft) {
        this.estimatedTimeLeft = estimatedTimeLeft;
    }
}
