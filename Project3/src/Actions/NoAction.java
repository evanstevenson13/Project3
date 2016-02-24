package Actions;

import Code.Action;
import Code.InterimResult;

public class NoAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		return x;
	}

}
