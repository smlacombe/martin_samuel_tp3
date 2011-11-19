package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import junit.framework.TestCase;
import ets.log120.tp3.cartes.Denomination;

/**
 * Classe test chargée de tester la reconnaissance ou non de quinte royale.
 * @author Samuel Milette-Lacombe
 * @see ets.log120.tp3.QuinteRoyale
 */
public class QuinteRoyaleTest extends TestCase {
	public void testQuinteRoyale()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.VALET,CouleurCarte.COEUR));
		
		assertTrue(new QuinteRoyale().reconnaitreMain(new ReqAnalyseMain(main)));
	}

	public void testPasDeQuinteRoyale()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.NEUF,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.VALET,CouleurCarte.COEUR));
		
		assertFalse(new QuinteRoyale().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	/*
	* Test avec main qui est une quinte avec Joker
	*/
	public void testQuinteRoyaleAvecJoker() {
		Main main = new Main();
		main.add(new Carte(Denomination.AS,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.JOKER,CouleurCarte.COEUR));
		
		assertTrue(new Quinte().reconnaitreMain(new ReqAnalyseMain(main)));
	}
}
