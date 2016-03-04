package Verifiers;

public class PlusInputVerifier implements InputVerifier {

	/**
	 * @param c character to be checked
	 * If c is a + then return true otherwise return false 
	 */
	@Override
	public boolean meetsCriteria(char c) {
		if(c==43){
			return true;
		}
		return false;
	}

}
