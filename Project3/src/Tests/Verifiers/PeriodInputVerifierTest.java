package Tests.Verifiers;

import static org.junit.Assert.*;
import org.junit.Test;
import Verifiers.PeriodInputVerifier;


public class PeriodInputVerifierTest {

	public PeriodInputVerifier DIV=new PeriodInputVerifier();
	
	/**
	 * Make sure period is accepted 
	 */
	@Test
	public void CharInRange(){
		assertTrue(DIV.meetsCriteria('.'));		
	}
	
	
	/**
	 * Anything that's not a period is not accepted
	 */
	@Test
	public void CharOutOfRange(){
		assertFalse(DIV.meetsCriteria('-'));
		assertFalse(DIV.meetsCriteria('/'));
		assertFalse(DIV.meetsCriteria('8'));
		assertFalse(DIV.meetsCriteria('e'));
		assertFalse(DIV.meetsCriteria('+'));
	}
	
	
}
