package Verifiers;


public class DigitInputVerifier implements InputVerifier {

	@Override
	public boolean meetsCriteria(char c) {
		if(c>=48 && c<=57){
			return true;
		}
		return false;
	}

}



/*
 
	v= c - '0'
		Take user input
		Takes ascii decimal value of c and subtracts decimal value of 0(48)
	
	s is sign holder(-1 for negative)(1 for positive)
	
	p indicates if a decimal has been entered
		if . entered then set p to 0.1
	
	if '\0' entered then end
		return s * v
		
	if other is entered then end
		return 0
		
*/