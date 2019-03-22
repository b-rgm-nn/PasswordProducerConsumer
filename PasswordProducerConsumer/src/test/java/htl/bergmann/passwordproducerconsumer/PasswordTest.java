package htl.bergmann.passwordproducerconsumer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthias
 */
public class PasswordTest {
    
    public PasswordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of check method, of class Password.
     */
    @Test
    public void testCheck1() {
        Password password = new Password("password123");
        assertEquals(password.check("pass"), false);
        assertEquals(password.check("123"), false);
        assertEquals(password.check("password123"), true);
    }

    @Test
    public void testCheck2() {
        Password password = new Password("3141");
        assertEquals(password.check("pass"), false);
        assertEquals(password.check("123"), false);
        assertEquals(password.check("password123"), false);
        assertEquals(password.check("3141"), true);
    }
    
}
