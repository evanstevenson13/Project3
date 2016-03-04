package verifiers;

public class PlusInputVerifier implements InputVerifier {

	public boolean meetsCriteria(char c) {
		if(c==43){
			return true;
		}
		return false;
	}

}
