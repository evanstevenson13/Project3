package tests.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.ValueIsDigitAction;
import code.InterimResult;


public class ValueIsDigitActionTest {

	@Test
	
	public void ValueIsChanged(){
		ValueIsDigitAction VDA =  new ValueIsDigitAction();
		InterimResult IRBefore = new InterimResult(0.0,1,0.0);
		InterimResult IRAfter = VDA.execute(IRBefore, '2');
		
		assertEquals(2, IRAfter.getV(), .00001);
	}

}
