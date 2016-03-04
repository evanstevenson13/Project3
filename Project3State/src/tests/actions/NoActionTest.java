package tests.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.NoAction;
import code.InterimResult;

public class NoActionTest {

	@Test
	public void ResultIsTheSame() {
		NoAction NoA =  new NoAction();
		InterimResult IRBefore = new InterimResult(0.0,1,0.0);
		InterimResult IRAfter = NoA.execute(IRBefore, '+');
		
		assertEquals(IRBefore, IRAfter);
	}

}
