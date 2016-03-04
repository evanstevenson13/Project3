package actions;

import code.Action;
import code.InterimResult;

/**
 * Continue the Fraction with more more places
 */
public class ContinuingFractionAction implements Action {

	/**
	 * Add the digit to the right place 
	 */
	public InterimResult execute(InterimResult ir, char c) {
	
		double oldValue = ir.getV();
		ir.setV(oldValue + (c - '0')*ir.getP());	//old value plus the current place
		ir.setP(ir.getP()/10);	//for the next value added
		return ir;
	}

}
