package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class QuinteTest extends TestCase {
	public void testEvalueMain()
	{
		/*
		 * Test avec main qui n'est pas une quinte
		 */
		Main main = new Main();
		main.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.NEUF,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.AS,    CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DEUX,  CouleurCarte.COEUR));
		
		assertFalse(new Quinte().reconnaitreMain(new ReqAnalyseMain(main)));

		/*
		 * Test avec main qui est une quinte avec AS
		 */
		main = new Main();
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,     CouleurCarte.CARREAU));
		
		assertTrue(new Quinte().reconnaitreMain(new ReqAnalyseMain(main)));

		/*
		 * Test avec main qui est une quinte sans AS
		 */
		main = new Main();
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DEUX,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.SIX,    CouleurCarte.CARREAU));
		
		assertTrue(new Quinte().reconnaitreMain(new ReqAnalyseMain(main)));
	}
}
