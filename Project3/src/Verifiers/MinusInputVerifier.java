package Verifiers;

public class MinusInputVerifier implements InputVerifier {

	@Override
	public boolean meetsCriteria(char c){
		if(c==45){
			return true;
		}
		return false;
	}

}
