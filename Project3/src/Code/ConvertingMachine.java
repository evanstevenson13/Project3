package Code;

import Actions.ContinuingFactionAction;
import Actions.ContinuingIntegerAction;
import Actions.NegateAction;
import Actions.NoAction;
import Actions.StartFraction;
import Actions.ValueIsDigitAction;
import Verifiers.DigitInputVerifier;
import Verifiers.InputVerifier;
import Verifiers.MinusInputVerifier;
import Verifiers.PeriodInputVerifier;
import Verifiers.PlusInputVerifier;


/**
 * A finite state machine that parses a string containing a real number. Will
 * throw NumberFormatExcaption if the string doesn't not contain a legal
 * representation of a real number. Note: we are not dealing with scientific
 * notation
 * 
 * @author Merlin
 *
 */

public class ConvertingMachine{
	
	/**
	 * All the possible edge
	 * each edge contains a current state, verifier, action, and next state
	 */
	private final Edge[] machine = {
			new Edge(State.START, new DigitInputVerifier(),
					new ValueIsDigitAction(), State.INTEGER),
			new Edge(State.START, new MinusInputVerifier(), new NegateAction(),
					State.INTEGER),
			new Edge(State.START, new PlusInputVerifier(), new NoAction(),
					State.INTEGER),
			new Edge(State.START, new PeriodInputVerifier(),
					new StartFraction(), State.DECIMAL),
			new Edge(State.INTEGER, new DigitInputVerifier(),
					new ContinuingIntegerAction(), State.INTEGER),
			new Edge(State.INTEGER, new PeriodInputVerifier(),
					new StartFraction(), State.DECIMAL),
			new Edge(State.DECIMAL, new DigitInputVerifier(),
					new ContinuingFactionAction(), State.DECIMAL)
	};


	/**
	 * 
	 * @param text string to be converted into a double
	 * @return the double the was extracted from the strings
	 * Will loop through each character and create a final number result based of each character in the string
	 * Invalid characters result in a exception being thrown
	 */
	public double parse(String text){		
		State currentState = State.START;	//the current state starts at State.START
		
		InterimResult ir = new InterimResult(0.0,1,0.0);	//create initial result p = 0, s = 1, v = 0 
		
		for(int StringPosition=0; StringPosition<text.length(); StringPosition++){
			char currentCharacter = text.charAt(StringPosition);		//current character at position of loop
			Edge currentEdge = searchForEdge(currentState,currentCharacter);	//update 
			
			ir=currentEdge.action.execute(ir, currentCharacter);		//the interim result is updated by the action of currentEdge
			currentState = currentEdge.nextState;		//update the currentState to the nextState of the currentEdge
		}
	
		return ir.getV()*ir.getS();		//return the sign times the value for final result
	}

	
	/**
	 * 
	 * @param currentState State it is currently on
	 * @param currentCharacter The character it is currently trying to perform an action to
	 * @return An edge that matches the current state and accepts the current character
	 * 				Throws exception if no state matching edge is found 
	 */
	protected Edge searchForEdge(State currentState, char currentCharacter){
		for(Edge edgeToCheck : machine){
			if(currentState==edgeToCheck.getCurrentState()){
				if(edgeToCheck.inputVerifier.meetsCriteria(currentCharacter)){
					return edgeToCheck;
				}
			}
		}
		
		throw new NumberFormatException();
	}

	
	/**
	 * Container for a edge. Has everything that the edge needs, current state, verifier, action, next state
	 */
	protected class Edge{
		State currentState;	// State that it is currently at
		InputVerifier inputVerifier; // Checks the input to see if it applies to this state
		Action action; // Performs calculation in the input if the state is selected
		State nextState; // Give the next state

		public Edge(State currentState, InputVerifier inputVerifier, Action action, State nextState){
			this.currentState = currentState;
			this.inputVerifier = inputVerifier;
			this.action = action;
			this.nextState = nextState;
		}
		
		protected State getCurrentState(){
			return currentState;
		}
		
	}

	
	/**
	 * Holds all the possible states
	 */
	protected enum State
	{
		START, INTEGER, DECIMAL, END
	}
}
