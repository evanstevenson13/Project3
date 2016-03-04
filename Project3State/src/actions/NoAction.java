package actions;

import code.Action;
import code.InterimResult;
import states.Integer;

/**
 *  Nothing should happen but the state becomes integer
 *  (Did this because that is what the state diagram showed but
 *  it would make just as much sense (if not a better option to not change
 *  the state an stay at Start) so NoAction could be used in another scenario
 *  (if that scenario was added later)
 */
public class NoAction implements Action {

	/**
	 * change state to integer
	 */
	public InterimResult execute(InterimResult ir, char c) 
	{
		ir.setCurrentState(new Integer());
		return ir;
	}

}
