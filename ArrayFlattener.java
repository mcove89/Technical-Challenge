import java.util.ArrayList;
import java.util.List;
/**
 * Flattens an array of arbitrarily nested arrays of integers into a single flat array
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
public class ArrayFlattener
{
    /**
     * Method for flattening a nested array of integers
     * @param input - Array to be flattened
     * @return The flattened array
     */
    public static List<Integer> flattenArray(Object[] input)
    {
        List<Integer> flattenedArray = new ArrayList<>();
        
        if(input == null)
        {
            return null;
        }
        
        //loop through all objects in input array and flatten
        for(Object o: input)
        {
            if(o instanceof Integer)
            {
                //if object is not array, add to list
                flattenedArray.add((Integer)o);
            }
            else
            {
                //if object is an array, recursively call method to dig until integers are found
                flattenedArray.addAll(flattenArray((Object[]) o));
            }
        }

        return flattenedArray;
    }
}
