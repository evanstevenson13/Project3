package Tests.Actions;

import static org.junit.Assert.*;
import org.junit.Test;
import Actions.ContinuingFactionAction;
import Code.InterimResult;

public class ContinuingFractionActionTest{

	/**
	 * Integer sent to action should be added to the end of the result
	 */
	@Test
	public void IntegerAddedToDecimal(){
		ContinuingFactionAction CFA =  new ContinuingFactionAction();
		InterimResult IRBefore = new InterimResult(0.1, 1, 5.0);
		InterimResult IRAfter = CFA.execute(IRBefore, '4');
		
		assertEquals(.01, IRAfter.getP(), .01);
		assertEquals(5.4, IRAfter.getV(), .01);
	}

}
