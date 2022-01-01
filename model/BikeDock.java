package model;

public class BikeDock {
    private String dockId;
    private String dockName;
    private String descriptions;
    private double distance;
    public BikeDock(String dockId, String dockName, String descriptions, double distance) {
        this.dockId = dockId;
        this.dockName = dockName;
        this.descriptions = descriptions;
        this.distance = distance;
    }
    public String getDockId() {
        return dockId;
    }
    public void setDockId(String dockId) {
        this.dockId = dockId;
    }
    public String getDockName() {
        return dockName;
    }
    public void setDockName(String dockName) {
        this.dockName = dockName;
    }
    
}
