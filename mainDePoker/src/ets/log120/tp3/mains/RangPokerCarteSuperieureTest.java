package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class RangPokerCarteSuperieureTest extends TestCase {
	public void testRangDifferents()
	{
		Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.DAME,  CouleurCarte.COEUR));
		mainSuperieure.add(new Carte(Denomination.SEPT,  CouleurCarte.COEUR));
		mainSuperieure.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
		mainSuperieure.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.ROI,   CouleurCarte.COEUR));
		mainInferieure.add(new Carte(Denomination.VALET, CouleurCarte.COEUR));
		mainInferieure.add(new Carte(Denomination.DIX,   CouleurCarte.TREFLE));
		mainInferieure.add(new Carte(Denomination.HUIT,  CouleurCarte.PIQUE));
		mainInferieure.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
		
		ReqAnalyseMain requeteMainSuperieure = new ReqAnalyseMain(mainSuperieure);
		ReqAnalyseMain requeteMainInferieure = new ReqAnalyseMain(mainInferieure);
		
		assertTrue(new CarteSuperieure().reconnaitreMain(requeteMainSuperieure));
		assertTrue(new CarteSuperieure().reconnaitreMain(requeteMainInferieure));
		
		RangPoker rangMainSuperieure = requeteMainSuperieure.getRangReconnu();
		RangPoker rangMainInferieure = requeteMainInferieure.getRangReconnu();
		
		assertTrue(rangMainSuperieure.compareTo(rangMainInferieure) > 0);
		assertTrue(rangMainInferieure.compareTo(rangMainSuperieure) < 0);
	}
	
	public void testRangEgaux()
	{
		Main main1 = new Main();
		main1.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		main1.add(new Carte(Denomination.DAME,  CouleurCarte.COEUR));
		main1.add(new Carte(Denomination.SEPT,  CouleurCarte.COEUR));
		main1.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
		main1.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		
		Main main2 = new Main();
		main2.add(new Carte(Denomination.AS,   CouleurCarte.COEUR));
		main2.add(new Carte(Denomination.VALET, CouleurCarte.COEUR));
		main2.add(new Carte(Denomination.DIX,   CouleurCarte.TREFLE));
		main2.add(new Carte(Denomination.HUIT,  CouleurCarte.PIQUE));
		main2.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
		
		ReqAnalyseMain requeteMain1 = new ReqAnalyseMain(main1);
		ReqAnalyseMain requeteMain2 = new ReqAnalyseMain(main2);
		
		assertTrue(new CarteSuperieure().reconnaitreMain(requeteMain1));
		assertTrue(new CarteSuperieure().reconnaitreMain(requeteMain2));
		
		RangPoker rangMain1 = requeteMain1.getRangReconnu();
		RangPoker rangMain2 = requeteMain2.getRangReconnu();
		
		assertTrue(rangMain1.compareTo(rangMain2) == 0);
		assertTrue(rangMain2.compareTo(rangMain1) == 0);
	}
}
