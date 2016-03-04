package Actions;

import Code.Action;
import Code.InterimResult;

public class NoAction implements Action {

	@Override
	/**
	 * @param ir the current InterimResult that will be modified based of the character given
	 * @param c character to be added to the new result
	 * @return the NOT modified InterimResult
	 * Nothing needs to be done. Just return the result that is given
	 */
	public InterimResult execute(InterimResult ir, char c) {
		return ir;
	}

}
