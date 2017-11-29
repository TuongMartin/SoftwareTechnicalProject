package library;

public class CheckStringIsNumber {
	
	
	public boolean isNumberString(String str){
		
		boolean result = true;
		str = str.trim();
		
		for(int i = 0; i < str.length() ; i++)
		{
			if((int)str.charAt(i) < 48 || (int)str.charAt(i) > 57)
			{
				result = false;
				break;
			}
		}
		
		return result;
	}
}
