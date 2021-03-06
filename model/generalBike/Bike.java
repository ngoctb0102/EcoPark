package model.generalBike;

import java.util.HashMap;
import java.util.Map;

public class Bike extends GeneralBike{

    @Override
    public Map<String, String> encapsulate() {
        Map<String, String> container = new HashMap<>();
        container.put("Name",name);
        container.put("Weight (kg)",weight.toString());
        container.put("License Plate",licensePlate);
        container.put("Manufactured Date",manufacturedDate.toString());
        container.put("Cost/Deposit (VND)",cost.toString());
        container.put("Type","Bike");
        container.put("Image",image);
        return container;
    }
}
