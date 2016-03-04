package tests.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.ContinuingIntegerAction;
import code.InterimResult;

public class ContinuingIntegerActionTest {

	/**
	 * Continue the integer with a tenths place
	 */
	@Test
	public void ResultIsDifferent() {
		ContinuingIntegerAction CIA =  new ContinuingIntegerAction();
		InterimResult IRBefore = new InterimResult(0.0, 1, 2.0);
		InterimResult IRAfter = CIA.execute(IRBefore, '4');
		
		assertEquals(24, IRAfter.getV(), .0001);
	}

}
