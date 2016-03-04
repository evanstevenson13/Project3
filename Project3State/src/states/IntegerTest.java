package states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.InterimResult;

public class IntegerTest
{
	/**
	 * Also covered in TestState but important to make sure the number
	 * gets to the integer state
	 */
	@Test
	public void getToIntegerState()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().digit('4', IR);
	
		assertTrue(IR.getCurrentState() instanceof Integer);
	}
	
	/**
	 * Continue building on the integer with another integer
	 */
	@Test
	public void testInteger()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().digit('4', IR);
		
		IR.getCurrentState().digit('5', IR);
		assertTrue(45 == IR.getV());
		assertTrue(IR.getCurrentState() instanceof Integer);

	}
	
	/**
	 * Start a fraction if decimal is entered
	 */
	@Test
	public void testFraction()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().digit('4', IR);
		
		IR.getCurrentState().decimal('.', IR);
		
		assertEquals(4.0, IR.getV(), .00001);
		assertEquals(.1, IR.getP(), .00001);
		assertTrue(IR.getCurrentState() instanceof Decimal);
	}
	
	/**
	 * Exception thrown if plus is entered from Integer state
	 */
	@Test (expected = NumberFormatException.class)
	public void testPlus()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().digit('4', IR);
		
		IR.getCurrentState().plus('+', IR);
		
		assertTrue(0 == IR.getV());
		assertTrue(IR.getCurrentState() instanceof End);
	}
	
	/**
	 * Exception thrown if minus is entered from Integer state
	 */
	@Test (expected = NumberFormatException.class)
	public void testMinus()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().digit('4', IR);
		
		IR.getCurrentState().minus('-', IR);
		
		assertTrue(0 == IR.getV());
		assertTrue(IR.getCurrentState() instanceof End);
	}
	
	@Test (expected = NumberFormatException.class)
	public void testOther()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().digit('4', IR);
		
		IR.getCurrentState().error('a', IR);
		assertTrue(0 == IR.getV());
		assertTrue(IR.getCurrentState() instanceof End);
	}
}
