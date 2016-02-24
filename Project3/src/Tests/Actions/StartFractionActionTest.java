package Tests.Actions;

import static org.junit.Assert.*;

import org.junit.Test;

import Actions.StartFraction;
import Code.InterimResult;

public class StartFractionActionTest {

	@Test
	//TODO: Fix name
	public void ResultIsDifferent() {
		StartFraction SF =  new StartFraction();
		InterimResult IRBefore = new InterimResult(0.0,1,0.0);
		InterimResult IRAfter = SF.execute(IRBefore, '.');
		
		assertNotEquals(IRBefore, IRAfter);
	}

}
