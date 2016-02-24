package Code;

import Actions.NegateAction;
import Actions.ValueIsDigitAction;
import Verifiers.DigitInputVerifier;
import Verifiers.InputVerifier;
import Verifiers.MinusInputVerifier;


/**
 * A finite state machine that parses a string containing a real number. Will
 * throw NumberFormatExcaption if the string doesn't not contain a legal
 * representation of a real number. Note: we are not dealing with scientific
 * notation
 * 
 * @author Merlin
 *
 */

public class ConvertingMachine
{

	private final Edge[] machine =
	{
			new Edge(State.START, new DigitInputVerifier(),
					new ValueIsDigitAction(), State.INTEGER),
			new Edge(State.START, new MinusInputVerifier(), new NegateAction(),
					State.INTEGER),
//			new Edge(State.START, new PlusInputVerifier(), new NoAction(),
//					State.INTEGER),
//			new Edge(State.START, new PeriodInputVerifier(),
//					new StartFraction(), State.DECIMAL),
//			new Edge(State.INTEGER, new DigitInputVerifier(),
//					new ContinuingIntegerAction(), State.INTEGER),
//			new Edge(State.INTEGER, new PeriodInputVerifier(),
//					new StartFraction(), State.DECIMAL),
//			new Edge(State.DECIMAL, new DigitInputVerifier(),
//					new ContinuingFactionAction(), State.DECIMAL)

	};

	public double parse(String text)
	{
		double v=0;
		int signIndicator = 1;
		double precision=0.1;
		Edge currentEdge=new Edge(State.START, null, null, null);
		
		for(int StringPosition=0; StringPosition<text.length(); StringPosition++){
			char currentCharacter = text.charAt(StringPosition);
			currentEdge=searchForEdge(currentEdge.currentState,currentCharacter);

		}
		return -1.123;
	}

	protected Edge searchForEdge(State currentState, char currentCharacter)
	{
		for(Edge edgeToCheck : machine){
			if(currentState==edgeToCheck.getCurrentState()){
				if(edgeToCheck.inputVerifier.meetsCriteria(currentCharacter)){
					return edgeToCheck;
				}
			}
		}
		return new Edge(null,null,null,null);
//		return currentEdge;
	}

	protected class Edge
	{
		State currentState;
		InputVerifier inputVerifier;
		Action action;
		State nextState;

		public Edge(State currentState, InputVerifier inputVerifier,
				Action action, State nextState)
		{
			this.currentState = currentState;
			this.inputVerifier = inputVerifier;
			this.action = action;
			this.nextState = nextState;
		}
		
		protected State getCurrentState(){
			return currentState;
		}
		
//		protected boolean IsVerified(char checkCharacter){
//			return inputVerifier.meetsCriteria(checkCharacter);
//		}
	}

	protected enum State
	{
		START, INTEGER, DECIMAL, END
	}
}
