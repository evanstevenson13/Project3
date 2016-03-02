package Actions;

import Code.Action;
import Code.InterimResult;

public class ValueIsDigitAction implements Action {

	@Override
	//TODO: change x to ir everywhere
	public InterimResult execute(InterimResult x, char c){
		x.setV((c-'0'));
		return x;
	}

}
