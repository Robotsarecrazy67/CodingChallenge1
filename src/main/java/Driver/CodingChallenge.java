package Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class CodingChallenge {
	public static final int MIN_CHARACTER = 1;
	public static final int MAX_CHARACTER = 9;
	public static final int MAX_ITERATIONS = 1000;
	
	/*
	Take the number 192 and multiply it by each of 1, 2, and 3:
	192 × 1 = 192
	192 × 2 = 384
	192 × 3 = 576
	By concatenating each product, we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
	The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5,giving the pandigital, 918273645, which is the concatenated product of 9 and(1,2,3,4,5).
	What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n >1?

	 */
	public static void main(String[] args) {
		List<Integer> allNums = new ArrayList<Integer>();
		for(int i = 1; i < MAX_ITERATIONS; i++) {
			List<Character> list = new ArrayList<Character>();			
			for(int j = MIN_CHARACTER; j <= MAX_CHARACTER; j++) {
				int product = i*j;
				list.add(Integer.toString(product).charAt(0));

				if(list.size() == 9) {
					int num = getPandigital(list);
					if(num > 0) {
						allNums.add(num);
					}
				}		
			}
		}
		Collections.sort(allNums); // sort the list of numbers
		
		System.out.println("The answer is " + allNums.get(allNums.size() - 1)); // print the last number in the list
	}

	/*
	 * Helper method to return the next pandigital number from a given list of digits, or zero
	 */
	private static int getPandigital(List<Character> list) {
		list = list.stream()
				.filter(chara -> chara != '0')
				.distinct()
				.collect(Collectors.toList()); // filter out all non-zero characters
		
		if(isPandigital(list)) { // check if the number is a pandigital
			// convert to string
			String panString = list.stream()
					.map(chara -> chara.toString())
					.collect(Collectors.joining());
			return Integer.parseInt(panString); // return value of converted string
		} 
		
		return 0; 
	}
	
	/*
	 * Checks if a given number in a list of digits is a pandigital
	 */
	public static boolean isPandigital(List<Character> list) {
		// A number is considered a pandigital if it contains all digits 1-9 
		// and is only 9 digits
		return (list.contains('1') && 
				list.contains('2') &&
			    list.contains('3') &&
			    list.contains('4') &&
			    list.contains('5') &&
			    list.contains('6') &&
			    list.contains('7') &&
			    list.contains('8') &&
		 	    list.contains('9') &&
			    list.size() == MAX_CHARACTER);
	}
	
}
