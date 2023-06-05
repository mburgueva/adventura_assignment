package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VecTest.
 *
 * This test class is responsible for testing the Vec class.
 * It includes various test cases to ensure the correctness of the implementation.
 *
 * @author Your Name
 * @version 1.0
 */
public class VecTest {
    private Vec vec1;
    private Vec vec2;

    /**
     * Default constructor for test class VecTest
     */
    public VecTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        vec1 = new Vec("vec1", true);
        vec2 = new Vec("vec2", false);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    /**
     * Test the getNazev method.
     * It checks whether the getNazev method returns the correct name of the object.
     */
    @Test
    public void testGetNazev() {
        assertEquals("vec1", vec1.getNazev());
        assertEquals("vec2", vec2.getNazev());
    }

    /**
     * Test the isJePrenosna method.
     * It checks whether the isJePrenosna method returns the correct value indicating if the object is portable or not.
     */
    @Test
    public void testIsJePrenosna() {
        assertTrue(vec1.isJePrenosna());
        assertFalse(vec2.isJePrenosna());
    }
}
