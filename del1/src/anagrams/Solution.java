package anagram;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Class that performs anagram determination and calculates total deleted characters required from two input strings
 * to make them anagrams. 
 * 
 * @author Jocke
 *
 */
public class Solution {

	/**
	 * Method that returns total deleted characters of two strings, that requires to make an anagram.
	 * Sort each string first, then call function trim on both sorted strings, which will
	 * remove characters in one of the strings and returning the result. Then call trim again
	 * with the other sorted string and the trimmed result of first call, which will remove
	 * characters from the other sorted strings, resulting in a total value of removed charachters.
	 * 
	 * @param s1 string 1 to check
	 * @param s2 string 2 to check
	 * @return total deleted characters to make input strings anagrams
	 */
    static int makingAnagrams(String s1, String s2){
    	String sortedS1 = sortString(s1);
    	String sortedS2 = sortString(s2);
    	Object[] obj = trimString(sortedS1, sortedS2);
    	Object[] obj2 = trimString(sortedS2, (String)obj[0]);
    	return (int)obj[1] + (int)obj2[1];
    }
    
    /**
     * Sorts a string according to the character values in incrementing order
     * 
     * @param s input string to sort 
     * @return new sorted string
     */
    private static String sortString(String s){
    	char[] array = s.toCharArray();
    	Arrays.sort(array);
    	return new String(array);
    }
    
    /**
     * Trims an input string by each character, according to reference string.
     * For every occurrence in reference string, remove it from reference string. 
     * This way, duplicates of characters in input is handled correctly. 
     * 
     * @param input string to trim
     * @param reference string to check characters to remain
     * @return object array that holds the new trimmed string and a value of deleted characters from the input string
     */
    private static Object[] trimString(String input, String reference){
    	String newString = "";
    	char[] c1 = input.toCharArray();
    	int rIndex = -1;
    	int totalDeleted = 0;
    	for(int i = 0; i < c1.length; i++){
    		rIndex = reference.indexOf(Character.toString(c1[i]));
    		if(rIndex != -1){
    			reference = removeIndex(reference, rIndex);
    			newString += Character.toString(c1[i]);
    		}else{
    			totalDeleted++;
    		}
    	}
   
    	return new Object[]{newString, totalDeleted};
    }
    
    /**
     * Remove a character from the input string at the specified index
     * 
     * @param s input string to that character will be removed from
     * @param index at the string to be removed
     * @return new string with character removed at specified index
     */
    private static String removeIndex(String s, int index){
    	return s.substring(0, index) + s.substring(index+1);
    }
    
    /**
     * Test anagram with txt file data
     * Customize test input files accordingly
     */
    private static void testData(){
    	String s1 = null, s2 = null;
    	try {
    		final StringBuilder sb = new StringBuilder(), sb2 = new StringBuilder();
    		
    		Path path = Paths.get("C:/Users/Joakim/Documents/OneAgency/s1.txt");
    		Files.lines(path).forEach(s -> sb.append(s));
    		s1 = sb.toString();
    		path = Paths.get("C:/Users/Joakim/Documents/OneAgency/s2.txt");
    		Files.lines(path).forEach(s -> sb2.append(s));
    		s2 = sb2.toString();
    	
            int result = makingAnagrams(s1, s2);
            System.out.println(result);
            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    /**
     * Scans the two input strings as seperate lines
     * 
     * @param args
     */
    public static void main(String[] args) {

    	//testData();
    	
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}
