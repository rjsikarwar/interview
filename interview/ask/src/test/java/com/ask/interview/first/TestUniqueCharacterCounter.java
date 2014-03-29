package com.ask.interview.first;

import com.ask.interview.first.UniqueCharacterCounter;

import junit.framework.TestCase;

/**
 * Unit test for exercise 1
 */
public class TestUniqueCharacterCounter 
    extends TestCase
{
	
    public void testCountSingleCharacter() {
    	assertEquals(1, UniqueCharacterCounter.count("a"));
    }
    
    public void testCountCaseInsensitivity() {
    	assertEquals(1, UniqueCharacterCounter.count("aA"));
    }

    public void testCountMulti() {
    	assertEquals(2, UniqueCharacterCounter.count("ab"));
    }

    public void testCountMultiCaseInsensitivity() {
    	assertEquals(2, UniqueCharacterCounter.count("aAbB"));
    }

    public void testCountSingleCharacter2() {
    	assertEquals(1, UniqueCharacterCounter.count("a", true));
    	assertEquals(1, UniqueCharacterCounter.count("a", false));
    }
    
    public void testCountCaseInsensitivity2() {
    	assertEquals(2, UniqueCharacterCounter.count("aA", true));
    	assertEquals(1, UniqueCharacterCounter.count("aA", false));
    }

    public void testCountMulti2() {
    	assertEquals(2, UniqueCharacterCounter.count("ab", true));
    	assertEquals(2, UniqueCharacterCounter.count("ab", false));
    }

    public void testCountMultiCaseInsensitivity2() {
    	assertEquals(4, UniqueCharacterCounter.count("aAbB", true));
    	assertEquals(2, UniqueCharacterCounter.count("aAbB", false));
    }

}
