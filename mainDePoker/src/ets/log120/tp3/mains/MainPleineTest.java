package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class MainPleineTest extends TestCase {
	public void testPasDeMainPleine()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME, CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.PIQUE));
		
		assertFalse(new MainPleine().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testPasDeMainPleineJoker()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME, CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.JOKER,CouleurCarte.JOKER));
		main.add(new Carte(Denomination.JOKER,CouleurCarte.JOKER));
		
		assertFalse(new MainPleine().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testMainPleineAsDame()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME, CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,   CouleurCarte.PIQUE));
		
		assertTrue(new MainPleine().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testMainPleineAvecPaireAsJoker()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME, CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.JOKER,   CouleurCarte.JOKER));
		
		assertTrue(new MainPleine().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testMainPleineAvecTripleAsJoker()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.JOKER, CouleurCarte.JOKER));
		main.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DAME, CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,   CouleurCarte.PIQUE));
		
		assertTrue(new MainPleine().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testMainPleineRoiDeux()
	{
		Main main = new Main();
		main.add(new Carte(Denomination.ROI,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.COEUR));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.PIQUE));
		
		assertTrue(new MainPleine().reconnaitreMain(new ReqAnalyseMain(main)));
	}

}
