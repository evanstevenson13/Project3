package Actions;

import Code.Action;
import Code.InterimResult;

public class ContinuingIntegerAction implements Action{

	@Override
	/**
	 * @param ir the current InterimResult that will be modified based of the character given
	 * @param c character to be added to the new result
	 * @return the modified InterimResult
	 * Adds a integer to the current integer
	 * Multiply current v by 10 to move it to the next place and then add on the new number
	 */
	public InterimResult execute(InterimResult ir, char c){
		double oldValue = ir.getV();
		double newValue = (10 * oldValue) + (c-'0');
		ir.setV(newValue);
		return ir;
	}

}
