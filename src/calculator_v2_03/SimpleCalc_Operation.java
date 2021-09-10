package calculator_v2_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextField;

public class SimpleCalc_Operation {
	
	public static void compute (JTextField field) {
		Double result = 0.0;
		String operation = field.getText();
		System.out.println(operation);
		String numberString = operation.replaceAll("[^.?0-9]+", " ");
		System.out.println(Arrays.asList(numberString.trim().split(" ")));
		String[] numbers = numberString.trim().split(" ");

		for (int i=0; i < numbers.length; i++) {
	      System.out.println(numbers[i]);
	    }
		
		String operatorString = operation.replaceAll("[0-9]", " ").replaceAll("[.]", " ").replaceAll("\\s", "");
		char[] operators = operatorString.toCharArray();
		for (int i=0; i < operators.length; i++) {
	      System.out.println(operators[i]);
	    }
		
		List<String> numbersList = new ArrayList<>(Arrays.asList(numbers));

	    List<Character> operatorsList = new ArrayList<Character>();
	    for (char c : operators) {
	    	operatorsList.add(c);
	    }
	
		while (operatorsList.contains('\u00B2') || operatorsList.contains('\u221A')) {
		    int x = operatorsList.indexOf('\u00B2');
		    int d = operatorsList.indexOf('\u221A');
		    if ((x<d && x>=0) || d<0) {
		    	result = Math.pow((Double.parseDouble(numbersList.get(x))),2);
		    	operatorsList.remove(x);
		    	numbersList.remove(x);
		    	numbersList.add(x, result.toString());
		    	System.out.println(operatorsList);
		    	System.out.println(numbersList);
		    	System.out.println(result);
		    	
		    } else if ((d<x && d>=0) || x<0) {
		    	if (numbersList.size() > operatorsList.size()) {
			    	result = Double.parseDouble(numbersList.get(d)) * Math.sqrt(Double.parseDouble(numbersList.get(d+1)));
			    	operatorsList.remove(d);
			    	numbersList.remove(d);
			    	numbersList.remove(d);
			    	numbersList.add(d, result.toString());
			    	System.out.println(operatorsList);
			    	System.out.println(numbersList);
			    	System.out.println(result);
		    	} else {
			    	result = Math.sqrt(Double.parseDouble(numbersList.get(d)));
			    	operatorsList.remove(d);
			    	numbersList.remove(d);
			    	numbersList.add(d, result.toString());
			    	System.out.println(operatorsList);
			    	System.out.println(numbersList);
			    	System.out.println(result);
		    	}
		    } else {
		    	System.out.println("Both x and d are negative"); 
		    	return;
		    }
		}
		
		
		while (operatorsList.contains('\u00D7') || operatorsList.contains('\u00F7')) {
		    int x = operatorsList.indexOf('\u00D7');
		    int d = operatorsList.indexOf('\u00F7');
		    if ((x<d && x>=0) || d<0) {
		    	result = Double.parseDouble(numbersList.get(x)) * Double.parseDouble(numbersList.get(x+1));
		    	operatorsList.remove(x);
		    	numbersList.remove(x);
		    	numbersList.remove(x);
		    	numbersList.add(x, result.toString());
		    	System.out.println(operatorsList);
		    	System.out.println(numbersList);
		    	System.out.println(result);
		    	
		    } else if ((d<x && d>=0) || x<0) {
		    	result = Double.parseDouble(numbersList.get(d)) / Double.parseDouble(numbersList.get(d+1));
		    	operatorsList.remove(d);
		    	numbersList.remove(d);
		    	numbersList.remove(d);
		    	numbersList.add(d, result.toString());
		    	System.out.println(operatorsList);
		    	System.out.println(numbersList);
		    	System.out.println(result);
		    } else {
		    	System.out.println("Both x and d are negative"); 
		    	return;
		    }
		}
		
		while (operatorsList.contains('+') || operatorsList.contains('-')) {
		    int x = operatorsList.indexOf('+');
		    int d = operatorsList.indexOf('-');
		    if ((x<d && x>=0) || d<0) {
		    	result = Double.parseDouble(numbersList.get(x)) + Double.parseDouble(numbersList.get(x+1));
		    	operatorsList.remove(x);
		    	numbersList.remove(x);
		    	numbersList.remove(x);
		    	numbersList.add(x, result.toString());
		    	System.out.println(operatorsList);
		    	System.out.println(numbersList);
		    	System.out.println(result);
		    	
		    } else if ((d<x && d>=0) || x<0) {
		    	result = Double.parseDouble(numbersList.get(d)) - Double.parseDouble(numbersList.get(d+1));
		    	operatorsList.remove(d);
		    	numbersList.remove(d);
		    	numbersList.remove(d);
		    	numbersList.add(d, result.toString());
		    	System.out.println(operatorsList);
		    	System.out.println(numbersList);
		    	System.out.println(result);
		    } else {
		    	System.out.println("Both x and d are negative"); 
		    	return;
		    }
		}
		
		field.setText(result.toString());
	}

}
