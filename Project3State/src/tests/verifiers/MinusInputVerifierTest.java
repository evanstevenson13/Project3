package tests.verifiers;

import static org.junit.Assert.*;

import org.junit.Test;

import verifiers.MinusInputVerifier;


public class MinusInputVerifierTest {

	public MinusInputVerifier DIV=new MinusInputVerifier();

	/**
	 * Make sure a '-' is recognized
	 */
	@Test
	public void CharInRange(){
		assertTrue(DIV.meetsCriteria('-'));		
	}
	
	/**
	 * Make sure a letter and a number are recognized as different
	 */
	@Test
	public void CharOutOfRange(){
		assertFalse(DIV.meetsCriteria('g'));
		assertFalse(DIV.meetsCriteria('1'));
		assertFalse(DIV.meetsCriteria('5'));
	}
	
	
}
