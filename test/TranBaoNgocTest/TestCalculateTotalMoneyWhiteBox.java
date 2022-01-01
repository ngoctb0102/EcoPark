package test.TranBaoNgocTest;
import org.junit.Test;
import controller.*;
import static org.junit.Assert.*;
public class TestCalculateTotalMoneyWhiteBox {
    ReturnBikePageController r = new ReturnBikePageController();
    @Test
    public void testCalculateTotalMoney1(){
        int testSuite[][] = {{5,0},{15,15000},{40,19500}};
        for(int i = 0;i<3;i++){
            assertEquals(testSuite[i][1],r.calculateTotalMoney(15000, testSuite[i][0]));
        }
    }
}
