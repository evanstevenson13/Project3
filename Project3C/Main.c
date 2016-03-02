/*
 * Main.c
 *
 *  Created on: Feb 29, 2016
 *      Author: Evan
 	gcc Main.c -o Main && ./Main
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "Common.h"
#include "Verifiers.h"
#include "Actions.h"


#define TOTALEDGES 13
Edge edges[TOTALEDGES];


	// Find an edge based on the current state and character provided
Edge SearchForEdge(State currentState, char currentCharacter){
	int edgeCounter;
	Edge currentEdge;
	for(edgeCounter = 0;edgeCounter < TOTALEDGES;edgeCounter++){
		currentEdge = edges[edgeCounter];
		if(currentEdge.currentState == currentState){
			if(currentEdge.verifier(currentCharacter)){
				return currentEdge;
			}
		}
	}
}


	// Loop through the string and figure out which edge to go to based of the character
float Parse(char inputString[]){
	InterimResult *ir = InterimResultNew(0.0, 1, 0.0);
	State currentState = Start;
	int numberLength = strnlen(inputString,100);

	int stringCounter = 0;
	while(currentState != End){
		char currentCharacter = inputString[stringCounter];
		Edge currentEdge = SearchForEdge(currentState, currentCharacter);

		currentEdge.action(ir, currentCharacter);
		currentState = currentEdge.nextState;

		stringCounter++;
	}

	return ir->v;
}


	// Set up all the edges, covers all input cases
void SetEdges(){
		//Edge to go from Start to Integer, digit was entered
	edges[0].currentState = Start;
	edges[0].verifier = &DigitInputVerifier;
	edges[0].action = &ValueIsDigitAction;
	edges[0].nextState = Integer;
	edges[0].edgeId = 0;

		//Edge to go from Start to Minus, - was entered
	edges[1].currentState = Start;
	edges[1].verifier = &MinusInputVerifier;
	edges[1].action = &NegateAction;
	edges[1].nextState = Integer;
	edges[1].edgeId = 1;

		//Edge to go from Start to Plus, + was entered
	edges[2].currentState = Start;
	edges[2].verifier = &MinusInputVerifier;
	edges[2].action = &NoAction;
	edges[2].nextState = Integer;
	edges[2].edgeId = 2;

		//Edge to go from Start to Decimal, . was entered
	edges[3].currentState = Start;
	edges[3].verifier = &PeriodInputVerifier;
	edges[3].action = &StartFractionAction;
	edges[3].nextState = Decimal;
	edges[3].edgeId = 3;

		//Edge to go from Integer to Integer, # was entered, now # was entered
	edges[4].currentState = Integer;
	edges[4].verifier = &DigitInputVerifier;
	edges[4].action = &ContinuingIntegerAction;
	edges[4].nextState = Integer;
	edges[4].edgeId = 4;

		//Edge to go from integer to decimal, # was entered, now . was entered
	edges[5].currentState = Integer;
	edges[5].verifier = &PeriodInputVerifier;
	edges[5].action = &StartFractionAction;
	edges[5].nextState = Decimal;
	edges[5].edgeId = 5;

		//Edge to go from Decimal to Decimal, . was entered, now # was entered
	edges[6].currentState = Decimal;
	edges[6].verifier = &DigitInputVerifier;
	edges[6].action = &ContinuingFactionAction;
	edges[6].nextState = Decimal;
	edges[6].edgeId = 6;

		//Edge to go from Start to End, invalid character was entered
	edges[7].currentState = Start;
	edges[7].verifier = &InvalidInputVerifier;
	edges[7].action = &NoAction;
	edges[7].nextState = End;
	edges[7].edgeId = 7;

		//Edge to go from Start to End, invalid character was entered
	edges[8].currentState = Integer;
	edges[8].verifier = &InvalidInputVerifier;
	edges[8].action = &NoAction;
	edges[8].nextState = End;
	edges[8].edgeId = 8;

		//Edge to go from Start to End, invalid character was entered
	edges[9].currentState = Decimal;
	edges[9].verifier = &InvalidInputVerifier;
	edges[9].action = &NoAction;
	edges[9].nextState = End;
	edges[9].edgeId = 9;

	//Edge to go from Start to End, end of string happened
	edges[10].currentState = Start;
	edges[10].verifier = &StringEndInputVerifier;
	edges[10].action = &StringEndAction;
	edges[10].nextState = End;
	edges[10].edgeId = 10;

		//Edge to go from Integer to End, end of string happened
	edges[11].currentState = Integer;
	edges[11].verifier = &StringEndInputVerifier;
	edges[11].action = &StringEndAction;
	edges[11].nextState = End;
	edges[11].edgeId = 11;

		//Edge to go from Decimal to End, end of string happened
	edges[12].currentState = Decimal;
	edges[12].verifier = &StringEndInputVerifier;
	edges[12].action = &StringEndAction;
	edges[12].nextState = End;
	edges[12].edgeId = 12;
}


void main(){
	printf("\n\n\n\n");

	SetEdges();

	char input[] = "-12.0231";

	printf("Final Result: %g", Parse(input));

	printf("\n\n\n\n");
}

