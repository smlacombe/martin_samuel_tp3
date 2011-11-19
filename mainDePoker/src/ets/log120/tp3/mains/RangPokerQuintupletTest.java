package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class RangPokerQuintupletTest extends TestCase {
	public void testDifferentQuintuplet()
	{
		Main mainInferieure = new Main();
		mainInferieure .add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		mainInferieure .add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		mainInferieure .add(new Carte(Denomination.TROIS,  CouleurCarte.COEUR));
		mainInferieure .add(new Carte(Denomination.TROIS,  CouleurCarte.TREFLE));
		mainInferieure .add(new Carte(Denomination.JOKER,  CouleurCarte.JOKER));
		
		Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.QUATRE,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.QUATRE,  CouleurCarte.COEUR));
		mainSuperieure.add(new Carte(Denomination.QUATRE,  CouleurCarte.TREFLE));
		mainSuperieure.add(new Carte(Denomination.QUATRE,  CouleurCarte.PIQUE));
		mainSuperieure.add(new Carte(Denomination.JOKER,   CouleurCarte.JOKER));
		
		ReqAnalyseMain requeteMainSuperieure = new ReqAnalyseMain(mainSuperieure);
		ReqAnalyseMain requeteMainInferieure = new ReqAnalyseMain(mainInferieure);
		
		assertTrue(new Quintuplet().reconnaitreMain(requeteMainSuperieure));
		assertTrue(new Quintuplet().reconnaitreMain(requeteMainInferieure));
		
		RangPoker rangMainSuperieure = requeteMainSuperieure.getRangReconnu();
		RangPoker rangMainInferieure = requeteMainInferieure.getRangReconnu();
		
		assertTrue(rangMainSuperieure.compareTo(rangMainInferieure) > 0);
		assertTrue(rangMainInferieure.compareTo(rangMainSuperieure) < 0);
	}

	public void testMemeQuintuplet()
	{
		Main main1 = new Main();
		main1.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		main1.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		main1.add(new Carte(Denomination.TROIS,  CouleurCarte.COEUR));
		main1.add(new Carte(Denomination.TROIS,  CouleurCarte.PIQUE));
		main1.add(new Carte(Denomination.JOKER,   CouleurCarte.JOKER));
		
		Main main2 = new Main();
		main2.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		main2.add(new Carte(Denomination.TROIS, CouleurCarte.COEUR));
		main2.add(new Carte(Denomination.TROIS,  CouleurCarte.TREFLE));
		main2.add(new Carte(Denomination.TROIS,   CouleurCarte.PIQUE));
		main2.add(new Carte(Denomination.JOKER,   CouleurCarte.JOKER));
		
		ReqAnalyseMain requeteMain1 = new ReqAnalyseMain(main1);
		ReqAnalyseMain requeteMain2 = new ReqAnalyseMain(main2);
		
		assertTrue(new Quintuplet().reconnaitreMain(requeteMain1));
		assertTrue(new Quintuplet().reconnaitreMain(requeteMain2));
		
		RangPoker rangMain1 = requeteMain1.getRangReconnu();
		RangPoker rangMain2 = requeteMain2.getRangReconnu();
		
		assertTrue(rangMain1.compareTo(rangMain2) == 0);
		assertTrue(rangMain2.compareTo(rangMain1) == 0);
	}
}
