package Actions;

import Code.Action;
import Code.InterimResult;

public class ContinuingIntegerAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		double oldValue = x.getV();
		double newValue = (10 * oldValue) + (c-'0');
		x.setV(newValue);
		return x;
	}

}
