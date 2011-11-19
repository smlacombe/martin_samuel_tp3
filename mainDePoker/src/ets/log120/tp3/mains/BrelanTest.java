package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class BrelanTest extends TestCase {
	public void testPasDeBrelan() {
		Main main = new Main();
		main.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.PIQUE));

		assertFalse(new Brelan().reconnaitreMain(new ReqAnalyseMain(main)));
	}

	public void testBrelanAs() {
		Main main = new Main();
		main.add(new Carte(Denomination.DAME, CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.AS,   CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,   CouleurCarte.PIQUE));

		assertTrue(new Brelan().reconnaitreMain(new ReqAnalyseMain(main)));
	}

	public void testBrelanRoi() {
		Main main = new Main();
		main.add(new Carte(Denomination.ROI,  CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.AS,   CouleurCarte.PIQUE));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.COEUR));

		assertTrue(new Brelan().reconnaitreMain(new ReqAnalyseMain(main)));
	}

	public void testBrelanAvecUnJoker() {
		Main main = new Main();
		main.add(Carte.JOKER);
		main.add(new Carte(Denomination.DEUX, CouleurCarte.COEUR));
		main.add(new Carte(Denomination.DEUX, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.PIQUE));

		assertTrue(new Brelan().reconnaitreMain(new ReqAnalyseMain(main)));
	}
	
	public void testBrelanAvecDeuxJoker() {
		Main main = new Main();
		main.add(Carte.JOKER);
		main.add(Carte.JOKER);
		main.add(new Carte(Denomination.DEUX, CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.DIX,  CouleurCarte.TREFLE));
		main.add(new Carte(Denomination.AS,   CouleurCarte.CARREAU));
		main.add(new Carte(Denomination.ROI,  CouleurCarte.PIQUE));

		assertTrue(new Brelan().reconnaitreMain(new ReqAnalyseMain(main)));
	}
}
