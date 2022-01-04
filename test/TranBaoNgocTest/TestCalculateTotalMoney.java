package test.TranBaoNgocTest;

import controller.ReturnBikePageController;

import static org.junit.Assert.*;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
@RunWith(Theories.class)
public class TestCalculateTotalMoney{
    ReturnBikePageController r = new ReturnBikePageController();
    @DataPoints
    public static int[][] data() {
        return new int[][] {{0,0},{5,0},{10,0},{15,10000},{30,10000},{40,13000},{45,13000},{46,16000}};
    }
    @Theory
    public void testCalculateTotalMoney(final int[] inputs) {
        System.out.println(String.format("Testing with %d and %d", inputs[0], inputs[1]));
        assertEquals(inputs[1], r.calculateTotalMoney(10000,inputs[0]));
    }
}
