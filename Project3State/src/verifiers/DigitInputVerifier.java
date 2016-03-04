package verifiers;


public class DigitInputVerifier implements InputVerifier {

	/**
	 * The char is a digit (0-9) 
	 */
	public boolean meetsCriteria(char c) {
		if(c>=48 && c<=57){
			return true;
		}
		return false;
	}

}
