package Tests.Actions;

import static org.junit.Assert.*;
import org.junit.Test;
import Actions.ValueIsDigitAction;
import Code.InterimResult;

public class ValueIsDigitActionTest {

	@Test
	//TODO: Fix name
	public void ResultIsDifferent() {
		ValueIsDigitAction VDA =  new ValueIsDigitAction();
		InterimResult IRBefore = new InterimResult(0.0,1,0.0);
		InterimResult IRAfter = VDA.execute(IRBefore, '2');
		
		assertEquals(2, IRAfter.getV(), .00001);
	}

}
