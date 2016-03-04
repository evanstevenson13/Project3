package Tests.Verifiers;

import static org.junit.Assert.*;

import org.junit.Test;

import Verifiers.DigitInputVerifier;

public class DigitInputVerifierTest {

	public DigitInputVerifier DIV=new DigitInputVerifier();
	
	/**
	 * Make sure numbers 0-9 is accepted
	 */
	@Test
	public void CharInRange(){
		for(int ValueToTest=0;ValueToTest<10;ValueToTest++){
			assertTrue(DIV.meetsCriteria((char)(ValueToTest+48)));
		}
		
	}
	
	
	/**
	 * Anything that's not a number 0-9 is not accepted
	 */
	@Test
	public void CharOutOfRange(){
		assertFalse(DIV.meetsCriteria('.'));
		assertFalse(DIV.meetsCriteria('/'));
		assertFalse(DIV.meetsCriteria(':'));
		assertFalse(DIV.meetsCriteria('a'));
		assertFalse(DIV.meetsCriteria('z'));
		assertFalse(DIV.meetsCriteria('`'));
	}
	
	
}
