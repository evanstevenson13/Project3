package Tests.Verifiers.Actions;

import static org.junit.Assert.*;
import org.junit.Test;
import Actions.ContinuingFactionAction;
import Code.InterimResult;

public class ContinuingFractionActionTest {

	@Test
	//TODO: Fix name
	public void ResultIsDifferent() {
		ContinuingFactionAction CFA =  new ContinuingFactionAction();
		InterimResult IRBefore = new InterimResult(0.1, 1, 0.0);
		InterimResult IRAfter = CFA.execute(IRBefore, '4');
		
		assertEquals(.01, IRAfter.getP(), .0001);
		assertEquals(.4, IRAfter.getV(), .0001);
	}

}
