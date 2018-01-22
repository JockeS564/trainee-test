package staircase;

import java.util.*;
/**
 * Class that defines a solution for staircase problem.
 * Two ways of determining a number is provided: Recursively and Iteratively. 
 * The latter is used for performance gain but can easily be changed to try the recursive function as well.
 * 
 * @author Joakim
 *
 */
public class Solution {

	/**
	 * Method that will call the main climb function with initiated parameters.
	 * 
	 * 
	 * @param n total stairs to climb
	 */
	static void staircase(int n){
		//System.out.println(climbRecursive(n));
		System.out.println(climbIterative(n));
	}
	
	
	/**
	 * <<<<<<<<<<<<<OBS! LÅNGSAMMARE ÄN ITERATIVA LÖSNINGEN>>>>>>>>>>>>>>>>
	 * 
	 * 
	 * Recursive function to solve the problem
	 * 
	 * Based on fibonacci principle f(n) = f(n-1) + f(n-2)
	 * 
	 * 
	 * 
	 * Method that performs the climbing of stairs by recursive calls.
	 * Base cases are:
	 *  <= 0	steps to go --> 0 possible ways
	 *  1 		steps to go --> 1 possible ways
	 *  2		steps to go --> 2 possible ways
	 *  3		steps to go --> 4 possible ways
	 *  
	 *  
	 *  
	 *  
	 *  and for more steps to go, calling the function recursivly like:
	 *  
	 *  climb(n) =  climb(n-1) + climb(n-2) + climb(n-3)
	 * 
	 *  
	 * 
	 * @param stepsLeft
	 * @return
	 */
	private static int climbRecursive(int stepsLeft){
		if(stepsLeft == 3){
			return 4;
		}else if(stepsLeft == 2){
			return 2;
		}else if(stepsLeft == 1){
			return 1;
		}else if(stepsLeft <= 0){
			return 0;
		}else{
			return climbRecursive(stepsLeft-1) + 
					climbRecursive(stepsLeft-2) +
					climbRecursive(stepsLeft-3);
		}
	}
	
	/**
	 * Iterative function to solve the problem
	 * 
	 * 
	 * Method that creates an array and fills it iteratively similarly like fibonaccis principle f(n) = f(n-1) + f(n-2)
	 * but here uses:
	 * 
	 * list[i] = list[i-1] + list[i-2] + list[i-3] 
	 * 
	 * because this determines the number of ways to climb from 3 step sizes (1,2,3). 
	 * 
	 * Base cases are:
	 * 
	 * 0 steps to do --> 0 possible ways
	 * 1 steps to do --> 1 possible ways
	 * 2 steps to do --> 2 possible ways
	 * 3 steps to do --> 4 possible ways
	 * 
	 * The list, which is 0-indexed, will be filled according to fibonnaci principle for instance:
	 * 
	 * list[3] = list[2] + list[1] + list[0] = 4 + 2 + 1 = 7 
	 * 
	 * the 4th place in the list tells us how many possible ways there is to climb 4 stairs = 7
	 * 
	 * This means that the last element in the list after being looped through, tells us the correct value for 
	 * how many possible ways there are to climb the input steps, which is then returned to the caller. 
	 * 
	 * @param stairs, input steps of staircase
	 * @return total possible ways of climbing stairs, placed last in list.
	 */
	
	private static int climbIterative(int stepsLeft){
		int[] list = new int[stepsLeft];

		if(stepsLeft == 0){
			return 0;
		}else if(stepsLeft == 1){
			return 1;
		}else if(stepsLeft == 2){
			return 2;
		}else if(stepsLeft == 3){
			return 4;
		}
		list[0] = 1;
		list[1] = 2;
		list[2] = 4;
		for(int i = 3; i < stepsLeft; i++){
			list[i] = list[i-1] + list[i-2] + list[i-3];
		}
		return list[list.length-1];
	}
	
	/**
	 * Scans the input and stores every test value in the list.
	 * This list is then iterated and for every value, the possible ways of climbing stairs is calculated.
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            list.add(n);
        }
        while(!list.isEmpty()){
        	staircase(list.remove(0));
        }
    }
}


