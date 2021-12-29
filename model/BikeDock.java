package model;

public class BikeDock {
    private String dockId;
    private String dockName;
    private String descriptions;
    private double distance;
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
    public String getDescriptions() {
        return descriptions;
    }
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
}
