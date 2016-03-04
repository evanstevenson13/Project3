package Actions;

import Code.Action;
import Code.InterimResult;

public class StartFraction implements Action{

	@Override
	/**
	 * @param ir the current InterimResult that will be modified based of the character given
	 * @param c character to be added to the new result
	 * @return the modified InterimResult
	 * Sets p to .1 so that it can later be multiplied by v to turn the number into a double
	 */
	public InterimResult execute(InterimResult ir, char c){
		ir.setP(.1);
		return ir;
	}

}
