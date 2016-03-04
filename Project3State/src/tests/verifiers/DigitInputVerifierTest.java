package tests.verifiers;

import static org.junit.Assert.*;

import org.junit.Test;

import verifiers.DigitInputVerifier;

public class DigitInputVerifierTest {

	public DigitInputVerifier DIV=new DigitInputVerifier();
	
	/**
	 * test for each number that the char will be recognized as a number
	 */
	@Test
	public void CharInRange(){
		for(int ValueToTest=0;ValueToTest<10;ValueToTest++){
			assertTrue(DIV.meetsCriteria((char)(ValueToTest+48)));
		}
		
	}
	
	/**
	 * test border cases another example that is not a number
	 */
	@Test
	public void CharOutOfRange(){
		assertFalse(DIV.meetsCriteria('.'));
		assertFalse(DIV.meetsCriteria('/'));
		assertFalse(DIV.meetsCriteria(':'));
	}
	
	
}
