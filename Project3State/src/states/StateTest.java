package states;

import static org.junit.Assert.*;

import org.junit.Test;

import code.InterimResult;


public class StateTest
{

	/**
	 * Make sure if the char is a digit it will decide a digit
	 */
	@Test
	public void testDecideDigit()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		
		IR.getCurrentState().decide('5', IR);
		
		assertEquals(5, IR.getV(), .000001);
		assertTrue(IR.getCurrentState() instanceof Integer);
	}
	
	/**
	 * Make sure if the char is a decimal it will decide a decimal
	 */
	@Test
	public void testDecideDecimal()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().decide('.', IR);
		
		assertEquals(0, IR.getV(), .000001);
		assertTrue(IR.getCurrentState() instanceof Decimal);
	}
	
	/**
	 * Make sure if the char is a plus sign it will use the plus method
	 */
	@Test
	public void testDecidePlus()
	{
		InterimResult IR = new InterimResult(0, 1, 0);	
		IR.getCurrentState().decide('+', IR);
		
		assertEquals(0, IR.getV(), .000001);
		assertTrue(IR.getCurrentState() instanceof Integer);
	}
	
	/**
	 *  Make sure if the char is a minus it will decide to use the minus method
	 */
	@Test
	public void testDecideMinus()
	{
		InterimResult IR = new InterimResult(0, 1, 0);	
		IR.getCurrentState().decide('-', IR);
		
		assertEquals(0, IR.getV(), .000001);
		assertTrue(-1 == IR.getS());
		assertTrue(IR.getCurrentState() instanceof Integer);
	}
	
	/**
	 * If it is something other than (+, -, digit, ., then make sure it can get to
	 * the error method 
	 */
	@Test(expected = NumberFormatException.class)
	public void testDecideOther()
	{
		InterimResult IR = new InterimResult(0, 1, 0);	
		IR.getCurrentState().decide('a', IR);
		
		assertTrue(IR.getCurrentState() instanceof End);
		assertTrue(0 == IR.getV());
	}

}
