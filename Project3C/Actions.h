

void ValueIsDigitAction(InterimResult *ir, char c){
	ir->v = (c-'0');
}


void NegateAction(InterimResult *ir, char c){
	ir->s = -1;
}


void NoAction(InterimResult *ir, char c){
	ir->v = 0.0;
	ir->s = 0;
	ir->p = 0.0;
}


void StringEndAction(InterimResult *ir, char c){
	ir->v *= ir->s;
}


void StartFractionAction(InterimResult *ir, char c){
	ir->p = (.1);
}


void ContinuingIntegerAction(InterimResult *ir, char c){
	ir->v = (ir->v*10) + (c-'0');
}


void ContinuingFactionAction(InterimResult *ir, char c){
	ir->v += ir->p * (c-'0');
	ir->p = (ir->p/10);
}
