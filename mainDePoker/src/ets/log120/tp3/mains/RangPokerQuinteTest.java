package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class RangPokerQuinteTest extends TestCase {

	public void testComparaisonQuinte()
	{
		Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.SEPT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.HUIT,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.NEUF,  CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.DIX,   CouleurCarte.CARREAU));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.AS,    CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.DEUX,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.TROIS,  CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.QUATRE, CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.CINQ,   CouleurCarte.CARREAU));
		
		ReqAnalyseMain requeteMainSuperieure = new ReqAnalyseMain(mainSuperieure);
		ReqAnalyseMain requeteMainInferieure = new ReqAnalyseMain(mainInferieure);
		
		assertTrue(new Quinte().reconnaitreMain(requeteMainSuperieure));
		assertTrue(new Quinte().reconnaitreMain(requeteMainInferieure));
		
		RangPoker rangMainSuperieure = requeteMainSuperieure.getRangReconnu();
		RangPoker rangMainInferieure = requeteMainInferieure.getRangReconnu();
		
		assertTrue(rangMainSuperieure.compareTo(rangMainInferieure) > 0);
		assertTrue(rangMainInferieure.compareTo(rangMainSuperieure) < 0);
	}
	
}
