package Actions;

import Code.Action;
import Code.InterimResult;

public class ContinuingFactionAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
	
		double oldValue = x.getV();
		x.setV(oldValue + (c - '0')*x.getP());
		x.setP(x.getP()/10);
		return x;
	}

}
