package actions;

import code.Action;
import code.InterimResult;

public class ValueIsDigitAction implements Action {

	/**
	 * First digit entered so set v to to digit
	 */
	public InterimResult execute(InterimResult ir, char c){
		ir.setV((c-'0'));
		return ir;
	}

}
