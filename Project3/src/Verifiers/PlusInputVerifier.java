package Verifiers;

public class PlusInputVerifier implements InputVerifier {

	@Override
	public boolean meetsCriteria(char c) {
		if(c==43){
			return true;
		}
		return false;
	}

}
