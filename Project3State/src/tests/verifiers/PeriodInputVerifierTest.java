package tests.verifiers;

import static org.junit.Assert.*;

import org.junit.Test;

import verifiers.PeriodInputVerifier;

/**
 * Test that the character is a '+'
 */
public class PeriodInputVerifierTest {

	public PeriodInputVerifier PIV = new PeriodInputVerifier();
	
	/**
	 * Is a '.'
	 */
	@Test
	public void CharInRange(){
		assertTrue(PIV .meetsCriteria('.'));		
	}
	
	/**
	 * Isn't a '.'
	 */
	@Test
	public void CharOutOfRange(){
		assertFalse(PIV .meetsCriteria('3'));
		assertFalse(PIV .meetsCriteria('a'));
		assertFalse(PIV .meetsCriteria('+'));
	}
	
	
}
