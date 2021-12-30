package bikeFactory;

import model.generalBike.GeneralBike;

import java.sql.Connection;

public interface GeneralBikeFactory {
    public GeneralBike createBikeObject(String bikeCode, Connection connection);
}
