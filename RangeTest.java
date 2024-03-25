package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
    
    
    /**
     * This method sets up the exampleRange object of the Range class to be tested
     */
    @Before
    public void setUp() throws Exception { exampleRange = new Range(-50.0, 60.0);
    }
    
    
    /**
     * ********************** expandToInclude() test ************************
     * public static Range expandToInclude(Range range, double value)
     * Returns a range that includes all the values in the specified range AND contains the specified value.
     * Parameters:
     * range - the range (null permitted).
     * value - the value that must be included
     * Returns:
     * A range which spans over the input range, and has been expanded to contain the input value.
     */
    
    
    /**
     * expandToIncludeBelowLowerBound.
     * 
     * This will test if expandToInclude() correctly includes a values below the lower bound of the range
     */
    
	@Test
	public void expandToIncludeBelowLowerBound() {
		Range expectedRange = new Range(-50.00001, 60.0);
		Range newRange = Range.expandToInclude(this.exampleRange, -50.00001);
		assertEquals("Expanding range to include a value below the lower bound", expectedRange, newRange);
	}
	
	/**
     * expandToIncludeLowerBound.
     * 
     * This will test if expandToInclude() correctly handles including a value at the lower bound of the range. 
     * There should be no change to the range
     */
	@Test
	public void expandToIncludeLowerBound() {
	    try {
	    	Range newRange = Range.expandToInclude(this.exampleRange, -50.0);
			assertEquals("Expanding range to include a value at the lower bound should not change the range", this.exampleRange, newRange);
	    } catch (Exception e) {
			fail("expandToInclude should return an unchanged range, not throw an exception: " + e.toString());
	    }
	}
	
	/**
     * expandToIncludeAboveLowerBound.
     * 
     * This will test if expandToInclude() correctly includes a values above the lower bound of the range
     */
	@Test
	public void expandToIncludeAboveLowerBound() {
		Range newRange = Range.expandToInclude(this.exampleRange, -49.99999);
		assertEquals("Expanding range to include a value below the lower bound", this.exampleRange, newRange);
	}
	
	/**
     * expandToIncludeNominalValue.
     * 
     * This will test if expandToInclude() correctly includes a nominal value
     */
	@Test
	public void expandToIncludeNominalValue() {
		Range newRange = Range.expandToInclude(this.exampleRange, 20.0);
		assertEquals("Expanding range to include a nominal value", this.exampleRange, newRange);
	}
	
	/**
     * expandToIncludeBelowUpperBound.
     * 
     * This will test if expandToInclude() correctly includes a values below the upper bound of the range
     */
	@Test
	public void expandToIncludeBelowUpperBound() {
		Range newRange = Range.expandToInclude(this.exampleRange, 59.99999);
		assertEquals("Expanding range to include a value below the upper bound", this.exampleRange, newRange);
	}
	
	/**
     * expandToIncludeUpperBound.
     * 
     * This will test if expandToInclude() correctly handles including a value at the upper bound of the range. 
     * There should be no change to the range
     */
	@Test
	public void expandToIncludeUpperBound() {
		Range newRange = Range.expandToInclude(this.exampleRange, 60.0);
		assertEquals("Expanding range to include a value at the upper bound", this.exampleRange, newRange);
	}
	
	/**
     * expandToIncludeAboveUpperBound.
     * 
     * This will test if expandToInclude() correctly includes a values above the upper bound of the range
     */
	@Test
	public void expandToIncludeAboveUpperBound() {
		Range expectedRange = new Range(-50.0, 60.00001);
		Range newRange = Range.expandToInclude(this.exampleRange, 60.00001);
		assertEquals("Expanding range to include a value above upper bound ", expectedRange, newRange);
	}
	
	/**
     * expandToIncludeMaxValue.
     * 
     * This will test if expandToInclude() correctly includes the maximum double value
     */
	@Test
	public void expandToIncludeMaxValue() {
		Range expectedRange = new Range(-50.0, Double.MAX_VALUE);
		Range newRange = Range.expandToInclude(this.exampleRange, Double.MAX_VALUE);
		assertEquals("Expanding range to include the maximum double value", expectedRange, newRange);
	}	
	
