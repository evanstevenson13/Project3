package verifiers;

/**
 * Test the minus input verifier
 */
public class MinusInputVerifier implements InputVerifier {

	/**
	 * returns whether or not the character is a -
	 */
	public boolean meetsCriteria(char c){
		if(c==45){		//is a '-'
			return true;	
		}
		return false;
	}

}
