package states;

import verifiers.DigitInputVerifier;
import verifiers.MinusInputVerifier;
import verifiers.PeriodInputVerifier;
import verifiers.PlusInputVerifier;
import code.InterimResult;

public abstract class State
{
	protected abstract void digit(char c, InterimResult ir);
	protected abstract void decimal(char c, InterimResult ir);
	protected abstract void plus(char c, InterimResult ir);
	protected abstract void minus(char c, InterimResult ir);
	protected abstract void error(char c, InterimResult ir);
	
	/**
	 * Decide which function to use
	 * Used regardless of the state in so the state knows what action to take
	 * @param c character to be analyzed
	 * @param ir Interim result to be change
	 */
	public void decide(char c, InterimResult ir)
	{
		DigitInputVerifier DigitInputVerifier = new DigitInputVerifier();
		PeriodInputVerifier PeriodInputVerifier = new PeriodInputVerifier();
		PlusInputVerifier PlusInputVerifier = new PlusInputVerifier();
		MinusInputVerifier MinusInputVerifier = new MinusInputVerifier();
		boolean actionHappened = false;
		
		if(DigitInputVerifier.meetsCriteria(c) == true)		//is a digit
		{
			digit(c, ir);	//use digit function
			actionHappened = true;		//mark that action happened
		}
		
		if(PeriodInputVerifier.meetsCriteria(c) == true)	//is a '.'
		{
			decimal(c, ir);			//use decimal function
			actionHappened = true;	//mark that action happened
		}
		
		if(PlusInputVerifier.meetsCriteria(c) == true)	//is a plus sign
		{
			plus(c, ir);		//use the plus function
			actionHappened = true;		//mark that action happened
		}
		
		if(MinusInputVerifier.meetsCriteria(c) == true)	///is a minus sign
		{
			minus(c, ir);	//use the minus function
			actionHappened = true;	//mark that action happened
		}
		
		/**
		 * if nothing else has happened then an error occurred
		 * some invalid character was entered
		 */
		if(actionHappened == false)
		{
			error(c, ir);
		}
	}
}
