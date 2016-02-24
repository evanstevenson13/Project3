package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Verifiers.MinusInputVerifier;


public class MinusInputVerifierTest {

	public MinusInputVerifier DIV=new MinusInputVerifier();
	
	@Test
	public void CharInRange(){
		assertTrue(DIV.meetsCriteria('-'));		
	}
	
	
	@Test
	public void CharOutOfRange(){
		assertFalse(DIV.meetsCriteria('g'));
		assertFalse(DIV.meetsCriteria('1'));
		assertFalse(DIV.meetsCriteria('5'));
	}
	
	
}
