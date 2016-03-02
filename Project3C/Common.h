

typedef enum{
	False=0,
	True=1
}bool;


typedef struct InterimResult{
	float p;
	int s;
	double v;
}InterimResult;


InterimResult* InterimResultNew(float p, int s, double v){
	InterimResult* ir = malloc(sizeof(InterimResult));
	ir->p = p;
	ir->s = s;
	ir->v = v;
}