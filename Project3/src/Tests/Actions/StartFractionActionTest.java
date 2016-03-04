package Tests.Actions;

import static org.junit.Assert.*;

import org.junit.Test;

import Actions.StartFraction;
import Code.InterimResult;

public class StartFractionActionTest{

	/**
	 * Period is sent to the action then p should be changed to .1
	 */
	@Test
	public void StartDecimalTest(){
		StartFraction SF =  new StartFraction();
		InterimResult IRBefore = new InterimResult(0.0, 1, 0.0);
		InterimResult IRAfter = SF.execute(IRBefore, '.');
		
		assertEquals(.1, IRAfter.getP(), .1);
	}

}
