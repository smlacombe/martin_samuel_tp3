/*
 * 2005-06-12
 * Code source inspir� et traduit � partir d'un �nonc� de laboratoire du MIT
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
 * Un ensemble de tests dans JUnit pour la classe CouleurCarte
 *
 */
public class CouleurCarteTest extends TestCase
{

	/**
	 * Constructor for CouleurCarteTest.
	 * @param arg0
	 */
	public CouleurCarteTest(String arg0)
	{
		super(arg0);
	}

	public static Test suite() {        
		return new TestSuite(CouleurCarteTest.class);
	}


	public void testCompareTo() {
        
		// Comparing to a null card suit should throw a NullPointerException.
		try {
			CouleurCarte.COEUR.compareTo(null);
			fail("Devrait lancer une NullPointerException");
		}
		catch (NullPointerException npe) {
		}
		catch (Exception e) {
			fail("Devrait lancer une NullPointerException: " + e.toString());
		}


		// Comparing to a String should throw a ClassCastException.
		// test d�suet avec Java 1.5 et "generics"
		/*
		try {
			CouleurCarte.PIQUE.compareTo("test");
			fail("Devrait lancer une ClassCastException");
		}
		catch (ClassCastException cce) {
		}
		catch (Exception e) {
			fail("Devrait lancer une ClassCastException: " + e.toString());
		}
		*/


		// A card suit cannot be less than the same card suit.
		assertTrue(CouleurCarte.CARREAU.compareTo(CouleurCarte.CARREAU) == 0);

		// Test two different card suits.
		assertTrue(CouleurCarte.COEUR.compareTo(CouleurCarte.CARREAU) > 0);
		assertTrue(CouleurCarte.CARREAU.compareTo(CouleurCarte.COEUR) < 0);
	}


	public void testEquals() {
		assertTrue(!CouleurCarte.TREFLE.equals(null));
		assertEquals(CouleurCarte.CARREAU, CouleurCarte.CARREAU);
		Assert.assertTrue(!CouleurCarte.COEUR.equals(CouleurCarte.PIQUE));
	}

}
