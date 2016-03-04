package tests.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.ContinuingFractionAction;
import actions.StartFraction;
import code.InterimResult;

public class StartFractionActionTest {

	/**
	 * Test to make sure the value is still 0.0 after decimal
	 */
	@Test
	public void ResultIsSame() {
		StartFraction SF =  new StartFraction();
		InterimResult IRBefore = new InterimResult(0.0,1,0.0);
		InterimResult IRAfter = SF.execute(IRBefore, '.');
		
		assertTrue(IRBefore.getV() == IRAfter.getV());
	}
	
	/**
	 * Make sure the integer can be added after the decimal
	 * to insure it starts the fraction correctly
	 */
	public void ResultIsDifferent() {
		StartFraction SF =  new StartFraction();
		InterimResult IRBefore = new InterimResult(0.0,1,0.0);
		InterimResult IRAfter = SF.execute(IRBefore, '.');
		
		//Requires continuing decimal also works
		char testInt = 5 + '0';	 //must be single digit
		double testTenth = testInt/10;
		ContinuingFractionAction CFA = new ContinuingFractionAction();
		IRAfter = CFA.execute(IRAfter, testInt);
		assertTrue(IRBefore.getV() == IRAfter.getV()+testTenth);
	}

}
