package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class QuintupletTest extends TestCase {
	public void testPasDeQuintuplet()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DAME,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,  CouleurCarte.PIQUE));
		
		assertFalse(new Quintuplet().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testQuintupletAs()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.AS, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.AS,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.JOKER,  CouleurCarte.JOKER));
		
		assertTrue(new Quintuplet().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testPasDeQuintupletJoker()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.JOKER,  CouleurCarte.JOKER));
		main.add(new Carte(Denomination.JOKER,  CouleurCarte.JOKER));
		main.add(new Carte(Denomination.JOKER,  CouleurCarte.JOKER));
		main.add(new Carte(Denomination.JOKER,  CouleurCarte.JOKER));
		main.add(new Carte(Denomination.JOKER,  CouleurCarte.JOKER));
		
		assertFalse(new Quintuplet().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testQuintupletAsJoker()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS, CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.JOKER,   CouleurCarte.JOKER));
		
		assertTrue(new Quintuplet().reconnaitreMain(new ReqAnalyseMain(main)));
	}
}
