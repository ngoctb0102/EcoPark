package test.MaiDInhTuanTest;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.AddPageController;

public class checkDateInputBlackBox {
	AddPageController controller = new AddPageController();
	
	@Test
	public void checkDateInput()  {
		Object testDate[][] = {{true,"04:56:10"}, {false, "25:04:10"},{false, "04-56-10"}, {false, "-1"}};
		for(int i = 0; i < testDate.length; ++i) {
			assertEquals(testDate[i][0], controller.checkdate((String)testDate[i][1]));
		}
		
	}
	
	

}
