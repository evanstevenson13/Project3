package code;


/**
 * A finite state machine that parses a string containing a real number. Will
 * throw NumberFormatExcaption if the string doesn't not contain a legal
 * representation of a real number. Note: we are not dealing with scientific
 * notation
 * 
 * @author Merlin
 *
 */

public class ConvertingMachine
{

	/**
	 * Breaks down the String to individual characters to solve
	 * one character at a time
	 * @param text
	 * @return
	 */
	public double parse(String text)
	{		
		InterimResult IR = new InterimResult(0, 1, 0);		//create intial InterimResult
		for(int charPos = 0; charPos < text.length(); charPos++)	
		{
			IR.currentState.decide(text.charAt(charPos), IR);	//act for that character
		}
		
		return IR.getV() * IR.getS();	//return sign times value
	}

}
