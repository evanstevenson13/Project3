package states;


import code.InterimResult;
/**
 * End State has NoAction no matter what is entered
 * 
 * Almost completely use class after throwing an error occurred
 * But it is referenced in tests that proved it was working 
 */
public class End extends State
{
	/**
	 * No Action
	 */
	@Override
	protected void digit(char c, InterimResult ir)
	{
		
	}

	/**
	 * No Action
	 */
	@Override
	protected void decimal(char c, InterimResult ir)
	{
		
	}

	/**
	 * No Action
	 */
	@Override
	protected void plus(char c, InterimResult ir)
	{

	}

	/**
	 * No Action
	 */
	@Override
	protected void minus(char c, InterimResult ir)
	{

	}	

	/**
	 * No Action
	 */
	@Override
	protected void error(char c, InterimResult ir)
	{
	
	}
}
