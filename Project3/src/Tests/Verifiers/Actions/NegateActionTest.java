package Tests.Verifiers.Actions;

import static org.junit.Assert.*;
import org.junit.Test;
import Actions.NegateAction;
import Code.InterimResult;

public class NegateActionTest {

	@Test
	//TODO: Fix name
	public void ResultIsDifferent() {
		NegateAction NegateA =  new NegateAction();
		InterimResult IRBefore = new InterimResult(0.0,1,0.0);
		InterimResult IRAfter = NegateA.execute(IRBefore, '-');
		
		assertEquals(-1, IRAfter.getS());
	}

}
