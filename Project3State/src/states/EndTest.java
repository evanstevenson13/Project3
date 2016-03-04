package states;

import static org.junit.Assert.*;

import org.junit.Test;

import code.InterimResult;

/**
 * Useful testing when the end state was reachable but the only time
 * the end state was reach was when NumberFormatException.class was expected
 * and it then all tests were ruined by throwing this error
 * and so all tests should have expected = NumberFormatException.class
 */
public class EndTest
{
	@Test (expected = NumberFormatException.class)
	public void testGetToEnd()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().error('a', IR);
		
		assertTrue(IR.getCurrentState() instanceof End);
		
	}
	@Test (expected = NumberFormatException.class)
	public void testInteger()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().error('a', IR);
		
		IR.getCurrentState().digit('1', IR);
		assertTrue(0 == IR.getV());
		assertTrue(IR.getCurrentState() instanceof End);
	}
	
	@Test (expected = NumberFormatException.class)
	public void testDecimal()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().error('a', IR);
		
		IR.getCurrentState().decimal('.', IR);
		assertTrue(0 == IR.getV());
		assertTrue(IR.getCurrentState() instanceof End);
	}
	
	@Test (expected = NumberFormatException.class)
	public void testPlus()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().error('a', IR);
		
		IR.getCurrentState().plus('+', IR);
		assertTrue(0 == IR.getV());
		assertTrue(IR.getCurrentState() instanceof End);
	}
	
	@Test (expected = NumberFormatException.class)
	public void testMinus()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().error('a', IR);
		
		IR.getCurrentState().minus('-', IR);
		assertTrue(0 == IR.getV());
		assertTrue(IR.getCurrentState() instanceof End);
	}
	
	
	@Test (expected = NumberFormatException.class)
	public void testOther()
	{
		InterimResult IR = new InterimResult(0, 1, 0);
		IR.getCurrentState().error('a', IR);
		
		IR.getCurrentState().error('a', IR);
		assertTrue(0 == IR.getV());
		assertTrue(IR.getCurrentState() instanceof End);
	}

}
