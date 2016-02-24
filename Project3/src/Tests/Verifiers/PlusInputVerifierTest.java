package Tests.Verifiers;

import static org.junit.Assert.*;
import org.junit.Test;
import Verifiers.PeriodInputVerifier;


public class PlusInputVerifierTest {

	public PeriodInputVerifier DIV=new PeriodInputVerifier();
	
	@Test
	public void CharInRange(){
		assertTrue(DIV.meetsCriteria('.'));		
	}
	
	
	@Test
	public void CharOutOfRange(){
		assertFalse(DIV.meetsCriteria('8'));
		assertFalse(DIV.meetsCriteria('e'));
		assertFalse(DIV.meetsCriteria('+'));
	}
	
	
}
