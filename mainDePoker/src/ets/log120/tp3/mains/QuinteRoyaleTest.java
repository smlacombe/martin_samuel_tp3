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
		main.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		
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
		main.add(new Carte(Denomination.JOKER,CouleurCarte.JOKER));
		
		assertTrue(new QuinteRoyale().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testQuinteRoyaleAvecJoker2() {
		Main main = new Main();
		main.add(new Carte(Denomination.JOKER,   CouleurCarte.JOKER));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.JOKER,CouleurCarte.JOKER));
		
		assertTrue(new QuinteRoyale().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testQuinteRoyaleAsAvecDoublon() {
		Main main = new Main();
		main.add(new Carte(Denomination.AS,  	CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.ROI,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.ROI, 	CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DAME, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.VALET,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.CARREAU));
		
		assertTrue(new QuinteRoyale().reconnaitreMain(new ReqAnalyseMain(main)));
	}
}
