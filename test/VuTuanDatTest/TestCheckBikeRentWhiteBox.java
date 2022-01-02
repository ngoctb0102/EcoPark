package test.VuTuanDatTest;

import org.junit.Test;
import rentBikeHistorySubsystem.rentBikeHistoryAPI.RentBikeHistoryManager;

import static org.junit.Assert.assertEquals;

public class TestCheckBikeRentWhiteBox {
    String[] sampleBikeCodes = {"ED123","AC123","AB123"};
    RentBikeHistoryManager rentBikeHistoryManager = new RentBikeHistoryManager();

    @Test
    public void TestMethod0(){
        boolean isRent0 = rentBikeHistoryManager.checkBikeRent(sampleBikeCodes[0]);
        assertEquals(isRent0,false);
        System.out.println("Test method0 passed successfully!");
    }

    @Test
    public void TestMethod1(){
        boolean isRent0 = rentBikeHistoryManager.checkBikeRent(sampleBikeCodes[1]);
        assertEquals(isRent0,false);
        System.out.println("Test method1 passed successfully!");
    }

    @Test
    public void TestMethod2(){
        boolean isRent0 = rentBikeHistoryManager.checkBikeRent(sampleBikeCodes[2]);
        assertEquals(isRent0,true);
        System.out.println("Test method2 passed successfully!");
    }

}
