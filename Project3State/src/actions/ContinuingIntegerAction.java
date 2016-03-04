package actions;

import code.Action;
import code.InterimResult;
import states.Integer;

/**
 * Continue adding on digits to an integer
 *
 */
public class ContinuingIntegerAction implements Action {

	/**
	 * Continue adding on digits to an integer
	 */
	public InterimResult execute(InterimResult ir, char c) {
		double oldValue = ir.getV();
		double newValue = (10 * oldValue) + (c-'0');	//10 times old value so when the new
						//number is added it is in the correct place
		ir.setV(newValue);	//set the new value
		ir.setCurrentState(new Integer());	//still an integer
		return ir;
	}

}
