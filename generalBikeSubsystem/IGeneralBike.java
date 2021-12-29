package GeneralBikeSubsystem;

import java.util.Map;

public interface IGeneralBike {
    public boolean checkBikeExist(String bikeCode);
    public boolean checkBikeRent(String bikeCode);
    public Map<String, String> getBikeDetail();
}
