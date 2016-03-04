package states;

import actions.ContinuingFractionAction;

import actions.ErrorAction;
import code.InterimResult;

public class Decimal extends State
{

	/**
	 *  Adding a digit from fraction
	 */
	@Override
	protected void digit(char c, InterimResult ir)
	{
		ContinuingFractionAction ContinuingFraction = new ContinuingFractionAction();
		ContinuingFraction.execute(ir, c);
	}

	/**
	 * Adding a decimal from fraction
	 */
	@Override
	protected void decimal(char c, InterimResult ir)
	{
		error(c, ir);
	}

	/**
	 * A plus sign from fraction
	 */
	@Override
	protected void plus(char c, InterimResult ir)
	{
		error(c, ir);
	}

	/**
	 * A negative sign from fraction
	 */
	@Override
	protected void minus(char c, InterimResult ir)
	{
		error(c, ir);
	}

	/**
	 * An error from fraction
	 */
	@Override
	protected void error(char c, InterimResult ir)
	{
		ErrorAction Error = new ErrorAction();
		Error.execute(ir, c);
	}

}