//	/**
//     * expandToIncludeMinValue.
//     * 
//     * This will test if expandToInclude() correctly includes the minimum double value
//     */
//	@Test
//	public void expandToIncludeMinValue() {
//		Range expectedRange = new Range(-50.0, Double.MIN_VALUE);
//		Range newRange = Range.expandToInclude(this.exampleRange, Double.MIN_VALUE);
//		assertEquals("Expanding range to include the minimum double value", expectedRange, newRange);
//	}	
	
	/**
     * expandToIncludeNullRange.
     * 
     * This will test if expandToInclude() correctly handles a null range. 
     * Null is a permissible range, and should return a range consisting of only the given value
     */
	@Test
	public void expandToIncludeNullRange() {
		Range expectedRange = new Range(15.0, 15.0);
		Range newRange = Range.expandToInclude(null, 15.0);
		assertEquals("Expanding a null range to include a value", expectedRange, newRange);
	}	
	
    /**
     * ********************** contains() test ************************
     * public boolean contains(double value)
     * Returns true if the specified value is within the range and false otherwise
     * Parameters:
     * value - the value to be tested
     * Returns:
     * true if the range contains the specified value.
     */
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueJustBelowLowerBound() {
        assertFalse("The result should be false when input value is just below the lower bound of the range",
        exampleRange.contains(-50.00001));
    }
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsLowerBound() {
    	assertTrue("The result should be true when input value is the lower bound of the range",
                exampleRange.contains(-50.0));
    }
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueJustAboveLowerBound() {
    	assertTrue("The result should be true when input value is just above the lower bound",
                exampleRange.contains(-49.99999));
    } 
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsNominalValue() {
    	assertTrue("The result should be true when input value is a nominal value within the range",
                exampleRange.contains(0));
    }  
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueJustBelowUpperBound() {
    	assertTrue("The result should be true when input value is just below the upper bound of the range",
                exampleRange.contains(59.99999));
    }   
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsUpperBound() {
    	assertTrue("The result should be true when input value is the upper bound of the range",
                exampleRange.contains(60.0));
    }    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueJustAboveUpperBound() {
    	assertFalse("The result should be false when input value is just above the upper bound of the range",
                exampleRange.contains(60.00001));
    }  
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsNotANumber() {
    	assertFalse("The result should be false when input value is not a number",
                exampleRange.contains(Double.NaN));
    }
    
