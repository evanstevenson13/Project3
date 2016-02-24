package Actions;

import Code.Action;
import Code.InterimResult;

public class StartFraction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
//		InterimResult IR = new InterimResult(x);
		x.setP(.1);
		return x;
	}

}
