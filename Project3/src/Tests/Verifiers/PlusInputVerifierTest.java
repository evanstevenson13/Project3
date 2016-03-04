package Tests.Verifiers;

import static org.junit.Assert.*;
import org.junit.Test;
import Verifiers.PlusInputVerifier;


public class PlusInputVerifierTest {

	public PlusInputVerifier DIV=new PlusInputVerifier();
	
	/**
	 * Make sure plus is accepted
	 */
	@Test
	public void CharInRange(){
		assertTrue(DIV.meetsCriteria('+'));		
	}
	
	
	/**
	 * Anything that's not a plus is not accepted
	 */
	@Test
	public void CharOutOfRange(){
		assertFalse(DIV.meetsCriteria('*'));
		assertFalse(DIV.meetsCriteria(','));
		assertFalse(DIV.meetsCriteria('3'));
		assertFalse(DIV.meetsCriteria('a'));
		assertFalse(DIV.meetsCriteria('.'));
	}
	
	
}
