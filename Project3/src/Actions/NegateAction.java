package Actions;

import Code.Action;
import Code.InterimResult;

public class NegateAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
//		InterimResult IR = new InterimResult(x);
		x.setS(-1);
		return x;
	}

}
