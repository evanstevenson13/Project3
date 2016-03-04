package Actions;

import Code.Action;
import Code.InterimResult;

public class NegateAction implements Action{

	@Override
	/**
	 * @param ir the current InterimResult that will be modified based of the character given
	 * @param c character to be added to the new result
	 * @return the modified InterimResult
	 * Set s to -1 so that it can later be multiplied by v and will make v a negative number
	 */
	public InterimResult execute(InterimResult ir, char c){
		ir.setS(-1);
		return ir;
	}

}
