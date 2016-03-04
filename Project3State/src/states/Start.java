package states;

import actions.ContinuingIntegerAction;
import actions.ErrorAction;
import actions.NegateAction;
import actions.NoAction;
import actions.StartFraction;
import code.InterimResult;
import states.State;

public class Start extends State
{
	/**
	 * Digit function for the Start state
	 */
	@Override
	protected void digit(char c, InterimResult ir)
	{
		ContinuingIntegerAction ContinueInteger = new ContinuingIntegerAction();
		ContinueInteger.execute(ir, c);
		
	}

	/**
	 * If it is a decimal for the Start state
	 */
	@Override
	protected void decimal(char c, InterimResult ir)
	{
		StartFraction StartFraction = new StartFraction();
		StartFraction.execute(ir, c);
	}

	/**
	 * If it is a plus sign from the Start state
	 */
	@Override
	protected void plus(char c, InterimResult ir)
	{
		NoAction NoAction = new NoAction();
		NoAction.execute(ir, c);
	}

	/**
	 * If it is a minus sign from the Start state
	 */
	@Override
	protected void minus(char c, InterimResult ir)
	{
		NegateAction Negate = new NegateAction();
		Negate.execute(ir, c);		
	}

	/**
	 * if there was an error directly from start state
	 */
	@Override
	protected void error(char c, InterimResult ir)
	{
		ErrorAction error = new ErrorAction();
		error.execute(ir, c);
	}


	
}
