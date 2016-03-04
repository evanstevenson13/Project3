package tests.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.NegateAction;
import code.InterimResult;

public class NegateActionTest {

	@Test
	
	public void ResultIsNegativeSign() {
		NegateAction NegateA =  new NegateAction();
		InterimResult IRBefore = new InterimResult(0.0,1,0.0);
		InterimResult IRAfter = NegateA.execute(IRBefore, '-');
		
		assertEquals(-1, IRAfter.getS());
	}

}
