package model.generalBike;

import java.util.HashMap;
import java.util.Map;

public class TwinBike extends GeneralBike{
    @Override
    public Map<String, String> encapsulate() {
        Map<String, String> container = new HashMap<>();
        container.put("Name",name);
        container.put("Weight",weight.toString());
        container.put("License Plate",licensePlate);
        container.put("Manufactured Date",manufacturedDate.toString());
        container.put("Cost/Deposit",cost.toString());
        container.put("Type","TwinBike");
        container.put("Image",image);
        return container;
    }
}
