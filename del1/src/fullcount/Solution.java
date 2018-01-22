package countingsort;

import java.util.*;

/**
 * Class that performs counting sort of a list which is defined by tuples of integers and strings.
 * The sorting is based on the integer values and the output result is based on replacing 
 * upper half of origin strings with dashes and printout by the sorting order. 
 * 
 * @author Joakim
 *
 */
public class Solution {
	
	
	/**
	 * Sorts the input string list according to specification:
	 * 
	 * - integer list which determines the sort order (incrementing)
	 * - first half of origin string list will be removed and replaced with dashes '-'
	 * - print the list in the sorted order with the dash replaced string at their new locations
	 * 
	 * For instance:
	 * 
	 * Input: 
	 * 4
	 * 0 a
	 * 3 b
	 * 2 c
	 * 1 d
	 * 
	 * strings 'a' and 'b' will be replaced with dashes '-' 
	 * the sorted order according to interger will now be (with dashes):
	 * 
	 * 0 -
	 * 1 d
	 * 2 c
	 * 3 -
	 * 
	 * 
	 * @param xList
	 * @param sList
	 * @param cMax
	 */
	static void sort(int[] xList, String[] sList, int cMax){
		int n = xList.length;
		int half = n/2;
		String[] sortedSList = new String[n];
		int[] sortedList = new int[n];
		
		/* helper array */
		int[] countList = new int[cMax];
		
		/* set list initialization values and set first half of input string list as dashed values */
		for(int i = 0; i < n; i++){
			sortedList[i] = 0;
			sortedSList[i] = "";
			if(i < half){
				sList[i] = "-";
			}
		}
		
		/* initialize helper array with 0-value */
		for(int i = 0; i < cMax; i++){
			countList[i] = 0;
		}
		
		/* for every corresponding location in helper array by input integer list, increment this value */
		for(int i = 0; i < n; i++){
			countList[xList[i]]++;
		}
		
		/* go through helper array and replace current value with sum of the current value and the previous one */
		for(int i = 1; i <= cMax-1; i++){
			countList[i] += countList[i-1];
		}
		
		/* 
		 * take values from helper array by the input integer list values 
		 * and set the sorted list values in the sorted list, location specified by helper array values,
		 * with the origin list values.
		 * After the sorted list has gotten new value, decrement the current location in the helper array by 1.
		 */
		for(int i = 0; i < n; i++){
			int countData = countList[xList[i]]; 
			sortedList[countData-1] = xList[i];
			countList[xList[i]]--;
		}
		
		int currentX, previousX = -1, k = 0;
		
		/*
		 * Go through the sorted integer list and now build the sorted string list.
		 * This is easily done by getting the location of origin string list which is defined by
		 * the integer value which now is checked.
		 * 
		 */
		for(int i = 0; i < n; i++){
			currentX = sortedList[i];
			if(currentX != previousX){
				for(int j = 0; j < n; j++){
					if(xList[j] == currentX){
						sortedSList[k++] = sList[j];
					}
				}
			}
			previousX = sortedList[i];
		}
		
		/* store the sorted string list in the input string list, accessible for the caller */
		for(int i = 0; i < n; i++){
			sList[i] = sortedSList[i];
		}
		
	}
	
	/**
	 * Prints out the input list of strings
	 * 
	 * @param list
	 */
	private static void printList(String[] list){
		for(String s: list){
			System.out.print(s+" ");
		}
	}
	
	/**
	 * Scans the input values which are:
	 * number n to indicate total lines to follow
	 * scan n lines as tuples of an integer value and a string value
	 * 
	 * input each value in separate lists for integers and strings
	 * 
	 * call sort method with these lists as input and then print out the sorted string array
	 * 
	 * 
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cMax = 100;
        
        int[] xList = new int[n];
        String[] sList = new String[n];
        
        
        for(int i = 0; i < n; i++){
            int x = in.nextInt();
            String s = in.next();
            xList[i] = x;
            sList[i] = s;
        }
        in.close();
        sort(xList, sList, cMax);
        
		printList(sList);
        
    }
}
