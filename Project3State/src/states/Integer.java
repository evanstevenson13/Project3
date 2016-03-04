package states;

import actions.ContinuingIntegerAction;
import actions.ErrorAction;
import actions.StartFraction;
import code.InterimResult;

public class Integer extends State
{
	/**
	 * Enter another digit to continue the integer
	 */
	@Override
	protected void digit(char c, InterimResult ir)
	{
		ContinuingIntegerAction ContinuingInteger = new ContinuingIntegerAction();
		ContinuingInteger.execute(ir, c);
	}

	/**
	 * Entered a decimal so start a fraction
	 */
	@Override
	protected void decimal(char c, InterimResult ir)
	{
		StartFraction StartFraction = new StartFraction();
		StartFraction.execute(ir, c);
	}
	
	 /**
	 * If a plus is entered then an error occurred because it already reached the integer
	 */
	@Override
	protected void plus(char c, InterimResult ir)
	{
		error(c, ir);
	}

	/**
	 * If a minus is entered then an error occurred because it already reached the integer
	 */
	@Override
	protected void minus(char c, InterimResult ir)
	{
		error(c, ir);
	}

	/**
	 * If an error is reached
	 */
	@Override
	protected void error(char c, InterimResult ir)
	{
		ErrorAction error = new ErrorAction();
		error.execute(ir, c);		
	}
	
}
