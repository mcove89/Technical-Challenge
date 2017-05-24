import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test methods for the Location Numeral Converter utility
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
public class LocationNumeralConverterTest
{
    /**
     * Test converting basic integer to location numeral
     */
    @Test
    public void testConvertIntegerBasic()
    {
        assertEquals("ad", LocationNumeralConverter.convertInteger(9));
    }
    
    /**
     * Test converting complex location numeral
     */
    @Test
    public void testConvertIntegerComplex()
    {
        assertEquals("abceg", LocationNumeralConverter.convertInteger(87));
    }
    
    /**
     * Test converting minimum location numeral
     * Minimum integer value is 1
     */
    @Test
    public void testConvertIntegerMin()
    {
        assertEquals("a", LocationNumeralConverter.convertInteger(1));
    }

    /**
     * Test converting maximum location numeral
     * Max integer value is 2^26-1
     */
    @Test
    public void testConvertIntegerMax()
    {
        assertEquals("abcdefghijklmnopqrstuvwxyz", LocationNumeralConverter.convertInteger(67108863));
    }
    
    /**
     * Test converting simple location numeral to integer
     */
    @Test
    public void testConvertLocationNumeralBasic()
    {
        assertEquals(9, LocationNumeralConverter.convertLocationNumeral("ad"));
    }
    
    /**
     * Test converting complex location numeral to integer
     */
    @Test
    public void testConvertLocationNumeralComplex()
    {
        assertEquals(87, LocationNumeralConverter.convertLocationNumeral("abceg"));
    }
    
    /**
     * Test converting minimum location numeral to integer
     */
    @Test
    public void testConvertLocationNumeralMin()
    {
        assertEquals(1, LocationNumeralConverter.convertLocationNumeral("a"));
    }
    
    /**
     * Test converting large location numeral to integer
     * Note: This method handles both abbreviated and extended form numerals, so limit does not apply
     */
    @Test
    public void testConvertLocationNumeralLarge()
    {
        assertEquals(67108864, LocationNumeralConverter.convertLocationNumeral("zz"));
    }
    
    /**
     * Test converting location numeral beyond limit of 2^26
     */
    @Test
    public void testConvertLocationNumeralBeyondLimit()
    {
        assertEquals(67108865, LocationNumeralConverter.convertLocationNumeral("azz"));
    }
    
    /**
     * Test abbreviating basic extended form location numeral
     */
    @Test
    public void testAbbreviateNumeralBasic()
    {
        assertEquals("ad", LocationNumeralConverter.abbreviateNumeral("abbc"));
    }
    
    /**
     * Test abbreviating extended form location numeral containing multiple repeated values
     */
    @Test
    public void testAbbreviateNumeral2()
    {
        assertEquals("ade", LocationNumeralConverter.abbreviateNumeral("abbcdd"));
    }
}
