package tests.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.ContinuingFractionAction;
import code.InterimResult;

public class ContinuingFractionActionTest {

	/**
	 * Test adding digits to the decimal
	 */
	@Test
	public void ResultIsDifferent() {
		ContinuingFractionAction CFA =  new ContinuingFractionAction();
		InterimResult IRBefore = new InterimResult(0.1, 1, 0.0);	//set p = .1 for proper calculation
		InterimResult IRAfter = CFA.execute(IRBefore, '4');
		
		assertEquals(.01, IRAfter.getP(), .0001);	//make sure p was changed (p/10)
		assertEquals(.4, IRAfter.getV(), .0001);	//the digit was the correct place
	}

}
