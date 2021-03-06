
package org.kickstats.swing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the methods of the Matrix class.
 * 
 * @author Chase Sonnemaker
 * @version 7 April 2020
 */
public class MatrixTest {
    
    public MatrixTest() {
    }// MatrixTest()

    /**
     * First test of get method, of class Matrix.
     * 
     * Tests retrieval of the value in the first row, first column of the 
     * 4x4 identity matrix.
     */
    @Test
    public void testGet1() {
        System.out.println("get");
        int row = 0;
        int column = 0;
        Matrix instance = new Matrix();
        double expResult = 1.0;
        double result = instance.get(row, column);
        assertEquals(expResult, result, 1E-8);
    }// testGet1()

    /**
     * Second test of get method, of class Matrix.
     * 
     * Tests retrieval of the value in the last row, last column of the 
     * 4x4 identity matrix.
     */
    @Test
    public void testGet2() {
        System.out.println("get");
        int row = 3;
        int column = 3;
        Matrix instance = new Matrix();
        double expResult = 1.0;
        double result = instance.get(row, column);
        assertEquals(expResult, result, 1E-8);
    }// testGet2()
    
    /**
     * First test of set method, of class Matrix.
     * 
     * Tests the setting of the value 10 on the first row, first column
     * position of a 4x4 identity matrix.
     */
    @Test
    public void testSet1() {
        System.out.println("set");
        int row = 0;
        int column = 0;
        double value = 10;
        Matrix instance = new Matrix();
        double expresult = 10; //At row 0, column 0
        instance.set(row, column, value);
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0 && j == 0) {
                    assertEquals(instance.get(i, j), expresult);
                }// if
                else if (i == j) {
                    assertEquals(instance.get(i, j), 1);
                }// else if
                else {
                    assertEquals(instance.get(i, j), 0);
                }// else
            }// for
        }// for
    }// testSet1()
    
    /**
     * First test of set method, of class Matrix.
     * 
     * Tests the setting of the value 5 on the last row, last column
     * position of a 4x4 identity matrix.
     */
    @Test
    public void testSet2() {
        System.out.println("set");
        int row = 3;
        int column = 3;
        double value = 5;
        Matrix instance = new Matrix();
        double expresult = 5; //At row 3, column 3
        instance.set(row, column, value);
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j == 3) {
                    assertEquals(instance.get(i, j), expresult);
                }// if
                else if (i == j) {
                    assertEquals(instance.get(i, j), 1);
                }// else if
                else {
                    assertEquals(instance.get(i, j), 0);
                }// else
            }// for
        }// for
    }// testSet2()
    
    //String method tests are located in Matrix main.
    
    /**
     * First test of identity method, of class Matrix.
     * 
     * Tests the conversion of a 4x4 matrix with a first row of elements 
     * (25, 50, 75, 100) to an identity matrix.
     */
    @Test
    public void testIdentity1() {
        System.out.println("identity");
        Matrix instance = new Matrix();
        instance.set(0, 0, 25);
        instance.set(0, 1, 50);
        instance.set(0, 2, 75);
        instance.set(0, 3, 100);
        instance.identity();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    assertEquals(instance.get(i, j), 1);
                }// if
                else {
                    assertEquals(instance.get(i, j), 0);
                }// else
            }// for
        }// for
    }// testIdentity1()

    /**
     * Second test of identity method, of class Matrix.
     * 
     * Tests the conversion of a 4x4 matrix with a diagonal of elements 
     * (25, 50, 75, 100) to an identity matrix.
     */
    @Test
    public void testIdentity2() {
        System.out.println("identity");
        Matrix instance = new Matrix();
        instance.set(0, 0, 25);
        instance.set(1, 1, 50);
        instance.set(2, 2, 75);
        instance.set(3, 3, 100);
        instance.identity();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    assertEquals(instance.get(i, j), 1);
                }// if
                else {
                    assertEquals(instance.get(i, j), 0);
                }// else
            }// for
        }// for
    }// testIdentity2()
    
    /**
     * First test of multiply method, of class Matrix.
     * 
     * Tests the product of two 4x4 identity matrices.
     */
    @Test
    public void testMultiply_Matrix1() {
        System.out.println("multiply");
        Matrix m = new Matrix();
        Matrix instance = new Matrix();
        Matrix expResult = new Matrix();
        Matrix result = instance.multiply(m);
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(result.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testMultiply_Matrix1()
    
    /**
     * Second test of multiply method, of class Matrix.
     * 
     * Tests the product of two 4x4 matrices. One is an identity matrix with 
     * a first row that has the values (25, 50, 75, 100) and the other is an
     * identity matrix where the diagonal now holds the values 
     * (25, 50, 75, 100).
     */
    @Test
    public void testMultiply_Matrix2() {
        System.out.println("multiply");
        Matrix m = new Matrix();
        m.set(0, 0, 25);
        m.set(1, 1, 50);
        m.set(2, 2, 75);
        m.set(3, 3, 100);
        Matrix instance = new Matrix();
        instance.set(0, 0, 25);
        instance.set(0, 1, 50);
        instance.set(0, 2, 75);
        instance.set(0, 3, 100);
        Matrix expResult = new Matrix();
        expResult.set(0, 0, 625);
        expResult.set(1, 1, 50);
        expResult.set(2, 2, 75);
        expResult.set(3, 3, 100);
        expResult.set(0, 1, 2500);
        expResult.set(0, 2, 5625);
        expResult.set(0, 3, 10000);
        Matrix result = instance.multiply(m);
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(result.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testMultiply_Matrix2()

    /**
     * First test of multiply (vector) method, of class Matrix.
     * 
     * Tests the product of a 4x4 identity matrix and a vector of 
     * (1, 0, 0).
     */
    @Test
    public void testMultiply_Vector1() {
        System.out.println("multiply");
        Vector v = new Vector(1, 0, 0);
        Matrix instance = new Matrix();
        Vector expResult = new Vector(1, 0, 0);
        Vector result = instance.multiply(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
    }// testMultiply_Vector1()
    
    /**
     * Second test of multiply (vector) method, of class Matrix.
     * 
     * Tests the product of a 4x4 matrix with (25, 50, 75, 1) on 
     * the diagonal and a vector of (100, 75, 50, 1).
     */
    @Test
    public void testMultiply_Vector2() {
        System.out.println("multiply");
        Vector v = new Vector(100, 75, 50);
        Matrix instance = new Matrix();
        instance.set(0, 0, 25);
        instance.set(1, 1, 50);
        instance.set(2, 2, 75);
        Vector expResult = new Vector(2500, 3750, 3750);
        Vector result = instance.multiply(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
    }// testMultiply_Vector2()

    /**
     * First test of translate method, of class Matrix.
     * 
     * Tests the creation of a matrix designed to translate a vector
     * 0 units in the x direction, 25 units in the y directions, and 50 units 
     * in the z direction. Then creates a matrix designed to move back to the 
     * original spot and multiplies them together. Ensures the resulting matrix
     * is the identity matrix.
     */
    @Test
    public void testTranslate1() {
        System.out.println("translate");
        double x = 0;
        double y = 25;
        double z = 50;
        Matrix instance = new Matrix();
        instance.translate(x, y, z);
        Matrix instance2 = new Matrix();
        instance2.translate(-x, -y, -z);
        instance = instance.multiply(instance2);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testTranslate1()

    /**
     * Second test of translate method, of class Matrix.
     * 
     * Tests the creation of a matrix designed to translate a vector
     * -100 units in the x direction, -50 units in the y directions, and 
     * 0 units in the z direction. Then creates a matrix designed to move back 
     * to the original spot and multiplies them together. Ensures the 
     * resulting matrix is the identity matrix.
     */
    @Test
    public void testTranslate2() {
        System.out.println("translate");
        double x = -100;
        double y = -50;
        double z = 0;
        Matrix instance = new Matrix();
        instance.translate(x, y, z);
        Matrix instance2 = new Matrix();
        instance2.translate(-x, -y, -z);
        instance = instance.multiply(instance2);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testTranslate2()
    
    /**
     * First test of rotateX method, of class Matrix.
     * 
     * Tests the creation of a matrix designed to rotate a vector 2 Pi radians
     * about the x axis.
     */
    @Test
    public void testRotateX1() {
        System.out.println("rotateX");
        double angle = 2 * Math.PI;
        Matrix instance = new Matrix();
        instance.rotateX(angle);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testRotatex1()

    /**
     * Second test of rotateX method, of class Matrix.
     * 
     * Tests the creation of a matrix designed to rotate a vector Pi radians
     * about the x axis. Then creates a matrix designed to rotate back 
     * to the original spot and multiplies them together. Ensures the 
     * resulting matrix is the identity matrix.
     */
    @Test
    public void testRotateX2() {
        System.out.println("rotateX");
        double angle = Math.PI;
        Matrix instance = new Matrix();
        instance.rotateX(angle);
        Matrix instance2 = new Matrix();
        instance2.rotateX(-angle);
        instance = instance.multiply(instance2);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testRotatex2()
    
    /**
     * First test of rotateY method, of class Matrix.
     * 
     * Tests the creation of a matrix designed to rotate a vector 2 Pi radians
     * about the y axis.
     */
    @Test
    public void testRotateY1() {
        System.out.println("rotateY");
        double angle = 2 * Math.PI;
        Matrix instance = new Matrix();
        instance.rotateY(angle);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testRotateY1()

    /**
     * Second test of rotateY method, of class Matrix.
     * 
     * Tests the creation of a matrix designed to rotate a vector Pi radians
     * about the y axis. Then creates a matrix designed to rotate back 
     * to the original spot and multiplies them together. Ensures the 
     * resulting matrix is the identity matrix.
     */
    @Test
    public void testRotateY2() {
        System.out.println("rotateY");
        double angle = Math.PI;
        Matrix instance = new Matrix();
        instance.rotateY(angle);
        Matrix instance2 = new Matrix();
        instance2.rotateY(-angle);
        instance = instance.multiply(instance2);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testRotateY2()
    
    /**
     * First test of rotateZ method, of class Matrix.
     * 
     * Tests the creation of a matrix designed to rotate a vector 2 Pi radians
     * about the z axis.
     */
    @Test
    public void testRotateZ1() {
        System.out.println("rotateZ");
        double angle = 2 * Math.PI;
        Matrix instance = new Matrix();
        instance.rotateZ(angle);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testRotateZ1()

    /**
     * Second test of rotateZ method, of class Matrix.
     * 
     * Tests the creation of a matrix designed to rotate a vector Pi radians
     * about the z axis. Then creates a matrix designed to rotate back 
     * to the original spot and multiplies them together. Ensures the 
     * resulting matrix is the identity matrix.
     */
    @Test
    public void testRotateZ2() {
        System.out.println("rotateZ");
        double angle = Math.PI;
        Matrix instance = new Matrix();
        instance.rotateZ(angle);
        Matrix instance2 = new Matrix();
        instance2.rotateZ(-angle);
        instance = instance.multiply(instance2);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testRotateZ2()
    
    /**
     * First test of scale method, of class Matrix.
     * 
     * Tests the creation of a matrix designed to scale a vector by a factor 
     * of 1 in the x direction, a factor of 25 in the y direction, and a factor
     * of 50 in the z direction. Then creates a matrix designed to scale back 
     * to the original size and multiplies them together. Ensures the 
     * resulting matrix is the identity matrix.
     */
    @Test
    public void testScale1() {
        System.out.println("scale");
        double x = 1.0;
        double y = 25.0;
        double z = 50.0;
        Matrix instance = new Matrix();
        instance.scale(x, y, z);
        Matrix instance2 = new Matrix();
        instance2.scale(1/x, 1/y, 1/z);
        instance = instance.multiply(instance2);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testScale1()
    
    /**
     * Second test of scale method, of class Matrix.
     * 
     * Tests the creation of a matrix designed to scale a vector by a factor 
     * of 0.01 in the x direction, a factor of 0.25 in the y direction, and a 
     * factor of 1 in the z direction. Then creates a matrix designed to scale
     * back to the original size and multiplies them together. Ensures the 
     * resulting matrix is the identity matrix.
     */
    @Test
    public void testScale2() {
        System.out.println("scale");
        double x = 0.01;
        double y = 0.25;
        double z = 1.0;
        Matrix instance = new Matrix();
        instance.scale(x, y, z);        
        Matrix instance2 = new Matrix();
        instance2.scale(1/x, 1/y, 1/z);
        instance = instance.multiply(instance2);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }// testScale2()
    
}// MatrixTest