//    /**
//     * This tests if contains() functions correctly for a range of values  from BLB to AUB
//     */
//    @Test
//    public void containsACharacter() {
//    	assertFalse("The result should be false when input value is a character",
//                exampleRange.contains('%'));
//    }
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueInRangeWithNegativeBoundaries() {
    	Range testRange = new Range(-20.0, -10.0);
    	assertTrue("The result should be true when input value is within a range with negative boundary values",
                testRange.contains(-13.0));
    }   
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueEqualToBothLowerAndUpperBoundaries() {
    	Range testRange = new Range(11.0, 11.0);
    	assertTrue("The result should be true when input value is equal to the lower and upper boundaries of the range",
                testRange.contains(11.0));
    }    
	
    /**
     * ********************** combine() test ************************
     * public static Range combine(Range range1,Range range2)
     * Creates a new range by combining two existing ranges.Note that:
     * either range can be null, in which case the other range is returned;
     * if both ranges are null the return value is null.
     * Parameters:
     * range1 - the first range (null permitted).
     * range2 - the second range (null permitted).
     * Returns:
     * A new range subsuming both input ranges (possibly null).
     */
    
    /**
     * This tests if combine() functions correctly when both ranges are null
     */
    @Test
    public void testCombineBothNull() {
        assertNull("The result should be null when both ranges null", Range.combine(null, null));
    }

    /**
     * This tests if combine() functions correctly when when range 1 is null
     */
    @Test
    public void testCombineRange1Null() {
        assertEquals("The result should be equal to the range that is not null", exampleRange, Range.combine(null, exampleRange));
    }

    /**
     * This tests if combine() functions correctly when when range2 is null
     */
    @Test
    public void testCombineRange2Null() {
        assertEquals("The result should be equal to the range that is not null", exampleRange, Range.combine(exampleRange, null));
    }

    /**
     * This tests if combine() functions correctly when when both ranges are not null
     */
    @Test
    public void testCombineBothNotNull() {
	    try {
	        Range range1 = new Range(1.0, 5.0);
	        Range range2 = new Range(3.0, 8.0);
	        Range expected = new Range(1.0, 8.0);
	        assertEquals("The result should be a combination of both ranges",expected, Range.combine(range1, range2));
	    } catch (Exception e) {
			fail("combine should combine both ranges, not throw an exception: " + e.toString());
	    }
    }

    /**
     * This tests if combine() functions correctly when when both ranges are exactly same
     */
    @Test
    public void testCombineEmptyRanges() {
        Range range1 = new Range(5.0, 5.0);
        Range range2 = new Range(5.0, 5.0);
        Range expected = new Range(5.0, 5.0);
        assertEquals("The resultant range should be exactly one of the ranges since both are same",expected, Range.combine(range1, range2));
    }

    /**
     * This tests if combine() functions correctly when one range is completely inside the other
     */
    @Test
    public void testCombineOneInsideOther() {
	    try {
	        Range range1 = new Range(1.0, 10.0);
	        Range range2 = new Range(3.0, 8.0);
	        Range expected = new Range(1.0, 10.0);
	        assertEquals("Combining one range inside another range will give",expected, Range.combine(range1, range2));
	    } catch (Exception e) {
			fail("combine should give the range of larger one since the other is inside first range, not throw an exception: " + e.toString());
	    }    
    }

    /**
     * This tests if combine() functions correctly when ranges touch each other (end of range1 == start of range2)
     */
    @Test
    public void testCombineTouchingRanges() {
	    try {
	        Range range1 = new Range(1.0, 5.0);
	        Range range2 = new Range(5.0, 10.0);
	        Range expected = new Range(1.0, 10.0);
	        assertEquals("Resultant range is the lowerbound of range1 and upper bound of range 2",expected, Range.combine(range1, range2));
	    } catch (Exception e) {
			fail("combine should give the range which is the lowerbound of one range and upperbound of the other range, not throw an exception: " + e.toString());
	    }      
    }
    
    /**
     * **********************intersects () test ************************
     * public boolean intersects(double lower,double upper)
     * Returns true if the range intersects (overlaps) with the specified range, 
     * and false otherwise.
     * Parameters:
     * lower - the lower bound (should be <= upper bound).
     * upper - the upper bound (should be >= lower bound).
     * Returns:
     * true if the ranges intersect.
     */
    
    
