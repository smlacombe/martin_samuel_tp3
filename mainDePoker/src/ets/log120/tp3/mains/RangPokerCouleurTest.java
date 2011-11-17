package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class RangPokerCouleurTest extends TestCase {
	public void testPremiereCarteDifferente()
	{
		Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.SIX,    CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.HUIT,   CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.DIX,    CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.SIX,    CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.HUIT,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.NEUF,   CouleurCarte.CARREAU));
		
		ReqAnalyseMain requeteMainSuperieure = new ReqAnalyseMain(mainSuperieure);
		ReqAnalyseMain requeteMainInferieure = new ReqAnalyseMain(mainInferieure);
		
		assertTrue(new Couleur().reconnaitreMain(requeteMainSuperieure));
		assertTrue(new Couleur().reconnaitreMain(requeteMainInferieure));
		
		RangPoker rangMainSuperieure = requeteMainSuperieure.getRangReconnu();
		RangPoker rangMainInferieure = requeteMainInferieure.getRangReconnu();
		
		assertTrue(rangMainSuperieure.compareTo(rangMainInferieure) > 0);
		assertTrue(rangMainInferieure.compareTo(rangMainSuperieure) < 0);
	}
	
	public void testSecondeCarteDifferente()
	{
		Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.SIX,    CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.HUIT,   CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.DIX,    CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.SIX,    CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.SEPT,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.DIX,    CouleurCarte.CARREAU));
		
		ReqAnalyseMain requeteMainSuperieure = new ReqAnalyseMain(mainSuperieure);
		ReqAnalyseMain requeteMainInferieure = new ReqAnalyseMain(mainInferieure);
		
		assertTrue(new Couleur().reconnaitreMain(requeteMainSuperieure));
		assertTrue(new Couleur().reconnaitreMain(requeteMainInferieure));
		
		RangPoker rangMainSuperieure = requeteMainSuperieure.getRangReconnu();
		RangPoker rangMainInferieure = requeteMainInferieure.getRangReconnu();
		
		assertTrue(rangMainSuperieure.compareTo(rangMainInferieure) > 0);
		assertTrue(rangMainInferieure.compareTo(rangMainSuperieure) < 0);
	}
	
	public void testMemeCartes()
	{
		Main main1 = new Main();
		main1.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		main1.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		main1.add(new Carte(Denomination.SIX,    CouleurCarte.CARREAU));
		main1.add(new Carte(Denomination.HUIT,   CouleurCarte.CARREAU));
		main1.add(new Carte(Denomination.DIX,    CouleurCarte.CARREAU));
		
		Main main2 = new Main();
		main2.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		main2.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		main2.add(new Carte(Denomination.SIX,    CouleurCarte.CARREAU));
		main2.add(new Carte(Denomination.HUIT,   CouleurCarte.CARREAU));
		main2.add(new Carte(Denomination.DIX,    CouleurCarte.CARREAU));
		
		ReqAnalyseMain requeteMain1 = new ReqAnalyseMain(main1);
		ReqAnalyseMain requeteMain2 = new ReqAnalyseMain(main2);
		
		assertTrue(new Couleur().reconnaitreMain(requeteMain1));
		assertTrue(new Couleur().reconnaitreMain(requeteMain2));
		
		RangPoker rangMain1 = requeteMain1.getRangReconnu();
		RangPoker rangMain2 = requeteMain2.getRangReconnu();
		
		assertTrue(rangMain1.compareTo(rangMain2) == 0);
		assertTrue(rangMain2.compareTo(rangMain1) == 0);
	}
}
