package actions;

import code.Action;
import code.InterimResult;
import states.Integer;

public class NegateAction implements Action {

	/**
	 * Negate the sign and make the currentState Integer
	 */
	public InterimResult execute(InterimResult ir, char c) {
		ir.setS(-1);
		ir.setCurrentState(new Integer());
		return ir;
	}

}
