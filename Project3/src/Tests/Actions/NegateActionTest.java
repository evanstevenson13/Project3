package Tests.Actions;

import static org.junit.Assert.*;
import org.junit.Test;
import Actions.NegateAction;
import Code.InterimResult;

public class NegateActionTest {

	/**
	 * S should become negative 1 when - is sent to action
	 */
	@Test
	public void TurnSNegative() {
		NegateAction NegateA =  new NegateAction();
		InterimResult IRBefore = new InterimResult(0.0,1,0.0);
		InterimResult IRAfter = NegateA.execute(IRBefore, '-');
		
		assertEquals(-1, IRAfter.getS());
	}

}
