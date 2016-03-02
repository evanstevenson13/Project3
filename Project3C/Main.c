/*
 * Main.c
 *
 *  Created on: Feb 29, 2016
 *      Author: Evan
 	gcc Verifiers.c Actions.c Main.c -o Main && ./Main
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "Common.h"
#include "Verifiers.h"
#include "Actions.h"


#define TOTALEDGES 7
 

typedef enum State{
 	Start,
 	Integer,
 	Decimal,
 	End
 }State;


typedef struct Edge{
	enum State startState;
	bool (*verifier)(char c);
	InterimResult (*action)(InterimResult *ir, char c);
	enum State nextState;
}Edge;


Edge SearchForEdge(State currentState, char currentCharacter){

}


float Parse(char inputString[]){

	InterimResult *ir = InterimResultNew(0.0, 1, 0.0);
	State currentState = Start;
	int numberLength = strnlen(inputString,100);

	for(int stringCounter=0;stringCounter < numberLength;stringCounter++){
		char currentCharacter = inputString[stringCounter];
		Edge currentEdge = SearchForEdge(currentState, currentCharacter);
		
		ir = currentEdge.action(ir, currentCharacter);
		currentState = currentEdge.nextState;

		printf("%c\n", inputString[stringCounter]);
	}

	return 1.000;
}


void SetEdges(){
	Edge edges[TOTALEDGES];

		//Edge to go from start to integer, digit was entered
	edges[0].startState = Start;
	edges[0].verifier = &DigitInputVerifier;
	edges[0].action = &ValueIsDigitAction;
	edges[0].nextState = Integer;

		//Edge to go from start to minus, - was entered
	edges[1].startState = Start;
	edges[1].verifier = &MinusInputVerifier;
	edges[1].action = &NegateAction;
	edges[1].nextState = Integer;

		//Edge to go from start to plus, + was entered
	edges[2].startState = Start;
	edges[2].verifier = &MinusInputVerifier;
	edges[2].action = &NoAction;
	edges[2].nextState = Integer;

		//Edge to go from start to decimal, . was entered
	edges[3].startState = Start;
	edges[3].verifier = &PeriodInputVerifier;
	edges[3].action = &StartFractionAction;
	edges[3].nextState = Decimal;

		//Edge to go from integer to integer, # was entered, now # was entered
	edges[4].startState = Integer;
	edges[4].verifier = &DigitInputVerifier;
	edges[4].action = &ContinuingIntegerAction;
	edges[4].nextState = Integer;

		//Edge to go from integer to decimal, # was entered, now . was entered
	edges[5].startState = Integer;
	edges[5].verifier = &PeriodInputVerifier;
	edges[5].action = &StartFractionAction;
	edges[5].nextState = Decimal;

		//Edge to go from decimal to decimal, . was entered, now # was entered
	edges[6].startState = Decimal;
	edges[6].verifier = &DigitInputVerifier;
	edges[6].action = &ContinuingFactionAction;
	edges[6].nextState = Decimal;

	// for(int x=0;x<TOTALEDGES;x++){
	// 	printf("Edge %d\n", x);
	// 	printf("\t%d\n", edges[x].startState);
	// 	printf("\t%d\n", edges[x].nextState);
	// }
}

void main(){
	printf("\n\n\n\n");

	SetEdges();
	
	printf("Final Result: %f", Parse("5123"));

	printf("\n\n\n\n");
}

