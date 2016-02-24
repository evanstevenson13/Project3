package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Verifiers.DigitInputVerifier;

public class DigitInputVerifierTest {

	public DigitInputVerifier DIV=new DigitInputVerifier();
	
	@Test
	public void CharInRange(){
		for(int ValueToTest=0;ValueToTest<10;ValueToTest++){
			assertTrue(DIV.meetsCriteria((char)(ValueToTest+48)));
		}
		
	}
	
	
	@Test
	public void CharOutOfRange(){
		assertFalse(DIV.meetsCriteria('.'));
		assertFalse(DIV.meetsCriteria('/'));
		assertFalse(DIV.meetsCriteria(':'));
	}
	
	
}
