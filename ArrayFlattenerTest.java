
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Test methods for ArrayFlattener utility
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
public class ArrayFlattenerTest
{
    Integer[] flat = new Integer[]{1, 2, 3, 4};
    List<Integer> testList = new ArrayList<>();
    
    /**
     * Test if null is returned when array object to be flattened is null
     */
    @Test
    public void testNullArray()
    {
        assertNull(ArrayFlattener.flattenArray(null));
    }
    
    /**
     * Test if input and result are the same when flat array used as input
     */
    @Test
    public void testFlatArray()
    {
        Object[] array = new Object[]{1, 2, 3, 4};
        testList = ArrayFlattener.flattenArray(array);
        assertArrayEquals(testList.toArray(new Integer[testList.size()]), flat);
    }
    
    /**
     * Test if two dimensional input array is converted to flat array
     */
    @Test
    public void testSingleNestArray()
    {
        Object[] array = new Object[]{1, 2, new Object[]{3}, 4};
        testList = ArrayFlattener.flattenArray(array);
        assertArrayEquals(testList.toArray(new Integer[testList.size()]), flat);
    }
    
    /**
     * Test if multidimensional input array is converted to flat array
     */
    @Test
    public void testMultiNestArray()
    {
        Object[] array = new Object[]{new Object[]{1, 2, new Object[]{3}}, 4};
        testList = ArrayFlattener.flattenArray(array);
        assertArrayEquals(testList.toArray(new Integer[testList.size()]), flat);
    }
}
