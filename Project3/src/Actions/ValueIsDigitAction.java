package Actions;

import Code.Action;
import Code.InterimResult;

public class ValueIsDigitAction implements Action{

	@Override
	/**
	 * @param ir the current InterimResult that will be modified based of the character given
	 * @param c character to be added to the new result
	 * @return the modified InterimResult
	 * Sets the first character in the new number to whatever number c is
	 */
	public InterimResult execute(InterimResult ir, char c){
		ir.setV((c-'0'));
		return ir;
	}

}
