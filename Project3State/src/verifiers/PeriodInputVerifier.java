package verifiers;

public class PeriodInputVerifier implements InputVerifier {

	
	public boolean meetsCriteria(char c){
		if(c==46){
			return true;
		}
		return false;
	}

}
