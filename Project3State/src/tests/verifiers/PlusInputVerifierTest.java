package tests.verifiers;

import static org.junit.Assert.*;

import org.junit.Test;

import verifiers.PlusInputVerifier;

/**
 * 
 * Test the + verifier
 */
public class PlusInputVerifierTest {

	public PlusInputVerifier PIV=new PlusInputVerifier();
	
	/**
	 * Make sure the plus sign is verified
	 */
	@Test
	public void CharInRange(){
		assertTrue(PIV.meetsCriteria('+'));		
	}
	
	/**
	 * Anything that isn't a plus sign should return false
	 */
	@Test
	public void CharOutOfRange(){
		assertFalse(PIV.meetsCriteria('8'));
		assertFalse(PIV.meetsCriteria('e'));
		assertFalse(PIV.meetsCriteria('.'));
	}
	
	
}