//    /**
//     * This tests if intersects() functions correctly for a range of values  between the BLB and LB
//     */
//    @Test
//    public void intersectsWithBLBAndLB() {
//    	assertTrue("Should return true due to intercept with LB",this.exampleRange.intersects(-50.00001, -50.0));
//    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the BLB and ALB
     */
    @Test
    public void intersectsWithBLBAndALB() {
    	assertTrue("Should return true due to intercept with LB",
    			this.exampleRange.intersects(-50.00001,-49.99999));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the BLB and AUB
     */
    @Test
    public void intersectsWithBLBAndAUB() {
    	assertTrue("Should return true due to intercept with LB and UB",
    			this.exampleRange.intersects(-50.00001, 60.00001));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the LB and ALB
     */
    @Test
    public void intersectsWithLBAndALB() {
    	assertTrue("Should return true due to intercept with LB",
    			this.exampleRange.intersects(-50.0, -49.99999));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the LB and UB
     */
    @Test
    public void intersectsWithLBAndUB() {
    	assertTrue("Should return true due to intercept with the entire range",
    			this.exampleRange.intersects(-50.0, 60.0));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values that fall with in the normal range
     */
    @Test
    public void intersectsWithNormalAndNormal() {
    	assertTrue("Should return true due to intercept with nominal range",
    			this.exampleRange.intersects(-49.0, 59.0));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the BUB and UB
     */
    @Test
    public void intersectsWithBUBAndUB() {
    	assertTrue("Should return true due to intercept with UB",
    			this.exampleRange.intersects(59.99999, 60.0));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the BUB and AUB
     */
    @Test
    public void intersectsWithBUBAndAUB() {
    	assertTrue("Should return true due to intercept with UB",
    			this.exampleRange.intersects(59.99999, 60.00001));
    } 
    
    
//    /**
//     * This tests if intersects() functions correctly for a range of values  between the UB and AUB
//     */
//    @Test
//    public void intersectsWithUBAndAUB() {
//    	assertTrue("Should return true due to intercept with UB",
//    			this.exampleRange.intersects(60.0, 70.00001));
//    }
    
   
    /**
     * This tests if intersects() functions correctly for a range of values  above the UB
     */
    @Test
    public void intersectsWithInputAUBAndMAX() {
        assertFalse("Should return False because value of out of range",
        		this.exampleRange.intersects(60.00001, Double.MAX_VALUE));
    }

    
    /**
     * This tests if intersects() functions correctly for a range of values below the LB
     */
    @Test
    public void intersectsWithInputBLBAndMIN() {
        assertFalse("Should return False because value of out of range",
        		this.exampleRange.intersects(-999.00, -50.00001));
    }
    
    
    /**
     * This tests if intersects() functions correctly for an invalid input
     */
    @Test
    public void intersectsWithInputNaNAnd1() {
        assertFalse("Should return False due to invalid input",
        		this.exampleRange.intersects(Double.NaN, 1));
    }  
    
    /**
     * ********************** shift () test ************************
     * public static Range shift(Range base,double delta)
     * Returns a range the size of the input range, which has been moved positively (to the right) 
     * by the delta value. Is equivalent to shift(base, delta, false) (does not allow zero crossing).
     * Parameters:
     * base - the base range (null not permitted).
     * delta - the amount to shift right by.
     * Returns:
     * A range representing the base range shifted right by delta.
     * Throws:
     * InvalidParameterException - if null base object is passed in.
     */ 
    
    /**
     * This method tests if the shift() function correctly shifts the range positively by delta
     */
    @Test
    public void positiveShiftRangeRight() {
        double delta = 50.0;
        Range expectedRange = new Range(0.0,110.0);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

        // Assertion
        assertEquals("Shift the range right", expectedRange,shiftedRange);
    }

    /**
     * This method tests if the shift() function correctly shifts the range negatively by delta
     */
    @Test
    public void negativeShiftRangeLeft() {
        double delta = -25.0;
        Range expectedRange = new Range(-75.0,35.0);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

        // Assertion
        assertEquals("Shift the range left", expectedRange,shiftedRange);
    }
    
    /**
     * This method tests if the shift() function correctly shifts the range negatively by a delta of 0.0.
     */
    @Test
    public void zeroDeltaNoShiftRange() {
        double delta = 0.0;
        Range shiftedRange = Range.shift(this.exampleRange, delta);

        // Assertion
        assertEquals("Should not shift range ", exampleRange,shiftedRange);
    }
    
    /**
     * This method tests if the shift() function correctly shifts the range positively by delta where the LB crosses the 0.
     */
    @Test
    public void positiveShiftLbZeroCrossing() {
        double delta = 50.00001;
        Range expectedRange = new Range(0.0, 110.00001);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

        // Assertion
        assertEquals("Shift the range right with only LB crossing zero ", expectedRange,shiftedRange);
    } 
    
    /**
     * This method tests if the shift() function correctly shifts the range positively by delta where the LB and UB crosses the 0.
     */
    @Test
    public void positiveShiftLbAndUbZeroCrossing() {
        double delta = 50.00001;
        this.exampleRange = new Range(-50.0,-40.0);
        Range expectedRange = new Range(0.0,0.0);
        Range shiftedRange = Range.shift(exampleRange, delta);

        // Assertion
        assertEquals("Shift the range right with LB and UB crossing zero ", expectedRange,shiftedRange);

    }
    
    /**
     * This method tests if the shift() function correctly shifts the range negatively by delta where the UB crosses the 0.
     */
    @Test
    public void negativeShiftUbZeroCrossing() {
        double delta = -50.00001;
        this.exampleRange = new Range(50.0,150.0);
        Range expectedRange = new Range(0.0, 99.99999);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

        // Assert
        assertEquals("Shift the range left with only LB zero crossing ", expectedRange,shiftedRange);
    }
    
    /**
     * This method tests if the shift() function correctly shifts the range negatively by delta where the LB and UB cross the 0.
     */
    @Test
    public void negativeShiftLbAndUbZeroCrossing() {
    	double delta = -100.00001;
        this.exampleRange = new Range(50.0,100.0);
        Range expectedRange = new Range(0.0,0.0);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

       
        // Assertion
        assertEquals("Shift the range left with LB and UB crossing zero", expectedRange, shiftedRange);
    }

    @Test
    public void testCombineIgnoringNaN_bothRangesNull() {
        Range result = Range.combineIgnoringNaN(null, null);
        assertNull(result);
    }

    @Test
    public void testCombineIgnoringNaN_range1Null() {
        Range range2 = new Range(1.0, 5.0);
        Range result = Range.combineIgnoringNaN(null, range2);
        assertEquals(range2, result);
    }

    @Test
    public void testCombineIgnoringNaN_range2Null() {
        Range range1 = new Range(1.0, 5.0);
        Range result = Range.combineIgnoringNaN(range1, null);
        assertEquals(range1, result);
    }

    @Test
    public void testCombineIgnoringNaN_bothRangesNotNull() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(3.0, 7.0);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(new Range(1.0, 7.0), result);
    }

    @Test
    public void testCombineIgnoringNaN_range1NaN() {
        Range range1 = new Range(Double.NaN, 5.0);
        Range range2 = new Range(3.0, 7.0);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(range2, result);
    }

//    @Test
//    public void testCombineIgnoringNaN_range2NaN() {
//        Range range1 = new Range(1.0, 5.0);
//        Range range2 = new Range(Double.NaN, 7.0);
//        Range result = Range.combineIgnoringNaN(range1, range2);
//        assertEquals(range1, result);
//    }

//    @Test
//    public void testCombineIgnoringNaN_bothRangesNaN() {
//        Range range1 = new Range(Double.NaN, 5.0);
//        Range range2 = new Range(Double.NaN, 7.0);
//        Range result = Range.combineIgnoringNaN(range1, range2);
//        assertNull(result);
//    }
    
    @Test
    public void testCombineIgnoringNaN_bothRangesNa() {
        Range range1 = new Range(Double.NaN, Double.NaN);
        Range range2 = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertNull(result);
    }
    
    @Test
    public void testCombineIgnoringNaN_Range1Null() {
        Range range1 = null;
        Range range2 = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertNull(result);
    }
    
    @Test
    public void testCombineIgnoringNaN_Range2Null() {
        Range range1 = new Range(Double.NaN, Double.NaN);
        Range range2 = null;
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertNull(result);
    }
    
    /**
     * ********************** ToString () test ************************
     * Returns a string representation of this Range.
     *
     * @return A String "Range[lower,upper]" where lower=lower range and
     *         upper=upper range.
     */
    
    /**
     * This method tests if the ToString Method works correctly 
     */ 
    @Test
    public void testToStringOriginalRange() {
        Range obj = new Range(-50.0, 60.0);
        assertEquals("Range[-50.0,60.0]", obj.toString());
    }
    
    @Test
    public void testToStringBelowLBndUB() {
        Range obj = new Range(-50.00001, 60.0);
        assertEquals("Range[-50.00001,60.0]", obj.toString());
    }
    
    @Test
    public void testToStringAboveLBndUB() {
        Range obj = new Range(-49.99999, 60.0);
        assertEquals("Range[-49.99999,60.0]", obj.toString());
    }
    
    @Test
    public void testToStringNominalValue() {
        Range obj = new Range(-30.0, 30.0);
        assertEquals("Range[-30.0,30.0]", obj.toString());
    }
    
    @Test
    public void testToStringBelowUpperBound() {
        Range obj = new Range(-50.0, 59.99999);
        assertEquals("Range[-50.0,59.99999]", obj.toString());
    }
    
    @Test
    public void testToStringAboveUpperBound() {
        Range obj = new Range(-50.0, 60.00001);
        assertEquals("Range[-50.0,60.00001]", obj.toString());
    }

    @Test
    public void testToStringNaN() {
        Range obj = new Range(-50.0, Double.NaN);
        assertEquals("Range[-50.0,NaN]", obj.toString());
    }
    
    public void testToStringMaxAndMin() {
        Range obj = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
        assertEquals("Range[4.9E-324,1.7976931348623157E308]", obj.toString());
    }
    
    /**
     * ********************** Equals () test ************************
     * Tests this object for equality with an arbitrary object.
     *
     * @param obj  the object to test against (<code>null</code> permitted).
     *
     * @return A boolean.
     */
    
    /**
     * This method tests if the Equals Method works correctly 
     */ 
    @Test
    public void testequalsOriginalRange() {
        Range obj = new Range(-50.0, 60.0);
        assertTrue(exampleRange.equals(obj));
    }
    
    @Test
    public void testequalsBelowLBAndUB() {
        Range obj = new Range(-50.00001, 60.0);
        assertFalse(exampleRange.equals(obj));
    }
    
    @Test
    public void testequalsAboveLBAndUB() {
        Range obj = new Range(-49.99999, 60.0);
        assertFalse(exampleRange.equals(obj));
    }
    
    @Test
    public void testequalsNominalValue() {
        Range obj = new Range(-30.0, 30.0);
        assertFalse(exampleRange.equals(obj));
    }
    
    @Test
    public void testequalsLBAndAboveUB() {
        Range obj = new Range(-50.0, 60.00001);
        assertFalse(exampleRange.equals(obj));
    }
    
    @Test
    public void testequalsLBAndBelowUB() {
        Range obj = new Range(-50.0, 59.99999);
        assertFalse(exampleRange.equals(obj));
    }

    @Test
    public void testequalsBelowLBAndBelowUB() {
        Range obj = new Range(-50.00001, 59.99999);
        assertFalse(exampleRange.equals(obj));
    }
    
    @Test
    public void testequalsBelowLBAndAboveUB() {
        Range obj = new Range(-50.00001, 60.00001);
        assertFalse(exampleRange.equals(obj));
    }
    
    @Test
    public void testequalsNull() {
        Range obj = null;
        assertFalse(exampleRange.equals(obj));
    }
    
    /**
     * ********************** Scale () test ************************
     * Scales the range by the specified factor.
     *
     * @param base the base range (<code>null</code> not permitted).
     * @param factor the scaling factor (must be non-negative).
     *
     * @return A new range.
     *
     * @since 1.0.9
     */
    
    @Test
    public void testScalePositiveFactor() {
      Range base = new Range(0.0, 10.0);
      double factor = 2.0;
      Range expected = new Range(0.0, 20.0);

      Range scaledRange = Range.scale(base, factor);

      assertEquals(expected, scaledRange);
    }

    @Test
    public void testScaleNegativeFactor() {
      Range base = new Range(5.0, 15.0);
      double factor = -0.5;

      try {
        Range.scale(base, factor);
        fail("Expected IllegalArgumentException"); // Indicate failed expectation
      } catch (IllegalArgumentException e) {
        // Expected exception, test passes silently
      }
    }

    @Test
    public void testScaleFactorZero() {
      Range base = new Range(-2.0, 8.0);
      double factor = 0.0;

      Range expected = new Range(0.0, 0.0);

      Range scaledRange = Range.scale(base, factor);

      assertEquals(expected, scaledRange);
    }

    @Test
    public void testScaleEqualBounds() {
      Range base = new Range(5.0, 5.0);
      double factor = 4.0;

      Range expected = new Range(20.0, 20.0);

      Range scaledRange = Range.scale(base, factor);

      assertEquals(expected, scaledRange);
    }
    
    /**
     * ********************** getCentralValue () test ************************
     * Returns the central value for the range.
     *
     * @return The central value.
     */
    
    @Test
    public void testCentralValuePositiveBounds() {
      Range range = new Range(5.0, 10.0);

      double centralValue = range.getCentralValue();

      assertEquals(7.5, centralValue, 0.001); // Allow a small delta for floating-point precision
    }

    @Test
    public void testCentralValueNegativeBounds() {
      Range range = new Range(-2.0, 3.0);

      double centralValue = range.getCentralValue();

      assertEquals(0.5, centralValue, 0.001);
    }

    @Test
    public void testCentralValueSingleBound() {
      Range range = new Range(1.0, 1.0);

      double centralValue = range.getCentralValue();

      assertEquals(1.0, centralValue, 0.001);
    }
    
    /**
     * ********************** getLength () test ************************
     * Returns the length of the range.
     *
     * @return The length.
     */ 
    
    @Test
    public void testLengthPositiveBounds() {
      Range range = new Range(5.0, 10.0);

      double length = range.getLength();

      assertEquals(5.0, length, 0.0);
    }

    @Test
    public void testLengthNegativeBounds() {
      Range range = new Range(-2.0, 3.0);

      double length = range.getLength();

      assertEquals(5.0, length, 0.0); // Absolute value of the difference
    }

    @Test
    public void testLengthSingleBound() {
      Range range = new Range(1.0, 1.0);

      double length = range.getLength();

      assertEquals(0.0, length, 0.0); // Zero length for equal bounds
    }    
    
  
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}