package test.TranBaoNgocTest;
import org.junit.Test;
import controller.*;
import static org.junit.Assert.*;
public class TestCalculateTotal1 {
    ReturnBikePageController r = new ReturnBikePageController();
    @Test
    public void testCalculateTotalMoney1(){
        int testSuite[][] = {{0,0},{5,0},{10,0},{15,15000},{30,15000},{40,19500},{45,19500},{46,24000}};
        for(int i = 0;i<7;i++){
            assertEquals(testSuite[i][1],r.calculateTotalMoney(15000, testSuite[i][0]));
        }
    }
}
