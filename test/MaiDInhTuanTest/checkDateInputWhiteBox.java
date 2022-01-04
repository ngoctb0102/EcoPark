package test.MaiDInhTuanTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.AddPageController;

public class checkDateInputWhiteBox {
	AddPageController controller = new AddPageController();
	
	@Test
	public void checkDateInput()  {
		Object testDate[][] = {{true,"04:56:10"}, {false, "-1"}};
		for(int i = 0; i < testDate.length; ++i) {
			assertEquals(testDate[i][0], controller.checkdate((String)testDate[i][1]));
		}
		
	}
}
