

typedef enum{
	False=0,
	True=1
}bool;


typedef enum State{
 	Start,
 	Integer,
 	Decimal,
 	End
 }State;


typedef struct InterimResult{
	float p;
	int s;
	double v;
}InterimResult;


InterimResult* InterimResultNew(float p, int s, double v){
	InterimResult *ir = malloc(sizeof(InterimResult));
	ir->p = p;
	ir->s = s;
	ir->v = v;
	return ir;
}


typedef struct Edge{
	enum State currentState;
	bool (*verifier)(char c);
	void (*action)(InterimResult *ir, char c);
	enum State nextState;
	int edgeId;
}Edge;
