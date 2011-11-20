package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class RangPokerMainPleineTest extends TestCase {

	public void testMainPleineEgale()
	{
		Main main1 = new Main();
		main1.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main1.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main1.add(new Carte(Denomination.DAME,  CouleurCarte.TREFLE));
		main1.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main1.add(new Carte(Denomination.AS,  CouleurCarte.PIQUE));
		
		Main main2 = new Main();
		main2.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main2.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main2.add(new Carte(Denomination.DAME,  CouleurCarte.TREFLE));
		main2.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main2.add(new Carte(Denomination.AS,  CouleurCarte.TREFLE));
		
		
		ReqAnalyseMain requeteMain1 = new ReqAnalyseMain(main1);
		ReqAnalyseMain requeteMain2 = new ReqAnalyseMain(main2);
		
		assertTrue(new MainPleine().reconnaitreMain(requeteMain1));
		assertTrue(new MainPleine().reconnaitreMain(requeteMain2));
		
		RangPoker rangMain1 = requeteMain1.getRangReconnu();
		RangPoker rangMain2 = requeteMain2.getRangReconnu();
		
		assertTrue(rangMain1.compareTo(rangMain2) == 0);
		assertTrue(rangMain2.compareTo(rangMain1) == 0);
	}
	
	public void testMainPleineNonEgale()
	{
		Main main1 = new Main();
		main1.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main1.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main1.add(new Carte(Denomination.DAME,  CouleurCarte.TREFLE));
		main1.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main1.add(new Carte(Denomination.AS,  CouleurCarte.PIQUE));
		
		Main main2 = new Main();
		main2.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main2.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main2.add(new Carte(Denomination.DAME,  CouleurCarte.TREFLE));
		main2.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		main2.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
		
		
		ReqAnalyseMain requeteMain1 = new ReqAnalyseMain(main1);
		ReqAnalyseMain requeteMain2 = new ReqAnalyseMain(main2);
		
		assertTrue(new MainPleine().reconnaitreMain(requeteMain1));
		assertTrue(new MainPleine().reconnaitreMain(requeteMain2));
		
		RangPoker rangMain1 = requeteMain1.getRangReconnu();
		RangPoker rangMain2 = requeteMain2.getRangReconnu();
		
		assertFalse(rangMain1.compareTo(rangMain2) == 0);
		assertFalse(rangMain2.compareTo(rangMain1) == 0);
	}
	
	public void testMainPleinePaireSuperieure()
	{
		Main main1 = new Main();
		main1.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main1.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main1.add(new Carte(Denomination.DAME,  CouleurCarte.TREFLE));
		main1.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main1.add(new Carte(Denomination.AS,  CouleurCarte.PIQUE));
		
		Main main2 = new Main();
		main2.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main2.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main2.add(new Carte(Denomination.DAME,  CouleurCarte.TREFLE));
		main2.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		main2.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
		
		
		ReqAnalyseMain requeteMain1 = new ReqAnalyseMain(main1);
		ReqAnalyseMain requeteMain2 = new ReqAnalyseMain(main2);
		
		assertTrue(new MainPleine().reconnaitreMain(requeteMain1));
		assertTrue(new MainPleine().reconnaitreMain(requeteMain2));
		
		RangPoker rangMain1 = requeteMain1.getRangReconnu();
		RangPoker rangMain2 = requeteMain2.getRangReconnu();
		
		assertTrue(rangMain1.compareTo(rangMain2) > 0);
		assertTrue(rangMain2.compareTo(rangMain1) < 0);
	}
	
	public void testMainPleineBrelanSuperieure()
	{
		Main main1 = new Main();
		main1.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main1.add(new Carte(Denomination.DAME, CouleurCarte.COEUR));
		main1.add(new Carte(Denomination.DAME,  CouleurCarte.TREFLE));
		main1.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main1.add(new Carte(Denomination.AS,  CouleurCarte.PIQUE));
		
		Main main2 = new Main();
		main2.add(new Carte(Denomination.AS, CouleurCarte.PIQUE));
		main2.add(new Carte(Denomination.AS, CouleurCarte.COEUR));
		main2.add(new Carte(Denomination.AS,  CouleurCarte.TREFLE));
		main2.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		main2.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
		
		
		ReqAnalyseMain requeteMain1 = new ReqAnalyseMain(main1);
		ReqAnalyseMain requeteMain2 = new ReqAnalyseMain(main2);
		
		assertTrue(new MainPleine().reconnaitreMain(requeteMain1));
		assertTrue(new MainPleine().reconnaitreMain(requeteMain2));
		
		RangPoker rangMain1 = requeteMain1.getRangReconnu();
		RangPoker rangMain2 = requeteMain2.getRangReconnu();
		
		assertTrue(rangMain2.compareTo(rangMain1) > 0);
		assertTrue(rangMain1.compareTo(rangMain2) < 0);
	}
	
	public void testMainPleineBrelanSuperieureJoker()
	{
		Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.AS, CouleurCarte.JOKER));
		mainSuperieure.add(new Carte(Denomination.JOKER, CouleurCarte.COEUR));
		mainSuperieure.add(new Carte(Denomination.AS,  CouleurCarte.TREFLE));
		mainSuperieure.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.JOKER,  CouleurCarte.PIQUE));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.JOKER, CouleurCarte.JOKER));
		mainInferieure.add(new Carte(Denomination.AS, CouleurCarte.COEUR));
		mainInferieure.add(new Carte(Denomination.AS,  CouleurCarte.TREFLE));
		mainInferieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.JOKER,  CouleurCarte.TREFLE));
		
		
		ReqAnalyseMain requeteMainInferieure = new ReqAnalyseMain(mainInferieure);
		ReqAnalyseMain requeteMainSuperieure = new ReqAnalyseMain(mainSuperieure);
		
		assertTrue(new MainPleine().reconnaitreMain(requeteMainInferieure));
		assertTrue(new MainPleine().reconnaitreMain(requeteMainSuperieure));
		
		RangPoker rangMainSuperieure = requeteMainSuperieure.getRangReconnu();
		RangPoker rangMainInferieure = requeteMainInferieure.getRangReconnu();
		
		assertTrue(rangMainSuperieure.compareTo(rangMainInferieure) > 0);
		assertTrue(rangMainInferieure.compareTo(rangMainSuperieure) < 0);
		
	}
}
