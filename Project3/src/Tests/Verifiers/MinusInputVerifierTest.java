package Tests.Verifiers;

import static org.junit.Assert.*;
import org.junit.Test;
import Verifiers.MinusInputVerifier;


public class MinusInputVerifierTest {

	public MinusInputVerifier DIV=new MinusInputVerifier();
	
	/**
	 * Make sure minus is accepted
	 */
	@Test
	public void CharInRange(){
		assertTrue(DIV.meetsCriteria('-'));		
	}
	
	
	/**
	 * Anything that's not a minus is not accepted
	 */
	@Test
	public void CharOutOfRange(){
		assertFalse(DIV.meetsCriteria(','));
		assertFalse(DIV.meetsCriteria('.'));
		assertFalse(DIV.meetsCriteria('g'));
		assertFalse(DIV.meetsCriteria('1'));
		assertFalse(DIV.meetsCriteria('5'));
	}
	
	
}
