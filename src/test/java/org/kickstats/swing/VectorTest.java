
package org.kickstats.swing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the methods of the Vector class.
 * 
 * @author Chase Sonnemaker
 * @version 6 April 2020
 */
public class VectorTest {
    
    public VectorTest() {
    }// VectorTest()

    /**
     * First test of get method, of class Vector.
     * 
     * Tests getting the first element of a 4 element vector.
     */
    @Test
    public void testGet1() {
        System.out.println("get");
        Vector instance = new Vector(1, 0, 0);
        double expResult = 1;
        double result = instance.get(0);
        assertEquals(expResult, result, 1E-8);
    }// testGet1()
    
    /**
     * Second test of get method, of class Vector.
     * 
     * Tests getting the last element of a 4 element vector.
     */
    @Test
    public void testGet2() {
        System.out.println("get");
        Vector instance = new Vector(0, 1, 0);
        double expResult = 1;
        double result = instance.get(3);
        assertEquals(expResult, result, 1E-8);
    }// testGet2
    
    /**
     * First test of set method, of class Vector.
     * 
     * Tests setting the first element of a 4 element vector to 10.
     */
    @Test
    public void testSet_int_double1() {
        System.out.println("set");
        int position = 0;
        double value = 10;
        Vector instance = new Vector(1, 0, 0);
        Vector expResult = new Vector(10, 0, 0);
        instance.set(position, value);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), instance.get(i), 1E-8);
        }// for
    }// testSet_int_double1()
    
    /**
     * Second test of set element method, of class Vector.
     * 
     * Tests setting the last element of a 4 element vector to 5.
     */
    @Test
    public void testSet_int_double2() {
        System.out.println("set");
        int position = 3;
        double value = 5;
        Vector instance = new Vector(0, 1, 0);
        Vector expResult = new Vector(0, 1, 0, 5);
        instance.set(position, value);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), instance.get(i), 1E-8);
        }// for
    }// testSet_int_double2()

    /**
     * First test of set Vector method, of class Vector.
     * 
     * Tests setting a vector of (0, 0, 0, 0) to (1, 0, 0, 1).
     */
    @Test
    public void testSet_Vector1() {
        System.out.println("set");
        Vector instance = new Vector();
        Vector expResult = new Vector(1, 0, 0);
        instance.set(expResult);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), instance.get(i), 1E-8);
        }// for
    }// testSet_Vector1()
    
    /**
     * Second test of set Vector method, of class Vector.
     * 
     * Tests setting a vector of (0, 0, 0, 0) to (0, 1, 0, 1).
     */
    @Test
    public void testSet_Vector2() {
        System.out.println("set");
        Vector instance = new Vector();
        Vector expResult = new Vector(0, 1, 0);
        instance.set(expResult);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), instance.get(i), 1E-8);
        }// for
    }// testSet_Vector2()
    
    /**
     * First test of toString method, of class Vector.
     * 
     * Tests vector (1, 0, 0, 1) conversion to a string.
     */
    @Test
    public void testToString1() {
        System.out.println("toString");
        Vector instance = new Vector(1, 0, 0);
        String expResult = "(1.0, 0.0, 0.0, 1.0)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }// testToString1()

    /**
     * Second test of toString method, of class Vector.
     * 
     * Tests vector (0, 1, 0, 1) conversion to a string.
     */
    @Test
    public void testToString2() {
        System.out.println("toString");
        Vector instance = new Vector(0, 1, 0);
        String expResult = "(0.0, 1.0, 0.0, 1.0)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }// testToString2()
    
    /**
     * First test of add method, of class Vector.
     * 
     * Tests the addition of vector (1, 0, 0) and vector (0, 1, 0).
     */
    @Test
    public void testAdd1() {
        System.out.println("add");
        Vector v = new Vector(0, 1, 0);
        Vector instance = new Vector(1, 0, 0);
        Vector expResult = new Vector(1, 1, 0);
        Vector result = instance.add(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
    } //testAdd1()

    /**
     * Second test of add method, of class Vector.
     * 
     * Tests the addition of vector (0, 1, 0) and vector (1, 0, 0).
     */
    @Test
    public void testAdd2() {
        System.out.println("add");
        Vector v = new Vector(1, 0, 0);
        Vector instance = new Vector(0, 1, 0);
        Vector expResult = new Vector(1, 1, 0);
        Vector result = instance.add(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
    } //testAdd2()
    
    /**
     * First test of subtract method, of class Vector.
     * 
     * Tests the subtraction of vector (0, 1, 0) from vector (1, 0, 0).
     */
    @Test
    public void testSubtract1() {
        System.out.println("subtract");
        Vector v = new Vector(0, 1, 0);
        Vector instance = new Vector(1, 0, 0);
        Vector expResult = new Vector(1, -1, 0);
        Vector result = instance.subtract(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
    }// testSubtract1()
    
    /**
     * Second test of subtract method, of class Vector.
     * 
     * Tests the subtraction of vector (1, 0, 0) from vector (0, 1, 0).
     */
    @Test
    public void testSubtract2() {
        System.out.println("subtract");
        Vector v = new Vector(1, 0, 0);
        Vector instance = new Vector(0, 1, 0);
        Vector expResult = new Vector(-1, 1, 0);
        Vector result = instance.subtract(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
    }// testSubtract2()
    
    /**
     * First test of dot method, of class Vector.
     * 
     * Tests the dot product of vector (1, 0, 0) and vector (0, 1, 0).
     */
    @Test
    public void testDot1() {
        System.out.println("dot");
        Vector v = new Vector(0, 1, 0);
        Vector instance = new Vector(1, 0, 0);
        double expResult = 0;
        double result = instance.dot(v);
        assertEquals(expResult, result, 1E-8);
    }// testDot1()
    
    /**
     * Second test of dot method, of class Vector.
     * 
     * Tests the dot product of vector (0, 1, 0) and vector (1, 0, 0).
     */
    @Test
    public void testDot2() {
        System.out.println("dot");
        Vector v = new Vector(1, 0, 0);
        Vector instance = new Vector(0, 1, 0);
        double expResult = 0;
        double result = instance.dot(v);
        assertEquals(expResult, result, 1E-8);
    }// testDot2()

    /**
     * First test of magnitude method, of class Vector.
     * 
     * Tests the magnitude of vector (1, 0, 0).
     */
    @Test
    public void testMagnitude1() {
        System.out.println("magnitude");
        Vector instance = new Vector(1, 0, 0);
        double expResult = 1;
        double result = instance.magnitude();
        assertEquals(expResult, result, 1E-8);
    }// magnitude1()

    /**
     * Second test of magnitude method, of class Vector.
     * 
     * Tests the magnitude of vector (0, 1, 0).
     */
    @Test
    public void testMagnitude2() {
        System.out.println("magnitude");
        Vector instance = new Vector(0, 1, 0);
        double expResult = 1;
        double result = instance.magnitude();
        assertEquals(expResult, result, 1E-8);
    }// magnitude2()
    
    /**
     * First test of normalize method, of class Vector.
     * 
     * Tests the normalization of vector (1, 0, 0).
     */
    @Test
    public void testNormalize1() {
        System.out.println("normalize");
        Vector instance = new Vector(1, 0, 0);
        Vector expResult = new Vector(1, 0, 0);
        Vector result = instance.normalize();
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
    }// testNormalize1()
    
    /**
     * Second test of normalize method, of class Vector.
     * 
     * Tests the normalization of vector (0, 1, 0).
     */
    @Test
    public void testNormalize2() {
        System.out.println("normalize");
        Vector instance = new Vector(0, 1, 0);
        Vector expResult = new Vector(0, 1, 0);
        Vector result = instance.normalize();
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
    }// testNormalize2()
    
    /**
     * First test of cross method, of class Vector.
     * 
     * Tests the cross product of vector (1, 0, 0) and vector (0, 1, 0).
     */
    @Test
    public void testCross1() {
        System.out.println("cross");
        Vector v = new Vector(0, 1, 0);
        Vector instance = new Vector(1, 0, 0);
        Vector expResult = new Vector(0, 0, 1);
        Vector result = instance.cross(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
    }// testCross1()
    
    /**
     * Second test of cross method, of class Vector.
     * 
     * Tests the cross product of vector (0, 1, 0) and vector (1, 0, 0).
     */
    @Test
    public void testCross2() {
        System.out.println("cross");
        Vector v = new Vector(1, 0, 0);
        Vector instance = new Vector(0, 1, 0);
        Vector expResult = new Vector(0, 0, -1);
        Vector result = instance.cross(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
    }// testCross1()
    
}// VectorTest
