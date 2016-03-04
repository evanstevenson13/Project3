package Actions;

import Code.Action;
import Code.InterimResult;

public class ContinuingFactionAction implements Action{

	/**
	 * @param ir the current InterimResult that will be modified based of the character given
	 * @param c character to be added to the new result
	 * @return the modified InterimResult
	 * Adds a number to the current decimal
	 * Adds the old v value to the integer and multiplies it by p to move it back however many places
	 * Divide p by 10 to move it back another place next time a number is entered
	 */
	@Override
	public InterimResult execute(InterimResult ir, char c){
		double oldValue = ir.getV();
		ir.setV(oldValue + (c - '0')*ir.getP());
		ir.setP(ir.getP()/10);
		return ir;
	}

}
