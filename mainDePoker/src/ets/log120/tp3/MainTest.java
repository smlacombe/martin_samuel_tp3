package ets.log120.tp3;

import junit.framework.*;

public class MainTest extends TestCase {

	public MainTest(String name) {
		super(name);
	}
	
    protected void setUp() {
       
    }
    
    public static Test suite() {        
        return new TestSuite(MainTest.class);
    }
	
    public void testSuit() {
        assertEquals(0,0);
    }
}
