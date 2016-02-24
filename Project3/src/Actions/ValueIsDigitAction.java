package Actions;

import Code.Action;
import Code.InterimResult;

public class ValueIsDigitAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c){
//		InterimResult IR = new InterimResult(x);
		x.setV((c-'0'));
		return x;
	}

}
