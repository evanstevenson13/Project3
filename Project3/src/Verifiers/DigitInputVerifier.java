package Verifiers;


public class DigitInputVerifier implements InputVerifier {

	/**
	 * @param c character to be checked
	 * If c is a number between 0-9 then return true otherwise return false 
	 */
	@Override
	public boolean meetsCriteria(char c) {
		if(c>=48 && c<=57){
			return true;
		}
		return false;
	}

}