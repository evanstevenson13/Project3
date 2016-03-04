package states;

import static org.junit.Assert.*;

import org.junit.Test;

import code.InterimResult;

public class DecimalTest
{
	/**
	 * Make sure getting to fraction works
	 */
	@Test
	public void getToIntegerState()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().decimal('.', IR);
	
		assertTrue(IR.getCurrentState() instanceof Decimal);
	}
	
	/**
	 * Test adding an integer from fraction
	 */
	@Test
	public void testInteger()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().decimal('.', IR);
		IR.getCurrentState().digit('5', IR);
		
		assertEquals(.5, IR.getV(), .00001);
		assertTrue(IR.getCurrentState() instanceof Decimal);
	}
	
	/**
	 * Test adding an a decimal from fraction
	 * Error should occur
	 */
	@Test (expected = NumberFormatException.class)
	public void testDecimal()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().decimal('.', IR);
		IR.getCurrentState().decimal('.', IR);
		
		assertEquals(0, IR.getV(), .00001);
		assertTrue(IR.getCurrentState() instanceof End);
	}
	
	/**
	 * Make sure error occurs when a + sign is added after a .
	 */
	@Test (expected = NumberFormatException.class)
	public void testPlus()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().decimal('.', IR);
		IR.getCurrentState().plus('+', IR);
		
		assertEquals(0, IR.getV(), .00001);
		assertTrue(IR.getCurrentState() instanceof End);
	}
	
	/**
	 * Make sure error occurs when a - sign is added after a .
	 */
	@Test (expected = NumberFormatException.class)
	public void testMinus()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().decimal('.', IR);
		IR.getCurrentState().minus('-', IR);
		
		assertEquals(0, IR.getV(), .00001);
		assertTrue(IR.getCurrentState() instanceof End);
	}
	
	/**
	 * Make sure an error is thrown when something other than
	 * + - digit or . is added from Decimal State
	 */
	@Test (expected = NumberFormatException.class)
	public void testOther()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().decimal('.', IR);
		IR.getCurrentState().error('a', IR);
		
		assertEquals(0, IR.getV(), .00001);
		assertTrue(IR.getCurrentState() instanceof End);
	}

}
