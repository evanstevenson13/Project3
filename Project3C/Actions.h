

	// Turns c into a number
void ValueIsDigitAction(InterimResult *ir, char c){
	ir->v = (c-'0');
}

	// Set s to -1 which is later multiplied by v to make v negative
void NegateAction(InterimResult *ir, char c){
	ir->s = -1;
}

	// Bad Name
	// Resets results because invalid input happened
void NoAction(InterimResult *ir, char c){
	ir->v = 0.0;
	ir->s = 0;
	ir->p = 0.0;
}

	// Multiplies v and s to get the final result
void StringEndAction(InterimResult *ir, char c){
	ir->v *= ir->s;
}

	// Sets p to .1
void StartFractionAction(InterimResult *ir, char c){
	ir->p = (.1);
}

	// Multiply current v by 10 to move it to the next place and then add on the new number
void ContinuingIntegerAction(InterimResult *ir, char c){
	ir->v = (ir->v*10) + (c-'0');
}

	// Adds the old v value to the integer and multiplies it by p to move it back however many places
	// Divide p by 10 to move it back another place next time a number is entered
void ContinuingFactionAction(InterimResult *ir, char c){
	ir->v += ir->p * (c-'0');
	ir->p = (ir->p/10);
}
