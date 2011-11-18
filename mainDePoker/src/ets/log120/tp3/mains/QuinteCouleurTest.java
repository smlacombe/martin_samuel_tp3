package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class QuinteCouleurTest extends TestCase {
	public void testQuinteCouleur2a6()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DEUX,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.CINQ,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.SIX,    CouleurCarte.COEUR));
		
		assertTrue(new QuinteCouleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testQuinteCouleurAvecAS()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DEUX,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.QUATRE, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.CINQ,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.AS,     CouleurCarte.COEUR));
		
		assertTrue(new QuinteCouleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void test2Quinte1SeuleQuinteCouleur()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DEUX,    CouleurCarte.COEUR));
		main.add(new Carte(Denomination.TROIS,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.QUATRE,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.CINQ,    CouleurCarte.COEUR));
		main.add(new Carte(Denomination.SIX,     CouleurCarte.COEUR));
		
		main.add(new Carte(Denomination.AS,    CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.ROI,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DIX,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.VALET, CouleurCarte.COEUR));
		
		assertTrue(new QuinteCouleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testPasDeQuinteCouleur()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DEUX,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.TROIS,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.AS,     CouleurCarte.COEUR));
		main.add(new Carte(Denomination.CINQ,   CouleurCarte.COEUR));
		main.add(new Carte(Denomination.SIX,    CouleurCarte.COEUR));
		
		assertFalse(new QuinteCouleur().reconnaitreMain(new ReqAnalyseMain(main)));
	}
}
