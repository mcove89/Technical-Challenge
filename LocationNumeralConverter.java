import java.util.Arrays;
/**
 * Contains methods for converting integers to location numerals, and location numerals to integers
 *
 * <pre>
 *
 * Date May 23, 2017
 * Revision Log
 * Who       When        Reason
 * --------- ---------- ----------------------------------
 * 
 * </pre>
 *
 * @author Maverick Cove
 * @version 1.0
 *
 */
public class LocationNumeralConverter
{
    /**
     * Converts an integer to its corresponding location numeral value
     * @param input - Integer value to be calculated
     * @return String location numeral
     */
    public static String convertInteger(int input)
    {
        char letter;
        String locationNum = "";
        
        //convert input to binary string
        String binaryString = Integer.toBinaryString(input);
        
        //reverse string to use array indexing, convert to char array
        char[] binary = (new StringBuilder(Integer.toBinaryString(input)).reverse().toString()).toCharArray();
        
        for(int i = 0; i<binary.length; i++)
        {
            //if there is a 1 at the array index position, get the corresponding letter using ASCII, add to string
            if(binary[i] == '1')
            {
                letter = (char)(i + 97);
                locationNum += letter;
            }
        }
        
        return locationNum;
    }
    
    /**
     * Converts a location number to its corresponding integer value
     * @param input - String location number to be converted
     * @return Integer value of location numeral
     */
    public static int convertLocationNumeral(String input)
    {
        int value = 0
            , temp = 0;
        
        //convert string to char array
        char[] location = input.toCharArray();
        for(char c: location)
        {
            //convert char to ASCII value, find alphabetical index position
            temp = (int)(c - 97);
            
            //use base 2 math to get integer value, add to total
            value += (int)Math.pow(2, temp);
        }
        
        return value;
    }
    
    /**
     * Converts a location numeral containing duplicate letters to abbreviated form
     * @param input - String location numeral to be abbreviated
     * @return String abbreviated numeral
     */
    public static String abbreviateNumeral(String input)
    {
        int[] letterCount = new int[26];
        int temp = 0;
        char letter;
        String locationNum = "";
        
        //create char array of input, sort the array alphabetically
        char[] location = input.toCharArray();
        Arrays.sort(location);
        
        for(char c: location)
        {
            //get ASCII value of char, get alphabetical index position
        	temp = (int)(c - 97);
        	
        	//add 1 to letter count for the current letter
        	letterCount[temp] += 1;
        	
        	//if the current letter count is 2, add 1 to next letter count and set current letter count to 0
        	//EX: 2 a's == 1 b
        	if(letterCount[temp] == 2)
        	{
        		letterCount[temp + 1] += 1;
        		letterCount[temp] = 0;
        	}
        }
        
        for(int i = 0; i<letterCount.length; i++)
        {
            //if value still remains in count for letter, get ASCII char value and add to location numeral value
        	if(letterCount[i] == 1)
        	{
        		letter = (char)(i + 97);
        		locationNum += letter;
        	}
        }
        
        return locationNum;
    }
}
