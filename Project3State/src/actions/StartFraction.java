package actions;

import states.Decimal;
import code.Action;
import code.InterimResult;
/**
 * Set up the interim result so numbers will be added to the correct placement
 */
public class StartFraction implements Action {

	public InterimResult execute(InterimResult ir, char c) {

		ir.setP(.1);	//set to the first place after decimal
		ir.setCurrentState(new Decimal());
		return ir;
	}

}
