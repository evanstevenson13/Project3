package actions;

import states.End;
import code.Action;
import code.InterimResult;
/**
 * throw an exception because the char wasn't expected
 */
public class ErrorAction implements Action
{
	/**
	 * Set the value to 0 and set the state end
	 */
	public InterimResult execute(InterimResult ir, char c){
		ir.setV(0);
		ir.setCurrentState(new End());
		throw new NumberFormatException();
	}
}
