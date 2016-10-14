package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals(""))
			return 0;
		
		String[] numbers = splitNumbers(text);
		checkNegatives(numbers);
		
		return sum(numbers);
	} 

	private static void checkNegatives(String[] numbers) {
		String negatives = "";
		for(String s : numbers) {
			if(toInt(s) < 0) {
				if(negatives == "")
					negatives = s;
				else
					negatives += "," + s;
			}
		}
	
		if(negatives != "")
			throw new IllegalArgumentException("Negatives not allowed: " + negatives);		
	}
	
	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){

		if(numbers.startsWith("//")) {
			String delimiter = numbers.charAt(2) + "|,|\n";
			return numbers.substring(4).split(delimiter);
		}
		
		return numbers.split(",|\n");
	}
     
    private static int sum(String[] numbers){
    	int total = 0;
		for(String number : numbers){
			int n = toInt(number);
			if(n<=1000)
				total += n;
		}
		return total;
    }
}