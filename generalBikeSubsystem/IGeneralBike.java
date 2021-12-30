package generalBikeSubsystem;

import model.generalBike.GeneralBike;

public interface IGeneralBike {
    public boolean checkBikeExist(String bikeCode);
    public GeneralBike getBikeDetail(String bikeCode);
}
