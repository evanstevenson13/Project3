

	// Defines a boolean type the can be used by the verifiers
	// Do this so its not just returning 0 and 1 which can be confusing when reading code
typedef enum{
	False=0,
	True=1
}bool;


	// Define the different states that a edge can be in
typedef enum State{
 	Start,
 	Integer,
 	Decimal,
 	End
 }State;


	// Defines a InterimResult structure, used to pass around the current number
typedef struct InterimResult{
	float p;
	int s;
	double v;
}InterimResult;


	// Constructor for a IterimResult so you can easily pass the values through the function
	// instead of individually setting them after create a IterimResult structure
InterimResult* InterimResultNew(float p, int s, double v){
	InterimResult *ir = malloc(sizeof(InterimResult));
	ir->p = p;
	ir->s = s;
	ir->v = v;
	return ir;
}


	// Defines a Edge structure. Has everything that a Edge needs. A current and next state as well as
	// a function pointer to a verifier and action
typedef struct Edge{
	enum State currentState;
	bool (*verifier)(char c);
	void (*action)(InterimResult *ir, char c);
	enum State nextState;
}Edge;
