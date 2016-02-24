package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Verifiers.PlusInputVerifier;


public class PeriodInputVerifierTest {

	public PlusInputVerifier DIV=new PlusInputVerifier();
	
	@Test
	public void CharInRange(){
		assertTrue(DIV.meetsCriteria('+'));		
	}
	
	
	@Test
	public void CharOutOfRange(){
		assertFalse(DIV.meetsCriteria('3'));
		assertFalse(DIV.meetsCriteria('a'));
		assertFalse(DIV.meetsCriteria('.'));
	}
	
	
}
