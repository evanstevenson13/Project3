package code;

/**
 * Interface for Actions
 *
 */
public interface Action
{
	//Must all have an execute method 
	public InterimResult execute(InterimResult ir, char c);
}
