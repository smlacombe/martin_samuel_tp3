/*
 * 2005-06-12
 * Code source inspiré et traduit à partir d'un énoncé de laboratoire du MIT
 * 6.170  	Laboratory in Software Engineering, Fall 2002
 * http://6170.lcs.mit.edu/www-archive/Old-2002-Fall/psets/ps2/ps2.html
 * 
 */

package ets.log120.tp3;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Ensemble de tests dans JUnit pour tester la classe Dénomination
 */
public class DenominationTest extends TestCase {

	/**
	 * Constructor for DénominationTest.
	 * @param arg0
	 */
	public DenominationTest(String arg0)
	{
		super(arg0);
	}

	//
	// METHODS
	//

	public static Test suite() {        
		return new TestSuite(DenominationTest.class);
	}


	public void testCompareTo() {
        
		// Comparing to a null card suit should throw a NullPointerException.
		try {
			Denomination.VALET.compareTo(null);
			fail("Devrait lancer une NullPointerException");
		}
		catch (NullPointerException npe) {
		}
		catch (Exception e) {
			fail("Devrait lancer une NullPointerException: " + e.toString());
		}


		// Comparing to a String should throw a ClassCastException.
		// test desuet avec Java 1.5 et "generics"
		/*
		try {
			Denomination.TROIS.compareTo("test");
			fail("Devrait lancer une ClassCastException");
		}
		catch (ClassCastException cce) {
		}
		catch (Exception e) {
			fail("Devrait lancer une ClassCastException: " + e.toString());
		}
		*/


		// A card value cannot be less than the same card value.
		assertTrue(Denomination.HUIT.compareTo(Denomination.HUIT) == 0);

		// Test two different card values.
		assertTrue(Denomination.AS.compareTo(Denomination.DEUX) > 0);
		assertTrue(Denomination.DEUX.compareTo(Denomination.AS) < 0);
	}


	public void testEquals() {
		assertTrue(!Denomination.VALET.equals(null));
		assertEquals(Denomination.SEPT, Denomination.SEPT);
		Assert.assertTrue(!Denomination.DEUX.equals(Denomination.AS));
	}
}
