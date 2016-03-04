

	// Checks the input is between 0-9
bool DigitInputVerifier(char c){
	if(c >= 48 && c<=57){
		return True;
	}
	return False;
}

	// Checks the input is a minus
bool MinusInputVerifier(char c){
	if(c == 45){
		return True;
	}
	return False;
}

	// Checks the input is a plus
bool PlusInputVerifier(char c){
	if(c == 43){
		return True;
	}
	return False;
}

	// Checks the input is a period
bool PeriodInputVerifier(char c){
	if(c == 46){
		return True;
	}
	return False;
}

	// Checks the input is null terminator
bool StringEndInputVerifier(char c){
	if(c == 0){
		return True;
	}
	return False;
}


	// Matches anything that isn't \0, ., +, -, 0-9
bool InvalidInputVerifier(char c){
		// Matches 0-9
	if(c >= 48 && c<=57){
		return False;
	}

		//Matches ., +, -, \0
	if(c == 43 || c==45 || c==46 || c==0){
		return False;
	}

	return True;
}



