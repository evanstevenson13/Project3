package Tests.Actions;

import static org.junit.Assert.*;
import org.junit.Test;
import Actions.ContinuingIntegerAction;
import Code.InterimResult;

public class ContinuingIntegerActionTest{

	/**
	 * Integer sent to action should be added to the end of the result
	 */
	@Test
	public void IntegerAdded(){
		ContinuingIntegerAction CIA =  new ContinuingIntegerAction();
		InterimResult IRBefore = new InterimResult(0.0, 1, 2.0);
		InterimResult IRAfter = CIA.execute(IRBefore, '4');
		
		assertEquals(24, IRAfter.getV(), .01);
	}

}
