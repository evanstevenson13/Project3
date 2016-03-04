package states;

import static org.junit.Assert.*;

import org.junit.Test;

import code.InterimResult;
/**
 * @author Kyle Jones
 * Testing actions from Start state
 */
public class StartTest
{
	/**
	 * Enter an integer to start
	 */
	@Test
	public void testInteger()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		
		IR.getCurrentState().digit('5', IR);
		
		assertTrue(5 == IR.getV());
		assertTrue(IR.getCurrentState() instanceof Integer);
	}
	
	/**
	 * Enter a . to start a fraction
	 */
	@Test
	public void testDecimal()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		
		IR.getCurrentState().decimal('.', IR);
		
		assertEquals(0.0, IR.getV(), .00001);
		assertEquals(.1, IR.getP(), .00001);
		assertTrue(IR.getCurrentState() instanceof Decimal);
	}
	
	/**
	 * A plus sign from start
	 */
	@Test
	public void testPlus()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		
		IR.getCurrentState().plus('+', IR);
		
		assertTrue(0 == IR.getV());
		assertTrue(1 == IR.getS());
		assertTrue(IR.getCurrentState() instanceof Integer);
	}
	
	/**
	 * A minus sign from start
	 */
	@Test
	public void testMinus()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		
		IR.getCurrentState().minus('-', IR);
		
		assertTrue(0 == IR.getV());
		assertTrue(-1 == IR.getS());
		assertTrue(IR.getCurrentState() instanceof Integer);
	}
	
	/**
	 * Something other than a number, sign or .
	 */
	@Test(expected = NumberFormatException.class)
	public void testOther()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().error('a', IR);
		assertTrue(0 == IR.getV());
		assertTrue(IR.getCurrentState() instanceof End);
	}

}
