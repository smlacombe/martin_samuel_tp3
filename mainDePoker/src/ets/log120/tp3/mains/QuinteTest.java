package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class QuinteTest extends TestCase {
	/*
	 * Test avec main qui n'est pas une quinte
	 */
	public void testPasDeQuinte()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.NEUF,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.AS,    CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.COEUR));
		
		assertFalse(new Quinte().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	/*
	 * Test avec main qui est une quinte sans AS
	 */
	public void testQuinteSansAs() {
		Main main = new Main();
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DEUX,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.SIX,    CouleurCarte.CARREAU));
		
		assertTrue(new Quinte().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	/*
	* Test avec main qui est une quinte avec AS
	*/
	public void testQuiteAvecAs() {
		Main main = new Main();
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,     CouleurCarte.CARREAU));
		
		assertTrue(new Quinte().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	/*
	* Test avec main qui est une quinte avec Joker
	*/
	public void testQuinteAvecJoker() {
		Main main = new Main();
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.JOKER,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.JOKER,  CouleurCarte.JOKER));
		
		assertTrue(new Quinte().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testQuinteAsAvecJoker() {
		Main main = new Main();
		main.add(new Carte(Denomination.AS,  	CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.TROIS, 	CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.JOKER,  CouleurCarte.JOKER));
		
		assertTrue(new Quinte().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testQuinteAsAvecDoublon() {
		Main main = new Main();
		main.add(new Carte(Denomination.AS,  	CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DEUX, 	CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.QUATRE,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
		
		assertTrue(new Quinte().reconnaitreMain(new ReqAnalyseMain(main)));
	}
}
