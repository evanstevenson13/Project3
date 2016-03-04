package Tests.Actions;

import static org.junit.Assert.*;

import org.junit.Test;

import Actions.NoAction;
import Code.InterimResult;

public class NoActionTest {

	/**
	 * The result should not change when sent to the action
	 */
	@Test
	public void NoChange() {
		NoAction NoA =  new NoAction();
		InterimResult IRBefore = new InterimResult(0.0,1,0.0);
		InterimResult IRAfter = NoA.execute(IRBefore, '+');
		
		assertEquals(IRBefore, IRAfter);
	}

}
